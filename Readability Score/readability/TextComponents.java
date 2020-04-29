package readability;

import java.util.Arrays;
import java.util.List;

public class TextComponents {
    private int words;
    private int sentences;
    private int characters;
    private int syllables;
    private int polysyllables;
    private final List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y');

    public TextComponents(String text) {
        this.words = 0;
        this.sentences = 0;
        this.characters = 0;
        this.syllables = 0;
        this.polysyllables = 0;
        calculateComponents(text);
    }

    private void calculateComponents(String text) {
        String[] tempText = text.split("\\s+");
        words = tempText.length;
        for (String a : tempText) {
            processWord(a);
        }
        if (!tempText[tempText.length - 1].matches(".+[.!?]")) {
            sentences++;
        }
    }

    private void processWord(String word) {
        characters += word.length();
        char[] letters = word.toCharArray();
        int vowels = 0;
        boolean isPreviousVowel = false;
        boolean isCurrentVowel = false;
        for (char a : letters) {
            isPreviousVowel = isCurrentVowel;
            isCurrentVowel = isVowel(a);
            if (isCurrentVowel && !isPreviousVowel) {
                vowels++;
            }
        }
        if (!isPreviousVowel && letters[word.length()-1] == 'e') {
            vowels--;
        }
        if (letters[word.length() - 1] == '!' || letters[word.length() - 1] == '.' || letters[word.length() - 1] == '?') {
            sentences++;
        }
        if (vowels == 0) {
            syllables++;
        } else if (vowels > 2) {
            polysyllables++;
        }
        syllables += vowels;
    }

    private boolean isVowel(char character) {
        return vowels.contains(character);
    }

    public void printComponents() {
        System.out.printf("Words: %d%nSentences: %d%nCharacters: %d%nSyllables: %d%nPolysyllables: %d%n", words, sentences, characters, syllables, polysyllables);
    }

    public int getWords() {
        return words;
    }

    public int getSentences() {
        return sentences;
    }

    public int getCharacters() {
        return characters;
    }

    public int getSyllables() {
        return syllables;
    }

    public int getPolysyllables() {
        return polysyllables;
    }
}
