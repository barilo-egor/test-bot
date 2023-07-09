package tgb.test.testbot.bot;

import java.util.Objects;


public class User {
    private long chatId;
    private Command command;
    private int step = 0;
    private  String name;

    public User(long chatId, Command command,String name,int step) {
        this.chatId = chatId;
        this.command = command;
        this.name = name;
        this.step = step;
    }

    public User() {

    }

    public User(String text, long chatId,Command command,int step) {
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {

        this.chatId = chatId;
    }

    public Command getCommand() {

        return command;
    }

    public void setCommand(Command command) {

        this.command = command;
    }

    public int getStep() {

        return step;
    }

    public void setStep(int step) {

        this.step = step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getChatId() == user.getChatId() && getStep() == user.getStep() && Objects.equals(getCommand(), user.getCommand());
    }

    @Override
    public String toString() {
        return "User{" + "id=" + chatId + ", command='" + command + '\'' + ", step=" + step + ", name" + name + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatId(), getCommand(), getStep());
    }
}

