package tgb.test.testbot.bot.trainee.tasks.arrays.eight;

public class Task09 {
    public void run() {
        int[] num = {3, 2, 1, 4,};
        int result = 1;
        for (int x = 0; x < num.length; x++) {
            if (num[x] == 0) {
                System.out.println("В массиве есть ноль");
            } else {
                result = result * num[x];
            }
            if (x != num.length - 1)
                System.out.print(num[x] + " * ");
            else {
                System.out.print(num[x] + " ");
            }
        }
        System.out.println("= " + result);

    }
}
