package tgb.test.testbot.bot;

import java.util.ArrayList;

public class AmphibianDataBase {
    public ArrayList<Animal> amphibians = new ArrayList<>(10);
     {
        Animal amphibian1 = new Animal("Кавказская жаба", 123, "Земноводные");
        amphibians.add(0,amphibian1);
        Animal amphibian2 = new Animal("Обыкновенный тритон",32,"Земноводные");
        amphibians.add(amphibian2);
    }

    public Animal addAmphibians(String name, int numbers, String type) {
        Animal amphibian = new Animal();
        amphibian.setName(name);
        amphibian.setNumber(numbers);
        amphibian.setType(type);
        amphibians.add(amphibian);
        return amphibian;
    }
    public String printAmphibians(){
        StringBuilder sb = new StringBuilder();
        for (Animal r:amphibians){
            sb.append(r);
        }
        return sb.toString();
    }
}
