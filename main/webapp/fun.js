var temp={};
var zTree;
	var demoIframe;

	var setting = {
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: ""
			}
		},
		callback: {
			beforeClick: function(treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("tree");
				if (treeNode.isParent) {
					zTree.expandNode(treeNode);
					demoIframe.attr("src",treeNode.file );
					return false;
				} else {
					demoIframe.attr("src",treeNode.file );
					return true;
				}
			}
		}
	};

	var zNodes =[
		{id:1, pId:0, name:"JS基本操作", open:true},
		{id:101, pId:1, name:"JQUERY", file:""},
		{id:101, pId:1, name:"Backbone", file:"backbone/index.html"},
		{id:101, pId:1, name:"angular", file:"angular/index.html"} 
	];
	
	//-[{"file":"1","id":"1","name":"测试","open":"11","pId":"1"},{"file":"1","id":"2","name":"测试1","open":"true","pId":"0"}]

	

	temp.loadReady=function() {
		var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
		htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
		maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
		h = demoIframe.height() >= maxH ? minH:maxH ;
		if (h < 530) h = 530;
		demoIframe.height(h);
	}
	
	temp.getFuntData=function (){
			$.ajax({    
			    type:'post',        
			    url:'/examForAPI/FamilyTree/queryFunTree.do',    
			    data:{},    
			    cache:false,
			    async:false,
			   // dataType:'json',    
			    success:function(data){   
			    	temp.zNodes=data;
			    
			    }    
		});
			
	}
	
$(document).ready(function(){
	temp.getFuntData();
	//temp.zNodes=zNodes;
	 //console.info("==="+JSON.parse(temp.zNodes));
	  var t = $("#tree");
      t = $.fn.zTree.init(t, setting, JSON.parse(temp.zNodes));
      //t = $.fn.zTree.init(t, setting, (temp.zNodes));
      demoIframe = $("#testIframe");
  	demoIframe.bind("load", temp.loadReady);
  	var zTree = $.fn.zTree.getZTreeObj("tree");
  	zTree.selectNode(zTree.getNodeByParam("id", 101));
	
	
});

  