package Illumy.Controller;

import Illumy.Model.ExibicaoDadosModel;
import Illumy.View.DashboardView;

public class DadosController {
    
    ExibicaoDadosModel exibicaoDadosModel;
    
    public DadosController(DashboardView view) {
        exibicaoDadosModel = new ExibicaoDadosModel(view);
        exibicaoDadosModel.ExibeDados();
    }
    
}
