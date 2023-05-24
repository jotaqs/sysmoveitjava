package Model.ConexaoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.Conexao;
import Model.Conexao;
import Model.Login;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConexaoDAO {
    private Connection con;

    public ConexaoDAO() {
        con = new Conexao().conectar();
        
    }
    
    public ArrayList<Login> listar() {
        String sql = "SELECT * FROM dados";
        ArrayList<Login> dados;
        dados = new ArrayList<Login>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Login l = new Login();
                l.setId(rs.getInt("id"));
                l.setCodRastreio(rs.getString("cod"));
                l.setDeclaracao(rs.getString("declaracao"));
                l.setCpf(rs.getString("cpf"));
                l.setData(rs.getString("data"));
                dados.add(l);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dados;
    }
    
    public void inserir(Login l) {
        String sql = "INSERT INTO dados(cod, declaracao, cpf, data) VALUE(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, l.getCodRastreio());
            ps.setString(2, l.getDeclaracao());
            ps.setString(4, l.getCpf());
            ps.setString(3, l.getData());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void atualizar(Login l) {
        String sql = "UPDATE dados SET cod=?,declaracao=?, data=?, cpf=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setString(1, l.getCodRastreio());
            ps.setString(2, l.getDeclaracao());
            ps.setString(4, l.getCpf());
            ps.setString(3, l.getData());
            ps.setInt(5, l.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro atualizado ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}
    public void excluir(Login l) {
        String sql = "DELETE FROM dados WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, l.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null,"contato excluido com sucesso");
            
        }catch(Exception e){
            System.out.println (e.getMessage());
        }
    }
}