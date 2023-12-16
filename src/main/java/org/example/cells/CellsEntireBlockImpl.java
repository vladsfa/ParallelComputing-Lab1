package org.example.cells;

public class CellsEntireBlockImpl extends Cells{
    public CellsEntireBlockImpl(int N, int K) {
        super(N, K);
    }

    @Override
    public void setIndex(int curIndex, int nextIndex) {
        synchronized (this){
            this.cells[curIndex] -= 1;
            this.cells[nextIndex] += 1;
        }
    }
}
