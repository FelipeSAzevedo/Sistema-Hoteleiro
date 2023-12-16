package DAO_hotel;

import Classes_hotel.Cliente;
import Conexao.util.Conexao;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO() {
        try {
            this.conn = Conexao.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inserir(Cliente cliente) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (cliente == null) {
            throw new ErpDAOException("O objeto cliente não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO cliente (cpf, nome, telefone) "
                    + "values (?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setInt(3, cliente.getTelefone());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao inserir um novo cliente" + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public void atualizar(Cliente cliente) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (cliente == null) {
            throw new ErpDAOException("O objeto cliente não pode ser nulo.");
        }

        try {
            String SQL = "UPDATE cliente set cpf=?, nome=?, telefone=? where id_cliente = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setInt(3, cliente.getTelefone());
            ps.setInt(4, cliente.getId_cliente());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao editar o cliente " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public Cliente procurar(int id_cliente) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;

        try {
            String SQL = "SELECT id_cliente, nome, telefone, cpf FROM cliente WHERE id_cliente = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, id_cliente);
            rs = ps.executeQuery();
            Cliente cliente = new Cliente();
            while (rs.next()) {
                id_cliente = rs.getInt("id do cliente");
                int cpf = rs.getInt("cpf");
                String nome = rs.getString("nome");
                int telefone = rs.getInt("telefone");

                cliente = new Cliente(id_cliente, cpf, nome, telefone);

            }

            return cliente;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao procurar o cliente " + sqle);
        } finally {
            // conexaoAulaDAO.close(connL,ps);
        }
    }

    public ArrayList Listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList cliente = new ArrayList();
        try {
            String SQL = "SELECT * FROM cliente ORDER BY id_cliente";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                int cpf = rs.getInt("cpf");
                String nome = rs.getString("nome");
                int telefone = rs.getInt("telefone");

                cliente.add(new Cliente(id_cliente, cpf, nome, telefone));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }

        return cliente;
    }

    public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (cliente  == null) {
            System.out.println("O objeto cliente não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM cliente WHERE id_cliente=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, cliente.getId_cliente());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir cliente " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }
}
