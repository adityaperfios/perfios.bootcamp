import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter id");
        int id = sc.nextInt();848
        System.out.println("enter name");
        String name = sc.next();
        System.out.println("enter salary");
        double salary = sc.nextDouble();
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);
        EmpData obj = new EmpData();
        int x = obj.saveEmp(emp);
        if(x>0){
            System.out.println("one record updated");
        }
//        List<Employee> empList = new ArrayList<Employee>();
//        empList = obj.getAllEmp();
//        for(Employee e:empList){
//            System.out.println("ID = "+e.getId()+"\nName = "+e.getName()+"\nSalary = "+e.getSalary());
//        }
    }
}
