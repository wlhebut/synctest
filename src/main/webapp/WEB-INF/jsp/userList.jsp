<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>test</title>



<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">  
<link href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" rel="stylesheet" type="text/css">  
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>  
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>  
<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>  
<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.js"></script>   


<script type="text/javascript">            
</script>  

</head>
	<body>
<div>
        <div>
            <div class="col-*-12">

                <div id="toolbar">
                    <div class="btn btn-primary" data-toggle="modal" data-target="#addModal">添加记录</div>
                </div>
                
                <table id="mytab" class="table table-hover"></table>

                <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">
                   <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">添加记录</h4>
                            </div>
                            <div class="modal-body">
                                <form role="form" action="javascript:void(0)">
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="name" placeholder="请输入名称">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="age" placeholder="请输入年龄">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" id="addRecord">提交</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(function() {
            //根据窗口调整表格高度
            $(window).resize(function() {
                $('#mytab').bootstrapTable('resetView', {
                    height: tableHeight()
                })
            })

            $('#mytab').bootstrapTable({
                url: "${pageContext.request.contextPath}/user/toUserList.do",//数据源
                dataField: "rows",//服务端返回数据键值 就是说记录放的键值是rows，分页时使用总记录数的键值为total
               // singleSelect:true,//按钮禁止多选
                height: tableHeight(),//高度调整
                cache:true, //设置为 true 禁用 AJAX 数据缓存

                striped:true,//设置为 true 会有隔行变色效果
                search: true,//是否搜索
                pagination: true,//是否分页
                pageSize: 20,//单页记录数
                pageList: [5, 10, 20, 50],//分页步进值
                sidePagination: "server",//服务端分页
                contentType: "application/json",//发送到服务器的数据编码类型,请求数据内容格式 默认是 application/json 自己根据格式自行服务端处理
                dataType: "json",//期待server返回数据类型
                method: "post",//请求方式
                searchAlign: "left",//查询框对齐方式
                queryParamsType: "limit",//查询参数组织方式
                queryParams: function getParams(params) {
                    //params obj
                    params.other = "otherInfo";
                    return params;
                },
                searchOnEnterKey: false,//回车搜索
                showRefresh: true,//刷新按钮
                showColumns: true,//列选择按钮
                buttonsAlign: "left",//按钮对齐方式
                toolbar: "#toolbar",//指定工具栏
                toolbarAlign: "right",//工具栏对齐方式
                columns: [
                    {
                        title: "全选",
                        field: "select",
                        checkbox: true,
                        width: 20,//宽度
                        align: "center",//水平
                        valign: "middle"//垂直
                    },
                    {
                        field: "id",//键名
                        title: "ID",//标题
                        sortable: true,//是否可排序
                        order: "asc"//默认排序方式
                    },
                    {
                        field: "name",
                        title: "NAME",
                        sortable: true,
                        titleTooltip: "this is name"
                    },
                    {
                        field: "groupId",
                        title: "GROUPID",
                        sortable: true,
                    },
                    {
                        field: "info",
                        title: "INFO[using-formatter]",
                        formatter: 'infoFormatter',//对本列数据做格式化
                    }
                ],
                onClickRow: function(row, $element) {
                    //$element是当前tr的jquery对象
                    $element.css("background-color", "green");
                },//单击row事件
                locale: "zh-CN",//中文支持,
                detailView: false, //是否显示详情折叠
                detailFormatter: function(index, row, element) {
                    var html = '';
                    $.each(row, function(key, val){
                        html += "<p>" + key + ":" + val +  "</p>"
                    });
                    return html;
                }
            });

            $("#addRecord").click(function(){
                alert("username:" + $("#username").val() + " userpwd:" +$("#userpwd").val());
            });
        })

        function tableHeight() {
        	
            return $(window).height() - 50;
        }
        /**
         * 列的格式化函数 在数据从服务端返回装载前进行处理
         * @param  {[type]} value [description]
         * @param  {[type]} row   [description]
         * @param  {[type]} index [description]
         * @return {[type]}       [description]
         */
        function infoFormatter(value, row, index)
        {
            return "id:" + row.id + " name:" + row.name + " age:" + row.age;
        }
    </script>
		
	</body>
</html>