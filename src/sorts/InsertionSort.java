package sorts;

/**
 * @Author: DokaSuki
 * @Date: 2020/3/14 13:55
 */
public class InsertionSort {

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

    public static void insertionSort(Comparable[] arr, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {
            //选择一个待插入的值
            Comparable val = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                //从右向左判断有序序列，寻找插入位置
                if (less(val, arr[j])) {
                    arr[j + 1] = arr[j];
                } else break;
            }
            //在当前元素右边插入
            arr[j + 1] = val;
        }
        show(arr);
    }

    public static void anotherInsertionSort(Comparable[] arr, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {
            Comparable val = arr[i];
            int order = i - 1;
            while (order >= 0 && less(val, arr[order])) {
                arr[order + 1] = arr[order];
                order--;
            }
            arr[order + 1] = val;
        }
        show(arr);
    }

    public static void shellSort(Comparable[] arr, int n) {
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            //数组变为h有序
            for (int i = h; i < n; i++) {
                //将arr[i]插入到arr[i-h],arr[i-2h],arr[i-3h]
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h)
                    exch(arr, j, j - h);
            }
            h = h / 3;
        }
        show(arr);
    }
}
