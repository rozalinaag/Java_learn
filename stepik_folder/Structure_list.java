import java.util.ArrayList;
import java.util.Scanner;

public class Structure{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input n = ");
        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>();

        int sum = 0, count = 0; // % 9!=0
        int max_v = -23456, min_v = 23245, index_max = -1, index_min = -1;

        for (int i = 0; i < n; i++) {
            int numbers = scanner.nextInt();
            list.add(numbers);

            if (numbers % 9!=0) {
                count += 1;
                sum += numbers;
            }

            if (numbers<0 && numbers % 7 !=0){

                if (max_v<numbers){
                    index_max = i;
                    max_v = numbers;
                }
                if (min_v>numbers){
                    index_min = i;
                    min_v = numbers;
                }
            }
        }

        System.out.println("You entered:");
        for(int number : list){
            System.out.print(number + " ");
        }
        System.out.println("\n");
        System.out.println("Summ = " + sum);
        System.out.println("Count of numbers = " + count);
        System.out.println("Middle sum = " + sum/count);

        if (index_max>=0 && index_min>=0) {
            System.out.println("Maximum number = " + max_v);
            System.out.println("Minimum number = " + min_v);

            list.set(index_max, min_v);
            list.set(index_min, max_v);

            System.out.println("We changed:");
            for(int number : list) {
                System.out.print(number + " ");
            }
        }

        System.out.println("\n");

    }
}
