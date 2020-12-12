var http = require('http');
var fs = require('fs');

http.createServer(function (req , res){
    //U
    //.appendFile() to update the previously created file
    //will append to the end of the file
    fs.appendFile('newFile1.txt', 'This is new content added', function(err){
        if(err) throw(err);
        console.log('Updated!');
    });
    //U - replace
    //.writeFile() will take the preexisting file
    //Then we will overwrite it to what we pass into ti
    fs.writeFile('newFile3.txt', 'This is the text that replaces it', function (err){
        if(err) throw (err);
        console.log('Replaced!');
    });
}).listen(8080);