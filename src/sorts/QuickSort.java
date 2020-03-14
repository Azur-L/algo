package sorts;

/**
 * @Author: DokaSuki
 * @Date: 2020/3/14 14:30
 */
public class QuickSort {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void show(Comparable[] arr) {
        for (Comparable a : arr) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }

    public static void quickSort(Comparable[] arr, int n) {
        quickSortInternally(arr, 0, n - 1);
        show(arr);
    }

    public static void quickSortInternally(Comparable[] arr, int l, int r) {
        if (l >= r) return;
        int q = scanPartition(arr, l, r);
        quickSortInternally(arr, l, q - 1);
        quickSortInternally(arr, q + 1, r);
    }

    private static int fillPartition(Comparable[] arr, int l, int r) {
        Comparable pivot = arr[r];
        int i = l;
        for (int j = i; j < r; j++) {
            if (less(arr[j], pivot)) {
                if (i == j) {
                    i++;
                } else {
                    exch(arr, i++, j);
                }
            }
        }
        exch(arr, i, r);
        return i;
    }

    private static int scanPartition(Comparable[] arr, int l, int r) {
        Comparable pivot = arr[l];
        int i = l;
        int j = l + 1;
        while (j<=r){
            if (less(arr[j],pivot)){
                if (i==j){
                    j++;
                }
                i++;
                exch(arr,i,j);
            }
            j++;
        }
        exch(arr,i,l);
        return i;
    }


}
