<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">
	<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type=text/css rel="stylesheet">	

<link href="${pageContext.request.contextPath}/css/login.css" type=text/css rel=stylesheet>

<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<script>
// 判断是登录账号和密码是否为空
function check(){
    var usercode = $("#usercode").val();
    var password = $("#password").val();
    if(usercode=="" || password==""){
    	$("#message").text("账号或密码不能为空！");
        return false;
    }  
    return true;
}
</script>

</head>
  <body>

    <div class="container login-div">

      <form class="form-login" action="<c:url value="/login"/>" method="post" onsubmit="return check()" >
        <h2 class="form-login-heading"><span>BOOT</span>客户管理系统</h2>
        
		<!-- 提示信息--> 
		<span id="message" class="message">${msg}</span>
						
        <label for="usercode"  class="sr-only">请输入用户名</label>
        <input type="text" id="usercode" name="usercode" class="form-control" placeholder="请输入用户名" autofocus>
        <label for="password" class="sr-only">请输入密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码" >
<!--         <div class="checkbox">
          <label>
            <input type="checkbox" name="remember" value="remember"> 记住密码
          </label>
        </div> -->

        <button class="btn btn-login btn-block" type="submit">登录</button>
      </form>
	  <hr/>
<%--	  <div class="forget-pwd">--%>
<%--		<a>--%>
<%--            忘记密码？--%>
<%--         </a>--%>
<%--	  </div>--%>

    </div> <!-- /container -->


  </body>
  <footer class="footer ">
	<div class="container navbar-fixed-bottom">
      <ul class="list-inline text-center">
		<li>mvcmvcmvc</li>
		<li>&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;</li>
		<li>&copy;2019</li>

      </ul>
	</div>
  </footer>
 <script type="text/javascript">
	<%-- 防止用户后退网页--%>
	//window.history.forward()
    history.pushState(null, null, document.URL);
    window.addEventListener('popstate', function () {
    history.pushState(null, null, document.URL);
    });
</script>

 <!-- js实现的点击"message"区域外隐藏div区域 -->
<script type="text/javascript">
window.onload=function(){
    var myDiv = document.getElementById("message");
    document.addEventListener("click",function(){
        myDiv.style.display="none";
    });
    myDiv.addEventListener("click",function(event){
        event=event||window.event;
        event.stopPropagation();
    });
};
</script>

</html>
