var http = require('http')
var fs = require('fs')

http.createServer(function (req, res) {
    var rs = fs.createReadStream('./archivo.txt');
    rs.on('open', function () {
        console.log('El archivo esta abierto.')
    });
}).listen(8080)