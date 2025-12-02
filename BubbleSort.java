import java.util.Arrays;

public class BubbleSort {
    
    /**
     * 冒泡排序方法
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化标志，如果某一轮没有发生交换，说明已经有序
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换相邻元素
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
     * 冒泡排序方法 - 泛型版本，可处理任何实现了Comparable接口的类型
     * @param arr 待排序的可比较对象数组
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化：如果某一轮没有发生交换，说明数组已经有序
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // 交换相邻元素
                    T temp = arr[j];
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
     * 打印数组内容
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
    
    // 测试方法
    public static void main(String[] args) {
        // 测试整数数组排序
        int[] intArr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("整数数组排序前:");
        printArray(intArr);
        
        bubbleSort(intArr);
        
        System.out.println("整数数组排序后:");
        printArray(intArr);
        
        System.out.println();
        
        // 测试字符串数组排序
        String[] strArr = {"banana", "apple", "orange", "grape", "cherry"};
        
        System.out.println("字符串数组排序前:");
        System.out.println(Arrays.toString(strArr));
        
        bubbleSort(strArr);
        
        System.out.println("字符串数组排序后:");
        System.out.println(Arrays.toString(strArr));
    }
}