package tgb.test.testbot.bot.trainee.tasks;

import java.util.Scanner;

// https://www.codewars.com/kata/56f69d9f9400f508fb000ba7
public class Task00 {

    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во обезьян");
        int number = in.nextInt();
        System.out.println("Подсчет обезбян: ");
        int[] monkey = new int[number];
        for (int i = 0; i < monkey.length; i++) {
            monkey[i] = i + 1;
            System.out.print(monkey[i]);
            if (i != monkey.length - 1) {
                System.out.print(",");
            }
        }
    }
}
