
package com.mycompany.projetoillumy.oshi;

import org.springframework.jdbc.core.JdbcTemplate;


public class InsertDisco {
    
    protected Double disponivel;
    protected Double total;
    protected Integer fkServidor;
    protected Double tamanhoUsado;
    protected long tamanhoUsadoPorcentagem;
    protected long espacoLivrePorcentagem;

    public InsertDisco(Double disponivel, Double total, Double tamanhoUsado,
            long tamanhoUsadoPorcentagem, long espacoLivrePorcentagem) {
        
    this.disponivel = disponivel;                
    this.total = total;                              
    this.tamanhoUsado = tamanhoUsado;                              
    this.tamanhoUsadoPorcentagem = tamanhoUsadoPorcentagem;                              
    this.espacoLivrePorcentagem = espacoLivrePorcentagem;                              
    this.fkServidor = 1;    
    
    }

   

    public void InsertDisco() {
        
        ConnectionFactory dadosConexao = new ConnectionFactory();
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
   
        try {
           jdbcTemplate.update(
                "insert into disco (espacoLivreGB, tamanhoTotalGB, tamanhoUsadoGB,"
                        + " tamanhoUsadoPorcentagem, espacoLivrePorcentagem, fkServidor)"
                + "values(?,?,?,?,?,?)", disponivel, total, tamanhoUsado,
                tamanhoUsadoPorcentagem, espacoLivrePorcentagem, fkServidor);
             
        } catch (Exception e) {
            System.out.println("Erro"+e);
        }
    }  
    
}
