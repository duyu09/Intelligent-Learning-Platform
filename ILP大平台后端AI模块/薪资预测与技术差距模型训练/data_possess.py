import csv

with open('数据分析岗位招聘.csv', 'r', encoding='utf-8', errors='ignore') as csvfile:
    reader = csv.reader(csvfile)
    rows = list(reader)
# 少于50人,50-500人,500-1000人,1000-5000人,5000-10000人,10000人以上
for row in rows:
    for i in range(len(row)):
        if row[i] == "少于50人":
            row[i] = 0
        elif row[i] == "50-500人":
            row[i] = 1
        elif row[i] == "500-1000人":
            row[i] = 2
        elif row[i] == "1000-5000人":
            row[i] = 3
        elif row[i] == "5000-10000人":
            row[i] = 4
        elif row[i] == "10000人以上":
            row[i] = 5
        # "无", "中专", "高中", "大专", "本科", "硕士", "博士"
        elif row[i] == "无":
            row[i] = 0
        elif row[i] == "中专":
            row[i] = 1
        elif row[i] == "高中":
            row[i] = 2
        elif row[i] == "大专":
            row[i] = 3
        elif row[i] == "本科":
            row[i] = 4
        elif row[i] == "硕士":
            row[i] = 5
        elif row[i] == "博士":
            row[i] = 6
        # "民营公司", "创业公司", "国企", "合资", "上市公司", "外资"
        elif row[i] == "民营公司":
            row[i] = 0
        elif row[i] == "创业公司":
            row[i] = 1
        elif row[i] == "国企":
            row[i] = 2
        elif row[i] == "合资":
            row[i] = 3
        elif row[i] == "上市公司":
            row[i] = 4
        elif row[i] == "外资":
            row[i] = 5
print(rows)

with open('Intermediate data.csv', 'w', encoding='utf-8', errors='ignore', newline='') as csvfile:
    writer = csv.writer(csvfile)
    writer.writerows(rows)
