import org.jreleaser.model.Active

plugins {
    id("java")
    id("java-library")
    id("maven-publish")
    id("org.jreleaser") version "1.17.0"
    id("io.freefair.lombok") version "8.4"
}

group = "org.smoodi.web"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    api("org.smoodi.core:smoodi-core:0.1.5")
    api("org.smoodi.physalus:physalus:0.1.0")

    // Serialization
    api("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    api("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
    api("org.glassfish.jaxb:jaxb-runtime:4.0.0")

    // Logger
    api("org.slf4j:slf4j-api:2.0.13")
    implementation("ch.qos.logback:logback-core:1.5.13")
    implementation("ch.qos.logback:logback-classic:1.5.13")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    // Test
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.addAll(
        listOf(
            "--add-exports", "jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED",
            "--add-exports", "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
            "--add-exports", "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
        )
    )
}

tasks.named("jreleaserFullRelease") {
    dependsOn("publish")
}

tasks.named("jreleaserDeploy") {
    dependsOn("publish")
}

publishing {

    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name.set("Smoodi Framework Web")
                description.set("A framework that includes features related to web application server technology.")
                url.set("https://github.com/Project-Smoodi/Smoodi-Web")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("Daybreak312")
                        name.set("Daybreak312")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/Project-Smoodi/Smoodi-Web.git")
                    developerConnection.set("scm:git:ssh://git@github.com:Project-Smoodi/Smoodi-Web.git")
                    url.set("https://github.com/Project-Smoodi/Smoodi-Web")
                }
            }
        }
    }

    repositories {
        maven {
            name = "staging"
            url = uri(layout.buildDirectory.dir("staging-deploy").get().asFile.absolutePath)
        }
    }
}

jreleaser {
    signing {
        active.set(Active.RELEASE)
        armored = true
    }
    deploy {
        maven {
            mavenCentral {
                create("sonatype") {
                    active.set(Active.RELEASE)
                    url.set("https://central.sonatype.com/api/v1/publisher")
                    stagingRepository(layout.buildDirectory.dir("staging-deploy").get().asFile.absolutePath)
                }
            }
            nexus2 {
                create("sonatype-snapshots") {
                    active.set(Active.SNAPSHOT)
                    url.set("https://s01.oss.sonatype.org/content/repositories/snapshots/")
                    snapshotUrl.set("https://s01.oss.sonatype.org/content/repositories/snapshots/")
                    applyMavenCentralRules.set(true)
                }
            }
        }
    }
    release {
        github {
            tagName.set("v{{projectVersion}}")
            releaseName.set("Release v{{projectVersion}}")
            changelog {
                formatted.set( Active.ALWAYS)
                preset.set("conventional-commits")
            }
        }
    }
}