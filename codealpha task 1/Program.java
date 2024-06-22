import java.util.Scanner;
public class Program{
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("please enter your name : ");
    String name = sc.nextLine();
    System.out.println("welcome to our bank");
    System.out.println("Hello "+name);
    
    System.out.println("for continue in english press 1:");
  
    int lang=sc.nextInt();
    if(lang==1){
        System.out.println(" Press 1 for Balance enquiry");
        System.out.println(" Press 2 for Withdrawl");
        System.out.println(" Press 3 for Deposit");  
        System.out.println(" Press 4 for Exit");
    }
      else
      System.out.println("invalid input");
    
    int func=sc.nextInt();
    switch (func){
        case 1:
        int amount = 35000;
        System.out.println("your account balance is: "+amount);
        break ;
       case 2:
       System.out.println("enter the amount you want to withdrawl:");
       Scanner Sc= new Scanner(System.in);
       int withdrawl=sc.nextInt();
       int available=35000-withdrawl;
       System.out.println("please collect your cash ");
       System .out.println ("your available balance is : "+available);
        break ;
        case 3:
        System.out.println("enter the amount you want to deposit");
       int deposit=sc.nextInt();
       int avail=35000+deposit;
       System .out.println ("your available balance is : "+avail);
        break ;
       case 4:
        System.out.println("thank you for using our services");
        break ;
        case 5:
        System.out.println("invalid input");
        break;
        
    }
    
    
    }
    
}
