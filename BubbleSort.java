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

    // 冒泡排序函数
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j] 和 arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
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