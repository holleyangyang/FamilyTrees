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
	<script type="text/javascript">
	</script>
</head>
<body>
	<h2>家谱信息</h2>
	
	<div style="margin:20px 0;"></div>
	
	<table class="easyui-datagrid" title="Basic DataGrid" id="easyui-datagrid" style="width:100%;height:250px"
			data-options="singleSelect:true,collapsible:true,url:'/examForAPI/FamilyUser/queryFamilyUserById.do?treeId=<%=request.getParameter("id") %>',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'id',width:80"> ID</th>
				<th data-options="field:'name',width:100">name</th>
				<th data-options="field:'sex',width:80,align:'right'">sex</th>
				<th data-options="field:'treeid',width:80,align:'right'">treeid</th>
 			</tr>
		</thead>
	</table>

</body>
</html>
   