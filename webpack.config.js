const path = require('path');

var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
    entry : {
        bundle : path.resolve(__dirname, './src/main/webapp/js/main.js'),
        styles : path.resolve(__dirname, './src/main/webapp/css/main.js')
    },
    output : {
        path: path.resolve(__dirname, 'src/main/webapp/dist/'),
        filename: '[name].js',
        library: 'home'
    },
    //devtool : "source-map",
    module: {
        rules: [
            {
                test: /\.less/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: ['css-loader', 'less-loader']
                })
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                query: {
                    presets: ['es2015','react']
                }
            }
        ]
    },
    plugins: [
        new ExtractTextPlugin('style.css')
    ]
};