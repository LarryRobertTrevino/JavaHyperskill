package search;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<person> data = enterData();
        search(data);
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
        System.out.println("Enter the number of search queries:");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        String[] queries = new String[n];
        for (int i = 0; i < n; i++) {
            boolean found = false;
            List<person> founded = new LinkedList<>();
            System.out.println("Enter data to search people:");
            queries[i] = scanner.nextLine();
            for( person a : data) {
                if (a.firstName.equalsIgnoreCase(queries[i]) || a.lastName.equalsIgnoreCase(queries[i])) {
                    founded.add(a);
                    found = true;
                    continue;
                }
                if (a.email != null) {
                    if (queries[i].equals("@")) {
                        founded.add(a);
                        found = true;
                        continue;
                    }
                    String[] partOfEmail = a.email.split("\\W");
                    for (String b : partOfEmail) {
                        if (b.equalsIgnoreCase(queries[i])) {
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
        return firstName + " " + lastName + " " + email;
    }
}
