<script>
import { RouterLink, RouterView } from 'vue-router';
import {errHandle, msgHandle, successHandle} from "../../utils/tools";
import {
  getAvatar,
  getUserInformation,
  readStudyStatus,
  setAvatar,
  updataInformation
} from "../../api/api";
import Cookies from "js-cookie";


export default
{
    name: "PersonalPage",
    data()
    {
        return{
           userId:0,
           aimUserId:0,
           AvatarData:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
           Password:'',
           Name:'正在加载...',
           Sex:'男',
           NickName:'正在加载...',
           School:'正在加载...',
           Major:'正在加载...',
           SelfIntroduction:'正在加载...',
           StudyStatus:'正在加载.....',
           changeInfoFormVisible:false,
           loading:true,
           InfoForm:{
            Name: '',
            Sex:1, //0=男，1=女
            NickName:'',
            School: '',
            Major: '',
            SelfIntroduction:'',
            ImgData: '',
          }
        }
    },
  methods:
      {
        openInfoForm()
        {
          if(this.Sex==='男')
          {
            this.InfoForm.Sex=0;
          }
          else
          {
            this.InfoForm.Sex=1;
          }
          this.InfoForm.Name=this.Name;
          this.InfoForm.NickName=this.NickName;
          this.InfoForm.School=this.School;
          this.InfoForm.Major=this.Major;
          this.InfoForm.SelfIntroduction=this.SelfIntroduction;
          this.InfoForm.ImgData=this.AvatarData;
        },
        changeInfo()
        {
          if(this.InfoForm.Name==''||this.InfoForm.Name==null)
          {
            errHandle("您必须设置姓名");
            return;
          }
          if(this.InfoForm.Sex==null)
          {
            errHandle("您必须设置性别");
            return;
          }
          if(this.InfoForm.NickName==''||this.InfoForm.NickName==null)
          {
            errHandle("您必须设置昵称");
            return;
          }
          if(this.InfoForm.School==''||this.InfoForm.School==null)
          {
            errHandle("您必须设置学校");
            return;
          }
          if(this.InfoForm.Major==''||this.InfoForm.Major==null)
          {
            errHandle("您必须设置专业");
            return;
          }
          updataInformation(this.aimUserId,
              this.InfoForm.Name,
              this.InfoForm.NickName,
              this.InfoForm.Sex,
              this.InfoForm.School,
              this.InfoForm.Major,
              this.InfoForm.SelfIntroduction,
              this.Password)
              .then(res=>{
                console.log(this.aimUserId);
                msgHandle('成功执行修改操作');
                return;
              }).catch(res=>{
            errHandle('修改失败：'+res);
          });


          const fileBox=this.$refs.fileBox;
          const Img = fileBox.files[0];
          const reader = new FileReader();
          if(Img===undefined||Img===null)
          {
            successHandle('已执行修改操作。');
            return;
          }
          else
          {
            reader.readAsDataURL(Img);
          }
          reader.onload = () => {
            const fileContent = reader.result; // 获取文件内容
            console.log(fileContent);
            if(fileContent.length>40000000)
            {
              errHandle("您选择的图片太大，无法处理。");
              return;
            }
            this.InfoForm.ImgData=fileContent;
            this.AvatarData=fileContent;
            setAvatar(this.aimUserId,this.AvatarData);
            successHandle('已执行修改操作。');
            return;
          };

        },
        LogOut()
        {
          Cookies.remove('userId');
          Cookies.remove('token');
          this.$router.push('/Login');
        }
      },
  mounted()
  {
    this.userId=Cookies.get('userId');
    let aimUserId=Cookies.get('PersonalPageAimUserId');
    this.aimUserId=aimUserId;
    if(this.aimUserId===undefined||this.aimUserId==='0'||this.aimUserId===null)
    {
      this.aimUserId = this.userId;
    }
    console.log(this.aimUserId);

      getAvatar(this.userId,this.aimUserId).then(res=>{
        this.AvatarData=res.data.imgData;
      });
      // readStudyStatus(this.aimUserId,"0").then(res=>{
      //   const q=res.data.result;
      //   if(q===1)
      //   {
      //     this.StudyStatus="正在自习"
      //   }
      //   else
      //   {
      //     this.StudyStatus="未自习"
      //   }
      // })
      const selfStudy = Cookies.get('studyStatus');
      if(selfStudy==='true'||selfStudy===true)
      {
        this.StudyStatus="正在自习";
      }
      else
      {
        this.StudyStatus='未自习';
      }

    getUserInformation(this.userId,this.aimUserId).then(res=>{
      //console.log("======="+aimUserId);
      if(res.data.code!==0)
      {
        errHandle('警告：读取用户基本信息错误。');
      }
      else
      {
        this.Name=res.data.data.userName;
        if(res.data.data.userSex===0)
        {
          this.Sex='男'
        }
        else
        {
          this.Sex='女'
        }
        this.NickName=res.data.data.userNickName;
        this.Password=res.data.data.userPassword;
        this.School=res.data.data.userSchool;
        this.Major=res.data.data.userMajor;
        this.SelfIntroduction=res.data.data.userSelfIntroduction;
      }
      this.loading=false;
    });
  }
}
</script>
<template>
    <div id="PersonalPage-MainDiv">
        <div id="PersonalPage-Div01">
            <div id="PersonalPage-Div02">
                <img id="PersonalPage-Image01" :src="AvatarData">
            </div>
            <div id="PersonalPage-Div03">
                <el-card shadow="always" id="PersonalPage-Card01"> {{ NickName }}的小名片 </el-card>
            </div>
        </div>
        <div id="PersonalPage-Div04">
