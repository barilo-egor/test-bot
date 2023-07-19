package tgb.test.testbot.bot.trainee.tasks.arrays.eight;

public class Task08 {
    public void run() {

        int[] num = {3,-24,11,-4};
        int sum = 0;
        System.out.println("Массив:");
        for (int j : num) {
            System.out.println(j);
            if (j > 0) {
                sum += j;
            }
        }
        System.out.println("Сумма положительных чисел " + sum);
    }
}
