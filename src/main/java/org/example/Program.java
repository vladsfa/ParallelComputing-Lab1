package org.example;

import org.example.cells.Cells;

import java.util.Arrays;

public class Program {
    public static void startDefault(Cells cells, ExecArgs execArgs, boolean isTest) throws InterruptedException {
        cells.printState();

        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[execArgs.K];
        for (int i = 0; i < threads.length; i++){
            threads[i] = new Thread(new Atom(execArgs.p, cells, isTest));
            threads[i].start();
        }

        long workTime = 10 * 1000;
        long lastPrintTime = System.currentTimeMillis();
        long printTime = 5 * 1000;
        while (Arrays.stream(threads).anyMatch(Thread::isAlive)){
            if (System.currentTimeMillis() - lastPrintTime > printTime){
                cells.printState();
                lastPrintTime = System.currentTimeMillis();
            }
            if (!isTest && System.currentTimeMillis() - startTime > workTime){
                Arrays.stream(threads).forEach(t -> {
                    t.interrupt();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            Thread.sleep(100);
        }

        if (isTest){
            cells.printState();
        }
        System.out.println("Кількість атомів у кінці: " + cells.getCellsSum());
    }

    public static void startTest(){

    }
}
