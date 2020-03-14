package sorts;

import static sorts.BubbleSort.borderBubbleSort;
import static sorts.BubbleSort.bubbleSort;

public class Main {
    public static void main(String[] args) {
        Integer[] a = {3,5,2,9,7,5,8,234,3456,1231232124,346,23,54,35325,43,1};
        bubbleSort(a,a.length);
        borderBubbleSort(a,a.length);
    }
}
