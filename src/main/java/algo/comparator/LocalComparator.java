package algo.comparator;

import java.util.Comparator;

public class LocalComparator<T> implements Comparator<T> {

    private final Comparator<T> comparator;
    private Long compareTimes;

    public LocalComparator(Comparator<T> comparator) {
        this.comparator = comparator;
        compareTimes = 0L;
    }

    @Override
    public int compare(T o1, T o2) {
        compareTimes++;
        return comparator.compare(o1, o2);
    }

    public Long getCompareTimes() {
        return compareTimes;
    }

    public void resetCompares() {
        this.compareTimes = 0L;
    }
}
