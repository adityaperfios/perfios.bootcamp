package courierservice;
import java.time.LocalDate;

public class Details {
private int track_id;
private String cust_name;
private String city;
private long phn;
private String delivery_area;
private double wt;
private double rpg=0.1;
private LocalDate book_date;
private	LocalDate del_date;
private double Pay_amt;
public double getPay_amt() {
	return Pay_amt;
}
public void setPay_amt(double amount) {
	this.Pay_amt = amount;
}
public int getTrack_id() {
	return track_id;
}
public void setTrack_id(int track_id) {
	this.track_id = track_id;
}
public String getCust_name() {
	return cust_name;
}
public void setCust_name(String cust_name) {
	this.cust_name = cust_name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public long getPhn() {
	return phn;
}
public void setPhn(long phn) {
	this.phn = phn;
}
public String getDelivery_area() {
	return delivery_area;
}
public void setDelivery_area(String delivery_area) {
	this.delivery_area = delivery_area;
}
public double getWt() {
	return wt;
}
public void setWt(double wt) {
	this.wt = wt;
}
public double getRpg() {
	return rpg;
}
public void setRpg(double rpg) {
	this.rpg = rpg;
}
public LocalDate getBook_date() {
	return book_date;
}
public void setBook_date(LocalDate book_date) {
	this.book_date = book_date;
}
public LocalDate getDel_date() {
	return del_date;
}
public void setDel_date(LocalDate del_date) {
	this.del_date = del_date;
}

}
