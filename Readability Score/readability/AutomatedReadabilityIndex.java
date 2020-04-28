package readability;

public class AutomatedReadabilityIndex {

    private double score;
    private int characters;
    private int words;
    private int sentences;
    private String age;

    AutomatedReadabilityIndex(String text) {
        this.characters = 0;
        this.words = 0;
        this.sentences = 0;
        calculateComponents(text);
        calculateScore();
        calculateCorrespondedAge();
    }

    public void printResult() {
        System.out.printf("Words: %d%nSentences: %d%nCharacters: %d%nThe score is: %.2f%nThis text should be understood by %s year olds.", words, sentences, characters, score, age);
    }

    private void calculateComponents(String text) {
        String[] tempText = text.split("\\s+");
        words = tempText.length;
        for (String a : tempText) {
            characters += a.length();
            if (a.matches(".+[.!?]")) {
                sentences++;
            }
        }
        if (!tempText[tempText.length - 1].matches(".+[.!?]")) {
            sentences++;
        }
    }

    private void calculateScore() {
        this.score = 4.71 * (characters / (double) words) + 0.5 * (words / (double) sentences) - 21.43;
    }

    private void calculateCorrespondedAge() {
        int tempScore = (int) score;
        if (score % 1 != 0) {
            tempScore++;
        }
        switch (tempScore) {
            case 1:
                age = "5-6";
                break;
            case 2:
                age = "6-7";
                break;
            case 3:
                age = "7-9";
                break;
            case 4:
                age = "9-10";
                break;
            case 5:
                age = "10-11";
                break;
            case 6:
                age = "11-12";
                break;
            case 7:
                age = "12-13";
                break;
            case 8:
                age = "13-14";
                break;
            case 9:
                age = "14-15";
                break;
            case 10:
                age = "15-16";
                break;
            case 11:
                age = "16-17";
                break;
            case 12:
                age = "17-18";
                break;
            case 13:
                age = "18-24";
                break;
            case 14:
                age = "24+";
                break;
            default:
                age = "";
                break;
        }
    }
}
