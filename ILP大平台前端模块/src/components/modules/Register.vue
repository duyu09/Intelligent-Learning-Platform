<script>
import "../../../public/css/bootstrap.min.css";
import "../../../public/js/bootstrap.bundle.min.js";
import "../../../public/js/register.js";
import {errHandle, msgHandle} from "../../utils/tools";
import {setUserInformation} from "../../api/api";
export default
{
  name: "Register",
  data()
  {
    return{
      userName:'',
      userNickname:'',
      userSex:0,
      userSchool:'',
      userMajor:'',
      userSelfIntroduction:'',
      userPassword:'',
      userPassword02:'',
      userAvatar:'',
      userRegisterTime:0
    }
  },
  methods:
      {
        writeImgData()
        {
          const fileBox=this.$refs.imgSelect;
          const Img = fileBox.files[0];
          const reader = new FileReader();
          reader.onload = () => {
            const fileContent = reader.result; // 获取文件内容
            if(fileContent.length>40000000)
            {
              errHandle("您选择的图片太大，无法处理。");
              fileBox.files[0]=null;
              return;
            }
            this.userAvatar=fileContent;


            // 在这里调用修改信息接口
            };
            try {
              reader.readAsDataURL(Img);
            }
            catch (e) {
              errHandle('读取头像文件失败。');
            }
        },
        RegFunction()
        {
          if(this.userName===''||this.userName==null)
          {
            errHandle("您必须设置姓名");
            return;
          }
          if(this.userSex==null)
          {
            errHandle("您必须设置性别");
            return;
          }
          if(this.userNickname===''||this.userNickname==null)
          {
            errHandle("您必须设置昵称");
            return;
          }
          if(this.userSchool===''||this.userSchool==null)
          {
            errHandle("您必须设置学校");
            return;
          }
          if(this.userMajor===''||this.userMajor==null)
          {
            errHandle("您必须设置专业");
            return;
          }
          if(this.userAvatar==='')
          {
            errHandle('您需要设置头像');
            return;
          }
          if(this.userPassword===''||this.userPassword==null)
          {
            errHandle('您必须设置密码。');
            return;
          }
          if(this.userPassword!==this.userPassword02)
          {
            errHandle('您两次输入的密码不一致。');
            return;
          }
          setUserInformation(this.userName,this.userNickname,this.userSex,this.userSchool,this.userMajor,this.userSelfIntroduction,this.userPassword,this.userAvatar)
              .then(res=>{
                if(res.data.code===0)
                {
                  msgHandle('注册成功').then(()=>{
                    msgHandle('您的ILP大平台账号为：'+res.data.userId+" ，请您牢记！");
                  });

                }
                else
                {
                  msgHandle('注册失败，请更改您的昵称。');
                }
              })
              .catch(res=>{
                msgHandle('注册失败：'+res);
              });
        }
      },
  mounted()
  {

  }
}
</script>

<template>
<div id="Register-MainDiv">
  <div class="container">
    <main>
      <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="../../assets/images/logo.svg" alt="" width="550" height="120" id="logoImg">
        <h2><nobr><span style="font-family: penxingshu,serif;font-size: larger; font-weight: bolder;">我的青春不迷茫&nbsp;<wbr>智能学习大平台</span></nobr><wbr><nobr>&nbsp;注册个人账号</nobr></h2>
        <p class="lead" style="font-family: font01,serif;font-weight: lighter;">
          大平台AI新科技 助力每一位学生的成长 你的大学生涯 从此不再迷茫！
        </p>
      </div>

      <div class="row g-5">
        <div class="col-md-7 col-lg-8">
          <h4 class="mb-3">基本信息填写</h4>
          <form class="needs-validation" novalidate>
            <div class="row g-3">
              <div class="col-sm-6">
                <label for="Name" class="form-label">您的姓名</label>
                <input type="text" class="form-control" id="Name" placeholder="" required v-model="userName">
                <div class="invalid-feedback">
                  您的姓名是必填项
                </div>

                <label for="NickName" class="form-label">您的昵称</label>
                <input type="text" class="form-control" id="NickName" placeholder="" required v-model="userNickname">
                <div class="invalid-feedback">
                  您的昵称是必填项
                </div>
              </div>

              <div class="col-md-4">
                <label for="Sex" class="form-label">您的性别</label>
                <select class="form-select" id="Sex" required v-model="userSex">
                  <option :value=0>男</option>
                  <option :value=1>女</option>
                </select>
                <div class="invalid-feedback">
                  您的性别是必填项
                </div>
              </div>

