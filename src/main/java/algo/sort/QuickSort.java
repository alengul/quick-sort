package algo.sort;

import java.util.Comparator;

public class QuickSort {

    private final boolean useMedian;

    public QuickSort(boolean useMedian) {
        this.useMedian = useMedian;
    }

    public <T> void sort(T[] arr, Comparator<? super T> comparator) {
        quicksort(arr, 0, arr.length - 1, comparator);
    }

    public <T> void quicksort(T[] arr, int l, int r, Comparator<? super T> comparator) {
        if (l < r) {
            int q = partition(arr, l, r, comparator);
            quicksort(arr, q + 1, r, comparator);
            quicksort(arr, l, q, comparator);
        }
    }

    public <T> int partition(T[] arr, int l, int r, Comparator<? super T> comparator) {
        T med = useMedian ? median(arr[l], arr[(r + l) / 2], arr[r], comparator) : arr[(r + l) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (comparator.compare(arr[i], med) < 0) {
                i++;
            }
            while (comparator.compare(arr[j], med) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            T tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return j;
    }

    public <T> T median(T l, T mid, T r, Comparator<? super T> comparator) {
        T tmp;
        if (comparator.compare(mid, l) < 0) {
            tmp = mid;
            mid = l;
            l = tmp;
        }
        if (comparator.compare(r, l) < 0) {
            r = l;
        }
        if (comparator.compare(mid, r) < 0) {
            r = mid;
        }
        return r;
    }
}
