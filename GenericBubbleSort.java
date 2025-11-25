/**
 * 泛型冒泡排序实现
 * 可以对实现了Comparable接口的类型进行排序
 */
public class GenericBubbleSort {
    
    /**
     * 泛型冒泡排序方法
     * @param arr 待排序的实现了Comparable接口的数组
     * @param <T> 数组元素类型，必须实现Comparable接口
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或单元素数组无需排序
        }
        
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化标志，如果某轮没有发生交换，则说明数组已经有序
            
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
            
            // 如果这轮没有发生交换，说明数组已经有序，可以提前结束
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * 打印数组元素
     * @param arr 要打印的数组
     */
    public static <T> void printArray(T[] arr) {
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
        System.out.println("=== 泛型冒泡排序测试 ===");
        
        // 测试整数数组
        Integer[] intArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\n测试整数数组:");
        System.out.print("排序前: ");
        printArray(intArr);
        bubbleSort(intArr);
        System.out.print("排序后: ");
        printArray(intArr);
        
        // 测试字符串数组
        String[] strArr = {"banana", "apple", "orange", "grape", "cherry"};
        System.out.println("\n测试字符串数组:");
        System.out.print("排序前: ");
        printArray(strArr);
        bubbleSort(strArr);
        System.out.print("排序后: ");
        printArray(strArr);
        
        // 测试双精度数组
        Double[] doubleArr = {3.14, 2.71, 1.41, 1.73, 0.57};
        System.out.println("\n测试双精度数组:");
        System.out.print("排序前: ");
        printArray(doubleArr);
        bubbleSort(doubleArr);
        System.out.print("排序后: ");
        printArray(doubleArr);
    }
}