<#include "common/vars.ftl"/>
<#import "micro/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="author" content="Tomtop Inc. Dev Team">
    <meta name="description" content="Tomtop Inc.">
    <#assign title = "TPMC System" >
	<title>${title}</title>
    <link type="text/css" href="${cssPath}login/ys_header_common2.css" rel="Stylesheet">
    <link type="text/css" href="${cssPath}login/ys_login2.css" rel="Stylesheet">
    <script src="${jsPath}plugins/jquery/jquery-1.11.1.min.js?version=${version}" type="text/javascript"></script>
    <script src="${jsPath}app/login/login.js?version=${version}" type="text/javascript"></script>
        <style type="text/css">
      input:-webkit-autofill {
        -webkit-box-shadow: 0 0 0px 1000px #262333 inset !important;
        /*//关于解决输入框背景颜色*/
        -webkit-text-fill-color: rgba(255,255,255,1)!important;
        /*//关于接输入框文字颜色*/
     }
    </style>

</head>
<body id="bg">
  <header>
    <ul class="head_ul">
      <li class="lf"><img src="${imagesPath}ys_tomtop.png" alt=""></li>
      <li class="rt li_css2">0755-892115011</li>
      <li class="rt">
        <div class="lf ys_div_css"><img src="${imagesPath}ys_phone.png" alt=""></div>
        <div class="lf ys_div_css2">
          <p class="p_css">Online Service</p>
          <p class="p_css">Monday to Sunday 9:00-18:30</p>
        </div>
      </li>
    </ul>
  </header>
  <!-- body -->
  <section id="ys_box">
  <div class="ys_div" >
  	  <div class = 'map'>
        <img src="${imagesPath}login3.png" alt="">    
      </div>
      
      <div class="container_mengceng" id="container2" >      
          <img class="pa yunduo" src="${imagesPath}yunduo.png" alt="">

      </div>
      <div class="container" id="container" >
        <div class="card">
          <form id="loginForm" method="post" action="login">
          <!-- 11 -->
           <ul class="login_ul2" >
             <li class="lf login_word"><@spring.message 'login' /></li>
            </ul>
          <!-- 99 -->
            <div class="input-container" >
              <input type="text" id="uname" name="loginName" value="${loginName!''}" required="required" onblur="validName()">
              <label for="uname"><@spring.message "login.name" /></label>
              <div class="bar" id="bar_name" ></div>
              <p id="uname_tip" class="tip_com"></p>
            </div>
            <div class="input-container input_container2" >
              <input type="password" id="upass" name="password" value="${password!''}" required="required" onblur="validCodee()">
              <label for="upass"><@spring.message "password" /></label>
              <div class="bar" id="bar_pass" ></div>
              <p id="upass_tip" class="tip_com">${passError!''}</p>
            </div>
            <div class="input-container ">
              <input type="text" id="upass2"  name="kaptcha" required="required" onblur="validAuthCode()" onkeyup="valiAndlogin(event)">
              <label for="authcode"><@spring.message "auth.code" /></label>
              <div class="bar" id="authCode_bar"></div>
              <p id="upass_tip2" class="tip_com tip_com2" style="right:40%">${authCodeError!''}</p>      
              <a href="javascript:void(0)" class="yanzhma" id="yanzhenma" onclick="changeKaptcha()">
                   <img width="100" height="30" src="/kaptcha" id="kaptcha" onclick="changeKaptcha()" style="float:left" title="<@spring.message 'click.change.img' />">
              </a>       
            </div>
            <input type="hidden" id="language" name="language" value="${language!'cn'}"/>
          </form>
          <div class="center css_ml" ><a class="clear btn150_red lg_btn a_css" onclick="validateAuthcode()">Login</a></div>
        </div>
      </div>    
  </div>    
  </section>
  <!-- footer -->
  <footer class="footer_ys">  
     TPMC V1.0 <span class="footer_css"> Copyright © 2014-${copyRight} Tomtop Inc. All Rights Reserved</span>
  </footer> 
</body>
</html>