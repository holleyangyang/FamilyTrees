define([
    'jquery',
    'underscore',
    'backbone',
     'view/HomeView'
], function ($, _, Backbone, HomeView) {
    var Router = Backbone.Router.extend({
        routes:{   //指定url路由
        	"":"indexHandler",
            "index":"indexHandler"
         },
        initialize: function() {
//           // this.top = HomeView;
//        	 this.top = new HomeView({router: this});
//             sendSdc("信用卡网银首页")//调用监控
        },       
        indexHandler:function () {
            var self = this;
            self.oldView = self.currentView;
            self.currentView = new HomeView(
            		{parent: self,
            			top: self,router: self
        		});
        	self.destroyView();	
        } ,
        destroyView: function() {
        	 
        }
    });
    return Router;
});