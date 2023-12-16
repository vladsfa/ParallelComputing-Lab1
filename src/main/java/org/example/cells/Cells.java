package org.example.cells;

import java.util.Arrays;

public abstract class Cells {
    final int[] cells;
    public Cells(int N, int K){
        this.cells = new int[N];
        this.cells[0] = K;
    }
    public abstract void setIndex(int curIndex, int nextIndex);
    public int getN(){
        return this.cells.length;
    }
    public void printState(){
        synchronized (this){
            for (int cell : cells) {
                System.out.print(cell);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public int getCellsSum(){
        return Arrays.stream(this.cells).sum();
    }
}
