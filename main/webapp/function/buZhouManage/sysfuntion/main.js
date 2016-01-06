require.config({
	urlArgs:base.urlArgs,
    shim: {
        'underscore': {
            deps: [
                'json'
            ],
            exports:'_'
        },
        'backbone':{
            deps: [
                'underscore'
            ],
            exports:'Backbone'
        },
        'jquery': {
            exports:'$'
        },
        'ztree': {
            deps: [
                'jquery'
            ],
            exports:'ztree'
        }
    },
    paths : {
    	 
        jquery: '../common/js/jquery-1.9.1.min',
        json: '../common/js/json2',
        underscore : '../common/js/underscore-min',
        text : '../common/js/text',
        backbone : '../common/js/backbone-min',
        partials: 'partials',                         //模板根目录
        logger: '../../common/js/logger',
        base_config: '../common/js/base',
        ztree: '../common/zTree/js/jquery.ztree.core-3.5.min'
    }
});
require([
    'logger',
    'app',
    'base_config'
], function(logger,app,base_config) {
    logger.i("home(主页) 模块初始化开始......");
    app.initialize();
    logger.i("home(主页) 模块初始化完毕！");
});