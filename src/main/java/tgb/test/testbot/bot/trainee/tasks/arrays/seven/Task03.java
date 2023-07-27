package tgb.test.testbot.bot.trainee.tasks.arrays.seven;

import java.util.Scanner;

public class Task03 {
    public void run() {
        System.out.println("0? 5? 10?");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        String[] strings = new String[x];
        switch (x) {
            case 0:
                System.out.println("null");
                break;
            case 5:
                for (int i = 0; i < strings.length; i++) {
                    if (i % 2 == 0) {
                        strings[i] = "true";
                    } else {
                        strings[i] = "false";
                    }
                    System.out.println(strings[i]);
                }
                break;
            case 10:
                for (int i = 0; i < strings.length; i++) {
                    if (i % 2 == 0) {
                        strings[i] = "blue";
                    } else {
                        strings[i] = "red";
                    }
                    System.out.println(strings[i]);
                }
                break;
            default:
                System.out.println("Введите одно из этих чисел : 0,5,10");
        }
    }
}
