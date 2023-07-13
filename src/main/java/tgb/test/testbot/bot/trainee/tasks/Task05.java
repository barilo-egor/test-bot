package tgb.test.testbot.bot.trainee.tasks;

public class Task05 {
    public void run() {
        boolean[] sheep = {true, true, true, false,
                true, true, true, true,
                true, false, true, false,
                true, false, false, true,
                true, true, true, true,
                false, false, true, true};

        int result = 0;
        for (boolean r : sheep) {
            if (r) {
                result++;
            }
        }
        System.out.println(result);
    }
}
