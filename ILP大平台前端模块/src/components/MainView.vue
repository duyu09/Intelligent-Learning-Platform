<script>
import { RouterLink, RouterView } from 'vue-router';
import {HomeFilled} from "@element-plus/icons-vue";
import {Sunny} from "@element-plus/icons-vue";
import {Guide} from "@element-plus/icons-vue";
import {ChatDotSquare} from "@element-plus/icons-vue";
import {Management} from "@element-plus/icons-vue";
import {FolderOpened} from "@element-plus/icons-vue";
import {Flag} from "@element-plus/icons-vue";
import GuideFuture from './modules/GuideFuture.vue';
import Cookies from "js-cookie";
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue';

export default
{
    name: "MainView",
    components: 
    {
      "GuideFuture": GuideFuture,
      "HomeFilled":HomeFilled,
      "Sunny":Sunny,
      "Guide":Guide,
      "ChatDotSquare":ChatDotSquare,
      "Management":Management,
      "FolderOpened":FolderOpened,
      "Flag":Flag,

    },
    data()
    {
      return{
        routerIndex:'',
      }
    },
    methods: 
    {
        MainViewMenuClick:function() 
        {
            console.log(this.routerIndex)
            if(this.routerIndex=='1-1') this.$router.push('/main/GuideFuture/JobAndSalary');
            else if(this.routerIndex=='1-2') this.$router.push('/main/GuideFuture/SkillDiff');
            
        },
        setNullPersonalPage()
        {
          Cookies.set('PersonalPageAimUserId',0);
        }
    },
}
</script>
<template>
    <div class="common-layout" style="height: 100%;">
    <el-container style="height:100%;">
      <el-aside id="MainView-Aside">

<!--        <el-menu-->
<!--        class="el-menu-vertical-demo"-->
<!--        @open="handleOpen"-->
<!--        @close="handleClose"-->
<!--        style="background-color: transparent;"-->
<!--        v-model="routerIndex"-->
<!--        >-->
<!--        <el-sub-menu index="1">-->
<!--          <template #title>-->
<!--            <span>我的未来我规划</span>-->
<!--          </template>-->
<!--          <el-menu-item-group>-->
<!--            <el-menu-item index="1-1" style="font-size: smaller;" @click="MainViewMenuClick()"><span>推荐岗位，预测薪资</span></el-menu-item>-->
<!--            <el-menu-item index="1-2" style="font-size: smaller;" @click="MainViewMenuClick()"><span>我和企业需求的差距</span></el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--        </el-sub-menu>-->
<!--        <el-menu-item index="2">-->
<!--          <span>Navigator Two</span>-->
<!--        </el-menu-item>-->
<!--        <el-menu-item index="4">-->
<!--          <span>Navigator Four</span>-->
<!--        </el-menu-item>-->
<!--      </el-menu>-->
        <div style="margin-top: 1.5rem;">
          <div class="MainView-MenuItem" @click="() => { setNullPersonalPage();this.$router.push('/main/PersonalPage');}">
            <el-icon><HomeFilled /></el-icon>
            我的主页
          </div>
          <div class="MainView-MenuItem" @click="() => this.$router.push('/main/GuideFuture/JobAndSalary')">
            <el-icon><Guide /></el-icon>
            我的未来
          </div>
          <div class="MainView-MenuItem" @click="() => this.$router.push('/main/PsyChat')">
            <el-icon><Sunny /></el-icon>
            小智同学
          </div>
          <div class="MainView-MenuItem" @click="() => this.$router.push('/main/Forum')">
            <el-icon><ChatDotSquare /></el-icon>
            论坛社团
          </div>
          <div class="MainView-MenuItem" @click="() => this.$router.push('/main/StartStudy')">
            <el-icon><Management /></el-icon>
            云上自习
          </div>
          <div class="MainView-MenuItem" @click="() => this.$router.push('/main/AimList')">
            <el-icon><Flag /></el-icon>
            我的目标
          </div>
          <div class="MainView-MenuItem" @click="() => this.$router.push('/main/Resources')">
            <el-icon><FolderOpened /></el-icon>
            资源天地
          </div>
        </div>



        
      </el-aside>
      <RouterView></RouterView>
    </el-container>
  </div>
</template>
<style>
@font-face
{
  src:url("../assets/fonts/HPHS.woff");
  font-family: HPHS;
}
#MainView-Aside
{
  color: white;
    /*background-color: rgb(221, 221, 223);*/
    width: 10rem;
    box-shadow: 0 0.9rem 0.9rem 0 rgba(0,0,0,0.6);
    /*background-image: url('../assets/images/05.jpg');*/
    background-color: #1b1e26;
    background-attachment: fixed;
    background-repeat: no-repeat;
    background-size: auto 100%;
}
.MainView-MenuItem
{
  text-align: center;
  padding-top: 1.25rem;
  padding-bottom: 1.25rem;
  font-family: HPHS, serif;
  font-size: 1.15rem;
}
.MainView-MenuItem:hover
{
  background-color: dimgrey;
  cursor: pointer;
}
.MainView-MenuItem:active
{
  background-color: #5a5a5a;
}
@media screen and (max-width:40rem)
{
    #MainView-Aside
    {
        display: none;
    }
}
</style>