import java.util.Scanner;

public class BankingSystem {
    protected String name;
    protected String id;

    protected Double balance;
    protected Double withdraw;
    protected Double deposit;
    protected Double transaction;

    String option;

    Scanner scan = new Scanner(System.in);

    protected void signin(String username, String UserId) {
        name = username;
        id = UserId;
    }

    protected void deposit(Double amountDeposited) {
        System.out.println("Enter the amount you wish to deposit: ");
        amountDeposited = scan.nextDouble();
        if (deposit > 0) {
            deposit = amountDeposited;
            // if (balance == null) {
            //     balance = deposit;
            // }else{
            //     balance  = balance + deposit;
            // }
             balance  = balance + deposit;
            transaction = amountDeposited;
            System.out.println("====================");
            System.out.println(name + ": " + " You deposited £" + deposit);
            System.out.println("====================");
        } else {
            System.out.println("Invalid");
            System.out.println("Please enter a valid amount that is higher than 0");
            System.exit(0);
        }

    }

    protected void withdrawal(Double amountWithdrawn) {
        System.out.println("Enter the amount you wish to withdraw: ");
        amountWithdrawn = scan.nextDouble();
        if (amountWithdrawn == 0) {
            System.out.println("Invalid");
            System.out.println("Please enter a valid amount that is higher than 0");
            System.exit(0);
        } else {
            withdraw = amountWithdrawn;
            balance = balance - withdraw;
            transaction = amountWithdrawn;
            System.out.println("====================");
            System.out.println(name + ": " + "You withdrew £" + withdraw);
            System.out.println("====================");
        }

        // if (balance == null) {
        // System.out.println("Your account is empty. Please make a deposit");
        // System.exit(0);
        // }
    }

    protected String getTransaction() {
        return name + ": " + transaction;
    }

    protected void menu() {
        do {
            System.out.println("Pick an option between 'deposit, withdraw, transaction'");
            option = scan.next();

            switch (option) {
                case "deposit":
                    deposit(deposit);
                    break;
                case "withdraw":
                    withdrawal(withdraw);
                    break;
                case "transaction":
                    if (transaction != null) {
                        System.out.println("====================");
                        getTransaction();
                        System.out.println("====================");
                    } else {
                        System.out.println("====================");
                        System.out.println("You have made no transactions");
                        System.out.println("====================");
                    }

                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pick an option between 'transaction, withdraw, deposit'");

            }
        } while (true);
    }

}
