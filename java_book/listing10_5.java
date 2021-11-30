
/**
 * Ссылка на нестатический метод класса
 */

class MyClass{
    private int number;
    MyClass(int n){
        number = n;
    }
    void set(int n){
        number = n;
    }
    int get(){
        return number;
    }
}

//the first functionality interface
interface MyGetter{
    int myget(MyClass obj);
}
//the second functionality interface
interface MySetter{
    void myset(MyClass obj, int n);
}

public class listing10_5 {
    public static void main(String[] args) {
        MyClass obj = new MyClass(100);
        System.out.println("the object with field 100 is created");

        //Using link to the methods
        MyGetter A = MyClass::get;
        MySetter B = MyClass::set;

        System.out.println("Value A: " + A.myget(obj)); //100
        System.out.println("Value obj: " + obj.get()); //100
        obj.set(200);
        System.out.println("the field is 200");
        System.out.println("Value A:" + A.myget(obj));//200

        B.myset(obj,300);
        System.out.println("Command B.myset(obj,300) is performed");

        System.out.println("Value A: " + A.myget(obj)); //300
        System.out.println("Value obj: " + obj.get()); //300

        obj = new MyClass(400);
        System.out.println("the object with field 400 is created");
        System.out.println("Value A: " + A.myget(obj)); //400;
        System.out.println("Value obj: " + obj.get()); //400

        B.myset(obj,500);
        System.out.println("Command B.myset(obj,500) is performed");
        System.out.println("Value A: " + A.myget(obj)); //500
        System.out.println("Value obj: " + obj.get()); //500


    }
}
