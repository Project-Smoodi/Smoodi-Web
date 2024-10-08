plugins {
    id("java")
    id("java-library")
    id("maven-publish")
}

group = "org.smoodi.web"

repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/Project-Smoodi/Smoodi-Core")
    }
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

dependencies {
    implementation("org.smoodi.framework:smoodi-core:0.0.1-ALPHA")

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

publishing {

    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            groupId = "org.smoodi.framework"
            artifactId = "smoodi-web"
            version = "0.0.1-SNAPSHOT"

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
                        email.set("ty82afg12@gmail.com")
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
            name = "Smoodi-Framework-Web"
            url = uri("https://maven.pkg.github.com/Project-Smoodi/Smoodi-Web")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.token") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}