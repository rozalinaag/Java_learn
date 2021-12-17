//roots of the quadratic equation
import java.math.BigDecimal;
import java.util.Scanner;

public class Roots {
    public static double f(double x){ // функция
        return x*x*x + 3*x*x - 6*x - 8;
    }
    public static double prf(double x) { // производная функции
        return 3 * x * x + 6 * x - 6 ;
    }

    public static double x_newton(double a, double e) {
        double x = a; // начальное приближение – левая граница
        // интервала локализации
        double razn;
        do {
            double xn = x - f(x) / prf(x); // вычисляется новое приближение к корню
            razn = Math.abs(xn - x); // абсолютная величина разности между
            // новым и старым приближениями
            x = xn; // старое приближение заменяется новым значением
        } while (razn > e); // выход из цикла, когда разность между сравниваемыми
        // приближениями становится меньше заданной
        // погрешности вычисления корня
        return x - f(x)/prf(x); // корень – следующее приближение
    }

    public static double x_div2(double a, double b, double e){
         // пока интервал больше погрешности вычисления корня
            double c=(a+b)/2; // вычисляется середина отрезка
            if (f(a)*f(c)<0) // если корень в левой части,
                b=c; // правая граница интервала переносится в середину
            else
            if(f(a)*f(c)>0) // если корень в правой части,
                a=c; // левая граница интервала переносится в середину,
            else // иначе будет f(a)*f(c)=0 – т.е. при делении
                // отрезка попали в корень
         if (b-a>e)
             x_div2(a, b, e); // в качестве корня возвращается среднее значение
        return (a+b)/2; // в качестве корня возвращается среднее значение
        // интервала
    }


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Введите значения интервала для корней:");
                // интервал должен содержать все корни
        double a=sc.nextDouble();
        double b=sc.nextDouble();

        double e=0.001;

        // ОТДЕЛЕНИЕ КОРНЕЙ ПУТЕМ ПРОХОЖДЕНИЯ ИНТЕРВАЛА
        // С ПЕРЕМЕННЫМ ШАГОМ
        System.out.print("Введите предполагаемое количество корней=> ");
        int kol=sc.nextInt(); // для кубического уравнения =3

        double xArray[]=new double [kol]; // массив для хранения выделенных корней

        int kol_naideno; // количество корней, найденное при очередном
        // прохождении
        double x, y1, y2; // текущее значение координаты x и значений функции на концах отрезка [x, x+h]
        double h=(b-a)/kol; // переменный шаг прохождения интервала

        do {
            kol_naideno=0;
            x=a;
            while (x<b) {
                y1=f(x);
                y2=f(x+h);
                if ( (y1*y2<=0) ) {
                    x=x_newton(x, e);
                    xArray[kol_naideno]=x;
                    kol_naideno++;
                }
                x+=h;
            }
            h/=2;
        } while ((kol>kol_naideno) && (2*h>e));

        // Вывод вычисленных корней в заданном формате
        // с помощью класса BigDecmal
        System.out.println("Корни уравнения методом Ньютона:");
        for (int i = 0; i < xArray.length; i++) {
            System.out.println(new BigDecimal(xArray[i]).setScale(3,BigDecimal.ROUND_UP));
        }


        h=(b-a)/kol;

        do {
            kol_naideno=0;
            x=a;
            while (x<b) {
                y1=f(x);
                y2=f(x+h);
                if ( (y1*y2<=0) ) {
                    x=x_div2(x,x+h, e);
                    xArray[kol_naideno]=x;
                    kol_naideno++;
                }
                x+=h;
            }
            h/=2;
        } while ((kol>kol_naideno) && (2*h>e));

        System.out.println("Корни уравнения методом деления отрезков пополам:");

        for (int i = 0; i < xArray.length; i++) {
            System.out.println(new BigDecimal(xArray[i]).setScale(3,BigDecimal.ROUND_UP));
        }
    }
}
