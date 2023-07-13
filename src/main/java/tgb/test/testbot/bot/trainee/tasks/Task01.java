package tgb.test.testbot.bot.trainee.tasks;

import java.util.Scanner;

public class Task01 {
    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во чисел");
        int num = in.nextInt();
        if (num == 0) {
            System.out.println("0");
        }
        int[] arrayItn = new int[num];
        int sum = 0;
        int averageValue;
        System.out.println("Числа массива:");
        for (int i = 0; i < arrayItn.length; i++) {
            arrayItn[i] = (int) (Math.random() * 100);
            sum += arrayItn[i];
            System.out.println(arrayItn[i]);
        }
        averageValue = sum / arrayItn.length;
        System.out.println("Среднее значение" + averageValue);
    }
}
