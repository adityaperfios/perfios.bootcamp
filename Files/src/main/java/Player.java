import java.io.Serializable;

public class Player implements Serializable {
    public int id;
    public String name;
    public String type;
    public String city;
    public transient int pin;//transient won't participate in Serialization (won't write/store the data)


}
