
import org.junit.jupiter.api.*;

public class EmpTesting {
    EmpData obj = null;

    @BeforeAll
    public static void BeforeAll(){
        System.out.println("Before all the test cases");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("after all the testing");
    }
    @BeforeEach
    public void setUp(){
        System.out.println("Before test method");
    }
    @AfterEach
    public void setDown(){
        System.out.println("After test method");
    }
    @Test
    public void testEmpData(){
        System.out.println("emp data test");

    }
    @Test
    public void testEmpData1(){
        System.out.println("emp data test");
    }


}
