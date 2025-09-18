#!/bin/bash

# 获取环境变量 a 的值
input_array="$a"

# 检查环境变量是否为空
if [[ -z "$input_array" ]]; then
  echo "环境变量 'a' 未定义或为空。"
  exit 1
fi

# 将输入字符串按空格或逗号分割成数组
# 这里我们使用一个简单的办法，先将逗号替换为空格，然后使用 read -a 来创建数组
IFS=',' read -r -a temp_array <<< "$input_array"
# 将逗号分隔的数组合并到最终的空格分隔的数组中
final_array=()
for element in "${temp_array[@]}"; do
    # 去除每个元素可能存在的前后空格
    element=$(echo $element | xargs)
    if [[ -n "$element" ]]; then
        final_array+=("$element")
    fi
done

# 如果最终数组为空，则尝试用空格分割原始输入
if [[ ${#final_array[@]} -eq 0 ]]; then
    read -r -a final_array <<< "$input_array"
fi

# 检查数组是否为空
if [[ ${#final_array[@]} -eq 0 ]]; then
  echo "无法从环境变量 'a' 解析出数组。"
  exit 1
fi

# 初始化乘积为1
product=1

# 遍历数组并计算乘积
for num in "${final_array[@]}"; do
  # 检查元素是否为数字
  if ! [[ "$num" =~ ^-?[0-9]+([.][0-9]+)?$ ]]; then
    echo "错误: '$num' 不是一个有效的数字。"
    exit 1
  fi
  product=$(echo "$product * $num" | bc -l)
done

# 输出结果
echo "数组 [${final_array[*]}] 的乘积是: $product"