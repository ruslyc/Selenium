package TestNG;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class Apple {
    @BeforeClass
    public void setup(){
        System.out.println("Setting up the environment in Before class annotantion");
    }

    @AfterClass
    public void teardown(){
        System.out.println("Closing everything in After Class annotation");
    }

    @BeforeMethod
    public void bm(){
        System.out.println("Before each test");
    }

    @Test
    public void appleInfo(){            // By default testNG @Test annotations run in alphabetical order.
        System.out.println("Test 1 here");
    }

    @Test(priority=0)
    public void appleInfo2(){
        System.out.println("Test 2 here"); // To control the order of @Test we can use priority by putting (priority = )
    }
    @Ignore                                 // Will ignore this test
    @Test(dependsOnMethods = "appleInfo")   //sets up the dependency on another method
    public void post(){
         System.out.println("Posting");
    }

}
