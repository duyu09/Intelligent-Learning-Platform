<script>
import "@/../public/js/bootstrap.bundle.min.js";
import "@/../public/js/all.js";
import "@/../public/js/page.js";
import "@/../public/css/bootstrap.min.css";
import "@/../public/css/styles.css";
import $ from "jquery"
import jQuery from "jquery";
import { loginVerification,setToken } from "../../api/api";
import {errHandle, msgHandle} from "../../utils/tools";
import Cookies from "js-cookie";

export default
{
  name: "Login",
  mounted()
  {
    // const a=parseInt(Math.random()*4)+1
    const mainBody=this.$refs.mainBody;
    // mainBody.style.backgroundImage='url(./images/0'+a+'.jpg)';
    mainBody.style.backgroundRepeat='no-repeat';
    mainBody.style.backgroundSize='cover';
    mainBody.style.backgroundImage='url(./images/03.jpg)';
    if(window.innerWidth<640)
    {
      this.$router.push('/LoginMobile');
    }
  },
  data()
  {
    return{
      userId:'',
      password:''
    }
  },
  methods:
      {
        LoginBtn()
        {
          if(this.userId===''||this.password==='')
          {
            msgHandle('请您输入账号和密码');
            return;
          }
          loginVerification(this.userId,this.password)
              .then(res=>{
                if(res.data.code===0)
                {
                  //登录成功
                  setToken(res.data.token);
                  Cookies.set('userId',this.userId);
                  this.$router.push('/main/HomePage');
                }
                else
                {
                  errHandle('警告：登录出错！');
                }
              })
              .catch(res=>{
                errHandle('警告：登录出错:'+res);
              })
        }
      }
}

$.noConflict();
jQuery(document).ready(function(){
  jQuery('.login-info-box').fadeOut();
  jQuery('.login-show').addClass('show-log-panel');
});


jQuery('.login-reg-panel input[type="radio"]').on('change', function() {
  if(jQuery('#log-login-show').is(':checked')) {
    jQuery('.register-info-box').fadeOut();
    jQuery('.login-info-box').fadeIn();

    jQuery('.white-panel').addClass('right-log');
    jQuery('.register-show').addClass('show-log-panel');
    jQuery('.login-show').removeClass('show-log-panel');

  }
  else if(jQuery('#log-reg-show').is(':checked')) {
    jQuery('.register-info-box').fadeIn();
    jQuery('.login-info-box').fadeOut();

    jQuery('.white-panel').removeClass('right-log');

    jQuery('.login-show').addClass('show-log-panel');
    jQuery('.register-show').removeClass('show-log-panel');
  }
});

</script>

<template>
<div id="mainBody" ref="mainBody">
  <div class="login-reg-panel" style="border-radius: 20px;">
    <div class="login-info-box">
      <h2><nobr>已经拥有账号?</nobr></h2>
      <p>使用你的账号登录</p>
      <label id="label-register" for="log-reg-show" style="border-width: 2px;">去登录</label>
      <input type="radio" name="active-log-panel" id="log-reg-show" checked="checked">
    </div>

    <div class="register-info-box" style="padding: 0 0 0 0;top: 16%;">
      <h3><nobr>您没有注册?</nobr></h3>
      <p style="font-family:font01,serif;font-size: larger;">
        我的青春不迷茫<br>智能学习大平台<br>AI新科技<br>助力每一位学生的成长<br>你的大学生涯<br>将不再迷茫！
      </p>
      <label id="label-login" for="log-login-show" style="border-width: 2px;" @click="this.$router.push('/Register')">注册账号</label>
      <input type="radio" name="active-log-panel" id="log-login-show">
    </div>

    <div class="white-panel" style="padding: 0 0 0 0; border-radius: 9px;">
      <div class="login-show">
        <img src="../../../public/images/logo02.svg">
        <input type="text" placeholder="User Identification" v-model="userId" style="border-radius: 10px;border-width: 2px;">
        <input type="password" placeholder="Password" v-model="password" style="border-radius: 10px;border-width: 2px;">
        <input type="button" value="登录平台" style="border-radius: 10px;border-width: 2px;" @click="LoginBtn()">
        <div>
          <div class="form-check" id="conf_check01">
            <input type="checkbox" class="form-check-input" id="conf" checked required="">
            <label class="form-check-label" for="conf">记住密码</label><br>
<!--            <a href="">忘记密码?</a>-->
          </div>
        </div>
      </div>
      <div class="register-show">
        <h2>注册账号</h2>
        <p style="font-family: font01,serif;font-size: larger;">
          我的青春不迷茫<br>智能学习大平台<br>AI新科技<br>助力每一位学生的成长<br>你的大学生涯<br>将不再迷茫！<br>
          相约大平台，收获美好大学时光!
        </p>
        <div class="form-check" id="conf_check02">
          <input type="checkbox" class="form-check-input" id="conf01" checked required>
          <label class="form-check-label" for="conf">注册前，请阅读并同意《注册须知》</label>
        </div><br>
        <input type="button" value="进入注册" style="border-radius: 10px;" onclick="gotoRegister()">
      </div>
    </div>
  </div>

  <center>
    <div>
      <div class="mobile-view">

        <div class="login-show-2">
          <br><br><br><br>
          <h2>登录平台</h2>
          <br><br><br>
          <input type="text" placeholder="User Name"  style="border-radius: 10px;border-width: 2px;">
          <br><br>
          <input type="password" placeholder="Password"  style="border-radius: 10px;border-width: 2px;">
          <br><br>
          <input type="button" value="登录平台"  style="border-radius: 10px;border-width: 2px;"><br>
          <a href=""><div class="forget">忘记密码?</div></a><br> <br>
          <div class="bottom">
            <div class="text">您没有注册? </div>
            <div class="reg"><a href="./register/index.html" style="border-width: 2px;">注册账号</a></div>
          </div>
        </div>
      </div>
    </div>
  </center>




</div>
</template>

<style scoped>
input[type="text"]:hover,input[type="password"]:hover,
input[type="text"]:active,input[type="password"]:active
{
  border-color: blue;
  border-width: 2px;
}
@font-face
{
  font-family:"font01";
  src: url('../../assets/fonts/font01.woff');
}
#mainBody
{
  animation: frame01 3s;
  height:100%;
}
@keyframes frame01
{
  from
  {
    -webkit-backdrop-filter: blur(20px);
    backdrop-filter: blur(20px);
  }
  to
  {
    -webkit-backdrop-filter: blur(0px);
    backdrop-filter: blur(0px);
  }
}
.mobile-view
{
  background-image: url("../src/assets/images/05.jpg");
}
</style>