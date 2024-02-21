public class MyClass {
    
    public static void main(String[] args) {
       
        // MyInterface obj = new MyInterface() {
        //     public void myMethod() {
        //         System.out.println("Anonymous class");
        //     }
        // };

        MyInterface obj = str -> str.length();

        obj.myMethod("Hello");

    }

}

/**
 * InnerMyClass
 */
interface MyInterface {

    public void myMethod(String str);
    
}
