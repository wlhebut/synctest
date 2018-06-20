<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>test</title>


<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrapValidator.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrapValidator.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/moment.min.js"></script>

<style type="text/css">  

</style> 


<script type="text/javascript">
$().ready(function() {  
    $("#login_form").validate({  
        rules: {  
            username: "required",  
            password: {  
                required: true,  
                minlength: 5  
            },  
        },  
        messages: {  
            username: "请输入姓名",  
            password: {  
                required: "请输入密码",  
                minlength: jQuery.format("密码不能小于{0}个字 符")  
            },  
        }  
    });  
    $("#register_form").validate({  
        rules: {  
            username: "required",  
            password: {  
                required: true,  
                minlength: 5  
            },  
            rpassword: {  
                equalTo: "#register_password"  
            },  
            email: {  
                required: true,  
                email: true  
            }  
        },  
        messages: {  
            username: "请输入姓名",  
            password: {  
                required: "请输入密码",  
                minlength: jQuery.format("密码不能小于{0}个字 符")  
            },  
            rpassword: {  
                equalTo: "两次密码不一样"  
            },  
            email: {  
                required: "请输入邮箱",  
                email: "请输入有效邮箱"  
            }  
        }  
    });  
});  
$(function() {  
    $("#register_btn").click(function() {  
        $("#register_form").css("display", "block");  
        $("#login_form").css("display", "none");  
    });  
    $("#back_btn").click(function() {  
        $("#register_form").css("display", "none");  
        $("#login_form").css("display", "block");  
    });  
});

function upPolicy() {

    document.sourcefile.action = "${pageContext.request.contextPath}/userController/upLoad.do";
    var submitUrl = document.getElementById("sourcefile").attributes["action"].value;
    $.ajax({
        type: "POST",
        url:submitUrl,
        data: $('#sourcefile').serialize(),
        //dataType: "json",
        success: function (result) {
            var json = JSON.parse(result);
            if (json.flag == "0" || json.flag == "1") {
                alert(tableJson.success);
                return;
            }
        }
    })
}
</script>

</head>
	<body>
        <!--  
            基础知识：  
            网格系统:通过行和列布局  
            行必须放在container内  
            手机用col-xs-*  
            平板用col-sm-*  
            笔记本或普通台式电脑用col-md-*  
            大型设备台式电脑用col-lg-*  
            为了兼容多个设备，可以用多个col-*-*来控制；  
        -->  
    <%--<div class="container">
        <div class="form row">  
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="login_form">  
                <h3 class="form-title">--成就完整家庭--</h3>  
                <div class="col-sm-9 col-md-9">  
                    <div class="form-group">  
                        <i class="fa fa-user fa-lg"></i>  
                        <input class="form-control required" type="text" placeholder="用户名" name="username" id="usernameid" autofocus="autofocus" maxlength="20"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-lock fa-lg"></i>  
                            <input class="form-control required" type="text" placeholder="手机号" name="telid" maxlength="11"/>  
                    </div>
                    <div class="form-group">  
                            <i class="fa fa-lock fa-lg"></i>  
                            <input class="form-control required" type="text" placeholder="最高院校名称" id="schoolid" name="school"/>  
                    </div>   
                    <div class="form-group">  
                            <i class="fa fa-lock fa-lg"></i>  
                            <input class="form-control required" type="text" placeholder="QQ" id="qqid" name="password"/>  
                    </div>   
                   <!--  <div class="form-group">  
                        <label class="checkbox">  
                            <input type="checkbox" name="remember" value="1"/> Remember me  
                        </label>  
                        <hr />  
                        <a href="javascript:;" id="register_btn" class="">Create an account</a>  
                    </div>   -->
                    <div class="form-group">  
                        <input type="submit" class="btn btn-success pull-right" value="注册 "/>     
                    </div>  
                </div>  
            </form>  
        </div>  
  
        <div class="form row">  
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form">  
                <h3 class="form-title"></h3>  
                <div class="col-sm-9 col-md-9">  
                    <div class="form-group">  
                        <i class="fa fa-user fa-lg"></i>  
                        <input class="form-control required" type="text" placeholder="用户名" name="username" autofocus="autofocus"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-lock fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="手机号" id="register_password" name="password"/>  
                    </div>  
 
                    <div class="form-group">  
                            <i class="fa fa-check fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="Re-type Your Password" name="rpassword"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-envelope fa-lg"></i>  
                            <input class="form-control eamil" type="text" placeholder="Email" name="email"/>  
                    </div>  
                    <div class="form-group">  
                        <input type="submit" class="btn btn-success pull-right" value="Sign Up "/>  
                        <input type="submit" class="btn btn-info pull-left" id="back_btn" value="Back"/>  
                    </div>  
                </div>  
            </form>  
        </div>  
        </div>  --%>

    欢迎使用智能小私服应用程序
   <%-- <div>
       <form id="sourcefile" name="sourcefile" method="post" action="" enctype="multipart/form-data">
        <input style="margin-left: 20px;" id="source_file" name="sourceFile" type="file" value="选择文件" />
        <input style="margin-left: 20px;"  type="submit" value="上  传" onClick="upPolicy()">
       </form>
    </div>


        <span style="font-size:14px;">
            <form action="${pageContext.request.contextPath}/userController/upLoad.do"  enctype="multipart/form-data" method="post">
         上传文件1：<input type="file" name="sourceFile"><br/>
            <!--          上传文件2：<input type="file" name="file2"><br/> -->
            <!--          上传文件3：<input type="file" name="file3"><br/> -->
            <!--          上传文件4：<input type="file" name="file4"><br/> -->
         <input type="submit" value="提交">
     </form></span>--%>

    </body>
</html>