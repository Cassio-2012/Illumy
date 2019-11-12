package Illumy.Controller;

import Illumy.Model.ExibicaoDadosModel;
import Illumy.View.DashboardView;
import java.util.Timer;
import java.util.TimerTask;

public class DadosController {
    
    ExibicaoDadosModel exibicaoDadosModel;
    
    public DadosController(DashboardView view) {
        exibicaoDadosModel = new ExibicaoDadosModel(view);
    }
    
    public void iniciaTimer(){
         try {
            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {
                    exibicaoDadosModel.getDados();
                    exibicaoDadosModel.exibeDados();
                }
            }, 1200, 5000);
        } catch (Exception ex) {
            System.out.println("Erro ao exibir" + ex);
        }
    }
}
