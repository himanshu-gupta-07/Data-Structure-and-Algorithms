import java.util.List;

interface InterfaceB{
    //public void method();
}

class Base{
    public void method(){
        System.out.println("namsnfskn");
    }
}

public class Test extends Base implements InterfaceB{
    /*
    //
     */
    public static void main(String str[]){

        new Test().method();
    }
}

