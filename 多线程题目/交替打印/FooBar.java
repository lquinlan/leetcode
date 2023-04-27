import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;
    Semaphore s1, s2;

    public FooBar(int n) {
        this.n = n;
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            s1.acquire();
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            s2.acquire();
            printBar.run();
            s1.release();
        }
    }
}