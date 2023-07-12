package tgb.test.testbot.bot;

import org.telegram.telegrambots.meta.api.objects.Update;

public enum Command {
    AMPHIBIANS ("/amphibians",false),
    START("/start", false),
    BIRDS("/birds", false),
    ADD_ANIMAL("/add", true),
    PLANTS ("/plants", false),
    BUFO("/BufoVerrucosissimus",false);
    private final String userCommand;
    private final boolean isAdmin;

    Command(String userCommand, boolean isAdmin) {
        this.userCommand = userCommand;
        this.isAdmin = isAdmin;
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
