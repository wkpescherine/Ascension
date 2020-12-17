var http = require('http');
var fs = require('fs');//This is for the ile syste CRUDRename

http.createServer( function (req,res){
    fs.readFile( 'demofile1.html', function(err, data){
        res.writeHead(200, {'Content-Type':'text/html'});
        res.write(data);
        return res.end();
    });
}).listen(8080);