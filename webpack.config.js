const path = require('path');

module.exports = {
    entry : './src/main/webapp/js/home.js',
    output : {
        path: path.resolve(__dirname, 'src/main/webapp/dist'),
        filename: 'bundle.js'
    }
};