<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <title>欢迎回来！！!</title>
  
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="plugins/iCheck/square/blue.css">
  
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="hold-transition login-page">
  <div class="login-box">
  	<!-- logo开始 -->
    <div class="login-logo">
      <p>天网巡检系统</p>
    </div>
    <!-- logo结束 -->
    
    <!-- 登录表单开始 -->
    <div class="login-box-body">
      <p class="login-box-msg">欢迎登录天网巡检系统</p>
      <form action="${pageContext.request.contextPath }/UsersValidator" method="post">
         <!-- 用户名 -->
        <div class="form-group has-feedback">
          <input id = "username" type="text" name = "username" class="form-control" placeholder="邮箱">
          <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <!-- 密码 -->
        <div class="form-group has-feedback">
          <input id = "pwd" type="password" name = "userpwd" class="form-control" placeholder="密码">
          <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <!-- 记住密码复选框，登录按钮 -->
        <div class="row">
          <div class="col-xs-8">
            <div class="checkbox icheck">
              <label><input type="checkbox">&nbsp;&nbsp;记住我</label>
            </div>
          </div>
          <div class="col-xs-4">
            <button id = "sub" type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
          </div>
        </div>
      </form>
		
	  <!-- 忘记密码，新用户注册 -->
      <a href="#">忘记密码</a><br>
      <a href="./register.jsp" class="text-center">注册新用户</a>
    </div>
    <!-- 登录表单结束 -->
  </div>
  
  <!-- 链入第三方js库 -->
  <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <script src="plugins/iCheck/icheck.min.js"></script>
  <script>
    $(function ()
    {
      $('input').iCheck(
      {
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%'
      });  
    });
  </script>
</body>
</html>