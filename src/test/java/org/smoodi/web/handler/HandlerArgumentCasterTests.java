package org.smoodi.web.handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.smoodi.web.handler.argument.HandlerArgumentCaster;
import org.smoodi.web.handler.argument.InvalidParameterValueException;
import org.smoodi.web.handler.argument.UnsupportedTypeParameterException;

public class HandlerArgumentCasterTests {

    private enum Enum {
        ONE,
        TWO,
        THREE
    }

    @Test
    public void castInteger() {
        Assertions.assertDoesNotThrow(() ->
                HandlerArgumentCaster.cast(
                        Integer.toString(Integer.MAX_VALUE),
                        Integer.class)
        );
    }

    @Test
    public void castIntegerWithInvalidString() {
        Assertions.assertThrows(InvalidParameterValueException.class, () ->
                HandlerArgumentCaster.cast(
                        Integer.MAX_VALUE + "char",
                        Integer.class)
        );
    }

    @Test
    public void castLong() {
        Assertions.assertDoesNotThrow(() ->
                HandlerArgumentCaster.cast(
                        Long.toString(Long.MAX_VALUE),
                        Long.class
                )
        );
    }

    @Test
    public void castLongWithInvalidString() {
        Assertions.assertThrows(InvalidParameterValueException.class, () ->
                HandlerArgumentCaster.cast(
                        Long.MAX_VALUE + "char",
                        Long.class)
        );
    }

    @Test
    public void castDouble() {
        Assertions.assertDoesNotThrow(() ->
                HandlerArgumentCaster.cast(
                        Double.toString(Double.MAX_VALUE),
                        Double.class
                )
        );
    }

    @Test
    public void castToDoubleWithInvalidString() {
        Assertions.assertThrows(InvalidParameterValueException.class, () ->
                HandlerArgumentCaster.cast(
                        Double.MAX_VALUE + "char",
                        Double.class
                )
        );
    }

    @Test
    public void castToChar() {
        Assertions.assertDoesNotThrow(() ->
                HandlerArgumentCaster.cast(
                        "a", Character.class
                ));
    }

    @Test
    public void castToCharWithInvalidString() {
        Assertions.assertThrows(InvalidParameterValueException.class, () ->
                HandlerArgumentCaster.cast(
                        "char", Character.class
                ));
    }

    @Test
    public void castToEnum() {
        Assertions.assertDoesNotThrow(() ->
                HandlerArgumentCaster.cast(
                        "ONE", Enum.class
                )
        );
    }

    @Test
    public void castToEnumWithInvalidString() {
        Assertions.assertThrows(InvalidParameterValueException.class, () ->
                HandlerArgumentCaster.cast(
                        "char", Enum.class
                )
        );
    }

    @Test
    public void castToUnknownType() {
        Assertions.assertThrows(UnsupportedTypeParameterException.class, () ->
                HandlerArgumentCaster.cast(
                        "char", Class.class
                )
        );
    }
}
