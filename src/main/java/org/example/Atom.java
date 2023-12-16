package org.example;

import org.example.cells.Cells;
import java.util.Random;

public class Atom implements Runnable{
    private int index;
    private final double p;
    private final Cells cells;
    private final Random r;
    private final static long startTime = System.currentTimeMillis();
    private final boolean isTest;
    private int n = 0;

    public Atom(double p, Cells cells, boolean isTest) {
        this.index = 0;
        this.p = p;
        this.cells = cells;
        this.r = new Random();
        this.isTest = isTest;
    }

    @Override
    public void run() {
        long timeMs = 60 * 1000;

        while (true){
            if (!isTest && System.currentTimeMillis() - startTime >= timeMs){
                break;
            }
            if (isTest && this.n > 1000000){
                break;
            }

            double m = this.r.nextDouble();
            if (this.r.nextDouble() > this.p){
                int nextIndex = this.getNextIndex(m);
                this.cells.setIndex(this.index, nextIndex);
                this.index = nextIndex;
            }

            try {
                if (!this.isTest){
                    Thread.sleep(1000);
                }
                else{
                    this.n += 1;
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private int getNextIndex(double m){
        int nextIndex = this.index;
        if (m > this.p){
            if (nextIndex + 1 < this.cells.getN()){
                nextIndex += 1;
            }
        }
        else{
            if (nextIndex != 0){
                nextIndex -= 1;
            }
        }
        return nextIndex;
    }
}
