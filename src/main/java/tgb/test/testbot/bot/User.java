package tgb.test.testbot.bot;

import java.util.Objects;


public class User {
    private long chatId;
    private String command;
    private int step = 0;

    public User(long chatId, String command) {
        this.chatId = chatId;
        this.command = command;
    }

    public User() {

    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
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
        return "User{" +
                "id=" + chatId +
                ", command='" + command + '\'' +
                ", stap=" + step +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatId(), getCommand(), getStep());
    }
}

