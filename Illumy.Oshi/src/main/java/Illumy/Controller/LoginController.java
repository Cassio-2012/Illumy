package Illumy.Controller;

import Illumy.Model.OperacoesSql;
import Illumy.View.DashboardView;
import Illumy.View.LoginView;
import java.awt.Color;

public class LoginController {
    
    OperacoesSql queries;
    LoginView view;

    public LoginController(LoginView view) {
        queries = new OperacoesSql();
        this.view = view;
    }
    
    public void login(){
        String user = view.getTfUsuario().getText();
        String pass = view.getTfSenha().getText();
        Boolean validacao = false;
        try {
            validacao = queries.queryLogin(pass, user);

            if (validacao) {
                new DashboardView().setVisible(true);
                view.dispose();
    }                                        
        else {
                view.getLbCredencial().setText("Usuário e/ou senha incorretos!");
                view.getLbCredencial().setForeground(Color.red);
            }
        } catch (Exception ex) {
            view.getLbCredencial().setText("Erro de comunicação com o banco de dados");
            view.getLbCredencial().setForeground(Color.red);
            System.out.println(ex);
        }
    }
}
