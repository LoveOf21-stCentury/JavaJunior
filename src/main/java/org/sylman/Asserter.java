package org.sylman;

// TODO: 4/1/2024  //использую этот класс, поскольку не стала использовать JSON вывод результата
class Asserter {
    static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("Expected: " + expected + ". Actual: " + actual);
        }
    }
}
