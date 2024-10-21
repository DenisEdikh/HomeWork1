package ru.aston;

import java.util.Comparator;

public final class Algorithms {

    public static <T> void quickSort(CustomArrayList<T> ar, Comparator<? super T> cmp) {
        quickSortWithComparator(ar, cmp, 0, ar.size() - 1);
    }

    private static <T> void quickSortWithComparator(CustomArrayList<T> ar, Comparator<? super T> cmp, int left, int right) {
        int middle = left + (right - left) / 2;
        T arMiddle = ar.get(middle);
        int l = left;
        int r = right;

        while (l <= r) {
            while (cmp.compare(ar.get(l), arMiddle) < 0) {
                l++;
            }
            while (cmp.compare(ar.get(r), arMiddle) > 0) {
                r--;
            }

            if (l <= r) {
                T temp = ar.get(l);
                ar.set(l, ar.get(r));
                ar.set(r, temp);
                l++;
                r--;
            }
        }

        if (l < right) {
            quickSortWithComparator(ar, cmp, l, right);
        }
        if (r > left) {
            quickSortWithComparator(ar, cmp, left, r);
        }
    }

    public static <T extends Comparable<T>> void quickSort(CustomArrayList<T> ar) {
        quickSortWithComparable(ar,0, ar.size() - 1);
    }

    private static <T extends Comparable<T>> void quickSortWithComparable(CustomArrayList<T> ar, int left, int right) {
        int middle = left + (right - left) / 2;
        T arMiddle = ar.get(middle);
        int l = left;
        int r = right;

        while (l <= r) {
            while (arMiddle.compareTo(ar.get(l)) < 0) {
                l++;
            }
            while (arMiddle.compareTo(ar.get(r)) > 0) {
                r--;
            }

            if (l <= r) {
                T temp = ar.get(l);
                ar.set(l, ar.get(r));
                ar.set(r, temp);
                l++;
                r--;
            }
        }

        if (l < right) {
            quickSortWithComparable(ar, l, right);
        }
        if (r > left) {
            quickSortWithComparable(ar, left, r);
        }
    }
}