<!--          <el-table :data="tableData" stripe id="PersonalPage-Table01">-->
<!--          <el-table-column prop="key_t"  align="center" />-->
<!--          <el-table-column prop="data_t" align="center" />-->
<!--          </el-table>-->
          <el-card style="font-size: 1rem;border-radius: 15px;"  v-loading="loading" element-loading-text="加载中..." element-loading-background="rgba(0, 0, 0, 0.2)">
            <template #header>
              <div class="card-header">
                <span>个人信息</span>&nbsp;&nbsp;
                <el-button type="primary" plain @click="changeInfoFormVisible = true" v-if="this.userId===this.aimUserId">
                  修改信息
                </el-button>
              </div>
            </template>
            <div class="PersonalPage-TableItem">
              <div style="flex-grow: 1;font-weight: bolder;">您的姓名</div>
              <div style="flex-grow: 1;width: 50%;text-align: left;">{{Name}}</div>
            </div>
            <div class="PersonalPage-TableItem">
              <div style="flex-grow: 1;font-weight: bolder;">您的性别</div>
              <div style="flex-grow: 1;width: 50%;text-align: left;">{{Sex}}</div>
            </div>
            <div class="PersonalPage-TableItem">
              <div style="flex-grow: 1;font-weight: bolder;">您的昵称</div>
              <div style="flex-grow: 1;width: 50%;text-align: left;">{{NickName}}</div>
            </div>
            <div class="PersonalPage-TableItem">
              <div style="flex-grow: 1;font-weight: bolder;">就读高校</div>
              <div style="flex-grow: 1;width: 50%;text-align: left;">{{School}}</div>
            </div>
            <div class="PersonalPage-TableItem">
              <div style="flex-grow: 1;font-weight: bolder;">就读专业</div>
              <div style="flex-grow: 1;width: 50%;text-align: left;">{{Major}}</div>
            </div>
            <div class="PersonalPage-TableItem">
              <div style="flex-grow: 1;font-weight: bolder;">自我介绍</div>
              <div style="flex-grow: 1;width: 50%;text-align: left;">{{SelfIntroduction}}</div>
            </div>
            <div class="PersonalPage-TableItem">
              <div style="flex-grow: 1;font-weight: bolder;">自习状态</div>
              <div style="flex-grow: 1;width: 50%;text-align: left;">{{StudyStatus}}</div>
            </div>

          </el-card>

          <div id="PersonalPage-Div05">
            <span id="PersonalPage-Span01" @click="LogOut()">退出登录</span>
          </div> <!-- 在这里添加路由 -->
        </div>



      <el-dialog v-model="changeInfoFormVisible" title="修改个人信息" @opened="openInfoForm()" style="min-width: 20rem;">
        <el-form :model="InfoForm">
          <el-form-item label="您的姓名">
            <el-input v-model="InfoForm.Name" autocomplete="off" />
          </el-form-item>
          <el-form-item label="您的性别">
            <el-radio-group v-model="InfoForm.Sex" id="PsyChat-RadioGroup">
              <el-radio-button :label="0">男</el-radio-button>
              <el-radio-button :label="1" >女</el-radio-button>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="设定昵称">
            <el-input v-model="InfoForm.NickName" autocomplete="off" />
          </el-form-item>
          <el-form-item label="就读高校">
            <el-input v-model="InfoForm.School" autocomplete="off" />
          </el-form-item>
          <el-form-item label="就读专业">
            <el-input v-model="InfoForm.Major" autocomplete="off" />
          </el-form-item>
          <el-form-item label="自我介绍">
            <el-input v-model="InfoForm.SelfIntroduction" autocomplete="off" />
          </el-form-item>
          <el-form-item label="设定头像">
            <input type="file" class="dsc-input" ref="fileBox">
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="changeInfoFormVisible = false">取消</el-button>
            <el-button type="primary" @click="changeInfo();changeInfoFormVisible = false;">确定</el-button>
          </span>
        </template>
      </el-dialog>



    </div>
