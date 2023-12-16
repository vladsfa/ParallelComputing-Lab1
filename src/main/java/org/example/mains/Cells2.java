package org.example.mains;

import org.example.ExecArgs;
import org.example.Program;
import org.example.cells.CellsCellBlockImpl;

public class Cells2 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecArgs execArgs = ExecArgs.parse(args);
        Program.startDefault(new CellsCellBlockImpl(execArgs.N, execArgs.K), execArgs, true);

        double timeS = (System.currentTimeMillis() - start) / 1000.0;
        System.out.println("Час виконання при захопленні однієї клітинки: " + timeS + " секунд");
    }
}
