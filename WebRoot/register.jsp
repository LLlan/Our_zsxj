<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" /> <!-- 针对IE8的兼容性设置 -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" />
  
  <title>欢迎新用户注册！！！</title>
  
  <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
  <link rel="stylesheet" href="./dist/css/AdminLTE.min.css" />
  <link rel="stylesheet" href="./plugins/iCheck/square/blue.css" />

  <!-- 针对IE浏览器版本低于IE9的兼容性设置 -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="hold-transition register-page">
  <div class="register-box">
    <!-- logo开始 -->
    <div class="register-logo">天网掌上巡检系统</div>
    <!-- logo结束 -->
    <div class="register-box-body">
      <p class="login-box-msg">欢迎新用户注册！！！</p>
      <!-- 注册表单开始 -->
      <form action="" method="post">
      	<!-- 邮箱账号 -->
        <div class="form-group has-feedback">
          <input type="email" class="form-control" placeholder="邮箱账号" />
          <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <!-- 密码 -->
        <div class="form-group has-feedback">
          <input type="password" class="form-control" placeholder="密码" />
          <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <!-- 确认密码 -->
        <div class="form-group has-feedback">
          <input type="password" class="form-control" placeholder="确认密码" />
          <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
        </div>
        <div class="row">
          <div class="col-xs-8">
            <div class="checkbox icheck">
              <!-- 服务条款 -->
              <label>&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox">&nbsp;&nbsp;我已阅读并同意<a href="#">服务条款</a></label>
            </div>
          </div>
          <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
          </div>
        </div>
      </form>
      <!-- 注册表单结束 -->

      <div class="social-auth-links text-center">
        <p>使用第三方账号注册</p>
        <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Facebook</a>
        <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Google+</a>
      </div>

      <a href="./login.jsp" class="text-center">已有账号</a>
    </div>
  </div>

  <!-- 链入第三方JavaScript库 -->
  <script src="./plugins/jQuery/jQuery-2.1.4.min.js"></script>
  <script src="./bootstrap/js/bootstrap.min.js"></script>
  <script src="./plugins/iCheck/icheck.min.js"></script>
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