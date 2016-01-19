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
<!-- 修改页面 -->
	<div id="dlg" class="easyui-dialog panel-body panel-body-noborder window-body" title="步骤信息编辑" style="width:500px;height:500px;padding:10px; "
			data-options="
				iconCls: 'icon-save',
				buttons: [{
					text:'Ok',
					iconCls:'icon-ok',
					handler:function(){
						
						if($('#id').val()=='000'){
							$.ajax({
					                cache: true,
					                type: 'POST',
					                url:'/examForAPI/codeManage/add/<%=request.getParameter("controllerMethodId")%>',
					                data:$('#frm1').serialize(),
					                async: false,
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
					                type: 'PUT',
					                url:'/examForAPI/sysfunction/update/'+$('#id').val(),
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
		<form  method="post" id="frm1">
		<div style="margin-bottom:20px">
 		<input name="id" type="hidden" id="id">
			<div>Name:</div>
			<input class="easyui-textbox" name="name" id="name" data-options="prompt:'Enter a name...'" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>desc:</div>
			<input class="easyui-textbox" name="desc"  id="desc" data-options="prompt:'Enter a name...'" style="width:100%;height:22px">
		</div>
		<div style="margin-bottom:20px">
			<div>remark:</div>
			<textarea id="remark" rows="14" name="remark"  class="textarea easyui-validatebox" style="width:100%;"></textarea> 
		</div>
		 </form>
		 </div>
</body>
</html>
<script type="text/javascript">

	 
$(function(){
	$('#dlg').dialog('close');
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
        onClickRow: function(index, data) {
        	var row = $('#list_data').datagrid('getSelected');
        	window.parent.document.getElementById('saoframe').src='Sao.jsp?flowActionServiceId='+row.flowActionServiceId;
        	window.parent.document.getElementById('daoframe').src='Dao.jsp?flowActionServiceId='+row.flowActionServiceId;

        },
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
   