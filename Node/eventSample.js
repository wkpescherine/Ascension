var events = require('events');
var eventEmitter = new events.EventEmitter();

//Create event handler here for events to be used in JS
var myEventHandler = function(){
    console.log('I hear a scream');
}

//Assign the event to the handler
eventEmitter.on('scream', myEventHandler);

//Fire the event
eventEmitter.emit('scream');