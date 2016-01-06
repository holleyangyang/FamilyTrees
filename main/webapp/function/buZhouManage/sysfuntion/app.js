define([
    'jquery',
    'underscore',
    'backbone',
    'router/HomeRouter',
    'view/HomeView'
], function ($, _, Backbone, HomeRouter,HomeView) {
    return {
        initialize:function () {
       
          //  var homeView = new HomeView({router: this});
            var homeRouter = new HomeRouter();
            Backbone.history.start({pushState:false});
        }
    }
});