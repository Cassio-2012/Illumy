package com.mycompany.projetoillumy.oshi;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.Util;

public class Processador {

    private final SystemInfo systemInfo;
    private final HardwareAbstractionLayer hardware;

    public Processador() {
        systemInfo = new SystemInfo();
        hardware = systemInfo.getHardware();
    }
    
    //Valores de atualização por tempo
    public String getUtilizacaoAtualProcessador(CentralProcessor processor) {
        long[] ticks = processor.getSystemCpuLoadTicks();
        Util.sleep(1000);
        return String.format("%.1f%%", processor.getSystemCpuLoadBetweenTicks(ticks) * 100);
        //return String.format("%.1f%%", hardware.getProcessor().getSystemCpuLoad() * 100);
    }

    public String getThreadsAtivos() {
        return String.valueOf(systemInfo.getOperatingSystem().getThreadCount());
    }

    public String getTemperaturaCpu() {
        return String.format("%.1f ºC",hardware.getSensors().getCpuTemperature());
    }
    //FIM Valores de atualização por tempo
}
