package cn.leetcode.concurrent;

public class ConcurrentPrintA implements Runnable {

    private volatile int count;
    private final int limit;

    public ConcurrentPrintA(int count, int limit) {
        this.count = count;
        this.limit = limit;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (count < limit) {
                System.out.printf("Thread [%s] - %d \n", Thread.currentThread().getName(), count++);
                this.notify();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public static void main(String[] args) {
        ConcurrentPrintA printer = new ConcurrentPrintA(0, 10);

        new Thread(printer, "Thread A").start();
        new Thread(printer, "Thread B").start();
    }
}
