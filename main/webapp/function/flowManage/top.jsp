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
        	<th data-options="field:'controllerMethodId',width:0,hidden:true" >功能编号</th>
          	<th data-options="field:'controllerName',width:250" >Controller</th>
			<th data-options="field:'controllerMethodName',width:300" >Method</th>
			<th data-options="field:'do',width:220" >.do</th>
			<th data-options="field:'controllerMethodName',width:400" >controllerMethodName</th>
			<th data-options="field:'controllerMethodDesc',width:500,align:'center'" nowrap="false">controllerMethodDesc</th>
        </tr> 
    </thead> 
</table>  
 
</body>
</html>
<script type="text/javascript">

	 
$(function(){
	$('#dlg').dialog('close');
		 $('#list_data').datagrid({ 
        title:'.do信息', 
        iconCls:'icon-edit',//图标 
        width: 800, 
        height: '200', 
        nowrap: false, 
        striped: true, 
        border: true, 
        collapsible:false,//是否可折叠的 
        fit: true,//自动大小 
        url:'/examForAPI/flow/list/1212', 
        //sortName: 'code', 
        //sortOrder: 'desc', 
        remoteSort:false,  
        pageSize: 15,//每页显示的记录条数，默认为10 
        pageList: [15,30,45],//可以设置每页记录条数的列表
        idField:'controllerMethodId', 
        singleSelect:false,//是否单选 
        pagination:true,//分页控件 
        rownumbers:true,//行号 
        onClickRow: function(index, data) {
        	var row = $('#list_data').datagrid('getSelected');
        	window.parent.document.getElementById('bottomframe').src='bottom.html?controllerMethodId='+row.controllerMethodId;
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
        }, '-', { 
            text: '修改', 
            iconCls: 'icon-edit', 
            handler: function() { 
            	
            	var id="";
            	var name="";
            	var remark="";
            	var desc="";
            	var row = $('#list_data').datagrid('getSelected');
            	if (row){
            		id=row.id;
            		name=row.name;
            		desc=row.desc;
            		remark=row.remark;
            		$("#id").val(id);
            		$("#desc").textbox('setValue',desc);
            		$("#name").textbox('setValue',name);
            		$("#remark").val(remark);
            	}else{
            		alert("请选择一行");
            	}
            	
            	$('#dlg').dialog('open');
            } 
        }, '-',{ 
            text: '删除', 
            iconCls: 'icon-remove', 
            handler: function(){
            	var id="";
            	var row = $('#list_data').datagrid('getSelected');
            	if (row){
            		id=row.id;
            	}else{
            		alert("请选择一行");
            	}
            	
            	$.ajax({
                    cache: true,
                    type: "DELETE",
                    url:'/examForAPI/sysfunction/delete/<%=request.getParameter("id") %>/'+id,
                    data:{},// 你的formid
                    async: false,
                    error: function(request) {
                        alert("Connection error");
                    },
                    success: function(data) {
                       alert("DELETE SUCCESS");
                       $('#list_data').datagrid('reload');
                    }
                });
            	
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
   