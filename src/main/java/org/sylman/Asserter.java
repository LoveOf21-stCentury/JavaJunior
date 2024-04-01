package org.sylman;

// TODO: 4/1/2024  //небольшая попытка реализации задания со звездочкой
class Asserter {
    static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("Expected: " + expected + ". Actual: " + actual);
        }
    }
}
