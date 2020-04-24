package search;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<person> data = enterData();
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

    public static List<person> enterData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of people:");
        int n = scanner.nextInt();
        scanner.nextLine();
        List<person> data = new ArrayList<>();
        System.out.println("Enter all people:");
        for (int i = 0; i < n; i++) {
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
        System.out.println();
        return data;
    }

    public static void search(List<person> data) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name or email to search all suitable people.");
        String request = scanner.nextLine();
        boolean found = false;
        List<person> founded = new LinkedList<>();
        for( person a : data) {
            if (a.firstName.equalsIgnoreCase(request) || a.lastName.equalsIgnoreCase(request)) {
                founded.add(a);
                found = true;
                continue;
            }
            if (a.email != null) {
                if (request.equals("@")) {
                    founded.add(a);
                    found = true;
                    continue;
                }
                String[] partOfEmail = a.email.split("\\W");
                for (String b : partOfEmail) {
                    if (b.equalsIgnoreCase(request)) {
                        founded.add(a);
                        found = true;
                        break;
                    }
                }
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
