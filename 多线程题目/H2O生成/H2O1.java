import java.util.concurrent.Semaphore;

class H2O1 {
    // CyclicBarrier barrier1;
    // CyclicBarrier barrier2;
    Semaphore so = new Semaphore(2);
    Semaphore sh = new Semaphore(0);

    public H2O1() {
        // sh.acquire();
        // barrier1 = new CyclicBarrier(3);
        // barrier2 = new CyclicBarrier(1);

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        sh.acquire();
        // try {
        // barrier1.await();
        // } catch (BrokenBarrierException ignore) {
        // }
        releaseHydrogen.run();
        so.release();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        so.acquire(2);
        // try {
        // barrier1.await();
        // } catch (BrokenBarrierException ignore) {
        // }
        releaseOxygen.run();
        sh.release(2);

    }
}