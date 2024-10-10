package view;

public class Historico {
    private int id;
    private String laboratorio;
    private String nome;
    private String matricula;
    private String horarioPegou;
    private String horarioTrouxe;

    // Construtor
    public Historico(int id, String laboratorio, String nome, String matricula, String horarioPegou, String horarioTrouxe) {
        this.id = id;
        this.laboratorio = laboratorio;
        this.nome = nome;
        this.matricula = matricula;
        this.horarioPegou = horarioPegou;
        this.horarioTrouxe = horarioTrouxe;
    }

    // Getters
    public int getId() { return id; }
    public String getLaboratorio() { return laboratorio; }
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public String getHorarioPegou() { return horarioPegou; }
    public String getHorarioTrouxe() { return horarioTrouxe; }
}
