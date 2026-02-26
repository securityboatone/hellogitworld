package com.github;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    private static int counter = 0;

    @Test
    void testCounterIncrement() throws InterruptedException {

        Thread t1 = new Thread(() -> counter++);
        Thread t2 = new Thread(() -> counter++);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // This assertion will randomly fail
        assertEquals(2, counter);
    }
}
