package utils;

import model.Usuario;

public class Autenticacao {
    public boolean autenticar(Usuario usuario, String senha) {
        return usuario.getSenha().equals(senha);
    }
}
