package training.algorithms;

import java.util.Comparator;

public class SortComparator <T extends Comparable<T>> implements Comparator<T> {
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
}
