package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String search = scanner.nextLine();
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals(search)) {
                answer = i + 1;
                break;
            }
        }
        if (answer == Integer.MIN_VALUE) {
            System.out.println("Not Found");
        } else System.out.println(answer);
    }
}
