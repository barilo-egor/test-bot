package tgb.test.testbot.bot;

import org.telegram.telegrambots.meta.api.objects.Update;

public enum Command {
    FIND_ALL ("/findall",true),
    START("/start", false),
    CREATE_USER("/createuser", true),
    IS_EXIST("/isexist", true),
    GET_ID("/getid", false);

    private final String userCommand;
    private final boolean isAdmin;

    Command(String userCommand, boolean isAdmin) {
        this.userCommand = userCommand;
        this.isAdmin = isAdmin;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public String getUserCommand() {
        return userCommand;
    }

    static Command getFromUpdate(Update update) {
        Command[] commands = Command.values();
        for (Command command : commands) {
            if (update.getMessage().getText().equals(command.getUserCommand())) {
                return command;
            }
        }
        return null;
    }
}
