
package modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class Sacola {
   
    private int id;
    private int qtd;
    private double valorCompra;
    private String dataPagamento;
    private String dataCompra;
    private ArrayList<Produto> minhaSacola;

    public Sacola(int qtd, double valorCompra, ArrayList<Produto> minhaSacola) {
        this.qtd = qtd;
        this.valorCompra = valorCompra;
        this.minhaSacola = minhaSacola;
    }

    public int getId() {
        return id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento() {
        
        Calendar data = Calendar.getInstance();
        data.add(Calendar.DATE, +30);
        
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy"); 
        dataPagamento = formatarDate.format(data);
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra() {
        Calendar data = Calendar.getInstance(); 
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy"); 
        dataCompra = formatarDate.format(data);
    }

    public ArrayList<Produto> getMinhaSacola() {
        return minhaSacola;
    }

    public void setMinhaSacola(ArrayList<Produto> minhaSacola) {
        this.minhaSacola = minhaSacola;
    }

   
}
