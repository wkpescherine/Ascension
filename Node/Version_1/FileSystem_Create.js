var http = require('http');
var fs = require('fs');//This is for the ile syste CRUDRename

http.createServer( function (req,res){
    //C
    //.appendFile() allows me to append to the end of a file
    //takes filename, and text as first 2 args
    //also if file does not exist will create new file
    fs.appendFile( 'newFile1.txt', 'Hello World' , function (err){
        if (err) throw (err);
        console.log('Saved!');
    });
    //.open() creates a new file and opens is
    //this method also take one arg, "w" is for write
    fs.open('newFile2.txt', 'w', function(err, file){
        if(err) throw (err);
        console.log('Saved!!');
    });
    //.writeFile() is used to open and overwrite a previous file
    //If file does not exist it will create a new file
    fs.writeFile('newFile3.txt', 'This is a new text file', function(err){
        if(err) throw (err);
        console.log('Saved!!!');
    });
}).listen(8080);