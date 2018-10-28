package modelo;

import java.util.Date;
import java.util.Objects;

public class Cliente {
    
    private int id;
    private String nome;
    private String cpf;
    private String contato;
    private Date cadastro;
    private Date nasc;
    //private ArrayList<Sacola> minhaSacola;

    public Cliente(String nome, String cpf, String contato, Date cadastro, Date nasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.cadastro = cadastro;
        this.nasc = nasc;
    }
    
    public Cliente(String nome, String cpf, Date cadastro, Date nasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.cadastro = cadastro;
        this.nasc = nasc;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public Date getNasc() {
        return nasc;
    }

    public void setNasc(Date nasc) {
        this.nasc = nasc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", contato=" + contato + ", cadastro=" + cadastro + ", nasc=" + nasc + '}';
    }
    
    
}
