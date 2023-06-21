package tgb.test.testbot.bot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

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
        String answer = run(text, chatId);
        sendMessage(chatId, answer);
    }

    public int step = 0;
    ArrayList<User> userList = new ArrayList<>();

    public String run(String inputText, Long chatId) {
        String answer = null;

        if (inputText.equals("/start")) {
            answer = "Для регистрации напишите /createuser \nДля проверки логина напишите /isexist \nДля проверки userID напишите /getid";
            step = 1;
        } else if (!inputText.equals("/createuser") && !inputText.equals("/isexist") && !inputText.equals("/getid") && step == 1) {
            answer = "Неизвестная команда";
            return answer;
        } else if (inputText.equals("/createuser") && step == 1) {
            answer = "Введите логин";
            step = 2;
        } else if (step == 2) {
            User user = new User(inputText, chatId);
            userList.add(user);
            answer = "Вы зарегистрированы";
            step = 0;
        }
        if (inputText.equals("/isexist") && step == 1) {
            answer = "Введите логин для проверки";
            step = 3;
        } else if (step == 3) {
            for (User user : userList) {
                if (inputText.equals(user.login)) {
                    answer = "Пользователь зареган";
                    step = 0;
                    break;
                }
            }
            if (answer == null) {
                answer = "Пользователь не зареган";
                step = 0;
            }
        }
        if (inputText.equals("/getid") && step == 1) {
            answer = "Введите логин для проверки userID";
            step = 4;
        } else if (step == 4) {
            for (User user : userList) {
                if (inputText.equals(user.login)) {
                    answer = String.valueOf(chatId);
                    break;
                }
            }
            if (answer == null) {
                answer = "Ползователь с таким логином не зареган";
                step = 0;
            }
        }
        if (answer == null) answer = "Для запуска бота, пропишите /start";
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

