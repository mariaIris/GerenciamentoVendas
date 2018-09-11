package modelo;

import java.util.ArrayList;

class Cliente {
    
    private int id;
    private String nome; 
    private String telefone;
    private ArrayList<Sacola> minhaSacola;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
   
    public ArrayList<Sacola> getMinhaSacola() {
        return minhaSacola;
    }

    public void setMinhaSacola(ArrayList<Sacola> minhaSacola) {
        this.minhaSacola = minhaSacola;
    }
    
}
