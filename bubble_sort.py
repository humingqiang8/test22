def is_all_numbers(arr):
    """
    判断列表中的所有元素是否都是数字（int 或 float）。

    Args:
        arr: 待检查的列表

    Returns:
        如果所有元素都是数字则返回 True，否则返回 False。
    """
    return all(isinstance(x, (int, float)) for x in arr)

def conditional_bubble_sort(arr):
    """
    条件冒泡排序：仅当列表中所有元素都是数字时才执行冒泡排序。

    Args:
        arr: 待排序的列表

    Returns:
        排序后的列表。如果列表包含非数字元素，则返回原列表。
    """
    if is_all_numbers(arr):
        print("列表包含纯数字，执行冒泡排序...")
        return bubble_sort(arr)
    else:
        print("列表包含非数字元素，跳过排序。")
        return arr

def bubble_sort(arr):
    """
    冒泡排序算法

    Args:
        arr: 待排序的列表

    Returns:
        排序后的列表
    """
    # is_all_numbers 检查已在 conditional_bubble_sort 中完成
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
    # 测试包含数字的列表
    numbers = [64, 34, 25, 12, 22, 11, 90]
    print("原始数组 (数字):", numbers)
    sorted_numbers = conditional_bubble_sort(numbers.copy()) # 使用copy()避免修改原数组
    print("处理后数组 (数字):", sorted_numbers)
    print("-" * 20)

    # 测试包含非数字的列表
    mixed_list = [1, 'a', 3]
    print("原始数组 (混合):", mixed_list)
    processed_mixed = conditional_bubble_sort(mixed_list.copy())
    print("处理后数组 (混合):", processed_mixed)
    print("-" * 20)

    # 测试空列表
    empty_list = []
    print("原始数组 (空):", empty_list)
    processed_empty = conditional_bubble_sort(empty_list.copy())
    print("处理后数组 (空):", processed_empty)
