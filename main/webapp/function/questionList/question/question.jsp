<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>问题列表维护</title>
	<link rel="stylesheet" type="text/css" href="../../common/jquery-easyui-1.4.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../../common/jquery-easyui-1.4.3/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../../common/jquery-easyui-1.4.3/demo/demo.css">
	<script type="text/javascript" src="../../common/jquery-easyui-1.4.3/jquery.min.js"></script>
	<script type="text/javascript" src="../../common/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
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
					
						if($('#questionId').val()=='000'){
							$.ajax({
					                type: 'post',
					                url:'/examForAPI/questionList/add',
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
					                async: true,
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
		<form method="PUT" id="frm1" name="frm1" >
			<div style="margin-bottom: 20px">
				<div>questionDesc:</div>
				<input class="easyui-textbox" name="questionDesc" id="questionDesc"
					style="width: 100%; height: 22px"> 
					<input name="questionId" id="questionId"
					style="width: 100%; height: 22px" type="hidden" value="000"> 
			</div>
			<div style="margin-bottom: 20px">
				<div>questionType:</div>
				<input class="easyui-textbox" name="questionType" id="questionType"
					style="width: 100%; height: 22px"> 
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
	return '<a href="#" onclick="constructionManager(\'' + row.questionId+ '\')">查看</a>  '

} 
function constructionManager(questionId){
	 window.open("../questionRolsove/questionRolsove.jsp?questionId="+questionId,"questionRolsove");
}	 
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
        url:'/examForAPI/questionList/list', 
        //sortName: 'code', 
        //sortOrder: 'desc', 
        remoteSort:false,  
        pageSize: 15,//每页显示的记录条数，默认为10 
        pageList: [15,30,45],//可以设置每页记录条数的列表
        idField:'questionId', 
        singleSelect:true,//是否单选 
        pagination:true,//分页控件 
        rownumbers:true,//行号 
        onClickRow: function(index, data) {
        	//var row = $('#list_data').datagrid('getSelected');
        	//window.parent.document.getElementById('middleframe').src='questionRolsove.jsp?questionId='+row.questionId;
        },
        toolbar: [{ 
            text: '添加', 
            iconCls: 'icon-add', 
            handler: function() { 
            	$('#questionId').val('000');
            	$('#dlg').dialog('open');
            } 
        }],
        columns: [[
                   {field:'questionId',title:'questionId',width:80,hidden:true},   
                   {field:'questionDesc',title:'questionDesc',width:250,hidden:false}, 
                   {field:'questionType',title:'questionType',width:250,hidden:false}, 
                   {field:'isResolve',title:'isResolve',width:250,hidden:false}, 
                   {field:'remark',title:'remark',width:250,hidden:false}, 
                   {field:'aa',title:'解决方案',formatter:function(value,row,index){
						return '<a href="#" onclick="constructionManager(\'' + row.questionId+ '\')">查看</a>  '
					  }   
					}
                   ]]
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
   