package tgb.test.testbot.bot.trainee.tasks.arrays.eight;

public class Task10 {
    public void run() {
        int[] array = {1, 2, -6, 3, 4};
        int[] array1 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        int f = 0;
        for (int i = 0; i < array.length; i++) {
            array1[f] = array[i] * -1;
            System.out.print(array1[f]);
            if (i != array1.length - 1) {
                System.out.print(", ");
            }
            f++;
        }
    }
}
