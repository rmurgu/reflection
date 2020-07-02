package org.tutorial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Folosind java reflection acceseaza pe un obiect
 * clasa sa, clasa parinte, interfata implementata, adnotare
 * campuri, metode, constructori
 */

public class ReflectionAccessNamesTest {

    @Test
    public void checkClassName() {
        // given
        Child child = new Child();

        // when
        Class<? extends Child> clazz = child.getClass();

        // then
        assertEquals("Child", clazz.getSimpleName());
        assertEquals("org.tutorial.Child", clazz.getName());
        assertEquals("org.tutorial.Child", clazz.getCanonicalName());
    }

    @Test
    public void checkClassFieldNames() {
        // given
        Child child = new Child();

        // when
        Field[] declaredFields = child.getClass().getDeclaredFields();
        List<String> fieldNames = getFieldNames(declaredFields);

        // then
        assertTrue(Arrays.asList("staticFinalField", "privateFinal", "privateField", "publicField")
            .containsAll(fieldNames));
    }

    @Test
    public void checkMethodNames() {
        // given
        Child child = new Child();

        // when
        Method[] declaredMethods = child.getClass().getDeclaredMethods();
        List<String> methodNames = getMethodNames(declaredMethods);

        // then
        assertTrue(Arrays.asList("getPrivateFinal", "getLocomotion", "setPublicField", "setPrivateField", "getPrivateField", "getPublicField")
            .containsAll(methodNames));
    }

    @Test
    public void checkParentClass() {
        // given
        Child child = new Child();

        // when
        Class<?> superclass = child.getClass().getSuperclass();

        // then
        assertEquals("Parent", superclass.getSimpleName());
        assertEquals("org.tutorial.Parent", superclass.getName());
        assertEquals("org.tutorial.Parent", superclass.getCanonicalName());
    }

    @Test
    public void checkInterface() {
        // given
        Child child = new Child();

        // when
        Class<?>[] interfaces = child.getClass().getInterfaces();

        // then
        assertEquals("Locomotion", interfaces[0].getSimpleName());
        assertEquals("org.tutorial.Locomotion", interfaces[0].getName());
        assertEquals("org.tutorial.Locomotion", interfaces[0].getCanonicalName());
    }

    @Test
    public void checkAnnotation() {
        // given
        Child child = new Child();

        // when
        Annotation[] declaredAnnotations = child.getClass().getDeclaredAnnotations();
        Class<? extends Annotation> annotationClazz = declaredAnnotations[0].annotationType();

        // then
        assertEquals(1, declaredAnnotations.length);
        assertEquals("Marked", annotationClazz.getSimpleName());
        assertEquals("org.tutorial.Marked", annotationClazz.getName());
        assertEquals("org.tutorial.Marked", annotationClazz.getCanonicalName());
    }

    @Test
    public void checkConstructors() {
        // given
        Child child = new Child();

        // when
        Constructor<?>[] declaredConstructors = child.getClass().getDeclaredConstructors();

        // then
        assertEquals(2, declaredConstructors.length);
    }

    @Test
    public void createObjectThroughReflection() throws ClassNotFoundException {
        // given
        Class<?> clazz = Class.forName("org.tutorial.Child");

        // when
        String simpleName = clazz.getSimpleName();
        String name = clazz.getName();
        String canonicalName = clazz.getCanonicalName();

        // then
        assertEquals("Child", simpleName);
        assertEquals("org.tutorial.Child", name);
        assertEquals("org.tutorial.Child", canonicalName);
    }

    private List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }

    private List<String> getMethodNames(Method[] methods) {
        List<String> methodNames = new ArrayList<>();
        for (Method method : methods)
            methodNames.add(method.getName());
        return methodNames;
    }

}
