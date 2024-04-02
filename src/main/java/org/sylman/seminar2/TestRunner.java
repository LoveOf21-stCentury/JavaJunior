package org.sylman.seminar2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestRunner {
    public static void run(Class<?> testClass) {
        final Object testObj = initTestObj(testClass);
        List<Method> testMethods = new ArrayList<>();
        List<Method> beforeAllMethods = new ArrayList<>();
        List<Method> beforeEachMethods = new ArrayList<>();
        List<Method> afterEachMethods = new ArrayList<>();
        List<Method> afterAllMethods = new ArrayList<>();

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(org.sylman.myAnnotations.Test.class)) {
                testMethods.add(method);
            }
            if (method.isAnnotationPresent(org.sylman.myAnnotations.BeforeAll.class)) {
                beforeAllMethods.add(method);
            }
            if (method.isAnnotationPresent(org.sylman.myAnnotations.BeforeEach.class)) {
                beforeEachMethods.add(method);
            }
            if (method.isAnnotationPresent(org.sylman.myAnnotations.AfterEach.class)) {
                afterEachMethods.add(method);
            }
            if (method.isAnnotationPresent(org.sylman.myAnnotations.AfterAll.class)) {
                afterAllMethods.add(method);
            }
        }

        executeMethods(beforeAllMethods, testObj);

        for (Method testMethod : testMethods) {
            executeMethods(beforeEachMethods, testObj);
            try {
                testMethod.invoke(testObj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            executeMethods(afterEachMethods, testObj);
        }
        executeMethods(afterAllMethods, testObj);
    }

    private static void executeMethods(List<Method> methods, Object object) {
        Collections.reverse(methods);
        for (Method method : methods) {
            try {
                method.invoke(object);
            } catch (IllegalAccessException | InvocationTargetException e){
            throw new RuntimeException();
        }}
    }

    private static Object initTestObj(Class<?> testClass) {
        try {
            Constructor<?> noArgsConstruction = testClass.getConstructor();
            return noArgsConstruction.newInstance();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Don't have constructor by default");
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Filed to create test class object");
        }
    }
}