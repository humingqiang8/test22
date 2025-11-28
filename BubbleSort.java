public class BubbleSort {
    
    /**
     * 冒泡排序方法 - 升序排列
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或只有一个元素的数组无需排序
        }
        
        int n = arr.length;
        boolean swapped; // 优化标志，如果某轮没有发生交换，则数组已排序完成
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // 每轮比较相邻元素，将最大值移到末尾
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果这一轮没有发生交换，说明数组已经有序
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
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) { // 改变比较符号实现降序
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
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("原始数组:");
        printArray(arr);
        
        bubbleSort(arr);
        System.out.println("升序排序后:");
        printArray(arr);
        
        bubbleSortDescending(arr);
        System.out.println("降序排序后:");
        printArray(arr);
    }
}