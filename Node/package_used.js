var http = require('http');
var uc = require('upper-case');

http.createServer(function (req,res){
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write(uc.upperCase('Hello This wIlL Show AS aLl UPPer case'));
    res.end();
}).listen(8080);