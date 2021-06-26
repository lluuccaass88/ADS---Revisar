var mongoose = require('mongoose');
var passportLocalMongoose = require('passport-local-mongoose');

var UserSchema = new mongoose.Schema({
    username: {type: String, unique:false},
    sobrenome: String,
    password: String,
    nome: String,
    telefone: Number,
    email: String,
    nascimento: Date
})

UserSchema.plugin(passportLocalMongoose);

module.exports = mongoose.model('User', UserSchema);