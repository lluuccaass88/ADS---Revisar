const mongoose = require('mongoose');

let PostSchema = new mongoose.Schema({
    title: String,
    image: String,
    text: String, 
    comments: [{ text: String, name: String, dateComments:{type: Date, default: Date.now}}],
    data: {type: Date, default: Date.now}
})

module.exports = mongoose.model('Post', PostSchema)