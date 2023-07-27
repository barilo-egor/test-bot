package tgb.test.testbot.bot.trainee.tasks.arrays.seven;

public class Task01 {
    public void run() {
        int[] array = {2,3,1};
        int sum = 0;
        System.out.println("Массив: ");
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            System.out.println(array[i]);
        }
        if (sum % 2 == 0 && sum != 0) {
            System.out.println("Чет");
        }else if (sum == 0) {
            System.out.println("Ноль");
        }else {
            System.out.println("Чет");
        }
    }
}
