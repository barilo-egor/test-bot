package tgb.test.testbot.bot;

import java.util.ArrayList;

public class UserDataBase {
    static ArrayList<User> userList = new ArrayList<>();

    static {
        User egor = new User(1654967182, "gdf");
        userList.add(egor);
        User egor2 = new User(393928596, "gfd");
        userList.add(egor2);
        User arina = new User(1257255680, "gdfg");
    }

    public User getByChatId(long chatId) {
        for (User user : userList) {
            if (user.getChatId() == chatId) {
                return user;
            }
        }
        return null;
    }

    public int getStepByChatId(long chatId) {
        for (User user : userList) {
            if (user.getChatId() == chatId) {
                return user.getStep();
            }
        }
        return -1;
    }
    public String getCommandByChatId(long chatId) {
        for (User user : userList) {
            if (user.getChatId()==chatId){
                return user.getCommand();
            }
        }
        return null;
    }
}
