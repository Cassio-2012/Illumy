package com.mycompany.projetoillumy.oshi;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.illumy.oshi;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//
///**
// *
// * @author P
// */
//public class InsertServidor {
//    
//    protected String usoCpu;
//    
//    private String modSO;
//    private String host;
//
//    public InsertServidor(String modSO, String host) {
//        
//    
//    this.modSO = modSO; 
//    this.host = host; 
//    
//    }
//
//    public void InsertServidor() {
//        
//        ConnectionFactory dadosConexao = new ConnectionFactory();
//        
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
//          
//        
//        try {
//           jdbcTemplate.update(
//                "insert into servidores (nomeServidor, sistemaOperacional)"
//                + "values(?,?)", host , modSO);
//             
//        } catch (Exception e) {
//            System.out.println("Erro"+e);
//        }
//        
//    }
//    
//}
