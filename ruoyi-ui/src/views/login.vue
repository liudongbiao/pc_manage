<template>

  <div class="login">

    <div class="container">
      <div class="row">
        <div class="login-desk">
          <div class="row">
            <div class="detail-box">
              <div class="detailsh">
                <img  class="help" src="../assets/images/help.png" alt="">
                <div style="padding-bottom: 20px">
                  <h3 style="color: #4c56c0">商家中心</h3>
                  <p style="color: #4c56c0">XH Smart Tech (China) Co., Ltd.<br />
                  </p>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form">
      <img class="logoxh" src="../assets/images/profile.png" width="70px" height="70px" style="margin-left: 48px;margin-bottom: 5px;" alt="">
      <h3 class="title" >商家中心</h3>
      <el-form-item prop="username">
        <el-input
          v-model="loginForm.username"
          type="text"
          autocomplete="off"
          placeholder="账号"
        >
          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          v-model="loginForm.password"
          type="password"
          auto-complete="nato-off"
          placeholder="密码"
          @keyup.enter.native="handleLogin"
        >
          <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
      <!--      <el-form-item prop="code" v-if="captchaOnOff">-->
      <!--        <el-input-->
      <!--          v-model="loginForm.code"-->
      <!--          autocomplete="off"-->
      <!--          placeholder="验证码"-->
      <!--          style="width: 63%"-->
      <!--          @keyup.enter.native="handleLogin"-->
      <!--        >-->
      <!--          <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />-->
      <!--        </el-input>-->
      <!--        <div class="login-code">-->
      <!--          <img :src="codeUrl" @click="getCode" class="login-code-img"/>-->
      <!--        </div>-->
      <!--      </el-form-item>-->
      <!-- <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 25px 0px;color: #ffffff">记住密码</el-checkbox> -->
      <el-form-item style="width:100%;">
        <el-button
          :loading="loading"
          size="medium"
          type="primary"
          style="width:100%;"
          @click.native.prevent="handleLogin"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <div style="float: right;" v-if="register">
          <router-link class="link-type" :to="'/register'">立即注册</router-link>
        </div>
      </el-form-item>
    </el-form>
    <!--  底部  -->
    <div class="el-login-footer">
      <span>Copyright © 2024 XH Smart All Rights Reserved.</span>
    </div>
  </div>
  <!--  <div class="login">-->
  <!--    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form">-->
  <!--      <h3 class="title">澳门新通达口岸通关卡管理系统</h3>-->
  <!--      <el-form-item prop="username">-->
  <!--        <el-input-->
  <!--          v-model="loginForm.username"-->
  <!--          type="text"-->
  <!--          auto-complete="off"-->
  <!--          placeholder="账号"-->
  <!--        >-->
  <!--          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />-->
  <!--        </el-input>-->
  <!--      </el-form-item>-->
  <!--      <el-form-item prop="password">-->
  <!--        <el-input-->
  <!--          v-model="loginForm.password"-->
  <!--          type="password"-->
  <!--          auto-complete="off"-->
  <!--          placeholder="密码"-->
  <!--          @keyup.enter.native="handleLogin"-->
  <!--        >-->
  <!--          <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon" />-->
  <!--        </el-input>-->
  <!--      </el-form-item>-->
  <!--&lt;!&ndash;      <el-form-item prop="code" v-if="captchaEnabled">&ndash;&gt;-->
  <!--&lt;!&ndash;        <el-input&ndash;&gt;-->
  <!--&lt;!&ndash;          v-model="loginForm.code"&ndash;&gt;-->
  <!--&lt;!&ndash;          auto-complete="off"&ndash;&gt;-->
  <!--&lt;!&ndash;          placeholder="验证码"&ndash;&gt;-->
  <!--&lt;!&ndash;          style="width: 63%"&ndash;&gt;-->
  <!--&lt;!&ndash;          @keyup.enter.native="handleLogin"&ndash;&gt;-->
  <!--&lt;!&ndash;        >&ndash;&gt;-->
  <!--&lt;!&ndash;          <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />&ndash;&gt;-->
  <!--&lt;!&ndash;        </el-input>&ndash;&gt;-->
  <!--&lt;!&ndash;        <div class="login-code">&ndash;&gt;-->
  <!--&lt;!&ndash;          <img :src="codeUrl" @click="getCode" class="login-code-img"/>&ndash;&gt;-->
  <!--&lt;!&ndash;        </div>&ndash;&gt;-->
  <!--&lt;!&ndash;      </el-form-item>&ndash;&gt;-->
  <!--&lt;!&ndash;      <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 25px 0px;">记住密码</el-checkbox>&ndash;&gt;-->
  <!--      <el-form-item style="width:100%;">-->
  <!--        <el-button-->
  <!--          :loading="loading"-->
  <!--          size="medium"-->
  <!--          type="primary"-->
  <!--          style="width:100%;"-->
  <!--          @click.native.prevent="handleLogin"-->
  <!--        >-->
  <!--          <span v-if="!loading">登 录</span>-->
  <!--          <span v-else>登 录 中...</span>-->
  <!--        </el-button>-->
  <!--        <div style="float: right;" v-if="register">-->
  <!--          <router-link class="link-type" :to="'/register'">立即注册</router-link>-->
  <!--        </div>-->
  <!--      </el-form-item>-->
  <!--    </el-form>-->
  <!--    &lt;!&ndash;  底部  &ndash;&gt;-->
  <!--    <div class="el-login-footer">-->
  <!--&lt;!&ndash;      <span>Copyright © 2018-2022 ruoyi.vip All Rights Reserved.</span>&ndash;&gt;-->
  <!--    </div>-->
  <!--  </div>-->
