var mongoose = require('mongoose');

var PedidoSchema = new mongoose.Schema({
    rua: String,
    numero_casa: Number,
    bairro: String,
    cep: String,
    pagamento: Number,
    estado: String,
    idUsuario: String,
    descricao: String,
    data: {type: Date, default: Date.now}
})

module.exports = mongoose.model('Pedido', PedidoSchema);