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
        url:"/queryFunTree.act?"+Math.random()
    });
}); 