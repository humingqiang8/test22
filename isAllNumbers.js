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

// 示例用法和测试
console.log('测试示例：');
console.log(isAllNumbers([1, 2, 3, 4]));       // true
console.log(isAllNumbers([1, '2', 3]));        // false
console.log(isAllNumbers([1, 2, NaN, 4]));     // false
console.log(isAllNumbers([]));                 // true (空数组)
console.log(isAllNumbers([1, 2.5, -3]));       // true
console.log(isAllNumbers(['hello', 'world'])); // false

// 导出函数以供其他模块使用
module.exports = isAllNumbers;