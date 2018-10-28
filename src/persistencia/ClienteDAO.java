/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
/**
 *
 * @author MariaI
 */
public class ClienteDAO {
    private Conexao con = new Conexao();
    
    private final String INSERTCLIENTE = "INSERT INTO CLIENTE INTO CLIENTE (NOME, CPF, CONTATO, CADASTRO, NASC)";
    private final String UPDATECLIENTE = "UPDATE CLIENTE SET NOME = ?, CPF = ?, CONTATO = ?, CADASTRO = ?, NASC = ? WHERE ID_CLIENTE";
    private final String DELETECLIENTE = "DELETE CLIENTE SET FROM CLIENTE WHRE ID_CLIENTE = ? ";
    private final String LISTCLIENTE = " SELECT * FROM CLIENTE ORDER BY NOME";
    private final String BUSCARCLIENTE = "SELECT * FROM CLIENTE WHERE UPPER (NOME) LIKE ? ORDER BY NOME";
    
    public boolean insertCliente(Cliente c) {
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTCLIENTE);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setString(1, c.getNome().toUpperCase());
            preparaInstrucao.setString(2, c.getCpf());
            preparaInstrucao.setDate(3, (Date) c.getCadastro());
            preparaInstrucao.setDate(4, (Date) c.getNasc());

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
    
    public boolean updateCliente(Cliente c) {
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATECLIENTE);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setString(1, c.getNome().toUpperCase());
            preparaInstrucao.setString(2, c.getCpf());
            preparaInstrucao.setDate(3, (Date) c.getCadastro());
            preparaInstrucao.setDate(4, (Date) c.getNasc());

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
    
    public boolean deleteCliente(int idCliente) {
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETECLIENTE);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1, idCliente);

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
    
    public ArrayList<Cliente> listCliente() {
        ArrayList<Cliente> lista = new ArrayList<>(); 

        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTCLIENTE); 

            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery(); 

            //TRATA O RETORNO DA CONSULTA
            while (rs.next()) { //enquanto houver registro
               Cliente c = new Cliente(rs.getString("NOME"), rs.getString("CPF"), rs.getDate("CADASTRO"),rs.getDate("NASC"));
                lista.add(c);
            }
            // DESCONECTA
            con.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Collections.sort(lista);
        return lista;
    }
    
    public ArrayList<Cliente> buscarCliente(String nomeCliente) {
        ArrayList<Cliente> lista = new ArrayList<>(); 

        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(BUSCARCLIENTE); 

            //SETA OS VALORES DA INSTRUCAO
            //OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setString(1, "%"+nomeCliente.toUpperCase()+"%");

            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery(); 

            //TRATA O RETORNO DA CONSULTA
            while (rs.next()) { //enquanto houver registro
                Cliente c = new Cliente(rs.getString("NOME"), rs.getString("CPF"), rs.getDate("CADASTRO"),rs.getDate("NASC"));
                lista.add(c); 
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
