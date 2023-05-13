from flask import Flask, request
import pandas as pd
import jieba
import numpy as np
import math
import pickle


def Salary_forecast(str_describe):
    jieba.initialize()
    expect_job = ''
    mix_seg = jieba.Tokenizer()
    # R,SPSS,Excel,Python,MATLAB,Java,SQL,SAS,Stata,EViews,Spark,'Hadoop'，地区,公司性质,公司规模,学历,工作经验
    # R,SPSS,Excel,Python,MATLAB,Java,SQL,SAS,Stata,EViews,Spark,area,compVar,compScale,academic,exp
    word_cut = mix_seg.lcut(str_describe)
    geo_pos = ["北京", "上海", "深圳", "广州"]
    enter_type = ["民营公司", "创业公司", "国企", "合资", "上市公司", "外资"]
    edu_background = ['无', '中专', '高中', '大专', '本科', '硕士', '博士']
    pos_list = ['R', 'SPSS', 'Excel', 'Python', 'MATLAB', 'Java', 'SQL', 'SAS', 'Stata', 'EViews', 'Spark',
                'Hadoop']
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
    if valid_bd > valid_da:
        expect_job = "大数据工程师"
    else:
        expect_job = "数据分析师"

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

    clear_flag = 0
    for entr in range(len(enter_type)):
        if enter_type[entr] in word_cut:
            enter_level = entr
            feature_List.append(enter_level)
        else:
            clear_flag += 1
            if clear_flag == len(enter_type):
                feature_List.append(3)
                break

    clear_flag = 0
    stuc = 0
    for word in range(len(word_cut)):
        if word_cut[word] == '规模':
            if word_cut[word + 2] == '人':
                stuc = int(word_cut[word + 1])
            elif word_cut[word - 1] == '人':
                stuc = int(word_cut[word - 2])
            if stuc < 50:
                feature_List.append(0)
                break
            elif 50 <= stuc < 500:
                feature_List.append(1)
                break
            elif 500 <= stuc < 1000:
                feature_List.append(2)
                break
            elif 1000 <= stuc < 5000:
                feature_List.append(3)
                break
            elif 5000 <= stuc < 10000:
                feature_List.append(4)
                break
            else:
                feature_List.append(5)
                break
        else:
            clear_flag += 1
            if clear_flag == (len(word_cut) - 1):
                feature_List.append(2)
                break

    clear_flag = 0
    for edu in range(len(edu_background)):
        if edu_background[edu] in word_cut:
            education_level = edu
            feature_List.append(education_level)
            break
        else:
            clear_flag += 1
            if clear_flag == len(edu_background):
                feature_List.append(0)
                break

    clear_flag = 0
    for word in range(len(word_cut)):
        if word_cut[word] == '经验':
            if word_cut[word - 2] == '年':
                years = int(word_cut[word - 3])
            else:
                years = 0
            feature_List.append(years)
        else:
            clear_flag += 1
            if clear_flag == (len(word_cut)):
                feature_List.append(0)
                break

    with open('model/my_model.pickle', 'rb') as handle:
        loaded_model = pickle.load(handle)
    pd_list = pd.DataFrame(np.matrix(feature_List))
    # # 使用线性回归模型进行预测
    return_dict = {}
    return_dict['data'] = {'salary': math.exp(loaded_model.predict(pd_list).values[0]), 'job': expect_job}
    return return_dict


