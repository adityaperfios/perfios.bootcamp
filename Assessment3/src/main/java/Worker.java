import java.util.Date;

public class Worker {

    int workerId;
    String fname;
    String lname;
    double sal;
    Date joinDate;
    String dept;
    public Worker() {
        super();
    }
    public Worker(String fname, String lname, double sal, Date joinDate, String dept) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.sal = sal;
        this.joinDate = joinDate;
        this.dept = dept;
    }
    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    public Date getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
}