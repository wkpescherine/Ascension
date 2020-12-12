var http = require('http');
var dt =  require('./myfirstmodule');

http.createServer(function (req , res){
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write("Hello Node world ");
    res.write("Date and time are currently" + dt.myDateTime());
    res.end();
}).listen(8080);