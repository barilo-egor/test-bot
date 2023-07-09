package tgb.test.testbot.bot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

@Service
public class Bot extends TelegramLongPollingBot {
    private UserDataBase userDataBase = new UserDataBase();


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
        Command command;
        long chatId = update.getMessage().getChatId();
        User currentUser = userDataBase.getByChatId(chatId);
        if (currentUser != null && !currentUser.getCommand().equals(Command.START)) {
            command = currentUser.getCommand();
        } else {
            command = Command.getFromUpdate(update);
        }
        if (command == null) {
            sendMessage(chatId, "Неверная команда");
            return;
        }

        switch (command) {
            case START:
                String name;
                if (currentUser == null) {
                    name = "Guest";
                    update.getMessage().getFrom().getUserName();
                } else {
                    name = currentUser.getName();
                }
                sendMessage(chatId, "Привет  " + name +" " + "(" + update.getMessage().getFrom().getUserName() + ")" + " \nВозможные команды \n/findall \n/createuser \n/isexist \n/getid");
                break;
            case CREATE_USER:
                if (currentUser == null){
                    currentUser = userDataBase.add(chatId, Command.START, "Guest",0);
                }
                if (currentUser != null) {
                    sendMessage(chatId, "Вы уже зарегистрированы");
                } else {
                }
                sendMessage(chatId, "Введите имя для регистрации");

                String name1 = update.getMessage().getText();
                break;
            case GET_ID:
                sendMessage(chatId, "Ваш id: " + chatId);
                break;
            case IS_EXIST:
                boolean isRegistred = false;
                sendMessage(chatId, "Проверка регистрации");
                ArrayList<User> users1 = new ArrayList<>();
                for (User user1 : userDataBase.findAll()) {
                    if (user1.equals(userDataBase.getByChatId(chatId))) {
                        isRegistred = true;
                        break;
                    }
                }
                if (isRegistred) {
                    sendMessage(chatId, "Зареган");
                } else {
                    sendMessage(chatId, "Не зареган");
                }
                break;

            case FIND_ALL:
                ArrayList<User> users = new ArrayList<>();
                int numMenu = 1;
                sendMessage(chatId, "Пользователи Бота:  \n");
                for (User user1 : userDataBase.findAll()) {
                    sendMessage(chatId, numMenu + ". " +
                            "Имя: " + user1.getName() +
                            "\n    Шаг: " + user1.getStep() +
                            "\n    Команда: " + user1.getCommand() +
                            "\n    ID: " + user1.getChatId());
                    numMenu++;
                }
                break;
        }
    }

    public String run(String inputText, Long chatId) {
        return null;
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

