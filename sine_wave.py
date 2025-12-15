import numpy as np
import matplotlib.pyplot as plt

# 生成x轴数据点
x = np.linspace(0, 4*np.pi, 1000)  # 从0到4π，共1000个点

# 生成正弦波数据
y = np.sin(x)

# 创建图形
plt.figure(figsize=(12, 6))
plt.plot(x, y, label='sin(x)', color='blue', linewidth=2)

# 设置中文字体以避免字体警告
plt.rcParams['font.sans-serif'] = ['SimHei', 'DejaVu Sans']
plt.rcParams['axes.unicode_minus'] = False

# 添加标题和标签
plt.title('Sine Wave', fontsize=16)
plt.xlabel('x', fontsize=12)
plt.ylabel('sin(x)', fontsize=12)

# 添加网格
plt.grid(True, linestyle='--', alpha=0.6)

# 添加图例
plt.legend()

# 设置x轴刻度标记为π的倍数
plt.xticks([0, np.pi, 2*np.pi, 3*np.pi, 4*np.pi], 
           ['0', 'π', '2π', '3π', '4π'])

# 显示图形
plt.tight_layout()
plt.savefig('/workspace/sine_wave.png', dpi=300, bbox_inches='tight')
print("正弦波图像已保存为 sine_wave.png")
plt.show()