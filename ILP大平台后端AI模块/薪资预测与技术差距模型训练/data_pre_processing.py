# 导入所需的Python库
import pandas as pd
import jieba
import numpy as np

# 读取Excel文件
job = pd.read_excel("dataSet/job_all.xlsx")

# 查看数据框结构
print(job.head())
print(job.info())
job['最低薪资'] = pd.to_numeric(job['最低薪资'])
job['最高薪资'] = pd.to_numeric(job['最高薪资'])
job['平均薪资'] = (job['最高薪资'] + job['最低薪资']) / 2
print("6666666666666666666666")
print(job['平均薪资'])
loc = job.index[job['地区'].isin(["北京", "上海", "深圳", "广州"])]
loc_other = job.index[~job['地区'].isin(["北京", "上海", "深圳", "广州"])]
job.loc[loc, '地区'] = 1
job.loc[loc_other, '地区'] = 0
job['地区'] = pd.to_numeric(job['地区'])
job["公司规模"] = pd.Categorical(job["公司规模"], categories=["少于50人", "50-500人", "500-1000人", "1000-5000人",
                                                      "5000-10000人", "10000人以上"], ordered=True)

job['学历'] = pd.Categorical(job['学历'], categories=["中专", "高中", "大专", "无", "本科", "硕士", "博士"])
software = pd.DataFrame(np.zeros((len(job['描述']), 12)))
software.columns = ["Kafka", "hive", "Flink", "Hadoop", "Oracle", "HBase", "Kylin", "Python", "java",
                    "MySQL", "Linux", "Spark"]

jieba.initialize()
mixseg = jieba.Tokenizer()


for j in range(len(job['描述'])):
    subdata = str(job['描述'][j])
    # print(subdata)
    fenci = mixseg.lcut(subdata)
    kafka_identify = ("Kafka" in fenci) or ("kafka" in fenci) or ("KAFKA" in fenci)
    hive_identify = ("hive" in fenci) or ("Hive" in fenci) or ("HIVE" in fenci)
    flink_identify = ("Flink" in fenci) or ("flink" in fenci) or ("FLINK" in fenci)
    Oracle_identify = ("Oracle" in fenci) or ("oracle" in fenci) or ("ORACLE" in fenci)
    hbase_identify = ("HBase" in fenci) or ("hbase" in fenci) or ("HBASE" in fenci)
    kylin_identify = ("Kylin" in fenci) or ("kylin" in fenci) or ("KYLIN" in fenci)
    Python_identify = ("Python" in fenci) or ("python" in fenci) or ("PYTHON" in fenci)
    Java_identify = ("java" in fenci) or ("JAVA" in fenci) or ("Java" in fenci)
    MySQL_identify = ("MySQL" in fenci) or ("mysql" in fenci) or ("MYSQL" in fenci)
    Linux_identify = ("Linux" in fenci) or ("linux" in fenci) or ("LINUX" in fenci)
    Spark_identify = ("Spark" in fenci) or ("SPARK" in fenci) or ("spark" in fenci)
    Hadoop_identify = ("HADOOP" in fenci) or ("Hadoop" in fenci) or ("hadoop" in fenci)
    if kafka_identify:
        software.at[j, 'Kafka'] = 1
    if hive_identify:
        software.at[j, 'hive'] = 1
    if flink_identify:
        software.at[j, 'Flink'] = 1
    if Oracle_identify:
        software.at[j, 'Oracle'] = 1
    if hbase_identify:
        software.at[j, 'HBase'] = 1
    if kylin_identify:
        software.at[j, 'Kylin'] = 1
    if Python_identify:
        software.at[j, 'Python'] = 1
    if Java_identify:
        software.at[j, 'java'] = 1
    if MySQL_identify:
        software.at[j, 'MySQL'] = 1
    if Linux_identify:
        software.at[j, 'Linux'] = 1
    if Spark_identify:
        software.at[j, 'Spark'] = 1
    if Hadoop_identify:
        software.at[j, 'Hadoop'] = 1


job_new = pd.concat([job['平均薪资'], software], axis=1)
job_new.columns = ["平均薪资"] + list(software.columns)
job_new['地区'] = job['地区']
job_new['公司类别'] = job['公司类别']
job_new['公司规模'] = job['公司规模']
job_new['学历'] = job['学历']
job_new['经验要求'] = job['经验']
job_new['行业类别'] = job['行业类别']
job_new['公司类别'].value_counts()
job_new = job_new[~job_new['公司类别'].isin(["非营利机构", "事业单位"])]
job_new.columns = ["aveSalary"] + list(job_new.columns[1:13]) + ["area", "compVar", "compScale", "academic", "exp",
                                                                 "induCate"]
job_new.to_csv("数据分析岗位招聘.csv", index=False)



