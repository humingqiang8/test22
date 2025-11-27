public class BubbleSortComplete {
    
    /**
     * 基础冒泡排序方法 - 升序
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    /**
     * 优化的冒泡排序方法 - 如果数组提前有序则提前结束
     * @param arr 待排序的整数数组
     */
    public static void optimizedBubbleSort(int[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化：如果某一轮没有发生交换，说明已经有序
            
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
    
    /**
     * 降序冒泡排序方法
     * @param arr 待排序的整数数组
     */
    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) { // 注意这里是小于号，实现降序
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * 泛型冒泡排序方法 - 使用Comparable接口
     * @param arr 待排序的实现了Comparable接口的对象数组
     */
    public static <T extends Comparable<T>> void genericBubbleSort(T[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // 交换元素
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
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
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    /**
     * 打印字符串数组元素
     * @param arr 要打印的数组
     */
    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    /**
     * 主方法 - 用于测试各种冒泡排序方法
     */
    public static void main(String[] args) {
        System.out.println("=== 冒泡排序演示 ===\n");
        
        // 测试基础冒泡排序
        System.out.println("1. 基础冒泡排序（升序）:");
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组:");
        printArray(arr1);
        bubbleSort(arr1);
        System.out.println("排序后数组:");
        printArray(arr1);
        System.out.println();
        
        // 测试优化冒泡排序
        System.out.println("2. 优化冒泡排序（升序）:");
        int[] arr2 = {5, 2, 8, 1, 9};
        System.out.println("原始数组:");
        printArray(arr2);
        optimizedBubbleSort(arr2);
        System.out.println("排序后数组:");
        printArray(arr2);
        System.out.println();
        
        // 测试降序冒泡排序
        System.out.println("3. 降序冒泡排序:");
        int[] arr3 = {10, 5, 8, 3, 6, 1};
        System.out.println("原始数组:");
        printArray(arr3);
        bubbleSortDescending(arr3);
        System.out.println("排序后数组（降序）:");
        printArray(arr3);
        System.out.println();
        
        // 测试泛型冒泡排序
        System.out.println("4. 泛型冒泡排序（字符串数组）:");
        String[] strArr = {"banana", "apple", "orange", "grape", "cherry"};
        System.out.println("原始数组:");
        printArray(strArr);
        genericBubbleSort(strArr);
        System.out.println("排序后数组:");
        printArray(strArr);
        System.out.println();
        
        // 性能对比：已排序数组
        System.out.println("5. 性能对比 - 已排序数组:");
        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.println("原始数组（已排序）:");
        printArray(sortedArr);
        
        long startTime = System.nanoTime();
        bubbleSort(sortedArr); // 基础版本
        long basicTime = System.nanoTime() - startTime;
        
        // 重新初始化数组
        sortedArr = new int[]{1, 2, 3, 4, 5};
        startTime = System.nanoTime();
        optimizedBubbleSort(sortedArr); // 优化版本
        long optimizedTime = System.nanoTime() - startTime;
        
        System.out.println("基础冒泡排序耗时: " + basicTime + " 纳秒");
        System.out.println("优化冒泡排序耗时: " + optimizedTime + " 纳秒");
    }
}