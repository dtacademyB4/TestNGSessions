package uiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {


    @Test
    public void method1(){
        System.out.println("Logging into the app");
        Assert.assertTrue(false);
    }

    @Test (dependsOnMethods = "method1")
    public void anothermethod(){
        System.out.println("Performing homepage test");
        Assert.assertTrue(true);
    }

    @Test (dependsOnMethods = "anothermethod")
    public void aanothermethod(){
        System.out.println("Performing logout page test");
        Assert.assertTrue(true);
    }
}
