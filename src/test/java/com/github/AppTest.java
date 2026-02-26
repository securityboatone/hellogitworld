package com.github;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.atomic.AtomicInteger;

class AppTest {

    private static AtomicInteger counter = new AtomicInteger(0);

    @Test
    void testCounterIncrement() throws InterruptedException {

        Thread t1 = new Thread(() -> counter.incrementAndGet());
        Thread t2 = new Thread(() -> counter.incrementAndGet());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // This assertion will now consistently pass
        assertEquals(2, counter.get());
    }
}
