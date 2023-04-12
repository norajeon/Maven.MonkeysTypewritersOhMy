package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        UnsafeCopier unsafe = new UnsafeCopier(introduction);
        Thread thread1 = new Thread(unsafe);
        Thread thread2 = new Thread(unsafe);
        Thread thread3 = new Thread(unsafe);
        Thread thread4 = new Thread(unsafe);
        Thread thread5 = new Thread(unsafe);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        SafeCopier safe = new SafeCopier(introduction);
        Thread thread6 = new Thread(safe);
        Thread thread7 = new Thread(safe);
        Thread thread8 = new Thread(safe);
        Thread thread9 = new Thread(safe);
        Thread thread10 = new Thread(safe);
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();


        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        System.out.println("Unsafe:");
        System.out.println(unsafe.copied.toString());
        System.out.println("---------");
        System.out.println("\n");
        System.out.println("\n");

        System.out.println("Safe:");
        System.out.println(safe.copied.toString());
        System.out.println("---------");

        // Print out the copied versions here.
    }
}