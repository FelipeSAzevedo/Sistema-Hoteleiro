package DAO_hotel;

import Classes_hotel.Reserva;
import Conexao.util.Conexao;

import java.sql.*;
import java.util.ArrayList;

public class ReservaDAO {


    private Connection conn;

    public ReservaDAO() {
        try {
            this.conn = Conexao.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList lista = new ArrayList();

        try {
            String SQL = "SELECT id_reserva, id_quarto, id_cliente, nome_cliente, data FROM reserva";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_reserva = rs.getInt("id_reserva");
                int id_quarto = rs.getInt("id_quarto");
                int id_cliente = rs.getInt("id_cliente");
                String nome_cliente = rs.getString("nome_cliente");
                Date data = rs.getDate("data");

                lista.add(new Reserva(id_reserva, id_quarto, id_cliente, nome_cliente, data));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }

        return lista;
    }//fim listar

    public void inserir(Reserva reserva) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (reserva == null) {
            throw new ErpDAOException("O objeto pessoa não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO reserva( id_quarto, id_cliente, nome_cliente, data) "
                    + "values (?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);

            ps.setInt(1, reserva.getId_quarto());

            ps.setInt(2, reserva.getId_cliente());
            
            ps.setString(3, reserva.getNome_cliente());

            java.util.Date dataJAVA = reserva.getData();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(4, dataSQL);
            
            

            //java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao inserir uma nova reserva " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }//fim inserir

    public void excluir(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        // if (consultas == null){
        //    System.out.println("O objeto pessoa não pode ser nulo.");
        // };

        try {
            String SQL = "DELETE FROM reserva WHERE id_reserva=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            System.out.println("reserva excluída com sucesso DAO");
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir a reserva " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }//fim excluir

    public Reserva procurar(int codigo) throws ErpDAOException {

        Reserva reserva = new Reserva();
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;

        try {
            String SQL = "SELECT id_reserva, id_quarto, id_cliente, nome_cliente, data FROM reserva WHERE id_reserva = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_reserva = rs.getInt("id_reserva");
                int id_quarto = rs.getInt("id_quarto");
                int id_cliente = rs.getInt("id_cliente");
                String nome_cliente = rs.getString("nome_cliente");
                Date data = rs.getDate("data");

                reserva = new Reserva(id_reserva, id_quarto, id_cliente, nome_cliente, data);

            }

            return reserva;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao procurar a reserva " + sqle);
        } finally {
            // conexao.close(connL,ps);
        }
    }

    public void atualizar(Reserva reserva) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;

        if (reserva == null) {
            throw new ErpDAOException("O objeto reserva não pode ser nulo.");
        }

        try {
            String SQL = "UPDATE reserva SET id_quarto=?, id_cliente=?, nome_cliente=?, data=? WHERE id_reserva=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            //ps.setInt(1, reserva.getId_reserva());
            ps.setInt(1, reserva.getId_quarto());
            ps.setInt(2, reserva.getId_cliente());
            ps.setString(3, reserva.getNome_cliente());
            java.util.Date dataJAVA = reserva.getData();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(4, dataSQL);
            ps.setInt(5, reserva.getId_reserva());
            
            System.out.println("atualizando o banco de dados");

            

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao editar a reserva " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }
    
    
    /*public void atualizar(Reserva reserva) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;

        if (reserva == null) {
            throw new ErpDAOException("O objeto reserva não pode ser nulo.");
        }

        try {
            String SQL = "UPDATE reserva SET id_reserva=?, id_quarto=?, id_cliente=?, data=? WHERE id_reserva=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, reserva.getId_reserva());
            ps.setInt(2, reserva.getId_quarto());
            ps.setInt(3, reserva.getId_cliente());
            java.util.Date dataJAVA = reserva.getData();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(4, dataSQL);

            ps.setInt(5, reserva.getId_reserva());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao editar a reserva " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }*/

    public ArrayList listarpordata(java.util.Date data) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList lista = new ArrayList();

        try {
            String SQL = "SELECT id_reserva, id_quarto, id_cliente, nome_cliente, data FROM reserva WHERE data=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            java.util.Date dataJAVA = data;  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(1, dataSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_reserva = rs.getInt("id_reserva");
                int id_quarto = rs.getInt("id_quarto");
                int id_cliente = rs.getInt("id_cliente");
                String nome_cliente = rs.getString("nome_cliente");
                //Date dat = rs.getDate("data");

                lista.add(new Reserva(id_reserva, id_quarto, id_cliente, nome_cliente, data));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }

        return lista;
    }//fim listar
}
