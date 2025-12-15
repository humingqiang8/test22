/**
 * 判断数组的所有成员是否都是数字
 * @param {Array} arr - 要检查的数组
 * @returns {boolean} - 如果所有成员都是数字则返回true，否则返回false
 */
function isAllNumbers(arr) {
    // 检查输入是否为数组
    if (!Array.isArray(arr)) {
        return false;
    }
    
    // 遍历数组中的每个元素
    for (let i = 0; i < arr.length; i++) {
        const element = arr[i];
        
        // 检查元素是否为数字类型且不是NaN
        if (typeof element !== 'number' || isNaN(element)) {
            return false;
        }
    }
    
    return true;
}

/**
 * 冒泡排序算法
 * @param {Array} arr - 要排序的数组
 * @returns {Array} - 排序后的数组，如果输入无效则返回null
 */
function bubbleSort(arr) {
    // 首先检查输入是否为数组
    if (!Array.isArray(arr)) {
        console.log("错误：输入不是一个数组");
        return null;
    }
    
    // 使用isAllNumbers函数检查数组中的所有元素是否都是数字
    if (!isAllNumbers(arr)) {
        console.log("错误：数组中包含非数字元素，无法进行排序");
        return null;
    }
    
    // 创建数组副本以避免修改原数组
    const sortedArr = [...arr];
    const n = sortedArr.length;
    
    // 冒泡排序算法
    for (let i = 0; i < n - 1; i++) {
        // 标记本轮是否发生交换，用于优化
        let swapped = false;
        
        for (let j = 0; j < n - i - 1; j++) {
            // 比较相邻元素，如果前面的元素大于后面的元素，则交换它们
            if (sortedArr[j] > sortedArr[j + 1]) {
                // 交换元素
                [sortedArr[j], sortedArr[j + 1]] = [sortedArr[j + 1], sortedArr[j]];
                swapped = true;
            }
        }
        
        // 如果这一轮没有发生任何交换，说明数组已经有序，可以提前结束
        if (!swapped) {
            break;
        }
    }
    
    return sortedArr;
}

// 示例用法和测试
console.log('冒泡排序测试：');

// 测试有效的数字数组
console.log('测试1 - 有效数组 [64, 34, 25, 12, 22, 11, 90]:');
const testArray1 = [64, 34, 25, 12, 22, 11, 90];
console.log('原数组:', testArray1);
console.log('排序后:', bubbleSort(testArray1));
console.log();

// 测试包含非数字元素的数组
console.log('测试2 - 包含非数字元素的数组 [64, 34, "hello", 12]:');
const testArray2 = [64, 34, "hello", 12];
console.log('原数组:', testArray2);
console.log('排序结果:', bubbleSort(testArray2));
console.log();

// 测试包含NaN的数组
console.log('测试3 - 包含NaN的数组 [64, 34, NaN, 12]:');
const testArray3 = [64, 34, NaN, 12];
console.log('原数组:', testArray3);
console.log('排序结果:', bubbleSort(testArray3));
console.log();

// 测试负数数组
console.log('测试4 - 包含负数的数组 [-5, 3, -1, 8, 0]:');
const testArray4 = [-5, 3, -1, 8, 0];
console.log('原数组:', testArray4);
console.log('排序后:', bubbleSort(testArray4));
console.log();

// 测试浮点数数组
console.log('测试5 - 包含浮点数的数组 [3.5, 1.2, 4.8, 2.1]:');
const testArray5 = [3.5, 1.2, 4.8, 2.1];
console.log('原数组:', testArray5);
console.log('排序后:', bubbleSort(testArray5));
console.log();

// 测试空数组
console.log('测试6 - 空数组 []:');
const testArray6 = [];
console.log('原数组:', testArray6);
console.log('排序后:', bubbleSort(testArray6));
console.log();

// 测试单个元素数组
console.log('测试7 - 单个元素数组 [42]:');
const testArray7 = [42];
console.log('原数组:', testArray7);
console.log('排序后:', bubbleSort(testArray7));