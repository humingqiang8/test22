public class BubbleSort {
    public static void main(String[] args) {
        // 假设这是环境中的数组 a
        int[] a = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:");
        printArray(a);

        bubbleSort(a);

        System.out.println("Sorted array:");
        printArray(a);
    }

    /**
     * 冒泡排序方法
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 数组为空或只有一个元素时，无需排序
        }
        
        int n = arr.length;
        boolean swapped; // 用于优化，如果某一轮没有发生交换，则说明数组已经有序
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // 每一轮将最大的元素"冒泡"到末尾
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果这一轮没有发生任何交换，说明数组已经有序，可以提前结束
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 打印数组元素
     * @param arr 要打印的数组
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("Array is null");
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}