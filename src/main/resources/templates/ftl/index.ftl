<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新浪有借运营后台 - 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
	<#assign base = ""> 		
    <link href="${base}/static/css/bootstrap.css" rel="stylesheet">
    <link href="${base}/static/css/font-awesome.css" rel="stylesheet">
    <link href="${base}/static/css/animate.min.css" rel="stylesheet">
    <link href="${base}/static/css/style.css" rel="stylesheet">
     <link href="${base}/static/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
    <style>
        .modal-footer {
            padding: 15px;
            text-align: center;
            border-top: 1px solid #e5e5e5;
        }
        input::-ms-clear,
        input::-ms-reveal {
            display: none; /* For ie10+ */
        }
    </style>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name"><img style="widows: 200px;height: 108px;" src="../img/logo.png"/></h1>

            </div>
            <h3>欢迎使用<span id="productname">新浪有借</span>运营后台</h3>

            <form  role="form"   id="loginForm"  >
                <div class="form-group" style="text-align: left;">
                    <input type="text" name="userName" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group" style="text-align: left;"  >
                    <input type="password" name="password" class="form-control" placeholder="密码" required="">
                </div>
    <!-- 
                <div class="form-group" style="text-align: left;"  >
                	<select class="form-control" name="productid" id="productid" onchange="changeProduct();">
		            	<option value="1001">新浪有借</option>
		            	<option value="1002">新浪有还</option>
		            </select>
                </div>
     -->

            </form>                
                <button type="button" onclick="submitFrom('loginForm')"  class="btn btn-primary block full-width m-b" >登 录</button>
                <p class="text-muted text-muted"> <a   data-toggle="modal" data-target="#myModal2" ><small>忘记密码了？</small></a> 
                </p>

        </div>
    </div>

    <!-- forget password start -->
     <div class="modal inmodal" id="myModal2" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content animated flipInY">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">忘记密码</h4>
                </div>
                <div class="modal-body">
                    <p><strong>如忘记密码，请联系管理员重置密码即可</strong></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-w-m btn-primary" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>
    <!-- forget password end -->
    
    	<!-- 遮罩层-->
    		<div  class="sinaif-modal sinaif-inmodal" id="modal-mask" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"   style="z-index: 1000000000 !important; " >
	               <div class="sk-spinner sk-spinner-wave">
                        <div class="sk-rect1"></div>
                        <div class="sk-rect2"></div>
                        <div class="sk-rect3"></div>
                        <div class="sk-rect4"></div>
                        <div class="sk-rect5"></div>
                    </div>
	   	   </div>
        <!--左侧导航结束-->

	

    <script>
     
     	
     	
</body>


</html>
