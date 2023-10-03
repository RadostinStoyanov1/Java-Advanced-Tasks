package P13DefiningClasses.P03BankAccounts;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccountsMap = new HashMap<>();
        while (true) {
            String[] line = scanner.nextLine().split("\\s+");
            if (line[0].equals("End")) {
                break;
            }

            switch (line[0]) {
                case "Create":
                    createBankAccount(bankAccountsMap);
                    break;
                case "Deposit":
                    depositSum(Integer.parseInt(line[1]), Double.parseDouble(line[2]), bankAccountsMap);
                    break;
                case "SetInterest":
                    setInterest(Double.parseDouble(line[1]));
                    break;
                case "GetInterest":
                    getInterest(Integer.parseInt(line[1]), Integer.parseInt(line[2]), bankAccountsMap);
                    break;
            }
        }
    }

    private static void getInterest(int id, int years, Map<Integer, BankAccount> bankAccountsMap) {
        if (bankAccountsMap.containsKey(id)) {
            System.out.printf("%.2f%n", bankAccountsMap.get(id).getInterestRate(years));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }

    private static void depositSum(int id, double amount, Map<Integer, BankAccount> bankAccountsMap) {
        if (bankAccountsMap.containsKey(id)) {
            bankAccountsMap.get(id).deposit(amount);
            System.out.printf("Deposited %.0f to ID%d%n", amount, id);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createBankAccount(Map<Integer, BankAccount> bankAccountsMap) {
        BankAccount ba = new BankAccount();
        bankAccountsMap.put(ba.getId(), ba);
        System.out.println("Account ID" + ba.getId() + " created");
    }
}
