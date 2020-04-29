package readability;

import java.util.ArrayList;
import java.util.List;

public class ReadAbilityTest {
    private final TextComponents textComponents;
    private final String method;
    private final List<Integer> ages = new ArrayList<>();
    private final List<Double> scores = new ArrayList<>();

    public ReadAbilityTest (String method, TextComponents textComponents) {
        this.method = method;
        this.textComponents = textComponents;
    }

    public void execute() {
        switch (method) {
            case "ARI":
                automatedReadabilityIndex();
                break;
            case "FK":
                fleshKincaidReadabilityTests();
                break;
            case "SMOG":
                simpleMeasureOfGobbledygook();
                break;
            case "CL":
                colemanLiauIndex();
                break;
            case "all":
                automatedReadabilityIndex();
                fleshKincaidReadabilityTests();
                simpleMeasureOfGobbledygook();
                colemanLiauIndex();
                break;
            default:
                break;
        }
        print();
    }

    private void automatedReadabilityIndex() {
        calculateCorrespondedAge(4.71 * (textComponents.getCharacters() / (double) textComponents.getWords()) + 0.5 * (textComponents.getWords() / (double) textComponents.getSentences()) - 21.43);
    }

    private void fleshKincaidReadabilityTests() {
        calculateCorrespondedAge(0.39 * (textComponents.getWords() / (double) textComponents.getSentences()) + 11.8 * (textComponents.getSyllables() / (double) textComponents.getWords()) - 15.59);
    }

    private void simpleMeasureOfGobbledygook() {
        calculateCorrespondedAge(1.043 * Math.sqrt(textComponents.getPolysyllables() * (30.0 / textComponents.getSentences())) + 3.1291);
    }

    private void colemanLiauIndex() {
        double L = textComponents.getCharacters() / (double) textComponents.getWords() * 100;
        double S = textComponents.getSentences() / (double) textComponents.getWords() * 100;
        calculateCorrespondedAge(0.0588 * L - 0.296 * S - 15.8);
    }

    private void calculateCorrespondedAge(double score) {
        scores.add(score);
        int tempScore = (int) Math.ceil(score);
        int[] CorrespondedAge = {6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 24};
        if (tempScore - 1 < 13) {
        ages.add(CorrespondedAge[tempScore - 1]);
        } else ages.add(25);
    }

    private void print() {
        System.out.println();
        String[] methodsNames = {"Automated Readability Index", "Flesch–Kincaid readability tests", "Simple Measure of Gobbledygook", "Coleman–Liau index"};
        int n = 1;
        int methodName = 0;
        switch (method) {
            case "ARI":
                methodName = 0;
                break;
            case "FK":
                methodName = 1;
                break;
            case "SMOG":
                methodName = 2;
                break;
            case "CL":
                methodName = 3;
                break;
            case "all":
                n = 4;
                break;
            default:
                break;
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%s: %.2f (about %d year olds).%n", methodsNames[methodName], scores.get(i), ages.get(i));
            methodName++;
        }

        if (n > 1) {
            System.out.println();
            int sumAges = 0;
            for (int a : ages) {
                sumAges += a;
            }
            double averageAge = sumAges / (double)ages.size();
            System.out.printf("This text should be understood in average by %.2f year olds.%n", averageAge);
        }
    }
}
