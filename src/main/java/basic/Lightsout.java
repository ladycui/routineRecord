package basic;

import java.util.Scanner;

//cousera 程序设计与算法作业——熄灯问题（画家问题）

/**
 * 找到画家的最小画的个数，问题描述
 * https://www.coursera.org/learn/suanfa-jichu/programming/ZZOH8/bian-cheng-zuo-ye-mei-ju
 */

public class Lightsout {
    static int tmp;
    static int minSteps;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        minSteps = N * N;
        int[][] press = new int[N + 1][N + 2];
        int[][] pumple = new int[N + 1][N + 2];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                pumple[i][j] = scanner.nextInt();
        enumerate(press, pumple, N);
        if (minSteps >= N * N)
            System.out.println("inf");
        else {
            System.out.println(minSteps);

        }
    }

    public static void enumerate(int[][] press, int[][] pumple, int N) {
        int stepsin1;
        int cur;
        int steps;
        // press[1][1]=0;
        while (isWhile(press, N)) {
            cur = 1;
            stepsin1 = 0;
            while (press[1][cur] > 1) {
                press[1][cur] = 0;
                cur++;
                press[1][cur]++;
            }

            for (int j = 1; j <= N; j++)
                if (press[1][j] == 1)
                    stepsin1++;
            steps = stepsin1 + computeSteps(press, pumple, N);
            if (steps < minSteps)
                minSteps = steps;
            press[1][1]++;


        }
    }

    // 计算步数
    // yellow 0;white 1;press 1;unpress 0;
    public static int computeSteps(int[][] press, int[][] pumple, int N) {
        boolean success;
        int from2Steps = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                press[i + 1][j] = (pumple[i][j] + press[i][j] + press[i][j - 1] + press[i - 1][j] + press[i][j + 1]) % 2;
                if (press[i + 1][j] == 1)
                    from2Steps++;
            }
        }
        if (isOK(press, pumple, N)) {
            return from2Steps;
        }
        return N * N;
    }

    public static boolean isOK(int[][] press, int[][] pumple, int N) {
        for (int j = 1; j <= N; j++)
            if ((pumple[N][j] + press[N][j] + press[N][j - 1] + press[N - 1][j] + press[N][j + 1]) % 2 != 0)
                return false;
        return true;
    }

    static boolean isWhile(int[][] press, int N) {
        int sum = 0;
        for (int j = 1; j <= N; j++) {
            sum += press[1][j];
        }
        if (sum == N + 1)
            return false;
        return true;
    }
}