<!--              <div class="col-12">-->
<!--                <label for="username" class="form-label">您的手机号码</label>-->
<!--                <div class="input-group has-validation">-->
<!--                  <span class="input-group-text">Phone Number</span>-->
<!--                  <input type="text" class="form-control" id="username" placeholder="" required>-->
<!--                  <div class="invalid-feedback">-->
<!--                    您的手机号码是必填项-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->

              <div class="col-12">
                <label for="School" class="form-label">您的学校名称</label>
                <input type="text" class="form-control" id="School" placeholder="" required v-model="userSchool">
                <div class="invalid-feedback">
                  您的学校名称是必填项
                </div>
              </div>

              <div class="col-12">
                <label for="Major" class="form-label">您的专业全称</label>
                <input type="text" class="form-control" id="Major" placeholder="" required v-model="userMajor">
                <div class="invalid-feedback">
                  您的专业全称是必填项
                </div>
              </div>

              <div class="col-12">
                <label for="si" class="form-label">自我介绍<span class="text-muted">(选填项目)</span></label>
                <div class="input-group">
                  <span class="input-group-text">Self<br>Introduction</span>
                  <textarea class="form-control" aria-label="Self Introduction" id="si" v-model="userSelfIntroduction"></textarea>
                </div>
              </div>
            </div>
            <br>
            <div>
              <label for="imgSelect" class="form-label">头像设置</label><br>
              <input type="file" class="dsc-input" id="imgSelect" @change="writeImgData()" ref="imgSelect">
            </div>

            <hr class="my-4">

            <h4 class="mb-3">密码设定</h4>


            <div class="col-12">
              <label for="password01" class="form-label">密码设定</label>
              <input type="password" class="form-control" id="password01" placeholder="Input Your Password" required v-model="userPassword">
              <div class="invalid-feedback">
                您必须设定密码
              </div>
              <br>

              <label for="password02" class="form-label">确认密码</label>
              <input type="password" class="form-control" id="password02" placeholder="Confirm Your Password" required v-model="userPassword02">
              <div class="invalid-feedback">
                您必须核实密码
              </div>
            </div>

            <hr class="my-4">

            <h4 class="mb-3">用户承诺</h4>

            <div class="form-check">
              <input type="checkbox" class="form-check-input" id="checkXY" required checked>
              <label class="form-check-label" for="checkXY">
                您已充分阅读《注册须知》全文，并充分理解及同意其中的全部内容。
              </label>
            </div>

            <hr class="my-4">

          </form>
          <button class="w-100 btn btn-primary btn-lg" @click="RegFunction()">注册账号</button>
        </div>
      </div>
    </main>
    <footer class="my-5 pt-5 text-muted text-center text-small" style="padding-bottom: 2rem;">
      <p class="mb-1">&copy; 2023 ILP Developer Team.</p>
    </footer>
  </div>
</div>
</template>

<style scoped>
.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}

@media (min-width: 768px)
{
  .bd-placeholder-img-lg
  {
    font-size: 3.5rem;
  }

}
@media (max-width: 768px) {
  #logoImg
  {
    width: 330px;
  }
}

.b-example-divider {
  height: 3rem;
  background-color: rgba(0, 0, 0, .1);
  border: solid rgba(0, 0, 0, .15);
  border-width: 1px 0;
  box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
}

.b-example-vr {
  flex-shrink: 0;
  width: 1.5rem;
  height: 100vh;
}

.bi {
  vertical-align: -.125em;
  fill: currentColor;
}

.nav-scroller {
  position: relative;
  z-index: 2;
  height: 2.75rem;
  overflow-y: hidden;
}

.nav-scroller .nav {
  display: flex;
  flex-wrap: nowrap;
  padding-bottom: 1rem;
  margin-top: -1px;
  overflow-x: auto;
  text-align: center;
  white-space: nowrap;
  -webkit-overflow-scrolling: touch;
}

@font-face {
  font-family: penxingshu;
  src: url('../src/assets/fonts/penxingshu.woff');
}
@font-face {
  font-family: font01;
  src: url('../src/assets/fonts/font01.woff2');
}
@font-face {
  font-family: ubuntu;
  src: url('../src/assets/fonts/ubuntu.woff2');
}
@font-face {
  font-family: HPHS;
  src: url('../src/assets/fonts/HPHS.woff');
}

.container
{
  max-width: 960px;
}

#Register-MainDiv
{
  font-family: ubuntu,'HPHS',serif;
  background-color: rgb(248,248,248);
}
</style>