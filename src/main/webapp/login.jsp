<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工注册</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">  
<link href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" rel="stylesheet" type="text/css">  
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>  
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>  
<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>  
<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.js"></script>  
    
    <script type="text/javascript">
    $(function () {
    	 /* var oTable = new TableInit();
    	 oTable.Init1();
    	 console.info(oTable);
    	 console.info(TableInit); */
    	var oTable=new TableInit();
    	 oTable.Init();
    	 });
    	  
    	  
    	  /* var TableInit = function () {
	    	 var oTableInit = new Object();
	    	 //初始化Table
	    	 oTableInit.Init1 = function () {
	    		 alert("34567");
	    	 };
	    	  
	    	 return oTableInit;
    	 }; */
    	 
    	var TableInit=function(){
    		 var oTableInit=new Object();
    		 oTableInit.Init=function(){
    			 alert(oTableInit);
    			 console.info(oTableInit);
    		 }
    		 return oTableInit;
    	 };
    	 
    </script>
    
  </head>
  
  <%-- '${pageContext.request.contextPath}/userController/showAll.do' --%>
  <body>
	<form method="post" action="${pageContext.request.contextPath}/login.do">
		<input type="text" name="name">
		<input type="text" name="password">
		<input type="submit" value="登录">
	</form>	
  </body>
</html>
