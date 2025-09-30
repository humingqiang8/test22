def bubble_sort(arr):
    """
    冒泡排序算法

    Args:
        arr: 待排序的列表

    Returns:
        排序后的列表
    """
    n = len(arr)
    # 外层循环控制排序的轮数
    for i in range(n):
        # 优化标志：如果在一轮中没有发生交换，则说明列表已经有序
        swapped = False
        # 内层循环负责每一轮的比较和交换
        # 每一轮后，最大的元素会“冒泡”到末尾，所以范围可以减小 i
        for j in range(0, n - i - 1):
            # 如果前一个元素大于后一个元素，则交换它们
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        # 如果这一轮没有发生任何交换，说明数组已经有序，可以提前结束
        if not swapped:
            break
    return arr

# 示例用法
if __name__ == "__main__":
    test_list = [64, 34, 25, 12, 22, 11, 90]
    print("排序前的列表:", test_list)
    sorted_list = bubble_sort(test_list.copy())  # 使用 copy() 避免修改原列表
    print("排序后的列表:", sorted_list)
