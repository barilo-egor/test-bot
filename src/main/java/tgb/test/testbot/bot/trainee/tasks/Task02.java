package tgb.test.testbot.bot.trainee.tasks;

import java.util.Scanner;

public class Task02 {
    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int num = in.nextInt();
        int[] arrayInt = new int[num];
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = (int) (Math.random() * 10);
            System.out.print("Было: " + arrayInt[i] + " ");
            if (arrayInt[i] >= 5) {
                arrayInt[i] = 1;
            } else {
                arrayInt[i] = 0;
            }
            System.out.println("Стало: " + arrayInt[i]);
        }
    }
}