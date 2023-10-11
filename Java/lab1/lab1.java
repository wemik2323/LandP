import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class lab1 {
    public static void main(String args[]) {
        double[] array1 = new double[6];
        double[] array2 = new double[7];
        System.out.println("A faggot");
        Scanner systemIn = new Scanner(System.in);
        System.out.println(solution(systemIn, array1));
        System.out.println(solution(systemIn, array2));
        

        array1_out(array1, array2);
    }

    static double solution(Scanner systemIn, double[] array) {
        for(int i = 0; i < Array.getLength(array); ++i) {
            array[i] = Math.sqrt(systemIn.nextInt());
        }

        double arrayMin = array[0];
        for (var i : array)
            arrayMin = Math.min(arrayMin, i);

        return arrayMin;
    }

    static void array1_out(double[] array1, double[] array2) {
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}