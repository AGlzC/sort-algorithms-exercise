package training.algorithms;

import java.util.Comparator;

public class QuickSort implements Sorter{

    private static <T> void swap(T[] array, int idx1, int idx2)
    {
        T temporal;
        temporal = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temporal;
    }

    private <T> void quicksort(T[] array, Comparator<T> comparator, int lo, int hi)
    {
        if (lo < hi){
            int pivot;

            pivot = slipArray(array, comparator, lo, hi);
            quicksort(array, comparator, lo, pivot - 1);
            quicksort(array, comparator, pivot + 1, hi);
        }
    }

    private <T> int slipArray(T[] array, Comparator<T> comparator, int lo, int hi) {
        int pivot, i, j;
        T pivotValue;

        pivotValue = array[hi];
        i = lo - 1;
        for (j = lo; j <= hi - 1; j++){
            if (comparator.compare(array[j], pivotValue) < 0){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, hi);
        return i + 1;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        quicksort(array, new SortComparator<T>(), 0, array.length - 1);
    }

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        quicksort(array, comparator, 0, array.length - 1);
    }
}
