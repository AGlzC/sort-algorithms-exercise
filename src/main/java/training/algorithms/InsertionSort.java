package training.algorithms;

import java.util.Comparator;

public class InsertionSort implements Sorter{

    private <T> void insertSortImplementation(T[] array, Comparator<T> comparator) {
        int arraySize = array.length;
        int i, j;
        T temporal;

        i = 0;
        while (i < arraySize){
            temporal = array[i];
            j = i - 1;
            while (j >= 0 && comparator.compare(array[j], temporal) > 0){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temporal;
            i++;
        }
    }
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        insertSortImplementation(array, new SortComparator<T>());
    }

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        insertSortImplementation(array, comparator);
    }
}
