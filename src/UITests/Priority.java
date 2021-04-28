package UITests;

import org.testng.annotations.Test;

public class Priority {

    @Test
    public void a(){
        System.out.println("a");
    }
    @Test (priority = -12)
    public void z(){
        System.out.println("z");
    }
    @Test (priority =  100)
    public void f(){
        System.out.println("f");
    }
    @Test (priority = 1)
    public void s(){
        System.out.println("s");
    }
    @Test (priority = 1)
    public void t(){
        System.out.println("t");
    }


}
