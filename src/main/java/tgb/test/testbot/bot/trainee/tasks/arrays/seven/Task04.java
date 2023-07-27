package tgb.test.testbot.bot.trainee.tasks.arrays.seven;

import java.util.Arrays;

public class Task04 {
    public void run() {
        int[] array = {10,4, 8, 6, 1};
        Arrays.sort(array);
        int amount = 0;
        for (int i = 1; i < array.length; i++) {
            amount += (array[i] - array[i - 1]) - 1;
        }
        System.out.println(amount);
    }
}
