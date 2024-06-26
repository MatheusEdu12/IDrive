package com.idrive.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.idrive.models.Veiculo;
import com.idrive.conf.Conexao;

public class VeiculoDao {
    
    private Conexao conexao;
    private PreparedStatement ps;
    
    public VeiculoDao(){
        conexao = new Conexao();        
    }
    
    public ResultSet listar(){
        try {
            return conexao.getConn()
                    .createStatement().executeQuery("SELECT * FROM veiculo");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void inserir(Veiculo veiculo){
        try {
            String SQL = "INSERT INTO veiculo(marca, modelo, ano, placa, disponibilidade) " +
                    "VALUES (?, ?, ?, ?, ?)";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setString(1, veiculo.getMarca());
            ps.setString(2, veiculo.getModelo());
            ps.setInt(3, veiculo.getAno());
            ps.setString(4, veiculo.getPlaca());
            ps.setBoolean(5, veiculo.isDisponibilidade());
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void excluir(Veiculo veiculo){
        try {
            String SQL = "DELETE FROM veiculo WHERE id = ?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, veiculo.getId());           
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public void editar(Veiculo veiculo){
        try {
            String SQL = "UPDATE veiculo SET " +
                        "marca = ?, modelo = ?, ano = ?, placa = ?, disponibilidade = ? " +
                        "WHERE id = ?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setString(1, veiculo.getMarca());
            ps.setString(2, veiculo.getModelo());
            ps.setInt(3, veiculo.getAno());
            ps.setString(4, veiculo.getPlaca());
            ps.setBoolean(5, veiculo.isDisponibilidade());
            ps.setInt(6, veiculo.getId());
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet quantidadeVeiculoPorMarca(Veiculo veiculo) {
        try {
            String SQL = "SELECT COUNT(*) FROM veiculo WHERE marca = ?";

            ps = conexao.getConn().prepareStatement(SQL);
            ps.setString(1, veiculo.getMarca());

            ResultSet rs = ps.executeQuery();
            
            ps.close();

            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null; 
    } 

    public boolean isDisponivel(Veiculo veiculo) {
        try {
            String SQL = "SELECT COUNT(*) FROM LOCACAO WHERE id_veiculo = ? AND NOW() BETWEEN dataInicio AND dataTermino";
    
            ps = conexao.getConn().prepareStatement(SQL);
            ps.setInt(1, veiculo.getId());
    
            ResultSet rs = ps.executeQuery();
            rs.next(); 
            int count = rs.getInt(1); 
    
            ps.close();
    
            return count > 0; 
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; 
        }
    }
    
}
