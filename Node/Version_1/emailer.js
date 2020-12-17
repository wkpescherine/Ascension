var nodemailer = require('nodemailer');

var transporter = nodemailer.createTransport({
    service:'gmail',
    auth:{
        user:'wkpescherine3@gmail.com',
        pass:'austin@16'
    }
});

var mailOptions = {
    from:'wkpescherine3@gmail.com',
    to:'wpescherine@gmail.com',
    subject:'Test Email',
    text: 'This is a test email'
};

transporter.sendMail( mailOptions, function(error , info){
    if (error){
        console.log(error);
    }
    else{
        console.log('Email sent: ' + info.response);
    }

});