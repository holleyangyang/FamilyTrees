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
        	<th data-options="field:'questionResolveId',width:0,hidden:true" >功能编号</th>
          	<th data-options="field:'questionDesc',width:250" >questionDesc</th>
			<th data-options="field:'questionType',width:300" >questionType</th>
			<th data-options="field:'questionResolveDesc',width:250" >questionResolveDesc</th>
 			<th data-options="field:'isResolve',width:220" >isResolve</th>
			<th data-options="field:'remark',width:400" >remark</th>
		</tr> 
    </thead> 
</table>  
</body>
</html>
<script type="text/javascript">

	 
$(function(){
	$('#dlg').dialog('close');
		 $('#list_data').datagrid({ 
        title:'解决方案', 
        iconCls:'icon-edit',//图标 
        width: 800, 
        height: '300', 
        nowrap: false, 
        striped: true, 
        border: true, 
        collapsible:false,//是否可折叠的 
        fit: true,//自动大小 
        url:'/examForAPI/questionResolve/list/<%=request.getParameter("questionId")%>', 
        //sortName: 'code', 
        //sortOrder: 'desc', 
        remoteSort:false,  
        idField:'questionResolveId', 
        singleSelect:true,//是否单选 
        pagination:false,//分页控件 
        rownumbers:true,//行号 
        onClickRow: function(index, data) {
        	var row = $('#list_data').datagrid('getSelected');
        	window.parent.document.getElementById('bottomframe').src='questionRolsoveList.jsp?questionResolveId='+row.questionResolveId;
        },
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
   