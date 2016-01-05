/**
 * Created by LIUYANMENG158 on 14-5-30.
 */
define(['app','jquery'], function (app) {
    app.register.controller('homeCtrl', ['$scope', '$location', '$http', '$parse','$sce','dateFilter','$interval',
        function ($scope, $location, $http, $parse,$sce,dateFilter,$interval) {
            //model
   
    	$scope.model ={};
 
            
        
            //所有请求链接管理
            var reqInfo = {"accountInfo": "/"+base.webContextName+"/queryFunTree.act"   //帐户信息
            }            //获取数据
            for (var reqKey in reqInfo) {
                getData(reqKey, reqInfo[reqKey]);
            }

          
            /**
             * //功能函数
             */
            function getData(key, url) {   //获取数据
                $http({
                    url: url,
                    method: "POST"
                })
                    .success(function (data, status, headers, config, reqKey) {
                        $scope.model[key] = data;
                    })
                    .error(function (e) {
                        //console.log(e);
                    })
            }

        }]);
});