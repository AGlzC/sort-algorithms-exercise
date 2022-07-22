package training.algorithms;

import java.lang.reflect.Array;
import java.util.Comparator;

public class MergeSort implements Sorter{

    private <T> void mergeArrays(T[] array, Comparator<T> comparator, int left, int mid, int right){
        int sizeLeftArray;
        int sizeRightArray;
        int indexLeft;
        int indexRight;
        int indexArray;

        sizeLeftArray =  mid - left + 1;
        sizeRightArray = right - mid;
        indexLeft = 0;
        indexRight = 0;
        indexArray = left;

        T[] arrayLeft = (T[]) Array.newInstance(array.getClass().getComponentType(), sizeLeftArray);
        System.arraycopy(array, left, arrayLeft, 0, sizeLeftArray);

        T[] arrayRight = (T[]) Array.newInstance(array.getClass().getComponentType(), sizeRightArray);
        System.arraycopy(array, mid + 1, arrayRight, 0, sizeRightArray);

        while (indexLeft < sizeLeftArray && indexRight < sizeRightArray){
            if (comparator.compare(arrayLeft[indexLeft], arrayRight[indexRight]) <= 0){
                array[indexArray++] = arrayLeft[indexLeft++];
            }
            else{
                array[indexArray++] = arrayRight[indexRight++];
            }
        }

        while (indexLeft < sizeLeftArray){
            array[indexArray++] = arrayLeft[indexLeft++];
        }
        while (indexRight < sizeRightArray){
            array[indexArray++] = arrayRight[indexRight++];
        }
    }

    private <T> void splitAndMerge(T[] array, Comparator<T> comparator, int start, int end){
        int center;

        if (start < end) {
            center = start + ((end - start) / 2);
            splitAndMerge(array, comparator, start, center);
            splitAndMerge(array, comparator, center + 1, end);
            mergeArrays(array, comparator, start, center, end);
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        splitAndMerge(array, new SortComparator<T>(), 0, array.length - 1);
    }

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        splitAndMerge(array, comparator, 0, array.length - 1);
    }
}
