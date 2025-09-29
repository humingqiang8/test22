def bubble_sort(arr):
    """
    冒泡排序算法

    Args:
        arr: 待排序的列表

    Returns:
        排序后的列表
    """
    n = len(arr)
    # 遍历所有数组元素
    for i in range(n):
        # 标记本轮是否发生交换，用于优化
        swapped = False
        # 最后i个元素已经排好序了
        for j in range(0, n - i - 1):
            # 如果当前元素比下一个元素大，则交换它们
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        # 如果本轮没有发生交换，说明数组已经有序，可以提前结束
        if not swapped:
            break
    return arr

# 示例用法
if __name__ == "__main__":
    numbers = [64, 34, 25, 12, 22, 11, 90]
    print("排序前的数组:", numbers)
    sorted_numbers = bubble_sort(numbers.copy()) # 使用copy()避免修改原数组
    print("排序后的数组:", sorted_numbers)
