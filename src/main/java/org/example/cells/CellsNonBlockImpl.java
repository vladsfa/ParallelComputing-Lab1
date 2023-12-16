package org.example.cells;

public class CellsNonBlockImpl extends Cells{

    public CellsNonBlockImpl(int N, int K) {
        super(N, K);
    }

    @Override
    public void setIndex(int curIndex, int nextIndex) {
        this.cells[curIndex] -= 1;
        this.cells[nextIndex] += 1;
    }
}
