public class BubbleSort {
    public static void main(String[] args) {
        // 假设这是环境中的数组 a
        int[] a = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:");
        printArray(a);

        bubbleSort(a);

        System.out.println("Sorted array:");
        printArray(a);
    }

    /**
     * 冒泡排序算法
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * 
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化标志，检测是否发生交换
            
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
            
            // 如果这一轮没有发生交换，说明数组已经有序，可以提前结束
            if (!swapped) {
                break;
            }
        }
    }

    // 打印数组函数
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}