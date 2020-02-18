package com.softma.pedidos.entities.enums;

public enum StatusPedido {

    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGE(4),
    CANCELADO(5);

    private int code;

    private StatusPedido (int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static StatusPedido valorDe(int code){
        for(StatusPedido valor : StatusPedido.values()){
            if (valor.getCode() == code)
                return valor;
        }
        throw new IllegalArgumentException("Codigo de Status do Pedido Invalido");

    }
}
