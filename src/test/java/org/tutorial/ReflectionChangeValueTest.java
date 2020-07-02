package org.tutorial;

import org.junit.Test;


import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Schimba valoarea unui camp public, privat,
 * final privat, static final
 */
public class ReflectionChangeValueTest {

    @Test
    public void changePublicField() throws NoSuchFieldException, IllegalAccessException {
        // given
        Child child = new Child();
        Field publicField = Child.class.getField("publicField");

        // when
        publicField.set(child, 100);

        // then
        assertEquals(100, child.getPublicField());
    }

    @Test
    public void changePrivateField() throws NoSuchFieldException, IllegalAccessException {
        // given
        Child child = new Child();
        Field privateField = Child.class.getDeclaredField("privateField");

        // when
        privateField.setAccessible(true);
        privateField.set(child, "Hello from private field!");

        // then
        assertEquals("Hello from private field!", child.getPrivateField());
    }

    @Test
    public void changeFinalField() throws NoSuchFieldException, IllegalAccessException {
        // given
        Child child = new Child();
        Field privateFinalField = Child.class.getDeclaredField("privateFinal");

        // when
        String initialValue = child.getPrivateFinal();
        privateFinalField.setAccessible(true);
        privateFinalField.set(child, "Hello from private final field!");

        // then
        assertNotEquals(initialValue, child.getPrivateFinal());
        assertEquals("Hello from private final field!", child.getPrivateFinal());
    }
}
