package banking_app;
import java.util.Scanner;

public class Insert_Values {
    public static void insert(Acc_Details user){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name");
        String name = sc.next();
        System.out.println("enter username");
        String username = sc.next();
        System.out.println("enter password");
        String password = sc.next();
        System.out.println("enter password again");
        String re_pass = sc.next();
        sc.nextLine();
        //System.out.println("enter acc_no");
        //Long acc_no = sc.nextLong();
        System.out.println("enter Address");
        String Address = sc.nextLine();
        System.out.println("enter email");
        String email = sc.next();
        System.out.println("enter phone no.");
        Long phone_no = sc.nextLong();

        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        //user.setAcc_no(acc_no);
        user.setAddress(Address);
        user.setEmail(email);
        user.setPhone_no(phone_no);
        Banking_utils obj = new Banking_utils();
        int x = obj.saveDetails(user);
        if(x>0){
            System.out.println("one record updated");
    }
}
}
