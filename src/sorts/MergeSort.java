package sorts;

/**
 * @Author: DokaSuki
 * @Date: 2020/3/14 14:29
 */
public class MergeSort {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] arr) {
        for (Comparable a : arr) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }

    public static void mergeSort(Comparable[] arr,int n){
        mergeSortInternally(arr,0,n-1);
        show(arr);
    }

    private static void mergeSortInternally(Comparable[] arr, int l, int r) {
        if (l>=r) return;
        int m = (r+l)/2;
        mergeSortInternally(arr,l,m);
        mergeSortInternally(arr,m+1,r);
        mergeSentry(arr,l,m,r);
    }

    private static void mergeSentry(Comparable[] arr, int l, int m, int r) {
        Comparable[] left = new Comparable[m-l+2];
        Comparable[] right = new Comparable[r-m+1];

        for (int i = 0; i < left.length-1; i++) {
            left[i]=arr[l+i];
        }
        left[left.length-1] = Integer.MAX_VALUE;

        for (int i = 0; i < right.length-1; i++) {
            right[i]=arr[m+i+1];
        }
        right[right.length-1] =Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = l;
        while (k<=r){
            if (less(left[i],right[j])){
                arr[k++] = left[i++];
            }else {
                arr[k++] = right[j++];
            }
        }
    }
}
