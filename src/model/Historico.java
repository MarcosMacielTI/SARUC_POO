package model;

import java.sql.Timestamp;

public class Historico {
    private int usuarioId;
    private int chaveId;
    private Timestamp horarioPegou;
    private Timestamp horarioTrouxe;

    public Historico(int usuarioId, int chaveId, Timestamp horarioPegou, Timestamp horarioTrouxe) {
        this.usuarioId = usuarioId;
        this.chaveId = chaveId;
        this.horarioPegou = horarioPegou;
        this.horarioTrouxe = horarioTrouxe;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getChaveId() {
        return chaveId;
    }

    public Timestamp getHorarioPegou() {
        return horarioPegou;
    }

    public Timestamp getHorarioTrouxe() {
        return horarioTrouxe;
    }
}
