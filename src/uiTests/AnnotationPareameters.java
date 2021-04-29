package uiTests;

import org.testng.annotations.Test;

public class AnnotationPareameters {


    @Test (priority = 1, enabled = false)
    public void m1(){
        System.out.println("m1");
    }

    @Test (enabled = false)
    public void m2(){
        System.out.println("m2");
    }
}
