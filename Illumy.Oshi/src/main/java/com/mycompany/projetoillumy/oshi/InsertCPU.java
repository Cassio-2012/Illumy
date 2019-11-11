package com.mycompany.projetoillumy.oshi;

import Illumy.Configuration.ConnectionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertCPU {

    protected String usoCPU;
    protected String modCPU;
    protected String tempCPU;
    protected Integer fkServidor;

    public InsertCPU(String usoCPU, String modCPU, String tempCPU) {
        this.usoCPU = usoCPU;
        this.modCPU = modCPU;
        this.tempCPU = tempCPU;
        this.fkServidor = 1;
    }

    public void insertCPU() {

        ConnectionFactory dadosConexao = new ConnectionFactory();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());

        try {
            jdbcTemplate.update(
                    "insert into CPU (utilizacaoAtual, ModProcessador, TempCPU, fkServidor)"
                    + "values(?,?,?,?)", usoCPU, modCPU, tempCPU, fkServidor);

        } catch (Exception e) {
            System.out.println("Erro" + e);
        }
    }
}
