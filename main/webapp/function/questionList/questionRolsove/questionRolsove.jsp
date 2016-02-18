<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../../common/jquery-easyui-1.4.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../../common/jquery-easyui-1.4.3/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../../common/jquery-easyui-1.4.3/demo/demo.css">
	<script type="text/javascript" src="../../common/jquery-easyui-1.4.3/jquery.min.js"></script>
	<script type="text/javascript" src="../../common/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
	<style type="text/css">
		body{
			margin:0 0 0 0;
		}
	</style>
	
</head>
<body>
	<table id="list_data" cellspacing="0" cellpadding="0"> 
    <thead> 
        
    </thead> 
</table>  
<!-- 修改页面 -->
	<div id="dlg"
		class="easyui-dialog panel-body panel-body-noborder window-body"
		title="问题编辑" style="width: 500px; height: 500px; padding: 10px;"
		data-options="
				iconCls: 'icon-save',
				buttons: [{
					text:'Ok',
					iconCls:'icon-ok',
					handler:function(){
					
						if($('#questionResolveId').val()=='000'){
							$.ajax({
					               
					                type: 'POST',
					                url:'/examForAPI/questionResolve/add',
					                data:$('#frm1').serialize(),
					              
					                error: function(request) {
					                    alert('add Connection error');
					                },
					                success: function(data) {
					                   $('#dlg').dialog('close');
					                    $('#list_data').datagrid('reload');
					                }
					            });
				            
				            }else{
					            $.ajax({
					                cache: true,
					                type: 'POST',
					                url:'/examForAPI/buzhou/update/<%=request.getParameter("id")%>',
					                data:$('#frm1').serialize(), 
					                async: false,
					                error: function(request) {
					                    alert('update Connection error');
					                },
					                success: function(data) {
					                   $('#dlg').dialog('close');
					                    $('#list_data').datagrid('reload');
					                }
					            });
				            }
					}
				},{
					text:'Cancel',
					handler:function(){
						alert('cancel');;
					}
				}],resizable:true,modal:true
			">
		<form method="put" id="frm1">
			<div style="margin-bottom: 20px">
				<div>questionResolveDesc:</div>
				<input class="easyui-textbox" name="questionResolveDesc" id="questionResolveDesc"
					style="width: 100%; height: 22px"> 
					<input name="questionResolveId" id="questionResolveId"
					style="width: 100%; height: 22px" type="hidden" value="000"> 
					<input name="questionId" id="questionId"
					style="width: 100%; height: 22px" type="hidden" value="<%=request.getParameter("questionId")%>"> 
					
			</div>
			 
			<div style="margin-bottom: 20px">
				<div>remark:</div>
			<textarea id="remark" rows="14" name="remark"  class="textarea easyui-validatebox" style="width:100%;"></textarea> 
			</div>
		</form>
	</div>
</body>
</html>
<script type="text/javascript">

	function  go(val,row){
		return '<a href="#" onclick="constructionManager(\'' + row.questionResolveId+ '\')">查看</a>  ';
	} 
	function constructionManager(questionResolveId){
		 window.open("../questionRolsoveList/questionRolsoveList.html?questionResolveId="+questionResolveId,"questionRolsoveList");
	}	
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
	        },
	        toolbar: [{ 
	            text: '添加', 
	            iconCls: 'icon-add', 
	            handler: function() { 
	            	$("#questionResolveId").val('000');
	        		$("#questionResolveDesc").textbox('setValue','');
	            	$('#dlg').dialog('open');
	            } 
	        }] ,
	        columns: [[
                    {field:'questionResolveId',title:'questionResolveId',width:80,hidden:true},   
                    {field:'questionResolveDesc',title:'questionResolveDesc',width:250,hidden:false}, 
                    {field:'questionDesc',title:'questionDesc',width:250,hidden:false}, 
                    {field:'remark',title:'remark',width:250,hidden:false}, 
                    {field:'aa',title:'解决详情',formatter:function(value,row,index){
 						return '<a href="#" onclick="constructionManager(\'' + row.questionResolveId+ '\')">查看</a>  ';}  
 					 }
	                  ]]
	    });  
	});
		
</script>
   