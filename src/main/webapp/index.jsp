<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="assets/img/favicon.png">

<title>Siimple - Free Bootstrap 3 Landing Page</title>

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
</head>
<script type="text/javascript">
function init(){
   var url = location.href;
   
   var param = url.split('#')[1];
   
   if(param == "failed"){
       location = url.split('#')[0];
       alert("µÇÂ¼Ê§°Ü!");
   }     
}
</script>
<body onload="init();">
	<div id="loginModal" class="modal show">
		<form action="login" class="form col-md-12 center-block" id="login_form">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header text-center"><h3>µÇÂ¼</h3></div>
					<div class="modal-body">
						<div class="form-group">
							<input name="name" type="text" class="form-control input-lg" placeholder="ÓÃ»§Ãû">
						</div>
						<div class="form-group">
							<input name="pwd" type="password" class="form-control input-lg"	placeholder="ÃÜÂë">
						</div>
					</div>

					<div class="modal-footer">
					    <div class="form-group">
							 <!--  button class="btn btn-primary btn-lg btn-block">Ã§Â«Â‹Ã¥ÂˆÂ»Ã§Â™Â»Ã¥Â½Â•</button-->
							 <input type="submit" value="µÇÂ¼" class="btn btn-primary btn-lg btn-block"/>
							 <span><a href="signup.jsp" class="pull-right">×¢²á</a></span>
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
