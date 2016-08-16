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
</head>
<body>
	<table id="list_data" cellspacing="0" cellpadding="0"> 
    <thead> 
        <tr>  
        	<th data-options="field:'id',width:0,hidden:true" >功能编号</th>
          	<th data-options="field:'data_type',width:250" >questionDesc</th>
			<th data-options="field:'data_name',width:300" >questionType</th>
			<th data-options="field:'data_value',width:220" >isResolve</th>
			<th data-options="field:'data_type_value',width:400" >remark</th>
         </tr> 
    </thead> 
</table>   
</body>
</html>
<script type="text/javascript">

	 
$(function(){
	$('#dlg').dialog('close');
		 $('#list_data').datagrid({ 
        title:'问题列表', 
        iconCls:'icon-edit',//图标 
        width: 800, 
        height: '200', 
        nowrap: false, 
        striped: true, 
        border: true, 
        collapsible:false,//是否可折叠的 
        fit: true,//自动大小 
        url:'/SystemManage/zidian/list', 
        //sortName: 'code', 
        //sortOrder: 'desc', 
        remoteSort:false,  
        pageSize: 15,//每页显示的记录条数，默认为10 
        pageList: [15,30,45],//可以设置每页记录条数的列表
        idField:'id', 
        singleSelect:true,//是否单选 
        pagination:true,//分页控件 
        rownumbers:true,//行号 
        onClickRow: function(index, data) {
        	var row = $('#list_data').datagrid('getSelected');
        	window.parent.document.getElementById('middleframe').src='questionRolsove.jsp?questionId='+row.questionId;
        },
        toolbar: [{ 
            text: '列表维护', 
            iconCls: 'icon-add', 
            handler: function() { 
            	window.open("question/question.jsp");
            } 
        }] 
    });
   
		//设置分页控件 
	    var p = $('#list_data').datagrid('getPager'); 
	    $(p).pagination({ 
	        method : 'POST',
	        loading:true,
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	        onBeforeRefresh:function(){
	            $(this).pagination('loading');
	            alert('before refresh');
	            $(this).pagination('loaded');
	        },
	        onRefresh:function(){
	        	   $(this).pagination('loading');
		            alert('before onRefresh');
		            $(this).pagination('loaded');
	        	
	        }
	    });  
	    
	    $(p).pagination('loading');
		
});
		
	</script>
   