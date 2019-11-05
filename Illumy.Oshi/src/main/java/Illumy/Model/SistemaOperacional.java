package Illumy.Model;

public class SistemaOperacional extends AtributosOshi {

    //Informações do Sistema Operacional e usuário
    public String getModeloSO() {
        return sistemaOperacional.getFamily();
    }

    public String getFabricante() {
        return sistemaOperacional.getManufacturer();
    }

    public String getHostname() {
        return sistemaOperacional.getNetworkParams().getHostName();
    }

    public String getUsername() {
        return sistemaOperacional.getProcess(0).getUser();
    }
    //FIM Informações do Sistema Operacional e usuário
}
