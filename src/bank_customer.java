import java.util.Scanner;
class negativeAmountException extends Exception{
    public String getMessage(){
        return "invalid input,PLEASE TRY AGAIN!"; }
}
public class bank_customer {
    int acc_no;
    String name="kannu priya";
    double balance=0.0;
    int branch_code=1906481;
    int amount;
    public void deposit(int amount){
        balance=balance+amount;
        System.out.println("amount deposited successfully");
    }

    public void withdraw(int amount){
        balance=balance-amount;
        System.out.println("withdrawal successful");

    }
    public void check_balance(){
        System.out.println("available balance in your bank account is Rs." + balance);
    }
    public static void main(String[] args) {
        boolean exit=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter account number of customer:");
        int acc_no=sc.nextInt();
        bank_customer bc=new bank_customer();
        System.out.println("account holder name:" +bc.name);
        System.out.println("account holder branch code:" +bc.branch_code);

        do{
            System.out.println("enter 0 to deposit in your bank account\nenter 1 for withdrawal from your bank account\nenter 2 for check balance of your account\nenter 3 for exit from database\n");
            int code=sc.nextInt();
            switch (code){
                case 0:
                    System.out.println("enter amount to deposit");
                    int amount=sc.nextInt();
                    if (amount<0) {
                        try {
                            throw new negativeAmountException();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else {
                        bc.deposit(amount);}
                    break;

                case 1:
                    System.out.println("enter amount to withdraw");
                    amount=sc.nextInt();
                    if (amount>bc.balance) {
                        try {
                            throw new negativeAmountException();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else {
                        bc.withdraw(amount);
                    }break;
                case 2:
                    bc.check_balance();break;
                case 3:
                    exit = true;break;
                default:
                    System.out.println("invalid choice!");break;}
            System.out.println();
        }

        while (!exit);
        System.out.println("your are exited from bank database!");
    }
}
