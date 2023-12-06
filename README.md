<p align="center">
  <br>
  <img src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/376cd821-b318-49af-ac63-fb93b645f5fb" style="width:25%;">
</p>
<br>

# 我的青春不迷茫 
## 基于LLM与回归分析的大学生智能生涯指导与学习大平台

------

#### 系统名称

- 系统全称：我的青春不迷茫-基于LLM与回归分析的大学生智能生涯指导与学习大平台

- 系统简称：我的青春不迷茫 智能学习大平台

- 系统英文名称：Intelligent Learning Platform Based on LLM & Regression Analysis Algorithms. (简称：_ILP_)

#### 项目简介

&nbsp;&nbsp;&nbsp;&nbsp;近些年，国内大学生普遍存在的迷茫现象一直是社会广泛关注的问题。虽然这些问题一直存在，但不论是家长还是教师，亦或是学生，几乎没有人能够有效地解决这个问题。并且，国内与之相关的软件产品少之又少，这个空白有待软件开发者们去弥补。于是，我们决定直面“迷茫”，以本次2023年第16届中国大学生计算机设计大赛为契机，开发一款针对解决大学生迷茫问题的多功能一站式软件系统，为解决这道“难题”，贡献出我们自己力所能及的力量。

&nbsp;&nbsp;&nbsp;&nbsp;大学生为何迷茫？知己知彼才能百战不殆，我们面向我们身边的同学以及周边多所高等院校的大学生，通过调研，总结并确定了大学生迷茫的原因。我们根据这些原因，开发“我的青春不迷茫-智能学习大平台”这款软件系统，旨在为大学生提供一站式的服务，从不同方面满足大学本科生的需求，帮助他们实现自我提升和规划未来。本项目的开发初衷是为了消除大学生的迷茫，满足大学生对个性化学习、交流、资源共享等方面的需求，减轻他们的学习负担，切实提高学习体验。

&nbsp;&nbsp;&nbsp;&nbsp;大学生迷茫的另一个重要原因在于对未来不确定性的影响，路还很长却不知道怎么走。于是我们应该精准分析每一位学生，不论他们就业也好，考研也罢，软件将告诉他们目前所掌握的知识和技术相当于什么水平，并且根据他们的专业知识掌握水平和欠缺的地方帮助他们制定包含一系列目标的目标清单，为他人生的道路，提供一些建议。

&nbsp;&nbsp;&nbsp;&nbsp;我们的软件系统包括了“我的未来”（基于回归分析的薪资预测与技术差距分析），“小智同学”（基于 ChatGLM-6B 大语言模型的智能百科问答与心理疏导机器人），“社团论坛”（同学们可以自由创建论坛，发表观点，交流技术，切磋学问，了解大学生活），“资源天地”（同学们可以共享学习资源干货），“云端自习”（上自习，也可以适当放松听音乐），“目标清单”和个人主页等7大功能模块。


#### 用户运行要求

- Chrome，Microsoft Edge，FireFox，Safari等主流浏览器均可；支持PC桌面端与移动端。

- 客户端部署上线地址：http://alpha.ilp.technology (大赛结束，现已失效)

- 后台管理系统部署上线地址：http://admin.ilp.technology (大赛结束，现已失效)


#### 工程各子目录结构

- ILP大平台前端模块：系统前端的相关代码

- ILP大平台后端Java模块：系统Java后端相关代码

- ILP大平台后端AI模块：系统人工智能模块(大语言模型及薪资预测)相关代码

- ILP大平台后台管理系统：后台管理系统的前端及Java后端相关代码


#### 开发者开发环境要求

&nbsp;&nbsp;&nbsp;&nbsp;我们所有成员的所有开发工作均在Windows操作系统中进行。使用到的IDE有JetBrains IDEA,WebStorm,Visual Studio Code等。开发工作对操作系统的依赖性不大，具体开发环境的要求参见各子目录的README.md文件。

