package modelo;

public enum Fornecedor {
    
    RACCO(1), NATURA(2), AVON(3), JEQUETI(4);
     
    private final int valor;
    
    Fornecedor(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
   
}
