import java.util.ArrayList;
import java.util.List;

public class Display {
    public static void Display(Worker_Data obj){
        List<Worker> userList = new ArrayList<Worker>();
        userList = obj.getAllEmp();
        for(Worker e:userList){
            System.out.println("=======================================================");
            System.out.println("Worker ID = "+e.getWorkerId()+"\nFirst Name = "+e.getFname()+"\nLast Name = "+e.getLname()+"\nsalary = "+e.getSal()+
                    "\nDate = "+e.getJoinDate()+"\nDeptartment = "+e.getDept());
        }
        System.out.println("=======================================================");

    }
}