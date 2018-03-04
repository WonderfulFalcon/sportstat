const path = require('path');
const webpack = require('webpack');

var ExtractTextPlugin = require('extract-text-webpack-plugin');
var EncodingPlugin = require('webpack-encoding-plugin');

module.exports = {
    entry : {
        bundle : path.resolve(__dirname, './src/main/webapp/js/main.js')
    },
    output : {
        path: path.resolve(__dirname, 'src/main/webapp/dist/'),
        filename: '[name].js',
        library: 'home'
    },
    devtool : "source-map",
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
            },
            {
                test: /\.json$/,
                loader: 'json-loader'
            }
        ]
    },
    plugins: [
        new ExtractTextPlugin('style.css'),
        new webpack.HotModuleReplacementPlugin(),
        new EncodingPlugin({encoding: 'UTF-16'})
    ]
};