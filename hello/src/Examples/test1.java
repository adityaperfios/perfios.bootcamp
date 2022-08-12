package Examples;
import java.io.*;
class Student{
	private int id;
	private String name;
	private String city;
	
	public Student() {
		
	}
	
	public Student(int id,String name,String city)
	{
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
		
	}
	
	
}
public class test1 {
	
	public static void main(String[] args) {
		Student[] data = new Student[3];
		
		Student std1 = new Student(101,"Devesh","Lucknow");
		Student std2 = new Student(102, "Unnathi","Coorg" );
		Student std3 = new Student(103,"Saurav","Bangalore");
		
		data[0] = std1;
		data[1] = std2;
		data[2] = std3;
		
		for(Student obj : data)
		{
			System.out.println("ID : "+obj.getId()+"\nName = "+obj.getName()+"\nCity = "+obj.getCity());
		}
	}
}
