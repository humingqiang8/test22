/**
 * 冒泡排序多种使用场景示例
 */
public class BubbleSortExample {

    /**
     * 冒泡排序方法 - 升序排列
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化标志，用于检测是否发生交换
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                // 如果前一个元素大于后一个元素，则交换
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j] 和 arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // 发生了交换
                }
            }
            
            // 如果这一轮没有发生任何交换，说明数组已经有序，可以提前结束
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * 冒泡排序方法 - 降序排列
     * @param arr 待排序的整数数组
     */
    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                // 改变比较条件以实现降序排列
                if (arr[j] < arr[j + 1]) {
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
     * 主方法，用于演示冒泡排序的不同用法
     */
    public static void main(String[] args) {
        // 示例1: 基本升序排序
        System.out.println("=== 示例1: 基本升序排序 ===");
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组:");
        printArray(arr1);
        
        bubbleSort(arr1);
        
        System.out.println("升序排序后:");
        printArray(arr1);
        
        // 示例2: 降序排序
        System.out.println("\n=== 示例2: 降序排序 ===");
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组:");
        printArray(arr2);
        
        bubbleSortDescending(arr2);
        
        System.out.println("降序排序后:");
        printArray(arr2);
        
        // 示例3: 已排序数组（测试优化效果）
        System.out.println("\n=== 示例3: 已排序数组（测试优化效果） ===");
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("原始数组(已排序):");
        printArray(arr3);
        
        bubbleSort(arr3);
        
        System.out.println("排序后:");
        printArray(arr3);
        
        // 示例4: 逆序数组
        System.out.println("\n=== 示例4: 逆序数组 ===");
        int[] arr4 = {7, 6, 5, 4, 3, 2, 1};
        System.out.println("原始数组(逆序):");
        printArray(arr4);
        
        bubbleSort(arr4);
        
        System.out.println("排序后:");
        printArray(arr4);
    }
}