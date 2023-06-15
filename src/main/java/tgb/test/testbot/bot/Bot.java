package tgb.test.testbot.bot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "testBotg234_bot";
    }

    @Override
    public String getBotToken() {
        return "6023855767:AAGU3BLB3uUa7fQ0JgNSutizYk3AY45reBQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        String answerText = run(text);
        sendMessage(chatId, answerText);
    }

    public String name;

    public String city;

    public int step = 0;

    public String run(String inputText) {
        String answer = null;

        if (inputText.equals("/start")) {
            answer = "Введите свое имя.";
        } else if (step == 0) {
            name = inputText;
            step++;
            answer = "Введите свой город.";
        } else if (step == 1) {
            city = inputText;
            answer = "Ваше имя: " + name + "\nВаш город:" + city;
        }


        if (answer == null) answer = "Не понимаю";
        return answer;
    }

    public void sendMessage(Long chatId, String text) {
        try {
            this.execute(SendMessage.builder()
                    .chatId(chatId.toString())
                    .text(text)
                    .build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
