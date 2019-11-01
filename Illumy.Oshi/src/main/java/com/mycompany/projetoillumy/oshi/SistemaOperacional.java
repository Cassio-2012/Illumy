package com.mycompany.projetoillumy.oshi;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class SistemaOperacional {
    private final SystemInfo systemInfo;
    private final OperatingSystem sistemaOperacional;

    public SistemaOperacional() {
        systemInfo = new SystemInfo();
        sistemaOperacional = systemInfo.getOperatingSystem();
    }
    
    //Informações do Sistema Operacional e usuário
    public String getModeloSO(){
        return sistemaOperacional.getFamily();
    }
    public String getFabricante(){
        return sistemaOperacional.getManufacturer();
    }
    
    public String getHostname(){
        return sistemaOperacional.getNetworkParams().getHostName();
    }
    
    public String getUsername(){
        return sistemaOperacional.getProcess(0).getUser();
    }
    //FIM Informações do Sistema Operacional e usuário
}