#### 系统宏观架构及各模块运行及部署方法

&nbsp;&nbsp;&nbsp;&nbsp;参赛时，系统采用三端互联双端部署的架构，其中Java后端，数据库以及SSR前端运行于CPU云服务器，ChatGLM-6B大语言模型以及薪资预测技术差距分析模型部署于国家超级计算济南中心的高性能计算集群。

请参见各个模块子目录中的README.md文件。这些文件中将详细描述工程各模块开发与生产的环境要求以及其他必要事项。

#### 系统架构示意图 (请放大查看)

<img alt="0001" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/09eddf2e-cd1d-4484-b1a8-65acc708abdb" style="width:31%;">

<img alt="0002" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/830b901e-d148-486b-8938-103de46c389c" style="width:31%;">

<img alt="0003" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/6239dd60-4764-4102-8396-3ca784863a0c" style="width:31%;">

#### 系统运行前端效果图 (请放大查看)

&nbsp;&nbsp;&nbsp;&nbsp;以下为ILP大平台系统前端界面效果图，分别节选了用户登录、主页、“我的未来”薪资预测系统、小智同学LLM机器人、资源共享平台、云自习室等模块的界面。因仓库体积限制以及时间原因，我们不再展示系统所有模块界面的运行效果。

<img alt="0004" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/c5af57cd-f877-40af-a4c2-acfd703ee0fc" style="width:31%;">

<img alt="0005" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/56daa734-4c81-4812-a315-ce6bcff3cfdc" style="width:31%;">

<img alt="0006" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/a799f2d1-c485-4317-9404-4d68453c8eb8" style="width:31%;">

<img alt="0007" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/594cd8ac-b410-472b-bd69-65940b5fe7e9" style="width:31%;">

<img alt="0008" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/25b9aea7-a774-4f29-a717-f657a623d6d2" style="width:31%;">

<img alt="0009" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/80cc653a-a10f-451e-860b-c5487a8b72ea" style="width:31%;">

#### 系统开发者及著作权声明

&copy; 2023 我的青春不迷茫-基于LLM与回归分析的大学生智能生涯指导与学习大平台 项目设计与研发小组

(在其他文件中简称：我的青春不迷茫-项目开发小组)

_Copyright &copy; 2023 Intelligent Learning Platform Developer Team._

小组成员名单(共3人)：

- 齐鲁工业大学 计算机科学与技术学部 软件工程(软件开发)21-1班 杜宇 (学号No.202103180009).

- 齐鲁工业大学 计算机科学与技术学部 软件工程(软件开发)21-1班 李庆隆 (学号No.202103180027).

- 齐鲁工业大学 计算机科学与技术学部 计算机科学与技术20-2班 袁红太 (学号No.202001020029).

指导教师(共2人)：

- 齐鲁工业大学(山东省科学院) 计算机科学与技术学部 软件工程系 贾瑞祥老师
  
- 山东省计算中心(国家超级计算济南中心) 助理研究员 王迪老师

List of Team Members:

- DU Yu (No.202103180009), Faculty of Computer Science and Technology, QLU(SDAS).

- LI Qinglong (No.202103180027), Faculty of Computer Science and Technology, QLU(SDAS).

- YUAN Hongtai (No.202101020029), Faculty of Computer Science and Technology, QLU(SDAS).

Advising Teacher:

- MR. JIA Ruixiang, Department of Software Engineering, QLU(SDAS).

- MRS. WANG Di, National Supercomputing Center in Jinan.

ILP软件系统遵守<b><i>GNU AGPL v3.0</i></b>协议开源，请各软件代码使用者阅读以下声明：

- __*该项目已参加2023年(第16届)中国大学生计算机设计大赛。*__

