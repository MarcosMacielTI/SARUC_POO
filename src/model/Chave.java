package model;

public class Chave {
    private String idChave;
    private String descricao;
    private String status; // Ativa ou Disponível

    public Chave(String idChave, String descricao) {
        this.idChave = idChave;
        this.descricao = descricao;
        this.status = "Disponível"; // Por padrão, a chave começa como Disponível
    }

    public String getIdChave() {
        return idChave;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return idChave + " - " + descricao + " (" + status + ")";
    }
}
