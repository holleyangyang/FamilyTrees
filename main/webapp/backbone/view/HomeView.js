/**
 * Created with IntelliJ IDEA. User: EX-ZHUZHAOWEI001 Date: 13-3-18 Time: 下午5:19
 * 帐户信息
 */
define(
		[ 'jquery', 'underscore', 'backbone', 'logger',
				'model/AccountInfoModel',
				 'text!partials/home.html'
				 
				 ],
		function($, _, Backbone, logger,AccountInfoModel
				, partial) {
			return Backbone.DelayView
					.extend({
						tagName : "div", // 若指定tagName则不需要指定el和$el，视图将在初始化之前自动生成
						_template : _.template(partial), // 初始化模板渲染器，非必须
						events : {// 此处添加事件绑定
						},
						initialize : function() {
							var self = this;
						
							
							if (!self.accountInfoModel) {
								self.accountInfoModel = new AccountInfoModel();
							}
							self.listenTo(self.accountInfoModel,"change",self.render);
							self.accountInfoModel.fetch({url:base.webContextName+self.accountInfoModel.url});


						
 						},
						render : function() {
							var self = this;
							var oldAccountInfoModel = self.accountInfoModel
									.toJSON()[0];
							logger.i("ffffffff="+self.accountInfoModel
									.toJSON().length);
							
 						
							self.$el.html(self._template({
								accountInfo : oldAccountInfoModel,
								
								self:self
							}));
						
							$("#context").append(self.$el);

						},
						
						
					 
						destroy : function() {
							var self = this;
							this.undelegateEvents();
							this.remove();
						}
					});
		});
