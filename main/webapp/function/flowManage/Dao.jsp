<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../common/jquery-easyui-1.4.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../common/jquery-easyui-1.4.3/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../common/jquery-easyui-1.4.3/demo/demo.css">
	<script type="text/javascript" src="../common/jquery-easyui-1.4.3/jquery.min.js"></script>
	<script type="text/javascript" src="../common/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
	<style type="text/css">
		body{
			margin:0 0 0 0;
		}
		
	</style>
</head>
<body>
	<table id="list_data" cellspacing="0" cellpadding="0"> 
    <thead> 
        <tr>  
        	<th data-options="field:'flowActionServiceId',width:0,hidden:true" >功能编号</th>
          	<th data-options="field:'serviceName',width:250" >serviceName</th>
			<th data-options="field:'serviceMethodName',width:400" >serviceMethodName</th>
			<th data-options="field:'serviceMethodDesc',width:400" >serviceMethodDesc</th>
			<th data-options="field:'remark',width:500,align:'center'" nowrap="false">备注</th>
        </tr> 
    </thead> 
</table>  
</body>
</html>
<script type="text/javascript">
$(function(){

		 $('#list_data').datagrid({ 
        title:'功能步骤', 
        iconCls:'icon-edit',//图标 
        width: 800, 
        height: '300', 
        nowrap: false, 
        striped: true, 
        border: true, 
        collapsible:false,//是否可折叠的 
        fit: true,//自动大小 
        url:'/examForAPI/flowControllerActionService/list/<%=request.getParameter("flowControolerActionId")%>', 
        //sortName: 'code', 
        //sortOrder: 'desc', 
        remoteSort:false,  
        idField:'flowActionServiceId', 
        singleSelect:false,//是否单选 
        pagination:false,//分页控件 
        rownumbers:true,//行号 
        toolbar: [{ 
            text: '添加', 
            iconCls: 'icon-add', 
            handler: function() { 
            	$("#id").val('000');
        		$("#name").textbox('setValue','');
        		$("#remark").val('');
        		$("#desc").val('');
            	$('#dlg').dialog('open');
            } 
        }]
    });  
		 
});
		
	</script>
   