package org.example.cells;

import java.util.Arrays;
import java.util.Objects;

public class CellsCellBlockImpl extends Cells{
    private final Object[] mutexs;
    public CellsCellBlockImpl(int N, int K) {
        super(N, K);
        this.mutexs = new Object[super.getN()];
        for (int i = 0; i < mutexs.length; i++){
            this.mutexs[i] = new Object();
        }
    }

    @Override
    public void setIndex(int curIndex, int nextIndex) {
        synchronized (mutexs[curIndex]){
            this.cells[curIndex] -= 1;
        }
        synchronized (mutexs[nextIndex]){
            this.cells[nextIndex] += 1;
        }
    }
}
