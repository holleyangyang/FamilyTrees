define(['angularAMD','angular-route'], function (angularAMD) {

    var app = angular.module("homeModule",['ngRoute'])
    /**
     *鐎规矮绠熺捄顖滄暠
     */
    app.config(['$routeProvider','$compileProvider',function ($routeProvider,$compileProvider) {
        $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|file|javascript):/)   //閹碘晛鍘朼閺嶅洨顒烽崥鍫熺《闁剧偓甯撮崜宥囩磻
        $compileProvider.aHrefSanitizationWhitelist("");
        $routeProvider
            .when("/index", angularAMD.route({     //缁楊兛绔村銉窗鐏炴洜銇氶崡锟�娴犮儱寮烽惄纾嬫彧
                templateUrl: 'home.html',
                controller:'homeCtrl',
                controllerUrl:'homeCtrl.js'
            }))
            .otherwise({redirectTo: '/index'})
    }]);
    angularAMD.bootstrap(app);
    //angularAMD.processQueue();   //鐎甸�绨径宥嗘絽妞ょ敻娼伴崣顖濃偓鍐闁插洨鏁ueue閺傜懓绱�    sendSdc("娣囷紕鏁ら崡锛勭秹闁惧爼顩绘い纰夌礄閺傚府绱�)//鐠嬪啰鏁ら惄鎴炲付
    return app;
});