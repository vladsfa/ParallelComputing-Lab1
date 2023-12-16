package org.example;

public class ExecArgs {
    public final int N;
    public final int K;
    public final double p;

    public ExecArgs(int n, int k, double p) {
        this.N = n;
        this.K = k;
        this.p = p;
    }

    public static ExecArgs parse(String[] args){
        if (args.length != 3){
            System.err.println("Неправильна кількість аргументів");
            System.exit(1);
        }

        int N = Integer.parseInt(args[0]);
        int K = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);

        if (p < 0 || p > 1){
            System.err.println("Третій аргумент повинен бути в діапазоні від 0 до 1");
            System.exit(1);
        }

        return new ExecArgs(N, K, p);
    }
}
