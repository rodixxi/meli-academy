var http = require('http')
var fs = require('fs')
var events = require('events')
var eventEmmiter = new events.EventEmitter();

var hadler = function () {
    console.log('Se disparo el evento.');
}

eventEmmiter.on('evento', hadler);

http.createServer(function (req, res) {
    eventEmmiter.emit('evento');
    res.end();
}).listen(8080)