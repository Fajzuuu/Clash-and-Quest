package src.item;
import src.character.Character;

public interface Item {

    String getName();

    String getDescription();

    int getPrice();

    void use(Character player);
}