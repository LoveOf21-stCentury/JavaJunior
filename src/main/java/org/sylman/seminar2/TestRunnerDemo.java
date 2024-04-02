package org.sylman.seminar2;

public class TestRunnerDemo {
    public static void main(String[] args) {
        TestRunner.run(TestRunnerDemo.class);
    }

    @org.sylman.myAnnotations.BeforeAll
    public static void beforeAll() {
        System.out.println("Before all tests");
    }

    @org.sylman.myAnnotations.BeforeEach
    public void beforeEach() {
        System.out.println("Before each test");
    }

    @org.sylman.myAnnotations.Test
    @org.sylman.myAnnotations.Order(1)
    public void test1() {
        System.out.println("First test");
        Asserter.assertEquals(2, 1 + 1);
    }

    @org.sylman.myAnnotations.Test
    @org.sylman.myAnnotations.Order(2)
    public void test2() {
        System.out.println("Second test");
        Asserter.assertEquals(4, 2 * 2);
    }

    @org.sylman.myAnnotations.AfterEach
    public static void afterEach() {
        System.out.println("After each test");
    }

    @org.sylman.myAnnotations.AfterAll
    public static void afterAll() {
        System.out.println("After all tests");
    }
}


