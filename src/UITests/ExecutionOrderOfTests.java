package UITests;

import org.testng.annotations.Test;

public class ExecutionOrderOfTests {
    // the default order of execution  -> alphabetic: according to the alphabetic order of names of the methods
    @Test
    public void a(){
        System.out.println("a");
    }

    @Test
    public void z(){
        System.out.println("z");
    }

    @Test
    public void f(){
        System.out.println("f");
    }


    @Test
    public void s(){
        System.out.println("s");
    }

    @Test
    public void b(){
        System.out.println("b");
    }

    @Test
    public void d(){
        System.out.println("d");
    }

    @Test ()
    public void x(){
        System.out.println("x");
    }

}
