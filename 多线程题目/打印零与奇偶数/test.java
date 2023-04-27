import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    volatile int state = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            if (i % 2 == 1) {
                state = 2;
            } else {
                state = 1;
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                Thread.yield();
            }

            // s2.acquire();
            printNumber.accept(i);
            // isodd = true;
            state = 0;

        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                Thread.yield();
            }

            // s2.acquire();
            printNumber.accept(i);
            // isodd = false;
            state = 0;

        }

    }
}