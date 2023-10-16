import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class lab1 {
    public static void main(String args[]) {
        double[] array1 = new double[6];
        double[] array2 = new double[7];
        ArrayList<Double> arr1 = new ArrayList<Double>(6);
        LinkedList<Double> arr2 = new LinkedList<Double>();
        Scanner systemIn = new Scanner(System.in);
  //      System.out.println(task1(systemIn, array1));
  //      System.out.println(task1(systemIn, array2));
    
        System.out.println(task2(systemIn, arr1.toArray()));
        System.out.println(task2(systemIn, arr2.toArray()));

        array1_out(array1, array2);
    }

    static double task1(Scanner systemIn, double[] array) {
        for(int i = 0; i < Array.getLength(array); ++i) {
            array[i] = Math.sqrt(systemIn.nextInt());
        }

        double arrayMin = array[0];
        for (var i : array)
            arrayMin = Math.min(arrayMin, i);

        return arrayMin;
    }

   
    static Object task2(Scanner systemIn, Object[] array) {
        for(int i = 0; i < Array.getLength(array); ++i) {
            array[i] = Math.sqrt(systemIn.nextInt());
        }
        System.out.println(array);

        Object arrayMin = array[0];

        return arrayMin;
    }

    static void array1_out(double[] array1, double[] array2) {
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}