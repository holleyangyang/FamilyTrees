require.config({
    urlArgs:"123",
    baseUrl: "js",

	// alias js_libraries paths
    paths: {
        'angular': 'angular',
        'angularAMD': 'angularAMD',   //requireJS鍦╝ngular涓簲鐢ㄦ彃浠�
        'angular-route': 'angular-route',   //angular 璺敱鎻掍欢
        'angular-animate':'angular-animate',    //angular鍔ㄧ敾鎻掍欢锛屾湰娆℃湭浣跨敤
        'ui-bootstrap': 'ui-bootstrap-tpls-0.10.0.min',   //bootstrap鏁堟灉绫诲簱锛屾湰娆℃湭浣跨敤
        'jquery': 'jquery-1.9.1.min'
    },

    // Add angular modules that does not support AMD out of the box, put it in a shim
    shim: {
        'angularAMD': ['angular'],
        'angular-animate': ['angular'],
        'angular-route': ['angular'],
        'angular-touch':['angular'],
        'ui-bootstrap':['angular']
    }

    // kick start application
    /*deps: ['app']*/
});
require(['app'])
