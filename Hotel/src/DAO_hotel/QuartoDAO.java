package DAO_hotel;

import Classes_hotel.Cliente;
import Classes_hotel.Quarto;
import Conexao.util.Conexao;

import java.sql.*;
import java.util.ArrayList;

public class QuartoDAO {


    private Connection conn;
    public QuartoDAO() {
        try{
            this.conn = Conexao.getConnection();
        }catch(Exception e){
            System.out.println(e.getMessage());;
        }
    }

    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList lista = new ArrayList();

        try {
            String SQL = "SELECT id_quarto, capacidade_maxima, tamanho_quarto, descricao FROM quarto";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_quarto = rs.getInt("id_quarto");
                int capacidade_maxima = rs.getInt("capacidade_maxima");
                int tamanho_quarto = rs.getInt("tamanho_quarto");
                String descricao = rs.getString("descricao");


                lista.add(new Quarto(id_quarto, capacidade_maxima, tamanho_quarto, descricao));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }

        return lista;
    }

    public void inserir(Quarto quarto) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (quarto == null){
            System.out.println("O objeto quarto não pode ser nulo.");
        }
        try{
            String SQL = "INSERT INTO quarto (capacidade_maxima, tamanho_quarto, descricao) " +
                    "values (?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, quarto.getCapacidade_maxima());
            ps.setInt(2, quarto.getTamanho_quarto());
            ps.setString(3, quarto.getDescricao());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao inserir um novo quarto" + sqle);
        }
        finally{
            Conexao.close(connL,ps);
        }
    }

    public Quarto procurar(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Quarto quarto = new Quarto();
        quarto = null;

        try{
            String SQL = "SELECT id_quarto, capacidade_maxima, tamanho_quarto, descricao FROM quarto WHERE id_quarto = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();


            while( rs.next()){
                int id_quarto = rs.getInt("id_quarto");
                int capacidade_maxima = rs.getInt("capacidade_maxima");
                int tamanho_quarto = rs.getInt("tamanho_quarto");
                String descricao = rs.getString("descricao");

                quarto = new Quarto(id_quarto, capacidade_maxima, tamanho_quarto, descricao);

            }



        }catch(SQLException sqle){
            System.out.println("Erro ao procurar quarto " + sqle);
        }
        finally{
            // ConexaoAulaDAO.close(connL,ps);
        }
        return quarto;
    }

    public void excluir(int quarto){
        PreparedStatement ps = null;
        Connection connL = null;
        //if (quarto == null){
        //    System.out.println("O objeto quarto não pode ser nulo.");
        //}

        try{
            String SQL = "DELETE FROM quarto WHERE id_quarto=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, quarto);
            ps.executeUpdate();
        }catch(SQLException sqle){
            System.out.println("Erro ao excluir quarto " + sqle);
        }
        finally{
            Conexao.close(connL,ps);
        }
    }

    public void atualizar(Quarto quarto) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (quarto == null){
            System.out.println("O objeto quarto não pode ser nulo.");
        }

        try{
            String SQL = "UPDATE quarto set capacidade_maxima=?, tamanho_quarto=?, descricao=? WHERE id_quarto=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, quarto.getCapacidade_maxima());
            ps.setInt(2, quarto.getTamanho_quarto());
            ps.setString(3, quarto.getDescricao());
            
            ps.setInt(4, quarto.getId_quarto());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao editar quarto " + sqle);
        }
        finally{
            Conexao.close(connL,ps);
        }
    }
}
