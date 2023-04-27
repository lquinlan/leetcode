import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Foo {
    BlockingQueue<String> BlockingQueue1 = new SynchronousQueue<String>();
    BlockingQueue<String> BlockingQueue2 = new SynchronousQueue<String>();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        BlockingQueue1.put("Second Start");
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        BlockingQueue1.take();
        printSecond.run();
        BlockingQueue2.put("third Start");
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        BlockingQueue2.take();
        printThird.run();
    }
}