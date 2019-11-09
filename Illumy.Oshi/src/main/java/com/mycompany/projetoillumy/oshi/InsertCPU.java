
package com.mycompany.projetoillumy.oshi;

import org.springframework.jdbc.core.JdbcTemplate;



public class InsertCPU {
    
    protected Double usoCPU;       
    protected Integer fkServidor;

    public InsertCPU(Double usoCPU){
    this.usoCPU = usoCPU;                                                     
    this.fkServidor = 1;                
    }

    public void insertCPU() {
        
        ConnectionFactory dadosConexao = new ConnectionFactory();
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
   
        try {
           jdbcTemplate.update(
                "insert into CPU (utilizacaoAtual, fkServidor)"
                + "values(?,?)", usoCPU,fkServidor);
             
        } catch (Exception e) {
            System.out.println("Erro"+e);
        }
    }
}
            

