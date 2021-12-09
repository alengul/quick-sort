package algo.sort;

import java.util.Comparator;

public class QuickSortInsertion extends QuickSort {

    public QuickSortInsertion(boolean useMedian) {
        super(useMedian);
    }

    @Override
    public <T> void quicksort(T[] arr, int l, int r, Comparator<? super T> comparator) {
        if (l < r) {
            int q = partition(arr, l, r, comparator);
            if (r - q < 10) {
                insertionSort(arr, q + 1, r, comparator);
            } else {
                quicksort(arr, q + 1, r, comparator);
            }
            if (q - l < 10) {
                insertionSort(arr, l, q, comparator);
            } else {
                quicksort(arr, l, q, comparator);
            }
        }
    }

    public <T> void insertionSort(T[] arr, int l, int r, Comparator<? super T> comparator) {
        for (int i = l + 1; i <= r; i++) {
            int j = i - 1;
            while (j >= l && comparator.compare(arr[j], arr[j + 1]) > 0) {
                T tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
                j--;
            }
        }
    }

}
