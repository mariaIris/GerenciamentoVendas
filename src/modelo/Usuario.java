package modelo;

import java.util.ArrayList;


public class Usuario {
    
    private int id;
    private String nome;
    private ArrayList<Cliente> meusCliente;

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cliente> getMeusCliente() {
        return meusCliente;
    }

    public void setMeusCliente(ArrayList<Cliente> meusCliente) {
        this.meusCliente = meusCliente;
    }   
}
