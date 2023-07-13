package tgb.test.testbot.bot.trainee.tasks;

public class Task04 {
    public void run() {

        String[] str = {"Егор", "у", "меня", "получилось"};
        String space = " ";
        String message = "";
        for (int i = 0; i < str.length;i++) {
            if (i != (str.length-1)){
                message = message.concat(str[i]).concat(space);
            }else {
                message = message.concat(str[i]);
            }
        }
        System.out.println("Message: " + message);

        String gfdg = String.join(" ", str);
        System.out.println("join: " + gfdg);
    }
}