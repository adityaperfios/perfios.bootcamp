package banking_app;

import java.util.ArrayList;
import java.util.List;

public class Display {
    public static void Display(Banking_utils obj){
        List<Acc_Details> userList = new ArrayList<Acc_Details>();
        userList = obj.getAllUser();
        for(Acc_Details e:userList){
            System.out.println("=======================================================");
            System.out.println("Name = "+e.getName()+"\nUsername = "+e.getUsername()+"\nAccount No. = "+e.getAcc_no()+"\nAmount = "+e.getAmount()+
                    "\nAddress = "+e.getAddress()+"\nEmail = "+e.getEmail()+"\nPhone no. = "+e.getPhone_no());
        }
        System.out.println("=======================================================");

    }
}
