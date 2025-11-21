public class BubbleSort {
    
    /**
     * 冒泡排序方法 - 升序排列
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或单元素数组无需排序
        }
        
        int n = arr.length;
        boolean swapped; // 优化标志，如果某轮没有交换，则说明已排序完成
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // 每轮比较相邻元素，将最大值移到末尾
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果这轮没有发生交换，说明数组已经有序
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * 冒泡排序方法 - 降序排列
     * @param arr 待排序的整数数组
     */
    public static void bubbleSortDesc(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或单元素数组无需排序
        }
        
        int n = arr.length;
        boolean swapped; // 优化标志
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // 每轮比较相邻元素，将最小值移到末尾
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果这轮没有发生交换，说明数组已经有序
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * 打印数组内容
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
    
    // 测试方法
    public static void main(String[] args) {
        // 测试升序排序
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原数组:");
        printArray(arr1);
        
        bubbleSort(arr1);
        System.out.println("升序排序后:");
        printArray(arr1);
        
        // 测试降序排序
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\n原数组:");
        printArray(arr2);
        
        bubbleSortDesc(arr2);
        System.out.println("降序排序后:");
        printArray(arr2);
        
        // 测试边界情况
        int[] arr3 = {};
        int[] arr4 = {42};
        int[] arr5 = {5, 2, 8, 1, 9};
        
        System.out.println("\n测试边界情况:");
        System.out.print("空数组排序: ");
        bubbleSort(arr3);
        printArray(arr3);
        
        System.out.print("单元素数组排序: ");
        bubbleSort(arr4);
        printArray(arr4);
        
        System.out.print("普通数组排序: ");
        bubbleSort(arr5);
        printArray(arr5);
    }
}