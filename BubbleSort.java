public class BubbleSort {
    
    public static void main(String[] args) {
        // 测试冒泡排序
        int[] a = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original array:");
        printArray(a);
        
        bubbleSort(a);
        
        System.out.println("Sorted array:");
        printArray(a);
        
        // 测试边界情况
        testEdgeCases();
    }
    
    /**
     * 测试边界情况
     */
    public static void testEdgeCases() {
        System.out.println("\n--- Testing edge cases ---");
        
        // 空数组
        int[] emptyArr = {};
        System.out.print("Empty array: ");
        bubbleSort(emptyArr);
        printArray(emptyArr);
        
        // 单元素数组
        int[] singleArr = {42};
        System.out.print("Single element: ");
        bubbleSort(singleArr);
        printArray(singleArr);
        
        // 已排序数组
        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.print("Already sorted: ");
        bubbleSort(sortedArr);
        printArray(sortedArr);
        
        // 逆序数组
        int[] reverseArr = {5, 4, 3, 2, 1};
        System.out.print("Reverse sorted: ");
        bubbleSort(reverseArr);
        printArray(reverseArr);
        
        // 包含重复元素
        int[] duplicateArr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        System.out.print("With duplicates: ");
        bubbleSort(duplicateArr);
        printArray(duplicateArr);
    }

    /**
     * 冒泡排序算法
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * 稳定性: 稳定排序
     * 
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或单元素数组无需排序
        }
        
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化标志：如果某一轮没有发生交换，说明数组已经有序
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果这一轮没有发生交换，数组已经有序，可以提前结束
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