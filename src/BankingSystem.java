import java.util.Scanner;

public class BankingSystem {
    protected String name;
    protected String id;

    protected Double balance = 0.0;
    protected Double withdraw;
    protected Double deposit;
    protected Double transaction;

    String option;

    Scanner scan = new Scanner(System.in);

    protected void signin(String username, String UserId) {
        name = username;
        id = UserId;
    }

    protected void accountHolding() {
        if (balance < 0.0) {
            System.out.println("You own the bank £" + Math.abs(balance));
        } else {
            System.out.println("Your account balance is now £" + balance);
        }
    }

    protected void deposit(Double amountDeposited) {
        System.out.println("Enter the amount you wish to deposit: ");
        amountDeposited = scan.nextDouble();
        if (amountDeposited > 0) {
            deposit = amountDeposited;
            balance = balance + deposit;
            transaction = amountDeposited;
            System.out.println("====================");
            System.out.println(name + ": " + " You deposited £" + deposit);
            accountHolding();
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
        } else if (balance == 0.0 || balance == null) {
            System.out.println("Your account is empty. Please make a deposit");
            System.exit(0);
        } else {
            withdraw = amountWithdrawn;
            balance = balance - withdraw;
            transaction = amountWithdrawn;
            System.out.println("====================");
            System.out.println(name + ": " + "You withdrew £" + withdraw);
            accountHolding();
            System.out.println("====================");
        }

    }

    protected void getTransaction() {
        System.out.println(name + ": " + transaction);
    }

    protected void menu() {
        do {
            System.out.println("Pick an option between 'deposit, withdraw, transaction' or enter '0' to exit");
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
                        System.out.println("You have made no transaction");
                        System.out.println("====================");
                    }
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pick an option between 'deposit, withdraw, transaction' or enter '0' to exit");

            }
        } while (true);
    }

}
