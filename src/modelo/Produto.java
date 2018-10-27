package modelo;

public class Produto {
    
    private int id;
    private double valor;
    private String nome;
    private String marca;
    private int qtd;

    public Produto(double valor, String nome, String marca, int qtd) {
        this.valor = valor;
        this.nome = nome;
        this.marca = marca;
        this.qtd = qtd;
    }

    public Produto(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", valor=" + valor + ", nome=" + nome + '}';
    }

    
}
