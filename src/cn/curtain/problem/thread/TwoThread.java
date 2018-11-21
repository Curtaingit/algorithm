package cn.curtain.problem.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Curtain
 * @date 2018/10/15 16:19
 *
 * 交替打印奇偶数  （线程切换）
 */
public class TwoThread {

    private int start = 1;

    /**
     * 保证内存可见性
     * 其实用锁了之后也可以保证可见性 这里用不用 volatile 都一样
     */
    private boolean flag = true;

    /**
     * 重入锁
     */
    private final static Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        TwoThread twoThread = new TwoThread();

        Thread single = new Thread(new Single(twoThread));
        Thread twice = new Thread(new Twice(twoThread));

        single.start();
        twice.start();
    }

    //奇数线程
    public static class Single implements Runnable {

        private TwoThread twoThread;

        public Single(TwoThread twoThread) {
            this.twoThread = twoThread;
        }

        @Override
        public void run() {
            while (twoThread.start < 100) {
                if (twoThread.flag) {
                    try {
                        LOCK.lock();
                        System.out.println(Thread.currentThread() + "奇数:" + twoThread.start);
                        twoThread.start++;
                        twoThread.flag = !twoThread.flag;
                    } finally {
                        LOCK.unlock();
                    }
                } else {
                    //不符合的情况 防止线程空转
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //偶数线程
    public static class Twice implements Runnable {

        private TwoThread twoThread;

        public Twice(TwoThread twoThread) {
            this.twoThread = twoThread;
        }

        @Override
        public void run() {
            while (twoThread.start <= 100) {
                if (!twoThread.flag) {
                    try {
                        LOCK.lock();
                        System.out.println(Thread.currentThread() + "偶数:" + twoThread.start);
                        twoThread.start++;
                        twoThread.flag = !twoThread.flag;
                    } finally {
                        LOCK.unlock();
                    }
                } else {
                    //不符合的情况 防止线程空转
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
