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
        }
    },
    paths : {
        jquery: 'js/jquery-1.9.1.min',
        json: 'js/json2',
        underscore : 'js/underscore-min',
        text : 'js/text',
        backbone : 'js/backbone-min',
        partials: 'partials',                         //模板根目录
        logger: 'js/logger',
        base_config: 'common/base'
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