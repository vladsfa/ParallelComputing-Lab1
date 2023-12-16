package org.example.mains;

import org.example.ExecArgs;
import org.example.Program;
import org.example.cells.CellsNonBlockImpl;

public class Cells0 {
    public static void main(String[] args) throws InterruptedException {
        ExecArgs execArgs = ExecArgs.parse(args);
        Program.startDefault(new CellsNonBlockImpl(execArgs.N, execArgs.K), execArgs, false);
    }
}