</template>

<script>
  import { getCodeImg } from "@/api/login";
  import Cookies from "js-cookie";
  import { encrypt, decrypt } from '@/utils/jsencrypt'

  export default {
    name: "Login",

    data() {

      return {
        codeUrl: "",
        loginForm: {
          username: "",
          password: "",
          rememberMe: false,
          code: "",
          uuid: ""
        },
        loginRules: {
          username: [
            { required: true, trigger: "blur", message: "请输入您的账号" }
          ],
          password: [
            { required: true, trigger: "blur", message: "请输入您的密码" }
          ],
          code: [{ required: true, trigger: "change", message: "请输入验证码" }]
        },
        loading: false,
        // 验证码开关
        captchaEnabled: true,
        // 注册开关
        register: false,
        redirect: undefined
      };
    },
    watch: {
      $route: {
        handler: function(route) {
          this.redirect = route.query && route.query.redirect;
        },
        immediate: true
      }
    },
    created() {
      this.getCode();
      this.getCookie();
    },
    methods: {
      getCode() {
        getCodeImg().then(res => {
          this.captchaEnabled = res.captchaEnabled === undefined ? true : res.captchaEnabled;
          if (this.captchaEnabled) {
            this.codeUrl = "data:image/gif;base64," + res.img;
            this.loginForm.uuid = res.uuid;
          }
        });
      },
      getCookie() {
        const username = Cookies.get("username");
        const password = Cookies.get("password");
        const rememberMe = Cookies.get('rememberMe')
        this.loginForm = {
          username: username === undefined ? this.loginForm.username : username,
          password: password === undefined ? this.loginForm.password : decrypt(password),
          rememberMe: rememberMe === undefined ? false : Boolean(rememberMe)
        };
      },

      handleLogin() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            this.loading = true;
            if (this.loginForm.rememberMe) {
              Cookies.set("username", this.loginForm.username, { expires: 30 });
              Cookies.set("password", encrypt(this.loginForm.password), { expires: 30 });
              Cookies.set('rememberMe', this.loginForm.rememberMe, { expires: 30 });
            } else {
              Cookies.remove("username");
              Cookies.remove("password");
              Cookies.remove('rememberMe');
            }
            this.$store.dispatch("Login", this.loginForm).then(() => {
              this.$router.push({ path:"/" }).catch(()=>{});
            }).catch(() => {
              this.loading = false;
              if (this.captchaEnabled) {
                this.getCode();
              }
            });
          }
        });
      }
    }
  };
</script>


<style rel="stylesheet/scss" lang="scss">
  .login {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    background-image: url("../assets/images/bg3.jpg");
    background-size: cover;
  }
  .title {
    margin: 0px auto 30px auto;
    text-align: center;
    /*更改title色 lyk*/
    /*color: #707070;*/
    color: #ffffff;
  }
  /*lyk */
  /*.login-form {*/
  /*  border-radius: 6px;*/
  /*  !*更改登录框背景色 lyk*!*/
  /*  !*background: #ffffff;*!*/
  /*  background: #4c56c0;*/
  /*  width: 400px;*/
  /*  padding: 25px 25px 5px 25px;*/
  /*  .el-input {*/
  /*    height: 38px;*/
  /*    input {*/
  /*      height: 38px;*/
  /*    }*/
  /*  }*/
  /*  .input-icon {*/
  /*    height: 39px;*/
  /*    width: 14px;*/
  /*    margin-left: 2px;*/
  /*  }*/
  /*}*/

  .login-form {
    border-radius: 6px;
    /*更改登录框背景色 lyk*/
    /*background: #ffffff;*/
    /*background: #4c56c0;*/
    /* 为其整体设置接近透明的效果 lyk */
    background-color: rgba(255,255,255,0.08);
    /*background: #5c56c0;*/
    /*opacity:0.95;*/
    width: 320px;
    /*padding: 25px 25px 5px 25px;*/
    padding: 45px 25px 65px 25px;
    .el-input {
      height: 38px;
      input {
        height: 38px;
      }
    }
    .input-icon {
      height: 39px;
      width: 14px;
      margin-left: 2px;
    }
  }
  .login-tip {
    font-size: 13px;
    text-align: center;
    color: #bfbfbf;
  }
  .login-code {
    width: 33%;
    height: 38px;
    float: right;
    img {
      cursor: pointer;
      vertical-align: middle;
    }
  }
  .el-login-footer {
    height: 40px;
    line-height: 40px;
    position: fixed;
    bottom: 0;
    width: 100%;
    text-align: center;
    color: #fff;
    font-family: Arial;
    font-size: 12px;
    letter-spacing: 1px;
  }
  .login-code-img {
    height: 38px;
  }


  /*lyk add*/
  .login-desk {
    filter: drop-shadow(0 0 13.5px rgba(0, 0, 0, 0.09));
    margin-top: 5%;
    margin-bottom: 5%; }
  .login-desk .detail-box {
    background-color: #FFF;
    padding: 15px; }
  .logoxh {
    width: 130px;
    padding-left: 50px;
  }
  .login-desk .detail-box .help {
    width: 300px;
    margin-top: 30px;
    margin-bottom: 50px; }

  .login-desk .detail-box .detailsh {
    text-align: center; }



</style>
