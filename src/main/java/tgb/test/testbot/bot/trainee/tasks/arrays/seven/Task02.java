package tgb.test.testbot.bot.trainee.tasks.arrays.seven;

public class Task02 {
    public void run(String[] strings) {
     //   String []strings = {"Привет","Егор","я","сделал"};
        int z = 1;
        for (int i = 0; i < strings.length; i++) {
            System.out.print(z + ": " + strings[i]);
            z++;
            if (i != strings.length -1){
                System.out.print(", ");
            }
        }
    }
}
