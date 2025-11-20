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
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化标志，用于检测是否发生交换
            
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
    
    // 测试方法
    public static void main(String[] args) {
        // 测试用例1：普通数组
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("测试用例1 - 普通数组:");
        System.out.print("排序前: ");
        printArray(arr1);
        bubbleSort(arr1);
        System.out.print("排序后: ");
        printArray(arr1);
        System.out.println();
        
        // 测试用例2：已经排序的数组
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("测试用例2 - 已排序数组:");
        System.out.print("排序前: ");
        printArray(arr2);
        bubbleSort(arr2);
        System.out.print("排序后: ");
        printArray(arr2);
        System.out.println();
        
        // 测试用例3：逆序数组
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println("测试用例3 - 逆序数组:");
        System.out.print("排序前: ");
        printArray(arr3);
        bubbleSort(arr3);
        System.out.print("排序后: ");
        printArray(arr3);
        System.out.println();
        
        // 测试用例4：单个元素
        int[] arr4 = {42};
        System.out.println("测试用例4 - 单个元素:");
        System.out.print("排序前: ");
        printArray(arr4);
        bubbleSort(arr4);
        System.out.print("排序后: ");
        printArray(arr4);
        System.out.println();
        
        // 测试用例5：空数组
        int[] arr5 = {};
        System.out.println("测试用例5 - 空数组:");
        System.out.print("排序前: ");
        printArray(arr5);
        bubbleSort(arr5);
        System.out.print("排序后: ");
        printArray(arr5);
    }
}