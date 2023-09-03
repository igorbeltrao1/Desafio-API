package com.pactomais.api.model.enun;

public enum TipoOperacao {
	
	COMPRA_A_VISTA(1, "Compra a vista"),
    COMPRA_PARCELADA(2, "Compra parcelada"),
    SAQUE(3, "Saque "),
    PAGAMENTO(4, "Pagamento");

    private final int id;
    private final String descricao;

    public int getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    private TipoOperacao(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
