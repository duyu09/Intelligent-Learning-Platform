import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import seaborn as sns
import statsmodels.api as sm
from statsmodels.formula.api import ols
import math
import pickle
import statsmodels.formula.api as smf

# 0,1,2,3,4,5
# 少于50人,50-500人,500-1000人,1000-5000人,5000-10000人,10000人以上

dat0 = pd.read_csv("Intermediate data.csv")
dat0.dropna(inplace=True)
n = dat0.shape[1]
dat0 = dat0.iloc[:, :-1]

print(dat0['aveSalary'].describe())

# 读取数据并创建 exp_level 列
dat0["exp_level"] = pd.cut(dat0["exp"], bins=[-0.01, 3.99, 6.01, dat0["exp"].max()],
                           labels=["经验：0-3年", "经验：4-6年", "经验：>6年"])
# 绘制箱线图
sns.boxplot(x="exp_level", y="aveSalary", data=dat0, palette="Blues")
plt.ylim(0, 45000)
plt.ylabel("aveSalary（元/月）")
plt.show()

# 计算线性回归模型并输出摘要


model = ols("aveSalary ~ exp_level", data=dat0).fit()
print(model.summary())
dat0["academic"] = pd.Categorical(dat0["academic"], categories=[0, 1, 2, 3, 4, 5, 6])
# "无", "中专", "高中", "大专", "本科", "硕士", "博士"
# 0,1,2,3,4,5,6
# 绘制箱线图
sns.boxplot(x="academic", y="aveSalary", data=dat0, palette="Blues")
plt.ylim(0, 45000)
plt.ylabel("aveSalary（元/月）")
plt.show()

# 计算线性回归模型并输出摘要


model = ols("aveSalary ~ academic", data=dat0).fit()
print(model.summary())
academic_counts = dat0["academic"].value_counts()

print(academic_counts)
dat0["compVar"] = pd.Categorical(dat0["compVar"], categories=[0, 1, 2, 3, 4, 5])
# "民营公司", "创业公司", "国企", "合资", "上市公司", "外资"
# 0, 1, 2, 3, 4, 5
# 确认分类变量已转换为 factors，并检查唯一值
X = dat0.iloc[:, 1:-1]  # 所有自变量列
y = np.log(dat0.loc[:, "aveSalary"])  # 因变量列
# X = sm.add_constant(X)  # 添加截距项

model = sm.OLS(y, X).fit()

# 输出摘要
print(model.summary())
new_data1 = pd.DataFrame(np.matrix([1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 2, 5]))
# # 对dataframe重新命名列名
new_data1.columns = dat0.columns[1:18]
# # 将数据类型转换为数值型
# new_data1 = sm.add_constant(new_data1)
for i in range(13):
    new_data1.iloc[:, i] = pd.to_numeric(new_data1.iloc[:, i], errors='coerce')
new_data1['exp'] = pd.to_numeric(new_data1['exp'], errors='coerce')

print(new_data1)
# arr2_reshaped = np.reshape(new_data1, (1, 19))
# # 使用线性回归模型进行预测
# print(new_data1.shape)
predicted_exp = model.predict(new_data1)


print(math.exp(predicted_exp.values[0])+7000)
with open('my_model.pickle_bigdata', 'wb') as handle:
    pickle.dump(model, handle, protocol=pickle.HIGHEST_PROTOCOL)