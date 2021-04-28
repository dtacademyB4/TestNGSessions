package UITests;

import org.testng.annotations.*;

public class ExecutionOrder {

    @AfterMethod
    public void m10(){
        System.out.println("After Method");
    }


    @BeforeSuite
    public void m1(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void m2(){
        System.out.println("Before Test");
    }


    @BeforeClass
    public void m3(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void m4(){
        System.out.println("Before Method");
    }

    @Test
    public void m5(){
        System.out.println("Method m5");
    }

    @Test
    public void m6(){
        System.out.println("Method m6");
    }

    @Test
    public void m61(){
        System.out.println("Method m61");
    }

    @AfterSuite
    public void m7(){
        System.out.println("After Suite");
    }

    @AfterTest
    public void m8(){
        System.out.println("After Test");
    }


    @AfterClass
    public void m9(){
        System.out.println("After Class");
    }







}
