<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>test</title>


<%-- <!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> --%>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">  
<link href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" rel="stylesheet" type="text/css">  
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>  
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>  
<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>  
<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.js"></script>   


<script type="text/javascript">            
$(function () {
	  
	 //1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
	  
	 //2.初始化Button的点击事件
	 /* var oButtonInit = new ButtonInit();
	 oButtonInit.Init(); */
	  
	 });
	  
	  
	 var TableInit = function () {
	 var oTableInit = new Object();
	 //初始化Table
	 oTableInit.Init = function () {
	  $('#tradeList').bootstrapTable({
		  url: "${pageContext.request.contextPath}/user/toUserList.do",//数据源
	  method: 'post',   //请求方式（*）
	  toolbar: '#toolbar',  //工具按钮用哪个容器
	  striped: true,   //是否显示行间隔色
	  cache: false,   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	  pagination: true,   //是否显示分页（*）
	  sortable: false,   //是否启用排序
	  sortOrder: "asc",   //排序方式
	  queryParams: oTableInit.queryParams,//传递参数（*）
	  sidePagination: "server",  //分页方式：client客户端分页，server服务端分页（*）
	  pageNumber:1,   //初始化加载第一页，默认第一页
	  pageSize: 50,   //每页的记录行数（*）
	  pageList: [10, 25, 50, 100], //可供选择的每页的行数（*）
	  strictSearch: true,
	  clickToSelect: true,  //是否启用点击选中行
	  height: 460,   //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	  uniqueId: "id",   //每一行的唯一标识，一般为主键列
	  cardView: false,   //是否显示详细视图
	  detailView: false,   //是否显示父子表
	  columns: [{
	   field: 'id',
	   title: '序号'
	  }, {
	   field: 'liushuiid',
	   title: '交易编号'
	  }, {
	   field: 'orderid',
	   title: '订单号'
	  }, {
	   field: 'receivetime',
	   title: '交易时间'
	  }, {
	   field: 'price',
	   title: '金额'
	  }, {
	   field: 'coin_credit',
	   title: '投入硬币'
	  }, {
	   field: 'bill_credit',
	   title: '投入纸币'
	  }, {
	   field: 'changes',
	   title: '找零'
	  }, {
	   field: 'tradetype',
	   title: '交易类型'
	  },{
	   field: 'goodmachineid',
	   title: '货机号'
	  },{
	   field: 'inneridname',
	   title: '货道号'
	  },{
	   field: 'goodsName',
	   title: '商品名称'
	  }, {
	   field: 'changestatus',
	   title: '支付'
	  },{
	   field: 'sendstatus',
	   title: '出货'
	  },]
	  });
	 };
	  
	 //得到查询的参数
	 oTableInit.queryParams = function (params) {
	  var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	  limit: params.limit, //页面大小
	  offset: params.offset, //页码
	  sdate: $("#stratTime").val(),
	  edate: $("#endTime").val(),
	  sellerid: $("#sellerid").val(),
	  orderid: $("#orderid").val(),
	  CardNumber: $("#CardNumber").val(),
	  maxrows: params.limit,
	  pageindex:params.pageNumber,
	  portid: $("#portid").val(),
	  CardNumber: $("#CardNumber").val(),
	  tradetype:$('input:radio[name="tradetype"]:checked').val(),
	  success:$('input:radio[name="success"]:checked').val(),
	  };
	  return temp;
	 };
	 return oTableInit;
	 };
/** 替换数据为文字 */  
/** 刷新页面 */  
/** 
 * 删除数据 
 */  
</script>  

</head>
	<body>
		<!-- 这是html主体代码,只需要这一个就可以了 -->
		<div ><table id="empUserList" class="table table-striped"></table> </div>  
		
	</body>
</html>