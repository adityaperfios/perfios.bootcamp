import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Insert_Values {
    public static void insert(Worker user) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter work id");
        int wid = sc.nextInt();
        System.out.println("enter first name");
        String fname = sc.next();
        System.out.println("enter last name");
        String lname = sc.next();
        System.out.println("enter salary");
        Double sal = sc.nextDouble();
        //System.out.println("enter acc_no");
        //Long acc_no = sc.nextLong();
        System.out.println("enter Joining Date format(yyyy/mm/dd)");
        String Sdate = sc.nextLine();
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(Sdate);
        System.out.println("enter department");
        String dept = sc.next();
        System.out.println("enter phone no.");
        Long phone_no = sc.nextLong();

        user.setWorkerId(wid);
        user.setFname(fname);
        user.setLname(lname);
        //user.setAcc_no(acc_no);
        user.setSal(sal);
        user.setJoinDate(date);
        user.setDept(dept);
        Worker_Data obj = new Worker_Data();
        int x = obj.savedDetails(user);
        if(x>0){
            System.out.println("one record updated");
        }
    }
}
