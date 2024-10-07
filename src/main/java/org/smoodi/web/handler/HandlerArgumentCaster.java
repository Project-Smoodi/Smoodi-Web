package org.smoodi.web.handler;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.smoodi.annotation.Api;
import org.smoodi.annotation.NotNull;

import java.lang.reflect.InvocationTargetException;

/**
 * <p>{@link HandlerMethodArgumentResolver}의 캐스팅 동작을 추출한 유틸리티.</p>
 *
 * @author Daybreak312
 * @see HandlerMethodArgumentResolver
 * @see MethodHandler
 * @see org.smoodi.web.handler.annotation.Handler Handler(Annotation)
 * @see Handler
 * @since v0.0.1
 */
@SuppressWarnings("unchecked")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HandlerArgumentCaster {

    private static final Class<Byte> byteClass = Byte.class;
    private static final Class<Short> shortClass = Short.class;
    private static final Class<Integer> intClass = Integer.class;
    private static final Class<Long> longClass = Long.class;
    private static final Class<Float> floatClass = Float.class;
    private static final Class<Double> doubleClass = Double.class;
    private static final Class<Character> charClass = Character.class;
    private static final Class<Boolean> booleanClass = Boolean.class;
    private static final Class<String> stringClass = String.class;

    @NotNull
    @Api
    public static <T> T cast(@NotNull final String s, @NotNull final Class<T> type) {

        try {
            if (type.equals(byteClass)) {
                return (T) Byte.valueOf(s);
            } else if (type.equals(shortClass)) {
                return (T) Short.valueOf(s);
            } else if (type.equals(intClass)) {
                return (T) Integer.valueOf(s);
            } else if (type.equals(longClass)) {
                return (T) Long.valueOf(s);
            } else if (type.equals(floatClass)) {
                return (T) Float.valueOf(s);
            } else if (type.equals(doubleClass)) {
                return (T) Double.valueOf(s);
            }
        } catch (NumberFormatException e) {
            throw new InvalidParameterValueException("Invalid value " + s + " for type " + type.getName());
        }

        if (type.equals(charClass)) {
            if (s.length() != 1) {
                throw new InvalidParameterValueException("Invalid value " + s + " for type " + type.getName());
            }
            return (T) Character.valueOf(s.charAt(0));
        } else if (type.equals(booleanClass)) {
            return (T) Boolean.valueOf(s);
        } else if (type.equals(stringClass)) {
            return (T) s;
        } else if (type.isEnum()) {
            return resolveEnum(s, type);
        } else {
            throw new UnsupportedTypeParameterException("Unknown type was expected: " + type);
        }
    }

    @NotNull
    @SneakyThrows({IllegalAccessException.class, NoSuchMethodException.class})
    private static <T> T resolveEnum(@NotNull final String s, @NotNull final Class<T> type) {

        try {
            return (T) type.getMethod("valueOf", String.class).invoke(null, s);
        } catch (InvocationTargetException e) {
            throw new InvalidParameterValueException("Unknown enum value for " + type.getName());
        }
    }
}
