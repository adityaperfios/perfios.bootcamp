import java.text.ParseException;
import java.util.Scanner;

public class WorkerTest {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Worker user = new Worker();
        Worker_Data obj = new Worker_Data();
        while(true){
            System.out.println("Menu");
            System.out.println("\n1.Insert\n2.Update\n3.Delete\n4.Display\n5.Fullname\n6.Distinct dept\n7.Find a in Amitabh\n8.Exit");
            System.out.println("enter your choice");
            int choice = sc.nextInt();
            switch (choice){
                case 1:{
                    Insert_Values.insert(user);
                }break;
                case 2:
                {
                    System.out.println("enter workerid");
                    int wid = sc.nextInt();
                    int chk = obj.update(user,wid);
                    if(chk==0){
                        System.out.println("credentials not updated");
                    }else {
                        System.out.println("Credentials updated");
                    }
                }break;
                case 3:{
                    System.out.println("Enter worker_id to be deleted");
                    int wid = sc.nextInt();
                    int chk = obj.deleteUser(user,wid);
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
                case 5:
                {
                    int chk = obj.query1();
                    if(chk==0){
                        System.out.println("Query failed");
                    }
                    else {
                        System.out.println("Query executed");
                    }
                }break;
                case 6:{
                    int chk = obj.query2();
                    if(chk==0){
                        System.out.println("Query failed");
                    }
                    else {
                        System.out.println("Query executed");
                    }
                }break;
                case 7:{
                    int chk = obj.query3();
                    if(chk==0){
                        System.out.println("Query failed");
                    }
                    else {
                        System.out.println("Query executed");
                    }
                }break;
                case 8:{
                    System.exit(1);
                }
                default:
                    System.out.println("Enter correct choice");
            }

        }

    }

}