# for j in range(len(job['描述'])):
#     subdata = str(job['描述'][j])
#     # print(subdata)
#     fenci = mixseg.lcut(subdata)
#     R_identify = ("R" in fenci) or ("r" in fenci)
#     SPSS_identify = ("spss" in fenci) or ("Spss" in fenci) or ("SPSS" in fenci)#1
#     Excel_identify = ("excel" in fenci) or ("EXCEL" in fenci) or ("Excel" in fenci)#1
#     Python_identify = ("Python" in fenci) or ("python" in fenci) or ("PYTHON" in fenci)
#     MATLAB_identify = ("matlab" in fenci) or ("Matlab" in fenci) or ("MATLAB" in fenci)
#     Java_identify = ("java" in fenci) or ("JAVA" in fenci) or ("Java" in fenci)
#     SQL_identify = ("SQL" in fenci) or ("Sql" in fenci) or ("sql" in fenci)
#     SAS_identify = ("SAS" in fenci) or ("Sas" in fenci) or ("sas" in fenci)
#     Tableau_identify = ("Tableau" in fenci) or ("tableau" in fenci) or ("TABLEAU" in fenci)
#     BI_identify = ("BI" in fenci) or ("bi" in fenci) or ("Bi" in fenci)
#     Spark_identify = ("Spark" in fenci) or ("SPARK" in fenci) or ("spark" in fenci)
#     Hadoop_identify = ("HADOOP" in fenci) or ("Hadoop" in fenci) or ("hadoop" in fenci)
#     if R_identify:
#         software.at[j, 'R'] = 1
#     if SPSS_identify:
#         software.at[j, 'SPSS'] = 1
#     if Excel_identify:
#         software.at[j, 'Excel'] = 1
#     if Python_identify:
#         software.at[j, 'Python'] = 1
#     if MATLAB_identify:
#         software.at[j, 'MATLAB'] = 1
#     if Java_identify:
#         software.at[j, 'Java'] = 1
#     if SQL_identify:
#         software.at[j, 'SQL'] = 1
#     if SAS_identify:
#         software.at[j, 'SAS'] = 1
#     if Tableau_identify:
#         software.at[j, 'Tableau'] = 1
#     if BI_identify:
#         software.at[j, 'BI'] = 1
#     if Spark_identify:
#         software.at[j, 'Spark'] = 1
#     if Hadoop_identify:
#         software.at[j, 'Hadoop'] = 1


# for j in range(len(job['描述'])):
#     subdata = str(job['描述'][j])
#     print(subdata)
#     fenci = mixseg.lcut(subdata)
#     R_identify = ("R" in fenci) or ("r" in fenci)
#     SPSS_identify = ("spss" in fenci) or ("Spss" in fenci) or ("SPSS" in fenci)
#     Excel_identify = ("excel" in fenci) or ("EXCEL" in fenci) or ("Excel" in fenci)
#     Python_identify = ("Python" in fenci) or ("python" in fenci) or ("PYTHON" in fenci)
#     MATLAB_identify = ("matlab" in fenci) or ("Matlab" in fenci) or ("MATLAB" in fenci)
#     Java_identify = ("java" in fenci) or ("JAVA" in fenci) or ("Java" in fenci)
#     SQL_identify = ("SQL" in fenci) or ("Sql" in fenci) or ("sql" in fenci)
#     SAS_identify = ("SAS" in fenci) or ("Sas" in fenci) or ("sas" in fenci)
#     Stata_identify = ("STATA" in fenci) or ("Stata" in fenci) or ("stata" in fenci)
#     EViews_identify = ("EViews" in fenci) or ("EVIEWS" in fenci) or ("Eviews" in fenci) or ("eviews" in fenci)
#     Spark_identify = ("Spark" in fenci) or ("SPARK" in fenci) or ("spark" in fenci)
#     Hadoop_identify = ("HADOOP" in fenci) or ("Hadoop" in fenci) or ("hadoop" in fenci)
#     if R_identify:
#         software.at[j, 'R'] = 1
#     if SPSS_identify:
#         software.at[j, 'SPSS'] = 1
#     if Excel_identify:
#         software.at[j, 'Excel'] = 1
#     if Python_identify:
#         software.at[j, 'Python'] = 1
#     if MATLAB_identify:
#         software.at[j, 'MATLAB'] = 1
#     if Java_identify:
#         software.at[j, 'Java'] = 1
#     if SQL_identify:
#         software.at[j, 'SQL'] = 1
#     if SAS_identify:
#         software.at[j, 'SAS'] = 1
#     if Stata_identify:
#         software.at[j, 'Stata'] = 1
#     if EViews_identify:
#         software.at[j, 'EViews'] = 1
#     if Spark_identify:
#         software.at[j, 'Spark'] = 1
#     if Hadoop_identify:
#         software.at[j, 'Hadoop'] = 1


# software.columns = ["R", "SPSS", "Excel", "Python", "MATLAB", "Java", "SQL", "SAS", "Stata",
#                     "EViews", "Spark", "Hadoop"]
# software.columns = ["R", "SPSS", "Excel", "Python", "MATLAB", "Java", "SQL", "SAS", "Tableau",
#                     "BI", "Spark", "Hadoop"]