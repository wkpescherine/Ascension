var fs = require('fs');
var rs = fs.createReadStream('./newFile3.txt');
var events = require('events');
var eventEmitter = new events.EventEmitter();

rs.on('open', function(){
    console.log('This file is now open');
})