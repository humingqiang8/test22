/**
 * 判断数组的所有成员是否都是数字 (ES6版本)
 * 使用Array.every()方法实现
 * @param {Array} arr - 要检查的数组
 * @returns {boolean} - 如果所有成员都是数字则返回true，否则返回false
 */
const isAllNumbers = (arr) => {
    // 检查输入是否为数组
    if (!Array.isArray(arr)) {
        return false;
    }
    
    // 使用every()方法检查每个元素是否都是数字且不是NaN
    return arr.every(element => typeof element === 'number' && !isNaN(element));
};

// 示例用法和测试
console.log('ES6版本测试示例：');
console.log(isAllNumbers([1, 2, 3, 4]));       // true
console.log(isAllNumbers([1, '2', 3]));        // false
console.log(isAllNumbers([1, 2, NaN, 4]));     // false
console.log(isAllNumbers([]));                 // true (空数组)
console.log(isAllNumbers([1, 2.5, -3]));       // true
console.log(isAllNumbers(['hello', 'world'])); // false

// 导出函数以供其他模块使用
module.exports = isAllNumbers;