package model;

public class Chave {
    private int id;
    private String descricao;
    private boolean status; // true = disponível, false = emitida

    public Chave(int id, String descricao, boolean status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isStatus() {
        return status;
    }
}
