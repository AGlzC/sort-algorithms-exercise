package training.algorithms;

import java.util.Collections;
import java.util.Comparator;

public class BubbleSort implements Sorter{

    private static <T> void swap(T[] array, int idx1, int idx2)
    {
        T temporal;
        temporal = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temporal;
    }


    private <T> void bubbleSortImplementation(T[] array, Comparator<T> comparator) {
        int arraySize = array.length;
        int i, j;
        boolean sorted;

        i = 0;
        sorted = false;
        while (i < arraySize && !sorted){
            sorted = true;
            i++;
            for (j = 0; j < arraySize - i; j++){
                if (comparator.compare(array[j], array[j + 1]) > 0){
                    sorted = false;
                    swap(array, j, j + 1);
                }
            }
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        bubbleSortImplementation(array, new SortComparator<T>());
    }

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        bubbleSortImplementation(array, comparator);
    }
}
