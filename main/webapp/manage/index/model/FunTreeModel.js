define([
    'jquery',
    'underscore',
    'backbone'
], function ($, _, Backbone) {
    return Backbone.Model.extend({
        defaults:{

        },
        validate:function (attrs) {
        },
        url:"/queryFunTree.do?"+Math.random()
    });
}); 