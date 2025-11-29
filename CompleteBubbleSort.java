public class CompleteBubbleSort {
    
    /**
     * 冒泡排序方法 - 基础版本
     * 时间复杂度：最坏情况 O(n²)，最好情况 O(n²)
     * 空间复杂度：O(1)
     * @param arr 待排序的整型数组
     */
    public static void bubbleSortBasic(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
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
     * 冒泡排序方法 - 优化版本
     * 时间复杂度：最坏情况 O(n²)，最好情况 O(n)
     * 空间复杂度：O(1)
     * @param arr 待排序的整型数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化标志，如果某轮没有交换，说明已经有序
            
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
            
            // 如果这轮没有发生交换，说明数组已经有序，可以提前结束
            if (!swapped) {
                System.out.println("在第 " + (i + 1) + " 轮后数组已有序，提前结束排序");
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
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    /**
     * 复制数组
     * @param source 源数组
     * @return 源数组的副本
     */
    public static int[] copyArray(int[] source) {
        int[] copy = new int[source.length];
        System.arraycopy(source, 0, copy, 0, source.length);
        return copy;
    }
    
    /**
     * 主方法，用于测试冒泡排序的各种情况
     */
    public static void main(String[] args) {
        System.out.println("=== 冒泡排序算法演示 ===\n");
        
        // 测试用例1：普通无序数组
        System.out.println("测试1: 普通无序数组");
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("排序前: ");
        printArray(arr1);
        
        bubbleSort(copyArray(arr1)); // 使用副本进行排序
        bubbleSort(arr1);
        System.out.print("排序后: ");
        printArray(arr1);
        System.out.println();
        
        // 测试用例2：已排序数组（最好情况）
        System.out.println("测试2: 已排序数组（最好情况）");
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("排序前: ");
        printArray(arr2);
        
        bubbleSort(arr2);
        System.out.print("排序后: ");
        printArray(arr2);
        System.out.println();
        
        // 测试用例3：逆序数组（最坏情况）
        System.out.println("测试3: 逆序数组（最坏情况）");
        int[] arr3 = {7, 6, 5, 4, 3, 2, 1};
        System.out.print("排序前: ");
        printArray(arr3);
        
        bubbleSort(arr3);
        System.out.print("排序后: ");
        printArray(arr3);
        System.out.println();
        
        // 测试用例4：包含重复元素的数组
        System.out.println("测试4: 包含重复元素的数组");
        int[] arr4 = {5, 2, 8, 2, 9, 1, 5, 4};
        System.out.print("排序前: ");
        printArray(arr4);
        
        bubbleSort(arr4);
        System.out.print("排序后: ");
        printArray(arr4);
        System.out.println();
        
        // 测试用例5：单个元素
        System.out.println("测试5: 单个元素");
        int[] arr5 = {42};
        System.out.print("排序前: ");
        printArray(arr5);
        
        bubbleSort(arr5);
        System.out.print("排序后: ");
        printArray(arr5);
        System.out.println();
        
        // 测试用例6：空数组
        System.out.println("测试6: 空数组");
        int[] arr6 = {};
        System.out.print("排序前: ");
        printArray(arr6);
        
        bubbleSort(arr6);
        System.out.print("排序后: ");
        printArray(arr6);
        System.out.println();
        
        System.out.println("=== 算法特点总结 ===");
        System.out.println("1. 稳定排序：相等元素的相对位置不会改变");
        System.out.println("2. 原地排序：只需要常数级额外空间");
        System.out.println("3. 时间复杂度：最好O(n)，平均和最坏O(n²)");
        System.out.println("4. 适用场景：小规模数据或基本有序的数据");
    }
}