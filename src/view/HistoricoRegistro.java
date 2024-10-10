package view;

public class HistoricoRegistro {
    private String laboratorio;
    private String nome;
    private String matricula;
    private String horarioPegou;
    private String horarioTrouxe;
    private String dataDeDevolucao;
    private String descricao;

    public HistoricoRegistro(String laboratorio, String nome, String matricula, String horarioPegou, String horarioTrouxe, String dataDeDevolucao) {
        this.laboratorio = laboratorio;
        this.nome = nome;
        this.matricula = matricula;
        this.horarioPegou = horarioPegou;
        this.horarioTrouxe = horarioTrouxe;
        this.dataDeDevolucao = dataDeDevolucao;
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getLaboratorio() {
        return laboratorio;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getHorarioPegou() {
        return horarioPegou;
    }

    public String getHorarioTrouxe() {
        return horarioTrouxe;
    }

    public String getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setHorarioTrouxe(String horarioTrouxe) {
        this.horarioTrouxe = horarioTrouxe;
    }
}

