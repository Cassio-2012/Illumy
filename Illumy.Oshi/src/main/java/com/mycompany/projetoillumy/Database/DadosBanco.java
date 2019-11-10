
package com.mycompany.projetoillumy.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.sql.DataSource;


public class DadosBanco {
    
    protected String user;
    protected String pass;
    protected Integer fator = 0;

    public DadosBanco(String user,String pass) {
        this.user = user;
        this.pass = pass;          
    }

    public void validation() throws SQLException{
        
     Connection con = new ConnectionFactory().getConnection();
     PreparedStatement stmt = con.prepareStatement("SELECT NomeUser, Senha FROM"
             + " usuario WHERE NomeUser = ? and Senha =?");
     
                stmt.setString(1, user);
                stmt.setString(2, pass);
                
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    rs.getString("NomeUser");  
                    rs.getString("Senha"); 
                    System.out.println("Validação Correta");
                    fator +=2;
                }                                     
                else{
                     System.out.println("Usuário e/ ou senha incorreto!");
                }
                       
    }
    

    public Integer getFator() {
        return fator;
    }
        

    }


    
    
    
    
   
    
 
