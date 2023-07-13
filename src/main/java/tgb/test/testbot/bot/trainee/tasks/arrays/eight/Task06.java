package tgb.test.testbot.bot.trainee.tasks.arrays.eight;

public class Task06 {
    public void run() {
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int sumArray1 = 0;
        int sumArray2 = 0;
        System.out.print("Array1: ");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 10);
            sumArray1 += array1[i];
            sumArray2 = sumArray1;
            System.out.print(array1[i] + " ");
        }
        System.out.println("\nsumArray1: " + sumArray1);

        System.out.print("Array2: ");
        for (int i = 0; i < array2.length; i++) {
            array2[i] = (int) (Math.random() * 10);
            sumArray2 += array1[i];

            System.out.print(array2[i] + " ");
        }
        System.out.println("\nsumArray2: " + sumArray2);
        System.out.println("Sum array1 and array2: " + (sumArray1 + sumArray2));
    }
}