</template>
<style scoped>
@font-face
{
    font-family: font01;
    src: url('../../assets/fonts/font01.woff');
}
/* @font-face 
{
    font-family: HPHS;
    src: url('../../assets/fonts/HPHS.woff');
} */
.PersonalPage-TableItem
{
  display: flex;
  padding-top: 0.4rem;
  padding-bottom: 0.4rem;
  background-color: rgba(0,0,0,0.05);
}
.PersonalPage-TableItem:nth-of-type(2n)
{
  background-color: rgba(0,0,0,0.15);
}
#PersonalPage-MainDiv
{
    width: 100%;
    text-align: center;
    background-image: url('../../assets/images/01.jpg');
    /*background-image: url("../../assets/images/temp.svg");*/
    background-size: cover;
    background-attachment: fixed;
    overflow: auto;
}
#PersonalPage-Div01
{
    display: flex;
    margin-top: 4rem;
    margin-left: 12rem;
    margin-right: 12rem;
}
#PersonalPage-Div02
{
    flex-grow: 1;
    padding: 0.4rem;
}
#PersonalPage-Image01
{
    border-radius: 4px;
    height: 4rem;
    width: 4rem;
    background-size: cover;
    box-shadow: 0 0.35rem 0.35rem 0 rgba(0,0,0,0.5);
}
#PersonalPage-Div03
{
    flex-grow: 8;
    padding: 0.4rem;
    font-size: 1.5rem;
    opacity: 0.85;
    font-family: font01;
}
#PersonalPage-Card01
{
    box-shadow: 0 0.2rem 0.2rem 0 rgba(0,0,0,0.35);
    background-image:  linear-gradient(to right, white, rgb(166, 234, 255));
    font-weight: bolder;
}
#PersonalPage-Div04
{
    margin-left: 12rem;
    margin-right: 12rem;
    font-size: larger;
    opacity: 0.785;
}
#PersonalPage-Table01
{
    border-radius: 10px;
    text-align: center;
    width: 100%;
    box-shadow: 0 0.35rem 0.35rem 0 rgba(0,0,0,0.5);
    color: black;
}
#PersonalPage-Div05
{
    text-align: right;
    font-size: smaller;
    margin-top: 0.5rem;
    margin-bottom: 0.75rem;
}
#PersonalPage-Span01
{
  color: black;
  cursor: pointer;
  font-weight: bolder;
  font-size: 1.25rem;
}

@media screen and (max-width:40rem)
{
    #PersonalPage-Div01
    {
        display: block;
        margin-left: 3rem;
        margin-right: 3rem;
    }
    #PersonalPage-Div04
    {
        margin-left: 2.25rem;
        margin-right: 2.25rem;
        margin-top: 1.5rem;
    }
    #PersonalPage-Div05
    {
        margin-bottom: 3.5rem;
    }
}
</style>