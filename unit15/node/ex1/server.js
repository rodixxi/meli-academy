var http = require('http')
var rs = require('./module')
var url = require('url')

http.createServer(function (req, res) {
    var q = url.parse(req.url, true).query;
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write('Hola ' + q.nombre + ' ' + q.apellido);
    res.end('Hola ' + rs.razonSocial());
}).listen(8080)