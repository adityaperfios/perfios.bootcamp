import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpData {
    public Statement getStatement()

    {  Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfsb2", "root", "password");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }
    public int saveEmp(Employee emp){
        String sql = null;
        try{
            sql = "insert into emp1 values("+emp.getId()+",'"+emp.getName()+"','"+emp.getSalary()+"')";
            return getStatement().executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int update(Employee emp){
        try{
            String sql = "update emp1 set emp_name="+emp.getName()+",emp_salary="+emp.getSalary()+" where id="+emp.getId()+"";
            return getStatement().executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int deleteEmp(Employee emp){
        try {
            String sql = "delete from emp1 where id="+emp.getId()+" ";
            return getStatement().executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public List<Employee> getAllEmp(){
        List<Employee> empList = new ArrayList<Employee>();

        try{
            String sql = "select * from emp1";
            ResultSet rs = getStatement().executeQuery(sql);

            while(rs.next()){
                Employee emp = new Employee();
                emp.setId(rs.getInt(1));
                emp.setName(rs.getString(2));
                emp.setSalary(rs.getDouble(3));
                empList.add(emp);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return empList;
    }

}
