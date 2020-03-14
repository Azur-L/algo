package sorts;

/**
 * @Author: DokaSuki
 * @Date: 2020/3/14 12:43
 */
public class BubbleSort {

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

    //1.带标记位的冒泡排序
    public static void bubbleSort(Comparable[] arr, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            //提前退出标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (less(arr[j + 1], arr[j])) {
                    exch(arr, j, j + 1);
                    //本次冒泡有数据交换
                    flag = true;
                }
            }
            //如果没有数据交换，跳出循环
            if (!flag) break;
        }
        show(arr);
    }

    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     */
    //2.带边界的冒泡排序
    public static void borderBubbleSort(Comparable[] arr, int n) {
        if (n <= 1) return;
        //无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        //最后一个交换元素的位置，初始为0
        int lastExchange = 0;
        for (int i = 0; i < n; i++) {
            //提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (less(arr[j + 1], arr[j])) {
                    exch(arr, j, j + 1);
                    //本次冒泡有数据交换
                    flag = true;
                    //更新最后一个交换元素的位置
                    lastExchange = j;
                }
            }
            //更新无序数据边界
            sortBorder = lastExchange;
            //如果没有数据交换，跳出循环
            if (!flag) break;
        }
        show(arr);
    }
}
