/**
 * Configuration for Development/Staging/Production environments
 */
var config = {
	development: {
		mode: 'development',
		port: 3000,
		mysql: {
			host: '0',
			port: 0,
			user: '',
			password: '', 
			database: '',
			multipleStatements : true
		},
	},
	staging: {
		mode: 'staging',
		port: 4000,
		mysql: {
			host: '',
			port: 0,
			user: '',
			password: '', 
			database: '',
			multipleStatements : true
		},
	},
	production: {
		mode: 'production',
		port: 5000,
		mysql: {
			host: '',
			port: 0,
			user: '',
			password: '',
			database: '',
			multipleStatements : true
		},
	}
}

/**
 * Attach to modules.
 * @param {*} mode 
 */
module.exports = function(mode) {
	return config[mode || process.argv[2] || 'development'] || config.development;
}