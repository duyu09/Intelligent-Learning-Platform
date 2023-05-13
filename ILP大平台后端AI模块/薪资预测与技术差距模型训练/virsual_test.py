# 导入所需的Python库
import pandas as pd
import jieba
import numpy as np
import math
import pickle


def Salary_forecast(str_describe):
    jieba.initialize()
    mix_seg = jieba.Tokenizer()
    # R,SPSS,Excel,Python,MATLAB,Java,SQL,SAS,Stata,EViews,Spark,'Hadoop'，地区,公司性质,公司规模,学历,工作经验
    # R,SPSS,Excel,Python,MATLAB,Java,SQL,SAS,Stata,EViews,Spark,area,compVar,compScale,academic,exp
    word_cut = mix_seg.lcut(str_describe)
    geo_pos = ["北京", "上海", "深圳", "广州"]
    enter_type = ["民营公司", "创业公司", "国企", "合资", "上市公司", "外资"]
    edu_background = ['无', '中专', '高中', '大专', '本科', '硕士', '博士']
    pos_list = ['R', 'SPSS', 'Excel', 'Python', 'MATLAB', 'Java', 'SQL', 'SAS', 'Stata', 'EViews', 'Spark',
                'Hadoop']
    feature_List = []
    for tech in pos_list:
        feature_List.append(1 if tech in word_cut else 0)

    for i in range(len(geo_pos)):
        if geo_pos[i] in word_cut:
            position_flag_level = 1
            feature_List.append(position_flag_level)
            break
        else:
            if i == len(geo_pos) - 1:
                position_flag_level = 0
                feature_List.append(position_flag_level)

    for entr in range(len(enter_type)):
        if enter_type[entr] in word_cut:
            education_level = entr
            feature_List.append(education_level)

    for word in range(len(word_cut)):
        if word_cut[word] == '规模':
            stuc = int(word_cut[word + 1])
            if stuc < 50:
                feature_List.append(0)
            elif 50 <= stuc < 500:
                feature_List.append(1)
            elif 500 <= stuc < 1000:
                feature_List.append(2)
            elif 1000 <= stuc < 5000:
                feature_List.append(3)
            elif 5000 <= stuc < 10000:
                feature_List.append(4)
            else:
                feature_List.append(5)

    for edu in range(len(edu_background)):
        if edu_background[edu] in word_cut:
            education_level = edu
            feature_List.append(education_level)

    for word in range(len(word_cut)):
        if word_cut[word] == '经验':
            if word_cut[word - 2] == '年':
                years = int(word_cut[word - 3])
            else:
                years = 0
            feature_List.append(years)

    with open('model/my_model.pickle', 'rb') as handle:
        loaded_model = pickle.load(handle)
    pd_list = pd.DataFrame(np.matrix(feature_List))
    # # 使用线性回归模型进行预测
    return math.exp(loaded_model.predict(pd_list).values[0])


def technological_gap(str_describe, ideal_sal):
    tech_gap = []
    out_list = []
    jieba.initialize()
    mix_seg = jieba.Tokenizer()
    # R,SPSS,Excel,Python,MATLAB,Java,SQL,SAS,Stata,EViews,Spark,'Hadoop'，地区,公司性质,公司规模,学历,工作经验
    # R,SPSS,Excel,Python,MATLAB,Java,SQL,SAS,Stata,EViews,Spark,area,compVar,compScale,academic,exp
    word_cut = mix_seg.lcut(str_describe)
    geo_pos = ["北京", "上海", "深圳", "广州"]
    enter_type = ["民营公司", "创业公司", "国企", "合资", "上市公司", "外资"]
    edu_background = ['无', '中专', '高中', '大专', '本科', '硕士', '博士']
    bd_ability = ["Kafka", "hive", "Flink", "Hadoop", "Oracle", "HBase", "Kylin", "Python", "java",
                  "MySQL", "Linux", "Spark"]
    da_ability = ["R", "SPSS", "Excel", "Python", "MATLAB", "Java", "SQL", "SAS", "Tableau",
                  "BI", "Spark", "Hadoop"]
    valid_bd = 0
    for word in word_cut:
        for abi in bd_ability:
            if word == abi:
                valid_bd += 1
    valid_da = 0
    for word in word_cut:
        for abi in da_ability:
            if word == abi:
                valid_da += 1
    pos_list = []
    if valid_bd > valid_da:
        out_list.append("大数据工程师")
        pos_list = ["Kafka", "hive", "Flink", "Hadoop", "Oracle", "HBase", "Kylin", "Python", "java",
                    "MySQL", "Linux", "Spark"]
        with open('model/my_model.pickle_bd', 'rb') as handle:
            loaded_model = pickle.load(handle)

    else:
        out_list.append("数据分析师")
        pos_list = ["R", "SPSS", "Excel", "Python", "MATLAB", "Java", "SQL", "SAS", "Tableau",
                    "BI", "Spark", "Hadoop"]
        with open('model/my_model.pickle_da', 'rb') as handle:
            loaded_model = pickle.load(handle)
    feature_List = []
    for tech in pos_list:
        feature_List.append(1 if tech in word_cut else 0)

    for i in range(len(geo_pos)):
        if geo_pos[i] in word_cut:
            position_flag_level = 1
            feature_List.append(position_flag_level)
            break
        else:
            if i == len(geo_pos) - 1:
                position_flag_level = 0
                feature_List.append(position_flag_level)

    for entr in range(len(enter_type)):
        if enter_type[entr] in word_cut:
            education_level = entr
            feature_List.append(education_level)

    for word in range(len(word_cut)):
        if word_cut[word] == '规模':
            stuc = int(word_cut[word + 1])
            if stuc < 50:
                feature_List.append(0)
            elif 50 <= stuc < 500:
                feature_List.append(1)
            elif 500 <= stuc < 1000:
                feature_List.append(2)
            elif 1000 <= stuc < 5000:
                feature_List.append(3)
            elif 5000 <= stuc < 10000:
                feature_List.append(4)
            else:
                feature_List.append(5)

    for edu in range(len(edu_background)):
        if edu_background[edu] in word_cut:
            education_level = edu
            feature_List.append(education_level)

    for word in range(len(word_cut)):
        if word_cut[word] == '经验':
            if word_cut[word - 2] == '年':
                years = int(word_cut[word - 3])
            else:
                years = 0
            feature_List.append(years)

    for abi in range(len(pos_list)):
        while feature_List[abi] == 1:
            abi += 1
        feature_List[abi] = 1
        tech_gap.append(abi)
        pd_list = pd.DataFrame(np.matrix(feature_List))
        if (math.exp(loaded_model.predict(pd_list).values[0]) * 10 + 7500) > ideal_sal:
            for tech in tech_gap:
                out_list.append(pos_list[tech])
            break
        if abi == len(pos_list) + 1:
            out_list.append("工作经验")
    return out_list


str_describe = '一位会用R和Python，BI,0年工作经验的本科，如果找一份位于上海、规模87人的上市公司提供的工作'
print(technological_gap(str_describe, 10000))
print(Salary_forecast(str_describe))
