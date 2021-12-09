package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static Random generator = new Random();
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i ++) {
            list.add(generator.nextInt(100));
        }

        Integer[] arr = list.toArray(new Integer[0]);
        insertionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void insertionSort(Integer[] arr){
        for(int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while(j >= 0 && arr[j] > arr[j + 1]){
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
                j--;
            }
        }
    }

}
