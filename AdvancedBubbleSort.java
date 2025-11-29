public class AdvancedBubbleSort {
    
    /**
     * 冒泡排序方法（升序）
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
                    // 交换相邻元素
                    swap(arr, j, j + 1);
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
     * 冒泡排序方法（降序）
     * @param arr 待排序的整数数组
     */
    public static void bubbleSortDescending(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或单元素数组无需排序
        }
        
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化标志
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) { // 注意这里是小于号，实现降序
                    // 交换相邻元素
                    swap(arr, j, j + 1);
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
     * 交换数组中两个位置的元素
     * @param arr 数组
     * @param i 第一个位置
     * @param j 第二个位置
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * 打印数组内容
     * @param arr 要打印的数组
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    /**
     * 主方法，用于测试冒泡排序的各种情况
     */
    public static void main(String[] args) {
        // 测试用例1：普通数组
        System.out.println("=== 测试用例1：普通数组 ===");
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前的数组:");
        printArray(arr1);
        
        bubbleSort(arr1);
        
        System.out.println("升序排序后的数组:");
        printArray(arr1);
        
        // 测试用例2：已排序数组（优化测试）
        System.out.println("\n=== 测试用例2：已排序数组 ===");
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("排序前的数组:");
        printArray(arr2);
        
        bubbleSort(arr2);
        
        System.out.println("升序排序后的数组:");
        printArray(arr2);
        
        // 测试用例3：逆序数组
        System.out.println("\n=== 测试用例3：逆序数组 ===");
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println("排序前的数组:");
        printArray(arr3);
        
        bubbleSort(arr3);
        
        System.out.println("升序排序后的数组:");
        printArray(arr3);
        
        // 测试用例4：降序排序
        System.out.println("\n=== 测试用例4：降序排序 ===");
        int[] arr4 = {1, 5, 2, 4, 3};
        System.out.println("排序前的数组:");
        printArray(arr4);
        
        bubbleSortDescending(arr4);
        
        System.out.println("降序排序后的数组:");
        printArray(arr4);
        
        // 测试用例5：单元素数组
        System.out.println("\n=== 测试用例5：单元素数组 ===");
        int[] arr5 = {42};
        System.out.println("排序前的数组:");
        printArray(arr5);
        
        bubbleSort(arr5);
        
        System.out.println("排序后的数组:");
        printArray(arr5);
        
        // 测试用例6：空数组
        System.out.println("\n=== 测试用例6：空数组 ===");
        int[] arr6 = {};
        System.out.println("排序前的数组:");
        printArray(arr6);
        
        bubbleSort(arr6);
        
        System.out.println("排序后的数组:");
        printArray(arr6);
    }
}