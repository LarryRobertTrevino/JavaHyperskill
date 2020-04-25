package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File inputData = new File(args[1]);
        List<person> data = enterData(inputData);
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            printMenu();
            int answer = scanner.nextInt();
            scanner.nextLine();
            switch (answer) {
                case 1:
                    search(data);
                    break;
                case 2:
                    for (person a : data) {
                        System.out.println(a.toString());
                    }
                    break;
                case 0:
                    go = false;
                    System.out.println();
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    public static List<person> enterData(File file) {
        List<person> data = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] temp = scanner.nextLine().split("\\s+");
                switch (temp.length) {
                    case 2:
                        data.add(new person(temp[0],temp[1]));
                        break;
                    case 3:
                        data.add(new person(temp[0],temp[1],temp[2]));
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + file);
        }
        return data;
    }

    public static void search(List<person> data) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name or email to search all suitable people.");
        String request = scanner.nextLine();
        Pattern pattern = Pattern.compile(request, Pattern.CASE_INSENSITIVE);
        boolean found = false;
        List<person> founded = new LinkedList<>();
        for( person a : data) {
            Matcher matcher = pattern.matcher(a.toString());
            if (matcher.find()) {
                found = true;
                founded.add(a);
            }
        }
        if (!found) {
            System.out.println("No matching people found.");
        } else {
            System.out.println();
            System.out.println("Found people:");
            for (person a : founded) {
                System.out.println(a.toString());
            }
        }
        System.out.println();
    }
}

class person {
    String firstName;
    String lastName;
    String email;

    public person(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        if (email != null)
            return firstName + " " + lastName + " " + email;
        return firstName + " " + lastName;
    }
}
