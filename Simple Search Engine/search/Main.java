package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Set<Integer>> searchMap = new LinkedHashMap<>();
        File inputData = new File(args[1]);
        List<Person> data = enterData(inputData, searchMap);
        AllSearcher allSearcher = new AllSearcher(data, searchMap);
        AnySearcher anySearcher = new AnySearcher(data, searchMap);
        NoneSearcher noneSearcher = new NoneSearcher(data, searchMap);
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            printMenu();
            int answer = scanner.nextInt();
            scanner.nextLine();
            switch (answer) {
                case 1:
                    System.out.println();
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    switch (scanner.nextLine()) {
                        case "ALL":
                            allSearcher.search();
                            break;
                        case "ANY":
                            anySearcher.search();
                            break;
                        case "NONE":
                            noneSearcher.search();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    for (Person a : data) {
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

    public static List<Person> enterData(File file, Map<String, Set<Integer>> searchMap) {
        List<Person> data = new ArrayList<>();
        int lineCount = 0;
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] temp = scanner.nextLine().split("\\s+");
                switch (temp.length) {
                    case 2:
                        data.add(new Person(temp[0],temp[1]));
                        break;
                    case 3:
                        data.add(new Person(temp[0],temp[1],temp[2]));
                    default:
                        break;
                }

                for (String a : temp) {
                    String b = a.toLowerCase();
                    if (!searchMap.containsKey(b)) {
                        searchMap.put(b, new LinkedHashSet<>());
                    }
                    searchMap.get(b).add(lineCount);
                }
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + file);
        }
        return data;
    }
}

class Person {

    String firstName;
    String lastName;
    String email;

    public Person(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public Person(String firstName, String lastName, String email) {
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

abstract class Searcher {

    Set<Integer> searchResult;
    String[] queries;
    List<Person> data;
    Map<String, Set<Integer>> searchMap;

    Searcher(List<Person> data, Map<String, Set<Integer>> searchMap) {
        this.data = data;
        this.searchMap = searchMap;
    }

    public void search() {
        getQuery();
        searchingProcess();
        printResult();
    }

    protected void getQuery() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name or email to search all suitable people.");
        queries = scanner.nextLine().toLowerCase().split("\\s+");
        scanner.close();
        searchResult = new LinkedHashSet<>();
    }

    protected void printResult(){
        if (searchResult.size() > 0) {
        System.out.println("" + searchResult.size() + " persons found:");
        for (Integer a : searchResult) {
            System.out.println(data.get(a).toString());
        }
        } else System.out.println("No matching people found.");
    }

    protected abstract void searchingProcess();
}

class AnySearcher extends Searcher {

    AnySearcher(List<Person> data, Map<String, Set<Integer>> searchMap) {
        super(data, searchMap);
    }

    @Override
    protected void searchingProcess() {
        for (String a : queries) {
            if (searchMap.get(a) != null) {
                searchResult.addAll(searchMap.get(a));
            }
        }
    }
}

class AllSearcher extends Searcher {

    AllSearcher(List<Person> data, Map<String, Set<Integer>> searchMap) {
        super(data, searchMap);
    }

    @Override
    protected void searchingProcess() {
        for (String a : queries) {
            if (searchMap.get(a) != null) {
                searchResult.addAll(searchMap.get(a));
            }
        }
        for (String a : queries) {
            if (searchMap.get(a) != null) {
                searchResult.retainAll(searchMap.get(a));
            }
        }
    }
}

class NoneSearcher extends Searcher {

    NoneSearcher(List<Person> data, Map<String, Set<Integer>> searchMap) {
        super(data, searchMap);
    }

    @Override
    protected void searchingProcess() {
        for (int i = 0; i < data.size(); i++) {
            searchResult.add(i);
        }
        for (String a : queries) {
            if (searchMap.get(a) != null) {
                searchResult.removeAll(searchMap.get(a));
            }
        }
    }
}
