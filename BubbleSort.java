public class BubbleSort {
    
    /**
     * 冒泡排序方法
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        boolean swapped; // 优化标志，如果某一轮没有发生交换，则说明数组已经有序
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // 每轮将最大元素"冒泡"到末尾
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
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
    
    /**
     * 主方法 - 用于测试冒泡排序
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("排序前的数组:");
        printArray(arr);
        
        bubbleSort(arr);
        
        System.out.println("排序后的数组:");
        printArray(arr);
        
        // 测试边界情况
        int[] emptyArr = {};
        int[] singleArr = {42};
        int[] sortedArr = {1, 2, 3, 4, 5};
        int[] reverseArr = {5, 4, 3, 2, 1};
        
        System.out.println("\n测试边界情况:");
        
        System.out.print("空数组: ");
        bubbleSort(emptyArr);
        printArray(emptyArr);
        
        System.out.print("单元素数组: ");
        bubbleSort(singleArr);
        printArray(singleArr);
        
        System.out.print("已排序数组: ");
        printArray(sortedArr);
        bubbleSort(sortedArr);
        printArray(sortedArr);
        
        System.out.print("逆序数组: ");
        printArray(reverseArr);
        bubbleSort(reverseArr);
        printArray(reverseArr);
    }
}