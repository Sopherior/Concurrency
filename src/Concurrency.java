import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrency {
	
	// create lock to control thread access
    private static final Lock myLock = new ReentrantLock();
    private static boolean firstThreadCompleted = false;
    
    // function for counting up to 20
    private static void countUp() {
        for (int i = 1; i <= 20; i++) {
            myLock.lock();
            try {
                System.out.println(i);
            } finally {
                myLock.unlock();
            }
        }
    }
    
    // function for counting down to 0
    private static void countDown() {
    	
        // Wait until the first thread has completed
        while (!firstThreadCompleted) {
            Thread.yield();
        }
        
        for (int i = 20; i >= 0; i--) {
            myLock.lock();
            try {
                System.out.println(i);
            } finally {
                myLock.unlock();
            }
        }
    }
    
    public static void main(String[] args) {
    	
    	// create two threads for counting
        Thread thread1 = new Thread(Concurrency::countUp);
        Thread thread2 = new Thread(Concurrency::countDown);
        
        // ask first thread to start
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            firstThreadCompleted = true;
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done.");
    }
}