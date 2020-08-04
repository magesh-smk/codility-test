/**
 * App.js
 * Main module for this project
 */
var express = require('express')
var app = express()

var mysql = require('mysql2')

/**
 * Load the Configuration file/module and its values
 */
var config = require('./config')('development');
app.set('config', config);

/**
 * This middleware provides a consistent API 
 * for MySQL connections during request/response life cycle
 */ 
var myConnection  = require('express-myconnection')
var dbOptions = config.mysql
/**
 * 3 strategies can be used
 * single: Creates single database connection which is never closed.
 * pool: Creates pool of connections. Connection is auto release when response ends.
 * request: Creates new connection per new request. Connection is auto close when response ends.
 */ 
app.use(myConnection(mysql, dbOptions, 'pool'))

/**
 * Express Validator Middleware for Form Validation
 */ 
var expressValidator = require('express-validator')
app.use(expressValidator())

/**
 * body-parser module is used to read HTTP POST data
 * it's an express middleware that reads form's input 
 * and store it as javascript object
 */ 
var bodyParser = require('body-parser')

/**
 * bodyParser.urlencoded() parses the text as URL encoded data 
 * (which is how browsers tend to send form data from regular forms set to POST) 
 * and exposes the resulting object (containing the keys and values) on req.body.
 */ 
//app.use(bodyParser.urlencoded({ extended: true }))
//app.use(bodyParser.json())

app.use( bodyParser.json({limit: '50mb'}) );
app.use(bodyParser.urlencoded({
  limit: '50mb',
  extended: true,
  parameterLimit:999999999
}));

/**
 * This module let us use HTTP verbs such as PUT or DELETE 
 * in places where they are not supported
 */ 
var methodOverride = require('method-override')

/**
 * using custom logic to override method
 * 
 * there are other ways of overriding as well
 * like using header & using query value
 */ 
app.use(methodOverride(function (req, res) {
  if (req.body && typeof req.body === 'object' && '_method' in req.body) {
    // look in urlencoded POST bodies and delete it
    var method = req.body._method
    delete req.body._method
    return method
  }
}))

/**
 * Dynamically includes the controller files 
 */
var fs = require('fs')
fs.readdirSync('./controllers/router/').forEach(function (file) {
  if(file.substr(-3) == '.js') {
      route = require('./controllers/router/' + file);
      route.controller(app)
  }
})

/**
 * Port enviroment variable is used in proceeding module.
 */
app.set('port', process.env.PORT || config.port );

/**
 * Server will listen at the specified port
 */
app.listen(app.get('port'), function(){
	console.log(`Server running at port : ${app.get('port')}`)
})