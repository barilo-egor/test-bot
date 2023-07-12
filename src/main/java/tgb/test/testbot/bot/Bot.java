package tgb.test.testbot.bot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class Bot extends TelegramLongPollingBot {
    private UserDataBase userDataBase = new UserDataBase();
    String type = null;
    String name = null;
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
        AmphibianDataBase amphibianDataBase = new AmphibianDataBase();
        Command command;
        long chatId = update.getMessage().getChatId();
        String text = update.getMessage().getText();
        String answer = run(text, chatId);
        int step;
        User currentUser = userDataBase.getByChatId(chatId);
        Animal animal = new Animal();
        if (currentUser != null && currentUser.getStep() != 0 ) {
            command = currentUser.getCommand();
            step = currentUser.getStep();
        } else {
            command = Command.getFromUpdate(update);
            step = 0;
        }
        if (command == null) {
            sendMessage(chatId, "Неверная команда");
            return;
        }


        switch (command) {
            case START:
                sendMessage(chatId, "Красаная Книга РБ \n/amphibians (Земноводные). \n/birds (Птицы). \n/plants (Растения).\n/add (Добавить живтоное)");
                command = Command.valueOf(update.getMessage().getText());
                break;
            case AMPHIBIANS:
                sendMessage(chatId, amphibianDataBase.printAmphibians());
                break;
            case BUFO:
                sendMessage(chatId, "Особи достаточно крупные, длина тела жабы может достигать 19 см. ");
                break;
            case BIRDS:
                sendMessage(chatId, "Птицы:");
                break;
            case PLANTS:
                sendMessage(chatId, "Растения: ");
                break;
            case ADD_ANIMAL:
                int number = 0;
                if (step == 0) {
                    sendMessage(chatId, "Введите имя");
                    currentUser.setStep(currentUser.getStep()+1);
                    currentUser.setCommand(Command.ADD_ANIMAL);
                }else if (step == 1) {
                    name = update.getMessage().getText();
                    sendMessage(chatId, "Введите кол-во особей");

                } else if (step == 2) {
                    number = Integer.parseInt(update.getMessage().getText());
                    sendMessage(chatId, "Введите вид");
                } else if (step == 3) {
                    type = update.getMessage().getText();
                    amphibianDataBase.addAmphibians(name, number, type);
                }
                currentUser.setStep(currentUser.getStep()+1);
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

