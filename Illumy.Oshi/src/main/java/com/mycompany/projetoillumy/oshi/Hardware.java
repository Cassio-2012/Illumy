package com.mycompany.projetoillumy.oshi;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class Hardware {
    private final SystemInfo systemInfo;
    private final HardwareAbstractionLayer hardware;
    
    public Hardware(){
        systemInfo = new SystemInfo();
        hardware = systemInfo.getHardware();
    }
    
    public String getMarcaComputador(){
        return hardware.getComputerSystem().getManufacturer();
    }
    
    public String getModeloCPU(){
        return hardware.getProcessor().getName();
    }
    
    public String getModeloPlacaMae(){
        return hardware.getComputerSystem().getBaseboard().getModel();
    }
    
}
