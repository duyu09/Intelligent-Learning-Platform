<p align="center">
  <br>
  <img src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/376cd821-b318-49af-ac63-fb93b645f5fb" style="width:25%;">
</p>
<br>

# Intelligent Learning Platform Based on LLM and Regression Analysis Algorithms

### Language of this document

[简体中文](https://github.com/duyu09/Intelligent-Learning-Platform/blob/main/README.md) | [English](https://github.com/duyu09/Intelligent-Learning-Platform/blob/main/README_en.md)

### Project Name

- System Project Name: Intelligent Learning Platform Based on LLM & Regression Analysis Algorithms. (Abbreviation: _ILP_)

### Project Introduction

&nbsp;&nbsp;&nbsp;&nbsp;In recent years, the widespread phenomenon of confusion among college students in China has been a topic of societal concern. While these issues have persisted, neither parents, teachers, nor students have been able to effectively address them. Moreover, there are very few software products related to this issue in China, and this gap is yet to be filled by software developers. Therefore, we decided to directly face the “confusion” and, taking advantage of the 16th China Collegiate Computing Competition in 2023, develop a multi-functional, one-stop software system aimed at solving the confusion problem faced by college students, contributing our efforts to this challenge.

&nbsp;&nbsp;&nbsp;&nbsp;Why are college students confused? To gain a clear understanding, we surveyed our peers and students from nearby universities, identifying the root causes of their confusion. Based on these causes, we developed the “My Youth is Not Confused - Intelligent Learning Platform” software system, designed to provide college students with one-stop services, meeting their needs in various aspects and helping them achieve personal growth and future planning. The development of this project aims to eliminate the confusion of college students, satisfy their demands for personalized learning, communication, and resource sharing, reduce their learning burdens, and significantly enhance their learning experience.

&nbsp;&nbsp;&nbsp;&nbsp;Another important cause of college students’ confusion is the uncertainty about their future. With a long path ahead but no clear direction, they don’t know which way to go. To address this, the system will precisely analyze each student. Whether aiming for employment or postgraduate exams, the platform will assess the student's current knowledge and skills, compare them with industry standards, and help them develop a goal list that outlines a series of objectives, offering some advice for their career path.

&nbsp;&nbsp;&nbsp;&nbsp;The software system includes seven major modules: “My Future” (Salary Prediction and Skill Gap Analysis based on Regression Analysis), “Friend Xiao Zhi” (an intelligent Q&A and psychological counseling chatbot based on the ChatGLM-6B large language model), “Club Forum” (where students can freely create forums, share opinions, exchange ideas, discuss techniques, and understand college life), “Resource Center” (where students can share study resources), “Cloud Study Room” (where students can study and also relax with music), “Goal List,” and personal profiles.

### User Requirements

- Supported browsers: Chrome, Microsoft Edge, FireFox, Safari, and other mainstream browsers; works on both PC desktop and mobile devices.

- Client deployment URL: http://alpha.ilp.technology (Link expired after the competition)

- Admin system deployment URL: http://admin.ilp.technology (Link expired after the competition)

### Project Directory Structure

- *ILP大平台前端模块*: Related code for the system's frontend

- *ILP大平台后端Java模块*: Related Java backend code for the system

- *ILP大平台后端AI模块*: Code related to the AI module (large language model and salary prediction)

- *ILP大平台后台管理系统*: Frontend and Java backend code for the admin system

### Developer Environment Requirements

&nbsp;&nbsp;&nbsp;&nbsp;All development work by our team members was conducted in a Windows environment. The IDEs used include JetBrains IDEA, WebStorm, Visual Studio Code, and others. The specific requirements for the development environment can be found in the README.md files in each subdirectory.

### System Architecture and Deployment Methods

&nbsp;&nbsp;&nbsp;&nbsp;During the competition, the system adopted a three-end interconnected dual-end deployment architecture, with the Java backend, database, and SSR frontend running on a CPU cloud server, while the ChatGLM-6B large language model and salary prediction model were deployed on the National Supercomputing Center in Jinan's high-performance computing cluster.

Please refer to the README.md files in each module subdirectory for detailed information about the development and production environment requirements.

### System Architecture Diagram (Please zoom in to view)

<img alt="0001" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/09eddf2e-cd1d-4484-b1a8-65acc708abdb" style="width:31%;">

<img alt="0002" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/830b901e-d148-486b-8938-103de46c389c" style="width:31%;">

<img alt="0003" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/6239dd60-4764-4102-8396-3ca784863a0c" style="width:31%;">

### Frontend Screenshots of the System (Please zoom in to view)

&nbsp;&nbsp;&nbsp;&nbsp;The following are screenshots of the ILP platform’s frontend interface, including login, homepage, "My Future" salary prediction system, Xiao Zhi chatbot, resource sharing platform, and cloud study room modules. Due to repository size limits and time constraints, not all module interfaces are shown.

<img alt="0004" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/c5af57cd-f877-40af-a4c2-acfd703ee0fc" style="width:31%;">

<img alt="0005" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/56daa734-4c81-4812-a315-ce6bcff3cfdc" style="width:31%;">

<img alt="0006" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/a799f2d1-c485-4317-9404-4d68453c8eb8" style="width:31%;">

<img alt="0007" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/594cd8ac-b410-472b-bd69-65940b5fe7e9" style="width:31%;">

<img alt="0008" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/25b9aea7-a774-4f29-a717-f657a623d6d2" style="width:31%;">

<img alt="0009" src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/80cc653a-a10f-451e-860b-c5487a8b72ea" style="width:31%;">

### Developer and Copyright Statement

&copy; 2023 *Intelligent Learning Platform Based on LLM and Regression Analysis Algorithms* Project Research and Development Team.

(Called: Intelligent Learning Platform Project Development Team in other documents)

_Copyright &copy; 2023 Intelligent Learning Platform Developer Team._

- Team Members (3 members):

  - Yu DU (No.202103180009), Faculty of Computer Science and Technology, QLU(SDAS).
  
  - Qinglong LI (No.202103180027), Faculty of Computer Science and Technology, QLU(SDAS).
  
  - Hongtai YUAN (No.202101020029), Faculty of Computer Science and Technology, QLU(SDAS).

- Supervisors:

  - Ruixiang JIA, Department of Software Engineering, QLU(SDAS).
  
  - Di WANG, National Supercomputing Center in Jinan, Shandong Computer Science Center.

The ILP software system follows the <b><i>GNU AGPL v3.0</i></b> open-source license. Users of the software code should read the following statement:

*The following translation is for reference only. The final version is in Chinese.*

- __*This project participated in the 16th Chinese Collegiate Computing Competition (CCCC, 4C) in 2023.*__

- __*Any individual or organization must comply with the AGPL-v3.0 license: it prohibits closed-source commercial use or participation in any form of competition with closed-source components. Those using any part of the code are required to display the copyright notice in development documentation, distribution, and reference the location of code resources. Violations will result in penalties and legal proceedings.*__

- __*By cloning or obtaining any portion of the source code, you acknowledge and fully understand the AGPL-v3.0 license terms.*__

------

### ILP Software System Explanation and Demo Video

https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/959649da-8741-4d1a-946c-1e94b5d67d45

------

### Special Thanks

<b>Qilu University of Technology (Shandong Academy of Sciences).</b>

<img src="https://user-images.githubusercontent.com/92843163/229986960-05c91bf5-e08e-4bd3-89a4-deee3d2dbc6d.svg" style="width:55%;border-radius:20px;">

<b>Faculty of Computer Science and Technology, Shandong Provincial Computer Center (National Supercomputing Center in Jinan).</b>

<img src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/3a31a937-804f-4230-9585-b437430ac950" style="width:55%;border-radius:20px;">
<br><br>

<b>Qilu University of Technology Developer Association (Shandong Academy of Sciences).</b>

<img src="https://github.com/duyu09/Intelligent-Learning-Platform/assets/92843163/7a554ca6-49b8-4099-b214-4c4ceff7c9a3" style="width:55%;border-radius:20px;">

### Links

- Qilu University of Technology (Shandong Academy of Sciences) [https://www.qlu.edu.cn/](https://www.qlu.edu.cn/)
  
- Shandong Provincial Computer Center (National Supercomputing Center in Jinan) [https://www.nsccjn.cn/](https://www.nsccjn.cn/)

- Faculty of Computer Science and Technology, Qilu University of Technology [http://jsxb.scsc.cn/](http://jsxb.scsc.cn/)

- DuYu’s GitHub Account [https://github.com/duyu09/](https://github.com/duyu09/)

### Visitor Statistics

<div><b>Number of Total Visits (All of Duyu09's GitHub Projects): </b><br><img src="https://profile-counter.glitch.me/duyu09/count.svg" /></div> 

<div><b>Number of Total Visits (Intelligent Learning Platform <i><b>ILP</b></i>): </b><br><img src="https://profile-counter.glitch.me/duyu09-ILP/count.svg" /></div> 
