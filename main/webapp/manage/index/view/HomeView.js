/**
 * Created with IntelliJ IDEA. User: EX-ZHUZHAOWEI001 Date: 13-3-18 Time: 下午5:19
 * 帐户信息
 */
define(
		[ 'jquery', 'underscore', 'backbone', 'logger','ztree',
		  'model/FunTreeModel','text!partials/home.html'
		],
		function($, _, Backbone, logger,ztree,FunTreeModel
				, partial) {
			return Backbone.DelayView
					.extend({
						tagName : "div", // 若指定tagName则不需要指定el和$el，视图将在初始化之前自动生成
						_template : _.template(partial), // 初始化模板渲染器，非必须
						events : {// 此处添加事件绑定
						},
						initialize : function() {
							var self = this;
							self.setting = {
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
												demoIframe.attr("src","../../right/index.jsp?id="+treeNode.id );

												zTree.expandNode(treeNode);

												return false;
											} else {
												demoIframe.attr("src","../../manage/right/index.jsp?id="+treeNode.id );
												return true;
											}
										}
									}
								};
							self.render();
 						},
 						loadReady:function() {
 							var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
 							htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
 							maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
 							h = demoIframe.height() >= maxH ? minH:maxH ;
 							if (h < 530) h = 530;
 							demoIframe.height(h);
 						},
						render : function() {
							//1、
							var self = this;
							$.ajax({    
							    type:'post',        
							    url:'../../FamilyTree/queryFunTree.do',    
							    data:{},    
							    cache:false,
							    async:false,
							   // dataType:'json',    
							    success:function(data){   
							    	self.funTreeModel=data;
							    },
							    error:function(data){
							    	alert("系统异常了");
							    }   
							});
							//2、
							self.$el.html(self._template({
								//accountInfo : oldAccountInfoModel,
								self:self
							}));
							//3、
							$("#context").append(self.$el);
							//4、
							var t = $("#tree");
						    t = $.fn.zTree.init(t, self.setting, JSON.parse(self.funTreeModel));
						    demoIframe = $("#testIframe");
						  	demoIframe.bind("load", self.loadReady);
						  	var zTree = $.fn.zTree.getZTreeObj("tree");
						  	zTree.selectNode(zTree.getNodeByParam("id", 101));

						},
						destroy : function() {
							var self = this;
							self.undelegateEvents();
							self.remove();
						}
					});
		});
