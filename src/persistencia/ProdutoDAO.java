/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Produto;

/**
 *
 * @author MariaI
 */
public class ProdutoDAO {
    private Conexao con = new Conexao();
    
    private final String INSERTPRODUTO = "INSERT INTO PRODUTO ( VALOR, NOME, MARCA, QTD) VALUES (?,?,?,?)";
    private final String UPDATEPRODUTO = "UPDATE PRODUTO SET VALOR = ?, NOME = ?, MARCA = ?, QTD = ? WHERE ID_PRODUTO = ?";
    private final String DELETEPRODUTO = "DELETE PRODUTO FROM PRODUTO WHERE ID_PRODUTO = ?";
    private final String LISTPRODUTO = "SELECT * FROM PRODUTO ORDER BY NOME";
    private final String BUSCARPRODUTO = "SELECT * FROM PRODUTO WHERE PRODUTO WHERE UPPER(NOME) LIKE ? ORDER BY NOME";
    
    public boolean insertUsuario (Produto p){
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTPRODUTO);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setDouble(1, p.getValor());
            preparaInstrucao.setString(2, p.getNome().toUpperCase());
            preparaInstrucao.setString(3, p.getMarca().toUpperCase());
            preparaInstrucao.setInt(4, p.getQtd());

            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();

            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateProduto(Produto p){
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEPRODUTO);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setDouble(1, p.getValor());
            preparaInstrucao.setString(2, p.getNome());
            preparaInstrucao.setString(3, p.getMarca());
            preparaInstrucao.setInt(4, p.getQtd());
            
             // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();

            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteProduto(Produto p){
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETEPRODUTO);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setDouble(1, p.getValor());
            preparaInstrucao.setString(2, p.getNome());
            preparaInstrucao.setString(3, p.getMarca());
            preparaInstrucao.setInt(4, p.getQtd());
            
             // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();

            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Produto> listProduto() {
        ArrayList<Produto> lista = new ArrayList<>(); 

        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTPRODUTO); 

            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery(); 

            //TRATA O RETORNO DA CONSULTA
            while (rs.next()) { //enquanto houver registro
                Produto p = new Produto(rs.getDouble("VALOR"), rs.getString("NOME"), rs.getString("MARCA"), rs.getInt("QTD"));
                lista.add(p); 
            }
            // DESCONECTA
            con.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Collections.sort(lista);
        return lista;
    }
    
    public ArrayList<Produto> buscarProduto(String nomeProduto) {
        ArrayList<Produto> lista = new ArrayList<>(); 

        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(BUSCARPRODUTO); 
            
            //SETA OS VALORES DA INSTRUCAO
            //OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setString(1, "%"+nomeProduto.toUpperCase()+"%");

            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery(); 

            //TRATA O RETORNO DA CONSULTA
            while (rs.next()) { //enquanto houver registro
                Produto p = new Produto(rs.getDouble("VALOR"), rs.getString("NOME"), rs.getString("MARCA"), rs.getInt("QTD"));
                lista.add(p); 
            }
            // DESCONECTA
            con.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Collections.sort(lista);
        return lista;
    }
}
