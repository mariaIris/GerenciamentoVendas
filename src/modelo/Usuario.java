package modelo;

import java.util.ArrayList;


public class Usuario {
   
    private int id;
    private String nome;
    private String contato;
    private String cpf;

    public Usuario(String nome, String contato, String cpf) {
        this.nome = nome;
        this.contato = contato;
        this.cpf = cpf;
    }
    
    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
