package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(args[0])));
        TextComponents textComponents = new TextComponents(text);
        textComponents.printComponents();
        printMenu();
        ReadAbilityTest readAbilityTest = new ReadAbilityTest(getAnswer(), textComponents);
        readAbilityTest.execute();
    }

    public static void printMenu() {
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
    }

    public static String getAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
