// 
// Utility Class
// 

// includes
var crypto = require('crypto');

// variables
var util = function(){}

// prototype name
util.prototype.projectName = 'Fish Ai';

// response data type
util.prototype.res = {
    error: 0,
    message: '',
    data:[]
}

// login channel id
util.prototype.channelId = {
    mail : 1,
    facebook : 2,
    twitter : 3,
    line : 4
}

// response status
util.prototype.resStatus =
{
    normal : 200,
    internal_error : 500
}

// create hash with sha256 encryption
util.prototype.createHashPass = function(pwd)
{
    return crypto.createHash('sha256').update(pwd, 'utf-8').digest('hex');
}

// generate token key with cipher hashcode
util.prototype.generateToken = function(tokenHash)
{
    var token =crypto.createCipher('aes192', 'fishAi').update(tokenHash, 'utf8', 'hex');
    return token;
}

// get enumeration key by value
util.prototype.getKeyName = function(prop, val)
{
    
    for(var i in prop) {
        if (prop[i] == val){
             return i;
        }
    }
    return '';
}

// export
module.exports = util;