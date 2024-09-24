package org.smoodi.net.config;

/**
 * HTTP에 관련된 설정 인터페이스
 *
 * @since v0.0.1-ALPHA
 * @author Daybreak312
 */
public interface HttpConfiguration {

    /**
     * @return 서버가 대기할 포트
     */
    int port();

    /**
     * @return 서버 요청을 처리할 경로의 시작 경로
     */
    String pathPrefix();

    /**
     * @return JSON Body에서 key의 표기법. 기본값은 {@link  JsonKeyCase#LOWER_SNAKE_CASE LOWER_SNAKE_CASE}
     */
    JsonKeyCase jsonKeyCase();

    /**
     * JSON에서의 key 표기법
     *
     * @since v0.0.1-ALPHA
     * @author Daybreak312
     */
    enum JsonKeyCase {

        /**
         * <p>소문자 스네이크 케이스</p>
         * <p>모든 단어를 _(언더스코어, Under Score)를 이용해 구분하고, 모든 글자를 소문자로 표기</p>
         *
         * <code>this_is_lower_snake_case</code>
         */
        LOWER_SNAKE_CASE,

        /**
         * <p>대문자 스네이크 케이스</p>
         * <p>모든 단어를 _(언더스코어, Under Score)를 이용해 구분하고, 모든 글자를 대문자로 표기</p>
         *
         * <code>THIS_IS_UPPER_SNAKE_CASE</code>
         */
        UPPER_SNAKE_CASE,

        /**
         * <p>파스칼 케이스</p>
         * <p>모든 단어를 붙여 쓰고, 각 단어의 시작을 대문자로 표기</p>
         *
         * <code>ThisIsPascalCase</code>
         */
        PASCAL_CASE,

        /**
         * <p>카멜 케이스</p>
         * <p>모든 단어를 붙여 쓰고, 첫 단어를 제외한 각 단어의 시작을 대문자로 표기</p>
         *
         * <code>thisIsCamelCase</code>
         */
        CAMEL_CASE
    }
}
