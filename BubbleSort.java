public class BubbleSort {
    
    /**
     * 主方法 - 用于测试冒泡排序
     */
    public static void main(String[] args) {
        // 测试升序排序
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr1);
        bubbleSort(arr1);
        System.out.println("Sorted array (ascending):");
        printArray(arr1);
        
        // 测试降序排序
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nOriginal array:");
        printArray(arr2);
        bubbleSortDesc(arr2);
        System.out.println("Sorted array (descending):");
        printArray(arr2);
        
        // 测试边界情况
        int[] arr3 = {};
        System.out.println("\nEmpty array test:");
        printArray(arr3);
        bubbleSort(arr3);
        printArray(arr3);
        
        int[] arr4 = {42};
        System.out.println("\nSingle element array test:");
        printArray(arr4);
        bubbleSort(arr4);
        printArray(arr4);
        
        // 测试已排序数组
        int[] arr5 = {1, 2, 3, 4, 5};
        System.out.println("\nAlready sorted array:");
        printArray(arr5);
        bubbleSort(arr5);
        printArray(arr5);
    }

    /**
     * 冒泡排序方法 - 升序排列（优化版本）
     * 时间复杂度：最好情况O(n)，最坏情况O(n²)
     * 空间复杂度：O(1)
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或单元素数组无需排序
        }
        
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
    
    /**
     * 冒泡排序方法 - 降序排列（优化版本）
     * 时间复杂度：最好情况O(n)，最坏情况O(n²)
     * 空间复杂度：O(1)
     * @param arr 待排序的整数数组
     */
    public static void bubbleSortDesc(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或单元素数组无需排序
        }
        
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化标志，如果某一轮没有发生交换，说明数组已经有序
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) { // 注意这里是小于号，实现降序
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
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}