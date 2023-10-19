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

        System.out.println(task1(systemIn, array1));
        System.out.println(task1(systemIn, array2));
        task1_arr_out(array1, array2);

        task2(systemIn, arr1, arr2);
        task2_arr_out(arr1, arr2);
    }

    static double task1(Scanner systemIn, double[] array) {
        for(int i = 0; i < Array.getLength(array); ++i) {
            array[i] = Math.sqrt(systemIn.nextDouble());
        }

        double arrayMin = array[0];
        for (var i : array)
            arrayMin = Math.min(arrayMin, i);

        return arrayMin;
    }

   
    static void task2(Scanner systemIn, ArrayList<Double> arr1, LinkedList<Double> arr2) {
        Double newDouble;
        for(int i = 0; i < 6; i++) {
            newDouble = systemIn.nextDouble();
            arr1.add(newDouble);
        }
        double arrayMin = arr1.get(0);
        for (var i : arr1)
            arrayMin = Math.min(arrayMin, i);
        System.out.printf("Минимальный элемент: %f\n", arrayMin);

        for(int i = 0; i < 7; i++) {
            newDouble = systemIn.nextDouble();
            arr2.add(newDouble);
        }
        arrayMin = arr2.get(0);
        for (var i : arr2)
            arrayMin = Math.min(arrayMin, i);
        System.out.printf("Минимальный элемент: %f\n", arrayMin);
    }

    static void task1_arr_out(double[] array1, double[] array2) {
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    static void task2_arr_out(ArrayList<Double> array1, LinkedList<Double> array2) {
        System.out.println(array1);
        System.out.println(array2);
    }
}