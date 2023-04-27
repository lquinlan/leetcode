
public class Foo3 {
    volatile int a = 0;

    public Foo3() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        a = 1;

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (a != 1)
            ;
        printSecond.run();
        a = 2;

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (a != 2)
            ;
        printThird.run();
    }

}
