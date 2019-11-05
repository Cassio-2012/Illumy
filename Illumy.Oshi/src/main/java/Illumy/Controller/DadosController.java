package Illumy.Controller;

import com.mycompany.projetoillumy.TelaDashboard;
import javax.swing.JLabel;

public class DadosController {

    TelaDashboard tela = new TelaDashboard();
    JLabel lb = new JLabel();

    public String alo() {
        lb.setText("aadasdwa");
        tela.setLbMarcaSO(lb);
        return "";
    }
 
}
