package algo.sort;

import algo.comparator.LocalComparator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    private final Random generator = new Random();
    private final QuickSort quickSortMedian = new QuickSort(true);
    private final QuickSort quickSort = new QuickSort(false);
    private final LocalComparator<Integer> comparator = new LocalComparator<>(Integer::compareTo);
    private Integer[] arr1;
    private Integer[] arr2;
    private Integer[] arr3;


    private void initializeArray(int size, int bound) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(generator.nextInt(bound));
        }
        arr1 = list.toArray(new Integer[0]);
        arr2 = list.toArray(new Integer[0]);
        arr3 = list.toArray(new Integer[0]);

        System.out.println("Running test for array of size " + size + ", values to " + bound);
    }

    @Test
    public void Test() {

        initializeArray(1000000, 1000000);

        comparator.resetCompares();
        long startTime = System.currentTimeMillis();
        quickSortMedian.sort(arr1, comparator);
        System.out.println("Local median: " + (System.currentTimeMillis() - startTime));
        System.out.println(comparator.getCompareTimes());

        comparator.resetCompares();
        startTime = System.currentTimeMillis();
        quickSort.sort(arr2, comparator);
        System.out.println("Local without median: " + (System.currentTimeMillis() - startTime));
        System.out.println(comparator.getCompareTimes());


        comparator.resetCompares();
        startTime = System.currentTimeMillis();
        Arrays.sort(arr3, comparator);
        System.out.println("Java: " + (System.currentTimeMillis() - startTime));
        System.out.println(comparator.getCompareTimes());

        System.out.println("\n");
        assertArrayEquals(arr1, arr3);
        assertArrayEquals(arr2, arr3);
    }

    @Test
    public void Test2() {

        initializeArray(1000000, 100);

        comparator.resetCompares();
        long startTime = System.currentTimeMillis();
        quickSortMedian.sort(arr1, comparator);
        System.out.println("Local median: " + (System.currentTimeMillis() - startTime));
        System.out.println(comparator.getCompareTimes());

        comparator.resetCompares();
        startTime = System.currentTimeMillis();
        quickSort.sort(arr2, comparator);
        System.out.println("Local without median: " + (System.currentTimeMillis() - startTime));
        System.out.println(comparator.getCompareTimes());


        comparator.resetCompares();
        startTime = System.currentTimeMillis();
        Arrays.sort(arr3, comparator);
        System.out.println("Java: " + (System.currentTimeMillis() - startTime));
        System.out.println(comparator.getCompareTimes());

        System.out.println("\n");
        assertArrayEquals(arr1, arr3);
        assertArrayEquals(arr2, arr3);
    }

    @Test
    public void Test3() {

        initializeArray(100, 1000);

        comparator.resetCompares();
        long startTime = System.currentTimeMillis();
        quickSortMedian.sort(arr1, comparator);
        System.out.println("Local median: " + (System.currentTimeMillis() - startTime));
        System.out.println(comparator.getCompareTimes());

        comparator.resetCompares();
        startTime = System.currentTimeMillis();
        quickSort.sort(arr2, comparator);
        System.out.println("Local without median: " + (System.currentTimeMillis() - startTime));
        System.out.println(comparator.getCompareTimes());


        comparator.resetCompares();
        startTime = System.currentTimeMillis();
        Arrays.sort(arr3, comparator);
        System.out.println("Java: " + (System.currentTimeMillis() - startTime));
        System.out.println(comparator.getCompareTimes());

        System.out.println("\n");
        assertArrayEquals(arr1, arr3);
        assertArrayEquals(arr2, arr3);
    }

}