- __*任何组织或个人需遵守AGPL-v3.0协议：禁止闭源商用或闭源参加任何性质任何类型的比赛。使用本软件部分或全部源代码的人员需在开发文档以及作品或产品的发行版中醒目地标明本软件(ILP大平台)的著作权标识以及代码资源引用位置。如有违反上述内容的单位或个人，开发小组将告知其所参加比赛的组织委员会或高校，建议取消其成绩并判处违规侵权抄袭；情节严重的，开发小组将提起诉讼，侵权者将承担中华人民共和国各项法律法规内最大限度的民事责任；触犯中华人民共和国刑法的，开发小组将其交由中国公安机关严肃处理，并积极配合刑事调查。*__

- __*您克隆(或通过其他方式获取到)本项目部分或全部源代码时，便意味着您已知晓并充分理解以上全部内容以及AGPL-v3.0协议的全部内容。*__

以下翻译仅供参考，最终以上文中文为准。*(The following translation is for reference only, and the Chinese version above shall prevail.)*

- __*This project has participated in the 16th Chinese Collegiate Computing Competition (CCCC, 4C) in 2023.*__

- __*Any organization or individual must comply with the AGPL-v3.0 license: it prohibits closed-source commercial use or participation in any form of competition with closed-source components. Individuals using any portion or all of the source code are required to prominently display the copyright notice of this software (ILP Platform) in the development documentation, as well as in the distribution of works or products, and indicate the location of the code resources reference. In the event of any violation by an individual or entity, the development team will notify the organizing committee or university of the competition in which they participated, recommending the cancellation of their results and penalties for infringement and plagiarism. In severe cases, the development team will initiate legal proceedings, and the infringer will bear the maximum civil liability under the laws and regulations of the People's Republic of China. If the violation involves the Criminal Law of the People's Republic of China, the development team will report it to the Chinese public security authorities for serious investigation and actively cooperate with the criminal investigation.*__

- __*By cloning (or obtaining in any other way) all or part of the source code of this project, it signifies that you are aware of and fully understand all the aforementioned terms and the entire content of the AGPL-v3.0 license.*__

------

### ILP软件系统讲解与演示视频

https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/959649da-8741-4d1a-946c-1e94b5d67d45

------

### 特别感谢

<b>齐鲁工业大学 (山东省科学院).</b>

<b>Qilu University of Technology (Shandong Academy of Sciences).</b>

<img src="https://user-images.githubusercontent.com/92843163/229986960-05c91bf5-e08e-4bd3-89a4-deee3d2dbc6d.svg" style="width:55%;border-radius:20px;">

<b>计算机科学与技术学部 山东省计算中心(国家超级计算济南中心).</b>

<b>Faculty of Computer Science and Technology. National Supercomputing Center in Jinan.</b>

<img src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/3a31a937-804f-4230-9585-b437430ac950" style="width:55%;border-radius:20px;">
<br><br>

<b>齐鲁工业大学 (山东省科学院) 开发者协会.</b>

<b>Developer Association of Qilu University of Technology (Shandong Academy of Sciences).

<img src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/7a554ca6-49b8-4099-b214-4c4ceff7c9a3" style="width:55%;border-radius:20px;">

#### 友情链接

- 齐鲁工业大学(山东省科学院) https://www.qlu.edu.cn/
  
- 山东省计算中心(国家超级计算济南中心) https://www.nsccjn.cn/

- 齐鲁工业大学(山东省科学院) 计算机科学与技术学部 http://jsxb.scsc.cn/

- DuYu的个人网站 https://www.duyu09.site/

- DuYu的GitHub账号 https://github.com/duyu09/

### 访客统计

<div><b>Number of Total Visits (All of Duyu09's GitHub Projects): </b><br><img src="https://profile-counter.glitch.me/duyu09/count.svg" /></div> 

<div><b>Number of Total Visits (Intelligent Learning Platform <i><b>ILP</b></i>): </b><br><img src="https://profile-counter.glitch.me/duyu09-ILP/count.svg" /></div> 
