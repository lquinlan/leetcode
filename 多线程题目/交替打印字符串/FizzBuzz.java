import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    AtomicInteger i = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;

    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i.get() <= n) {
            final int tmp = i.get();
            if (tmp % 3 == 0 && tmp % 5 != 0) {
                printFizz.run();
                i.incrementAndGet();

            }
            Thread.yield();

        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i.get() <= n) {
            final int tmp = i.get();
            if (tmp % 5 == 0 && tmp % 3 != 0) {
                printBuzz.run();
                i.incrementAndGet();

            }
            Thread.yield();

        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i.get() <= n) {
            final int tmp = i.get();
            if (tmp % 3 == 0 && tmp % 5 == 0) {
                printFizzBuzz.run();
                i.incrementAndGet();

            }
            Thread.yield();

        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i.get() <= n) {
            final int tmp = i.get();
            if (tmp % 3 != 0 && tmp % 5 != 0) {
                printNumber.accept(tmp);
                i.incrementAndGet();

            }
            Thread.yield();

        }

    }
}