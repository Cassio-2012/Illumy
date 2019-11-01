
package com.mycompany.projetoillumy.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DadosBanco {
    
    protected String user;
    protected String pass;
    protected Integer fator = 0;

    public DadosBanco(String user,String pass) {
        this.user = user;
        this.pass = pass;          
    }

    public void validaUser() throws SQLException{
        
     Connection con = new ConnectionFactory().getConnection();
     PreparedStatement stmt = con.prepareStatement("select nomeUser from usuario");


     
                    ResultSet rs = stmt.executeQuery();
    

                    while (rs.next()) {
                     String login = rs.getString("nomeUser");                     
                     if (login.equals(user)){     
                            System.out.println("Usuário ok!");
                            fator ++;
                            break;
                         }
                     else{
                         System.out.println("Usuário não encontrado!");
                     }
                      
    }
                    
                                         
                                               
       
    }
    
    public void validaPass() throws SQLException{
        
     Connection con = new ConnectionFactory().getConnection();
     PreparedStatement stmt = con.prepareStatement("select senha from usuario");

     

                    ResultSet rs = stmt.executeQuery();
    


                    while (rs.next()) {
                     String senha = rs.getString("senha");                     
                     if (senha.equals(pass)){     
                            System.out.println("Senha ok!");
                            fator ++;
                            break;
                         }
                     else{
                         System.out.println("Senha incorreta!");
                     }
                      
    }
                    
                                         
                                                      
    }

    public Integer getFator() {
        return fator;
    }
        

    }


    
    
    
    
   
    
 
