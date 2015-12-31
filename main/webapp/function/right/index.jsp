<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="/examForAPI/jquery-easyui-1.4.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/examForAPI/jquery-easyui-1.4.3/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/examForAPI/jquery-easyui-1.4.3/demo/demo.css">
	<script type="text/javascript" src="/examForAPI/jquery-easyui-1.4.3/jquery.min.js"></script>
	<script type="text/javascript" src="/examForAPI/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
</head>
<body>
	<table id="list_data" cellspacing="0" cellpadding="0"> 
    <thead> 
        <tr>  
          	<th data-options="field:'id',width:80,hidden:true" >步骤</th>
			<th data-options="field:'name',width:400" >步骤描述</th>
			<th data-options="field:'remark',width:500,align:'center'" nowrap="false">备注</th>
        </tr> 
    </thead> 
</table>  
	
	
<!-- 修改页面 -->
	<div id="dlg" class="easyui-dialog panel-body panel-body-noborder window-body" title="家族成员信息编辑" style="width:400px;height:400px;padding:10px; "
			data-options="
				iconCls: 'icon-save',
				
				buttons: [{
					text:'Ok',
					iconCls:'icon-ok',
					handler:function(){
						alert('ok');
					}
				},{
					text:'Cancel',
					handler:function(){
						alert('cancel');;
					}
				}],resizable:true,modal:true
			">
		
		<div style="margin-bottom:20px">
			<div>Name:</div>
			<input class="easyui-textbox" data-options="prompt:'Enter a email address...',validType:'email'" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div> sex:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>treeid:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<input class="easyui-textbox" style="width:100%;height:22px">
		</div>
	
</body>
</html>
<script type="text/javascript">

	 
$(function(){
	$('#dlg').dialog('close');
		 $('#list_data').datagrid({ 
        title:'功能步骤', 
        iconCls:'icon-edit',//图标 
        width: 700, 
        height: 'auto', 
        nowrap: false, 
        striped: true, 
        border: true, 
        collapsible:false,//是否可折叠的 
        fit: true,//自动大小 
        url:'/examForAPI/buzhou/list.do?random=Math.random()&treeId=<%=request.getParameter("id") %>', 
        //sortName: 'code', 
        //sortOrder: 'desc', 
        remoteSort:false,  
        pageSize: 15,//每页显示的记录条数，默认为10 
        pageList: [15,30,45],//可以设置每页记录条数的列表
        idField:'id', 
        singleSelect:false,//是否单选 
        pagination:true,//分页控件 
        rownumbers:true,//行号 
        toolbar: [{ 
            text: '添加', 
            iconCls: 'icon-add', 
            handler: function() { 
            	$('#dlg').dialog('open');
            } 
        }, '-', { 
            text: '修改', 
            iconCls: 'icon-edit', 
            handler: function() { 
            	$('#dlg').dialog('open');
            } 
        }, '-',{ 
            text: '删除', 
            iconCls: 'icon-remove', 
            handler: function(){ 
                delAppInfo(); 
            } 
        }], 
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
   