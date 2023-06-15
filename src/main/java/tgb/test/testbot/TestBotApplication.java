package tgb.test.testbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.facilities.TelegramHttpClientBuilder;

@SpringBootApplication
public class TestBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBotApplication.class, args);
    }

}
