// 
// Recipe Model class
// 

// includes
var Util = require('./../lib/util.js');
var fs = require('fs');

// Variables
var util = new Util();

/**
 * Add Recipe
 * @param {*} connection 
 * @param {*} callback 
 */
exports.addrecipe = (connection, data, req, callback) => 
{

    // Initialize
   // Get error codes
    var errcode = data.error_codes;
    // Get Time
    var nowTime = new Date();
    

    // Get return type data
    var ret = util.res;

    // Insert upload data
    // Insert fields
    var insfields = {
        'title' : data.title || 1,
        'making_time' : data.making_time || 0 ,
        'serves' : data.serves || 0 ,
        'ingredients' : data.ingredients || 0 ,
        'cost' : data.cost || 0 ,
    };

    // Insert query
    var insqry = `INSERT INTO recipes SET ?; `
    var recordId = "";
    // Call insert query
    connection.query(insqry, insfields, function (error, results, fields) {
        // if error
        if(error){
            // return db processing error
            ret.error = util.getKeyName(errcode, errcode.ERRDTB002);
            ret.message = errcode.ERRDTB002;
            return callback(ret);
        } else {
            // return success
            // Get UserId
            recordId = results.insertId;
            data.id = recordId;
            data.created_at = nowTime;
            data.updated_at = nowTime;
            ret.error = util.getKeyName(errcode, errcode.ERR000000);
            ret.message = errcode.ERR000000;
            ret.data = data;
            return callback(ret);
        }
    });
    
}


/**
 * Get All points
 * @param {*} connection 
 * @param {*} callback 
 */
exports.getallreceipes = (connection, data, req, callback) => 
{

    // Initialize
    // Get error codes
    var errcode = data.error_codes;
    
    // Get return type data
    var ret = util.res;

    // Query
    var qry = `SELECT id, title, making_time, serves, ingredients, cost from recipes;`
    // Call query
    connection.query(qry, function (error, results, fields) {
        // if error
        if(error){
            // return db processing error
            ret.error = util.getKeyName(errcode, errcode.ERRDTB002);
            ret.message = errcode.ERRDTB002;
            return callback(ret);
        } 
        // if success
        else {
            // return success + data
            ret.error = util.getKeyName(errcode, errcode.ERR000000);
            ret.message = errcode.ERR000000;
            ret.data = results
            return callback(ret);
        }
    });
    
}

/**
 * Get All points
 * @param {*} connection 
 * @param {*} callback 
 */
exports.getreceipes = (connection, data, req, callback) => 
{

    // Initialize
    // Get error codes
    var errcode = data.error_codes;
    
    // Get return type data
    var ret = util.res;

    // Query
    var qry = `SELECT id, title, making_time, serves, ingredients, cost from recipes where id = ${data.id};`
    // Call query
    connection.query(qry, function (error, results, fields) {
        // if error
        if(error){
            // return db processing error
            ret.error = util.getKeyName(errcode, errcode.ERRDTB002);
            ret.message = errcode.ERRDTB002;
            return callback(ret);
        } 
        // if success
        else {
            // return success + data
            ret.error = util.getKeyName(errcode, errcode.ERR000000);
            ret.message = errcode.ERR000000;
            ret.data = results
            return callback(ret);
        }
    });
    
}

/**
 * Update Reciepes
 * @param {*} connection 
 * @param {*} callback 
 */
exports.updaterecipe = (connection, data,  req, callback) => 
{

    // Initialize
    // Get error codes
    var errcode = data.error_codes;
        
    // Get return type data
    var ret = util.res;

    // update password
    // Prepare query
    var qry = `update recipes set title = '${data.title}', making_time='${data.making_time}', serves='${data.serves}', ingredients='${data.ingredients}', cost='${data.cost}' where id = ${data.id} ;`
    // Call query
    connection.query(qry, function (error, results, fields) {
        // if error
        if(error){
            // return db process error
            ret.error = util.getKeyName(errcode, errcode.ERRDTB002);
            ret.message = errcode.ERRDTB002;
            return callback(ret);
        } 
        // if success
        else {
            // return data
            ret.error = util.getKeyName(errcode, errcode.ERR000000);
            ret.message = errcode.ERR000000;
            ret.data = data;
            return callback(ret);
        }
    });
   
}



/**
 * Delete Reciepes
 * @param {*} connection 
 * @param {*} callback 
 */
exports.deleterecipe = (connection, data,  callback) => 
{

    // Initialize
    // Get error codes
    var errcode = data.error_codes;
    // Get return type data
    var ret = util.res;

    // update password
    // Prepare query
    var qry = `delete from recipes where id = ${data.id} ;`
    // Call query
    connection.query(qry, function (error, results, fields) {
        // if error
        if(error){
            // return db process error
            ret.error = util.getKeyName(errcode, errcode.ERRDTB002);
            ret.message = errcode.ERRDTB002;
            return callback(ret);
        } 
        // if success
        else {
            // return data
            ret.error = util.getKeyName(errcode, errcode.ERR000000);
            ret.message = errcode.ERR000000;
            return callback(ret);
        }
    });
   
}


