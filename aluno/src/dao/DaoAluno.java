/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aluno;

/**
 *
 * @author Administrador
 */
public class DaoAluno {
     public static boolean inserir(Aluno objeto) {
        String sql = "INSERT INTO aluno (nome, sobrenome) VALUES (?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getSobrenome());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
      public static void main(String[] args) {
        Aluno objeto = new Aluno();
        objeto.setNome("Fernanda");
        objeto.setSobrenome("Prediger");
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}