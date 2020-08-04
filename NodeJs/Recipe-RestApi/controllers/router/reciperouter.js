
// 
// Recipe router class
// 

module.exports.controller = function(app) {
    
    // Includes
    const base = require('../recipecontroller.js');
 
    // Add recipe
    app.post('/recipes', base.register);

    // Get list of recipe
    app.get('/recipes', base.getall);

    // Get recipe
    app.get('/recipes/:id', base.getrecipe);

    // update recipe
    app.patch('/recipes/:id', base.update);

    // delete recipe
    app.delete('/recipes/:id', base.delete);


}