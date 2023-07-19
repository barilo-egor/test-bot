package tgb.test.testbot.bot.trainee.tasks.arrays.eight;

public class Task07 {
    public void run() {
        String[] match = {"3:1", "1:3", "2:2", "4:1", "2:1", "1:4", "2:5", "5:2", "1:1", "4:1"};
    }




    public static void score(String[] strings) {
        int teamA = 0;
        for (String string : strings) {
            String[] str = string.split(":");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            if (a > b) {
                teamA += 3;
            } else if (a == b) {
                teamA += 1;
            }
        }
        System.out.println("Result: " + teamA);
    }
}
