package InterfaceChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Employee emp1 = new Director(30001,"Michael", "Jackson", 125000.00,
                "Executive Management");
        Employee emp2 = new Manager(30002, "Sheila", "Griffin", 77000.09,
                "Human Resources");
        Employee emp3 = new ShopAssistant(30003, "Wasim", "Hussein", 28500.00,
                "Retail");


        ArrayList<String> emp1Details = saveToStorageList(emp1);

        retrieveDataFromStorageList(emp2);
        ArrayList<String> emp2Details = saveToStorageList(emp2);
        ArrayList<String> emp3Details = saveToStorageList(emp3);


    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static ArrayList saveToStorageList(Employee e) throws IllegalAccessException {
        return e.valuesToList();
    }

    public static void retrieveDataFromStorageList(ISaveable e){
        ArrayList<String> data = readValues();
        e.populateFromList(data);
    }
}
