const path = require('path');

module.exports = {
    entry : path.resolve(__dirname, './src/main/webapp/js/main.js'),
    output : {
        path: path.resolve(__dirname, 'src/main/webapp/dist'),
        filename: 'main.js'
    },
    module: {
        loaders: [{
            test: /\.js?$/,
            exclude: /node_modules/,
            loader: 'babel-loader',
            query: {
                presets: ['es2015','react']
            }
        }]
    }
};