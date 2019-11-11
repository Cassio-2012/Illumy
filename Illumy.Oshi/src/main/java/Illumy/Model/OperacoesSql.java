package Illumy.Model;

import Illumy.Configuration.ConnectionFactory;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;

public class OperacoesSql {

    private final JdbcTemplate jdbcTemplate;
    private final ConnectionFactory conexao;

    public OperacoesSql() {
        this.conexao = new ConnectionFactory();
        this.jdbcTemplate =new JdbcTemplate(conexao.getDataSource());
    }

    public Boolean login(String login, String senha) {

        List<Map<String, Object>> loginValido = jdbcTemplate.queryForList("Select count(*) from usuario where nomeUser=(?) and senha=(?)", login, senha);

        if (loginValido.size() > 0) {
            return true;
        }
        else{
        return false;
        }
    }

}
