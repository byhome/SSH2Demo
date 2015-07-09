<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="assets/img/favicon.png">

<title>Siimple - SignUp</title>

<!-- Bootstrap -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/bootstrap-theme.css" rel="stylesheet">

<!-- siimple style -->
<link href="assets/css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
function init(){
   var url = location.href;
   
   var param = url.split('#')[1];
   
   if(param == "success"){
       location = "index.jsp";
       alert("注册成功!");
   } else if(param == "failed") {
       location = url.split('#')[0];
       alert("注册失败!");
   }     
}
</script>
</head>

<body onload="init();">
	<div id="loginModal" class="modal show">
		<form action="signup" class="form col-md-12 center-block" id="login_form">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header text-center"><h3>注册</h3></div>
					<div class="modal-body">
						<div class="form-group">
							<input name="name" type="text" class="form-control input-lg" placeholder="用户名">
						</div>
						<div class="form-group">
							<input name="pwd" type="passwd" class="form-control input-lg"	placeholder="密码">
						</div>
					</div>

					<div class="modal-footer">
					    <div class="form-group">
							 <input type="submit" value="注册" class="btn btn-primary btn-lg btn-block"/>
						     <span><a href="index.jsp" class="pull-right">登录</a></span>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
