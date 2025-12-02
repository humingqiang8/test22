public class BubbleSort {
    /**
     * 主方法，用于测试冒泡排序
     */
    public static void main(String[] args) {
        int[] a = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:");
        printArray(a);

        bubbleSort(a);

        System.out.println("Sorted array:");
        printArray(a);
        
        // 测试边界情况
        System.out.println("\nTesting edge cases:");
        
        // 空数组
        int[] emptyArr = {};
        System.out.print("Empty array: ");
        bubbleSort(emptyArr);
        printArray(emptyArr);
        
        // 单元素数组
        int[] singleArr = {42};
        System.out.print("Single element array: ");
        printArray(singleArr);
        bubbleSort(singleArr);
        printArray(singleArr);
        
        // 已排序数组
        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.print("Already sorted array: ");
        printArray(sortedArr);
        bubbleSort(sortedArr);
        printArray(sortedArr);
        
        // 逆序数组
        int[] reverseArr = {5, 4, 3, 2, 1};
        System.out.print("Reverse sorted array: ");
        printArray(reverseArr);
        bubbleSort(reverseArr);
        printArray(reverseArr);
        
        // 包含重复元素的数组
        int[] duplicateArr = {3, 7, 3, 1, 7, 2, 1};
        System.out.print("Array with duplicates: ");
        printArray(duplicateArr);
        bubbleSort(duplicateArr);
        printArray(duplicateArr);
    }

    /**
     * 冒泡排序方法 - 优化版本
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化标志，如果某一轮没有发生交换，说明数组已经有序
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j] 和 arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果这一轮没有发生交换，说明数组已经有序，可以提前结束
            if (!swapped) {
                break;
            }
        }
    }

    // 打印数组函数
    /**
     * 打印数组元素
     * @param arr 要打印的数组
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}