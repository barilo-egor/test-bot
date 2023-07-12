package tgb.test.testbot.bot;

import java.util.ArrayList;

public class UserDataBase {
    static ArrayList<User> userList = new ArrayList<>();

    static {
        User gleb = new User(431259592,Command.START,"Gleb Paukov",0);
        userList.add(gleb);
        User egor = new User(1654967182,Command.START, "Егор Ходиков",0);
        userList.add(egor);
        User egor2 = new User(393928596,Command.START, "Eгор Барило",0);
        userList.add(egor2);
        User arina = new User(1257255680, Command.START, "Арина Паукова",0);
        userList.add(arina);

    }

    public User add(Long chatID,Command command,String name,int step) {
        User user = new User();
        user.setName(name);
        user.setChatId(chatID);
        user.setCommand(Command.START);
        user.setStep(0);
        userList.add(user);
        return user;
    }

    public User getByChatId(long chatId) {
        for (User user : userList) {
            if (user.getChatId() == chatId) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> findAll() {
        return userList;
    }

    public int getStepByChatId(long chatId) {
        for (User user : userList) {
            if (user.getChatId() == chatId) {
                return user.getStep();
            }
        }
        return -1;
    }

    public Command getCommandByChatId(long chatId) {
        for (User user : userList) {
            if (user.getChatId() == chatId) {
                return user.getCommand();
            }
        }
        return null;
    }
}
