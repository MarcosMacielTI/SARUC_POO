package controller;

import model.Chave;
import model.Usuario;
import java.util.List;

public class ControleChave {

    // Emissão de chaves - apenas chaves disponíveis
    public void emitirChave(Usuario usuario, Chave chave) {
        if (chave.getStatus().equals("Disponível")) {
            chave.setStatus("Ativa");
            System.out.println("Chave " + chave.getIdChave() + " emitida para: " + usuario.getNome());
        } else {
            System.out.println("A chave " + chave.getIdChave() + " já está em uso.");
        }
    }

    // Devolução de chaves - apenas chaves ativas
    public void devolverChave(Usuario usuario, Chave chave) {
        if (chave.getStatus().equals("Ativa")) {
            chave.setStatus("Disponível");
            System.out.println("Chave " + chave.getIdChave() + " devolvida por: " + usuario.getNome());
        } else {
            System.out.println("A chave " + chave.getIdChave() + " já está disponível.");
        }
    }

    // Listagem de chaves disponíveis
    public void listarChavesDisponiveis(List<Chave> chaves) {
        System.out.println("Chaves Disponíveis:");
        for (Chave chave : chaves) {
            if (chave.getStatus().equals("Disponível")) {
                System.out.println(chave);
            }
        }
    }

    // Listagem de chaves ativas
    public void listarChavesAtivas(List<Chave> chaves) {
        System.out.println("Chaves Ativas:");
        for (Chave chave : chaves) {
            if (chave.getStatus().equals("Ativa")) {
                System.out.println(chave);
            }
        }
    }
}
