package org.example.mains;

import org.example.ExecArgs;
import org.example.Program;
import org.example.cells.CellsEntireBlockImpl;

public class Cells1 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecArgs execArgs = ExecArgs.parse(args);
        Program.startDefault(new CellsEntireBlockImpl(execArgs.N, execArgs.K), execArgs, true);

        double timeS = (System.currentTimeMillis() - start) / 1000.0;
        System.out.println("Час виконання при захопленні всіх клітинок: " + timeS + " секунд");
    }
}
