package banking_app;

import java.util.Scanner;

public class AccTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Acc_Details user = new Acc_Details();
        Banking_utils obj = new Banking_utils();
        while(true){
            System.out.println("Menu");
            System.out.println("\n1.Insert\n2.Update\n3.Delete\n4.Display\n5.Exit");
            System.out.println("enter your choice");
            int choice = sc.nextInt();
            switch (choice){
                case 1:{
                    Insert_Values.insert(user);
                }break;
                case 2:
                {
                    System.out.println("enter acc no to be updated");
                    int acc_no = sc.nextInt();
                    int chk = obj.update(acc_no);
                    if(chk==0){
                        System.out.println("credentials not updated");
                    }else {
                        System.out.println("Credentials updated");
                    }
                }break;
                case 3:{
                    System.out.println("Enter acc_no to be deleted");
                    long acc_no = sc.nextLong();
                    int chk = obj.deleteUser(user,acc_no);
                    if(chk==0){
                        System.out.println("Item not deleted");
                    }
                    else {
                        System.out.println("Item deleted");
                    }
                }break;
                case 4:
                {
                    Display.Display(obj);
                }break;
                case 5:{
                    System.exit(1);
                }
                default:
                    System.out.println("Enter correct choice");
            }

        }

    }

}
