import java.util.ArrayList;
import java.util.List;
public class EmpData {
    static List<Employee> listEmp = new ArrayList<Employee>();

    static {
        listEmp.add(new Employee(101,"Rock","Blr"));
        listEmp.add(new Employee(102,"King","hyd"));
        listEmp.add(new Employee(103,"Hero","Blr"));
        listEmp.add(new Employee(104,"Player","Blr"));
    }
    public List<Employee> empData(){
        return listEmp;
    }
}
