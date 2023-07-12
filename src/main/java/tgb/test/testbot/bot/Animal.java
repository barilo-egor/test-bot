package tgb.test.testbot.bot;

import java.util.Objects;

public class Animal {
    public String name;
    public int number;
    public String type;

    public Animal() {

    }

    public Animal(String name, int number, String type) {
        this.name = name;
        this.number = number;
        this.type = type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType(), getNumber());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Animal(String name, String type, int number) {
        this.name = name;
        this.type = type;
        this.number = number;
    }

    @Override
    public String toString() {
        return "\n" +
                name +
                ".\nВид: " + type +
                ".\nКолличество особей: " + number + ".\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return getNumber() == animal.getNumber() && Objects.equals(getName(), animal.getName()) && Objects.equals(getType(), animal.getType());
    }
}
