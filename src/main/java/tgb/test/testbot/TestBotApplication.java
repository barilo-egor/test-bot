package tgb.test.testbot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import tgb.test.testbot.bot.User;

@SpringBootApplication
public class TestBotApplication {

    public static void main(String[] args) {
      //  SpringApplication.run(TestBotApplication.class, args);
        User egor = new User(1654967182,"fsdfsdfsd");
        System.out.println(egor.toString());
    }

}
