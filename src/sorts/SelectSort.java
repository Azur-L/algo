package sorts;

/**
 * @Author: DokaSuki
 * @Date: 2020/3/14 14:07
 */
public class SelectSort {


    //数据交换辅助函数
    private static void exch(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    //比较辅助函数
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //在单行中打印数组
    private static void show(Comparable[] arr) {
        for (Comparable value : arr) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    public static void selectSort(Comparable[] arr,int n){
        if (n<=1)return;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                if (less(arr[j],arr[min])){
                    min = j;
                }
            }
            exch(arr,i,min);
        }
        show(arr);
    }
}
