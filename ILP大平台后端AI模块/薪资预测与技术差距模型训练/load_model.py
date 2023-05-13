import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import math
import seaborn as sns
import statsmodels.api as sm
from statsmodels.formula.api import ols
import pickle

with open('my_model.pickle', 'rb') as handle:
    loaded_model = pickle.load(handle)
new_data1 = pd.DataFrame(np.matrix([1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 6, 8]))

# 测试数据
# 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 4, 5, 6, 6

# # 对dataframe重新命名列名
# R,SPSS,Excel,Python,MATLAB,Java,SQL,SAS,Stata,EViews,Spark,'Hadoop'，地区,公司性质,公司规模,学历,工作经验
# R,SPSS,Excel,Python,MATLAB,Java,SQL,SAS,Stata,EViews,Spark,area,compVar,compScale,academic,exp
new_data1.columns = ['R', 'SPSS', 'Excel', 'Python', 'MATLAB', 'Java', 'SQL', 'SAS', 'Stata', 'EViews', 'Spark',
                     'Hadoop', 'area',
                     'compVar', 'compScale', 'academic', 'exp']
# # 将数据类型转换为数值型
for i in range(13):
    new_data1.iloc[:, i] = pd.to_numeric(new_data1.iloc[:, i], errors='coerce')
new_data1['exp'] = pd.to_numeric(new_data1['exp'], errors='coerce')
print(new_data1)
# # 使用线性回归模型进行预测
print(math.exp(loaded_model.predict(new_data1).values[0]))
