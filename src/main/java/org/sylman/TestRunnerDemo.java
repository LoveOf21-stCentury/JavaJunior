package org.sylman;

import org.sylman.myAnnotations.*;

public class TestRunnerDemo {
    public static void main(String[] args) {
        TestRunner.run(TestRunnerDemo.class);
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each test");
    }

    @Test
    @Order(1)
    public void test1() {
        System.out.println("First test");
        Asserter.assertEquals(2, 1 + 1);
    }

    @Test
    @Order(2)
    public void test2() {
        System.out.println("Second test");
        Asserter.assertEquals(4, 2 * 2);
    }

    @AfterEach
    public static void afterEach() {
        System.out.println("After each test");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all tests");
    }
}


