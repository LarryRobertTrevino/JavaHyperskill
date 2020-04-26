package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        double wordsCounts = 1;
        double sentencesCounts = 1;
        for (int i = input.length - 2; i >= 0; i--) {
            if (input[i].matches(".+[.!?]")) {
                sentencesCounts++;
            }
            wordsCounts++;
        }
        double estimate = wordsCounts / sentencesCounts;
        if (estimate > 10) {
            System.out.println("HARD");
        } else System.out.println("EASY");

    }
}