def technological_gap(str_describe, ideal_sal, web_geo="北京"):
    tech_gap = []
    return_dict = {}
    out_job = ''
    posi_sal = 0
    jieba.initialize()
    mix_seg = jieba.Tokenizer()
    # R,SPSS,Excel,Python,MATLAB,Java,SQL,SAS,Stata,EViews,Spark,'Hadoop'，地区,公司性质,公司规模,学历,工作经验
    # R,SPSS,Excel,Python,MATLAB,Java,SQL,SAS,Stata,EViews,Spark,area,compVar,compScale,academic,exp
    word_cut = mix_seg.lcut(str_describe)
    geo_pos = ["北京", "上海", "深圳", "广州"]
    enter_type = ["民营公司", "创业公司", "国企", "合资", "上市公司", "外资"]
    edu_background = ['无学历', '中专', '高中', '大专', '本科', '硕士', '博士']
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
        posi_sal = 3000
        posi_step = 8000
        out_job = "大数据工程师"
        pos_list = bd_ability
        with open('model/my_model.pickle_bd', 'rb') as handle:
            loaded_model = pickle.load(handle)

    else:
        posi_sal = 45
        posi_step = 8000
        out_job = "数据分析师"
        pos_list = da_ability
        with open('model/my_model.pickle_da', 'rb') as handle:
            loaded_model = pickle.load(handle)
    feature_List = []
    position_flag_level = 0
    for tech in pos_list:
        feature_List.append(1 if tech in word_cut else 0)
    for i in range(len(geo_pos)):
        if geo_pos[i] == web_geo:
            position_flag_level = 1
            feature_List.append(position_flag_level)
            break
        else:
            if i == len(geo_pos) - 1:
                position_flag_level = 0
                feature_List.append(position_flag_level)
    clear_flag = 0
    for entr in range(len(enter_type)):
        if enter_type[entr] in word_cut:
            enter_level = entr
            feature_List.append(enter_level)
        else:
            clear_flag += 1
            if clear_flag == len(enter_type):
                feature_List.append(3)
                break

    clear_flag = 0
    stuc = 0
    for word in range(len(word_cut)):
        if word_cut[word] == '规模':
            if word_cut[word + 2] == '人':
                stuc = int(word_cut[word + 1])
            elif word_cut[word - 1] == '人':
                stuc = int(word_cut[word - 2])
            if stuc < 50:
                feature_List.append(0)
                break
            elif 50 <= stuc < 500:
                feature_List.append(1)
                break
            elif 500 <= stuc < 1000:
                feature_List.append(2)
                break
            elif 1000 <= stuc < 5000:
                feature_List.append(3)
                break
            elif 5000 <= stuc < 10000:
                feature_List.append(4)
                break
            else:
                feature_List.append(5)
                break
        else:
            clear_flag += 1
            if clear_flag == (len(word_cut) - 1):
                feature_List.append(2)
                break

    clear_flag = 0
    for edu in range(len(edu_background)):
        if edu_background[edu] in word_cut:
            education_level = edu
            feature_List.append(education_level)
            break
        else:
            clear_flag += 1
            if clear_flag == len(edu_background):
                feature_List.append(0)
                break

    clear_flag = 0
    for word in range(len(word_cut)):
        if word_cut[word] == '经验':
            if word_cut[word - 2] == '年':
                years = int(word_cut[word - 3])
            else:
                years = 0
            feature_List.append(years)
        else:
            clear_flag += 1
            if clear_flag == (len(word_cut)):
                feature_List.append(0)
                break
    out_str = ''
    for abi in range(len(pos_list)):
        while feature_List[abi] == 1:
            abi += 1
        feature_List[abi] = 1
        tech_gap.append(abi)
        pd_list = pd.DataFrame(np.matrix(feature_List))
        if (math.exp(loaded_model.predict(pd_list).values[0]) * posi_sal + posi_step) > ideal_sal:
            for tech in tech_gap:
                out_str = out_str + ' ' + pos_list[tech]
            return_dict['data'] = {'diff': out_str, 'job': out_job}
            return return_dict
        if abi == len(pos_list) + 1:
            for tech in tech_gap[:-1]:
                if tech < len(pos_list):
                    out_str = out_str + ' ' + pos_list[tech]
            out_str = out_str + " 工作经验"
            # return_dict['data'] = {'diff': out_str, 'job': out_job}
            return_dict['data'] = {'diff': out_str}
            return return_dict


app = Flask(__name__)


@app.route('/skillTest', methods=['POST'])
def index():
    # str_describe = '一位会用R和Python，BI,0年工作经验的本科，如果找一份位于上海、规模87人的上市公司提供的工作'
    data=request.get_json()
    data = data['skillTest']
    web_mode = data.get('workMode')
    if web_mode == 0:
        web_desc = data.get('inputContext')  # 获取POST的数据，并转换为字符串
        print(web_desc)
        return Salary_forecast(web_desc)
    else:
        web_desc = data.get('inputContext')  # 获取POST的数据，并转换为字符串
        web_sal = data.get('expectSalary')
        web_geo = data.get('expectCity')
        print(web_desc, web_sal, web_geo)
        return technological_gap(web_desc, web_sal, web_geo)

if __name__ == '__main__':
    predict_begin = app.run(host='0.0.0.0',port=5200)
