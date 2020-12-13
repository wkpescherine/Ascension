var http = require('http');
var fs = require('fs');

http.createServer( function(req,res){
    //.unlink() will wedelete the file that is called
    fs.unlink( 'newFile2.txt', function (err){
        if (err) throw err;
        console.log('File deleted');
    });
    //.rename() renames the file to the name indicated in the method
    fs.rename( 'newFile1.txt', 'anotherFilename.txt', function (err){
        if (err) throw err;
        console.log('File renamed');
    });
}).listen(8080);