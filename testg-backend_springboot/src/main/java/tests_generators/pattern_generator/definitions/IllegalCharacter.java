package tests_generators.pattern_generator.definitions;

import lombok.Getter;
import tests_generators.utils.enums.CharactersUtils;

@Getter
public class IllegalCharacter {

    String character;
    String alias;

    public IllegalCharacter(String character) {
        this.character = character;
        this.alias = CharactersUtils.characterToString(character);
    }
}
