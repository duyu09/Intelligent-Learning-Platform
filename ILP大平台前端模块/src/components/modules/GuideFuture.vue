<script>
import { RouterLink, RouterView,createRouter,createWebHashHistory } from 'vue-router';
import JobAndSalary from "./JobAndSalary.vue";
import SkillDiff from "./SkillDiff.vue";
import { Star } from "@element-plus/icons-vue";
import 'element-plus/dist/index.css';
export default
{
    name:'GuideFuture',
    compilerOptions: 
    {
      isCustomElement: tag => tag === 'nobr'
    },
    components:
    {
      "JobAndSalary":JobAndSalary,
      "SkillDiff":SkillDiff,
      "Star":Star,
    },
    data()
    {
      var temp=0;
      if(this.$route.fullPath==='/main/GuideFuture/JobAndSalary') temp=0;
      else if(this.$route.fullPath==='/main/GuideFuture/SkillDiff') temp=1;
      return{
        GuideFuture_RadioLabel:temp,
      }
    },
    methods: 
    {

    },
};
document.title="我的未来我规划 - 基于AI与大数据分析的智能未来规划系统"
</script>
<template>
    <div class="common-layout" id="GuideFuture-common-layout">
    <el-container>
      <el-container>
        <el-header id="GuideFuture-elHeader">
            <div id="GuideFuture-elHeader-title01">
              <div id="GuideFuture-elHeader-title03">
                <nobr>我的未来我规划</nobr>
              </div>
              <div id="GuideFuture-elHeader-title02">
                <nobr>基于AI与大数据分析的智能未来规划系统</nobr><br>
                <span id="GuideFuture-elHeader-title04">
                  <nobr>Intelligent Future Planning System Based on AI and Big Data Analysis</nobr>
                </span>
              </div>
            </div>
        </el-header>
        <el-main>
          <div>
            <el-card shadow="always" style="width: 100%;box-shadow: 0 0.35rem 0.35rem 0 rgba(0,0,0,0.5);"> 
              <div id="GuideFuture-Label01">
                <!-- <div style="padding-bottom: 0.5rem;">我们采用了AI和大数据分析的技术，智能地向莘莘学子提供建议，指引未来。</div> -->
                <div style="padding-bottom: 0.2rem;"><el-icon><Star /></el-icon>选择“推荐岗位，预测薪资”项，系统可以根据您的知识与技术，以及您所在的城市，推荐适合您的工作岗位，并预测薪资。</div>
                <div style="padding-bottom: 0.35rem;"><el-icon><Star /></el-icon>选择“我和企业需求的差距”项，系统可以根据您的知识与技术，期望薪资待遇，工作城市等，推测您欠缺的知识技术，并可生成目标清单，助力您完成学习。</div>
              </div>
              <el-radio-group v-model="GuideFuture_RadioLabel">
                <el-radio :label="0"  @click="()=> this.$router.push('/main/GuideFuture/JobAndSalary')">推荐岗位，预测薪资</el-radio>
                <el-radio :label="1"  @click="()=> this.$router.push('/main/GuideFuture/SkillDiff')">我和企业需求的差距</el-radio>
              </el-radio-group>
            </el-card>
            <br>
          </div>
          <!-- <SkillDiff></SkillDiff> -->
          <!-- <JobAndSalary></JobAndSalary> -->
          <RouterView></RouterView>
        </el-main>
        <!-- <el-footer>Footer</el-footer> -->
      </el-container>
    </el-container>
  </div>
</template>
<style scoped>
@font-face 
{
  font-family: font01;
  src: url("../../assets/fonts/font01.woff");
}
@font-face
{
  font-family: ubuntu;
  src:url("../../assets/fonts/ubuntu.woff2");
}
#GuideFuture-elHeader
{
  height: 5rem;
  color: white;
  background-image:linear-gradient(to right, rgb(0, 135, 255), rgb(0, 0, 108));
  box-shadow: 0 0.35rem 0.35rem 0 rgba(0,0,0,0.5);
  border-radius: 0 0 10px 10px;
}
#GuideFuture-elHeader-title01
{
  font-family: font01,serif;
  padding-top: 0.75rem;
  padding-left: 1.5rem;
  font-size: 2.7rem;
  display: flex;
}
#GuideFuture-elHeader-title02
{
  font-size: 1.3rem;
  padding-top: 0.3rem;
  padding-left: 1.35rem;
  font-style: italic;
  color: rgb(180, 255, 255);
  text-shadow: 1px 1px black;
  flex-grow: 14;
}
#GuideFuture-elHeader-title03
{
  flex-grow: 1;
  text-shadow: 2px 2px black;
}
#GuideFuture-elHeader-title04
{
  font-size: 0.9rem;
  font-family: ubuntu,serif;
  color: rgb(100, 255, 255);
  text-shadow: 1px 1px black;
}
#GuideFuture-common-layout
{
  width:100%;
}
#GuideFuture-Label01
{
  font-size: 0.8rem;
}
@media screen and (max-width:40rem)
{
  #GuideFuture-elHeader
  {
    height: 5rem;
  }
  #GuideFuture-elHeader-title01
  {
    padding-top: 0.4rem;
    font-size: 1.85rem;
    padding-left: 0;
    display: block;
  }
  #GuideFuture-elHeader-title02
  {
    font-size: 1rem;
    padding-top: 0.2rem;
    text-align: center;
  }
  #GuideFuture-elHeader-title03
  {
    text-align: center;
  }
  #GuideFuture-elHeader-title04
  {
    display: none;
  }
}
</style>