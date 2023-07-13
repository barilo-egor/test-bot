package tgb.test.testbot.bot.trainee.tasks;

public class Task03 {
    public void run() {
        String str = "Егор, у меня получилось";
        String[] strArray = str.split(" ");
        for (String string : strArray) {
            System.out.println(string);
        }

    }
}
