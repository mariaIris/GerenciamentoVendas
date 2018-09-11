package modelo;

class Produto {
    
    private int id;
    private double valor;
    private String nome;
    private int qtd;
    private Fornecedor fornecedor;

    public Produto(double valor, String nome,int qtd, Fornecedor fornecedor) {
        this.valor = valor;
        this.nome = nome;
        this.qtd = qtd;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
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

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", valor=" + valor + ", nome=" + nome + ", fornecedor=" + fornecedor + '}';
    }

    
}
