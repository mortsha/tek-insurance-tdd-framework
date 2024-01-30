package tek.examples;

import org.testng.annotations.*;

public class FirstTestNGTest {

    @BeforeMethod
    public void setupTest(){
        System.out.println("setup test with Before method");
    }

    @AfterMethod
    public void afterTest() {
        System.out.println("This method is after test with After method");
    }

    @Test
    public void test1(){
        System.out.println("This is first test");
    }

    @Test
    public void test2(){
        System.out.println("This is test number 2");
    }

    @BeforeClass
    public void beforeAllTests(){
        System.out.println("Run Before All the test in this class");
    }
    @AfterClass
    public void afterAllTest(){
        System.out.println("Run After all test in this class");
    }
}
