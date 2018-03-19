const path = require('path');
const webpack = require('webpack');
const merge = require('webpack-merge');

const ExtractTextPlugin = require('extract-text-webpack-plugin');
const EncodingPlugin = require('webpack-encoding-plugin');

const TARGET = process.env.npm_lifecycle_event;
const PATHS = {
    source: path.resolve(__dirname, './src/main/webapp/js/main.js'),
    output: path.resolve(__dirname, 'src/main/webapp/dist/'),
};

const baseConfig = {
    entry: PATHS.source,
    output : {
        path: PATHS.output,
        filename: '[name].js',
    },
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
        new EncodingPlugin({encoding: 'UTF-16'})
    ]

};

const devConfig = {
    devtool: 'source-map',
    devServer: {
        port: 9090,
        proxy: {
            '/': {
                target: 'http://localhost:8080',
                secure: false,
                prependPath: false
            }
        },
    historyApiFallback: true,
    publicPath: 'http://localhost:9090/dist/',
    },
};

if (TARGET === 'start') {
    module.exports = merge(baseConfig, devConfig);
}

if (TARGET === 'build' || !TARGET) {
    module.exports = merge(baseConfig, {});
}
