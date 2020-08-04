// 
// Recipe Controller class
// 

// Includes
var model = require('../models/recipe');
var ERRUtil = require('./../lib/errorutil.js');
var Util = require('./../lib/util.js');
var ReqUtil = require('request');

// variables
var util = new Util();

/**
 * New user registration
 * @param {*} req 
 * @param {*} res 
 */
exports.register = (req, res) => {	

    // Initialize
    // Get return type data
    var ret = util.res;
    // Get locale string
    var lang = String(req.body.ln || 'ja').slice(0,2);
    // Load error object according to locale
    var errcodes = new ERRUtil(lang);

    // Create connection
    req.getConnection(function (err, connection) {
        // if error 
        if(err)
        {
            // retrun databse conneection error
            ret.error = util.getKeyName(errcodes, errcodes.ERRDTB001);
            ret.message = errcodes.ERRDTB001;
            res.send(ret);
            return 
        }
        else{
            // if connection success

            // Get post data 
            var data =
            {
                'id':'',
                'title' : req.body.title,
                'making_time' : req.body.making_time,
                'serves' : req.body.serves,
                'ingredients' : req.body.ingredients,
                'cost' : req.body.cost,
                'created_at' :'',
                'updated_at': '',
                'error_codes' : errcodes,
            };

            if(data.title == '' || data.making_time == '' || data.serves == '' || data.ingredients == '' || data.cost == ''){
    
                var retBody = {
                    message: 'Recipe creation failed!',
                    required: 'title, making_time, serves, ingredients, cost'
                };
        
                res.send(JSON.stringify(retBody));
                return

            }else{
                
                // call registration process
                model.addrecipe(connection,data, req, function(data){
                    // return response
                    var retBody = {
                        message: 'Recipe successfully created!',
                        recipe:{
                            'id': ret.data.id,
                            'title' :ret.data.title,
                            'making_time' : ret.data.making_time,
                            'serves' : ret.data.serves,
                            'ingredients' : ret.data.ingredients,
                            'cost' : ret.data.cost,
                            'created_at' : ret.data.created_at,
                            'updated_at': ret.data.updated_at,
                        } 
                    };
            
                    res.send(JSON.stringify(retBody));
                    return
                })

            }
            
        }
    });
           
};


/**
 * New user registration
 * @param {*} req 
 * @param {*} res 
 */
exports.getall = (req, res) => {	

    // Initialize
    // Get return type data
    var ret = util.res;
    // Get locale string
    var lang = String(req.body.ln || 'ja').slice(0,2);
    // Load error object according to locale
    var errcodes = new ERRUtil(lang);

    // Create connection
    req.getConnection(function (err, connection) {
        // if error 
        if(err)
        {
            // retrun databse conneection error
            ret.error = util.getKeyName(errcodes, errcodes.ERRDTB001);
            ret.message = errcodes.ERRDTB001;
            res.send(ret);
            return 
        }
        else{
            // if connection success

            // Get post data 
            var data =
            {
                'id':req.params.id,
                'error_codes' : errcodes,
            };

            // call registration process
            model.getallreceipes(connection,data, req, function(data){
                // return response
                var retBody = {
                    recipe: ret.data,
                };
        
                res.send(JSON.stringify(retBody));
                return
            })

            
        }
    });
           
};



/**
 * New user registration
 * @param {*} req 
 * @param {*} res 
 */
exports.update = (req, res) => {	

    // Initialize
    // Get return type data
    var ret = util.res;
    // Get locale string
    var lang = String(req.body.ln || 'ja').slice(0,2);
    // Load error object according to locale
    var errcodes = new ERRUtil(lang);

    // Create connection
    req.getConnection(function (err, connection) {
        // if error 
        if(err)
        {
            // retrun databse conneection error
            ret.error = util.getKeyName(errcodes, errcodes.ERRDTB001);
            ret.message = errcodes.ERRDTB001;
            res.send(ret);
            return 
        }
        else{
            // if connection success

            // Get post data 
            var data =
            {
                'id':req.params.id,
                'title' : req.body.title,
                'making_time' : req.body.making_time,
                'serves' : req.body.serves,
                'ingredients' : req.body.ingredients,
                'cost' : req.body.cost,
                'error_codes' : errcodes,
            };

            // call registration process
            model.getallreceipes(connection,data, req, function(data){
                // return response
                var retBody = {
                    message:'Recipe successfully updated!',
                    recipe: data.data,
                };
        
                res.send(JSON.stringify(retBody));
                return
            })

            
        }
    });
           
};



/**
 * New user registration
 * @param {*} req 
 * @param {*} res 
 */
exports.delete = (req, res) => {	

    // Initialize
    // Get return type data
    var ret = util.res;
    // Get locale string
    var lang = String(req.body.ln || 'ja').slice(0,2);
    // Load error object according to locale
    var errcodes = new ERRUtil(lang);

    // Create connection
    req.getConnection(function (err, connection) {
        // if error 
        if(err)
        {
            // retrun databse conneection error
            ret.error = util.getKeyName(errcodes, errcodes.ERRDTB001);
            ret.message = errcodes.ERRDTB001;
            res.send(ret);
            return 
        }
        else{
            // if connection success

            // Get post data 
            var data =
            {
                'id':req.params.id,
                'error_codes' : errcodes,
            };


            // call registration process
            model.getreceipes(connection,data, req, function(data){
                // return response
                var retBody = {
                    message:'No Recipe found',
                };


                if(ret.data.length<=0){
                    res.send(JSON.stringify(retBody));
                    return
                }else{

                    var data1 =
                    {
                        'id':req.params.id,
                        'error_codes' : errcodes,
                    };
                    // call registration process
                    model.deleterecipe(connection,data1, function(data){
                        // return response
                        var retBody1= {
                            message:'Recipe successfully removed!',
                        };
                
                        res.send(JSON.stringify(retBody1));
                        return
                    })


                }
        
                return

            })
            
                        
        }
    });
           
};


/**
 * New user registration
 * @param {*} req 
 * @param {*} res 
 */
exports.getrecipe = (req, res) => {	

    // Initialize
    // Get return type data
    var ret = util.res;
    // Get locale string
    var lang = String(req.body.ln || 'ja').slice(0,2);
    // Load error object according to locale
    var errcodes = new ERRUtil(lang);

    // Create connection
    req.getConnection(function (err, connection) {
        // if error 
        if(err)
        {
            // retrun databse conneection error
            ret.error = util.getKeyName(errcodes, errcodes.ERRDTB001);
            ret.message = errcodes.ERRDTB001;
            res.send(ret);
            return 
        }
        else{
            // if connection success

            // Get post data 
            var data =
            {
                'id':req.params.id,
                'error_codes' : errcodes,
            };

            // call registration process
            model.getreceipes(connection,data, req, function(data){
                // return response
                var retBody = {
                    message: "Recipe details by id",
                    recipe: ret.data,
                };
        
                res.send(JSON.stringify(retBody));
                return
            })

            
        }
    });
           
};
