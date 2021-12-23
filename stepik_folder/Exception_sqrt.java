/**
* Реализуйте метод sqrt(), 
* вычисляющий квадратный корень числа. 
* В отличие от Math.sqrt(), это метод при передаче отрицательного параметра должен бросать исключение java.lang.IllegalArgumentException 
* с сообщением "Expected non-negative number, got ?"
*/

public static double Exception_sqrt(double x) {
    if (x < 0){
        throw new IllegalArgumentException("Expected non-negative number, got " + x); //So
    }
    return Math.sqrt(x);  
}
