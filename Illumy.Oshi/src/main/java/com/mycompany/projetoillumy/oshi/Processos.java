package com.mycompany.projetoillumy.oshi;

import java.util.Arrays;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class Processos {
    
    private final SystemInfo systemInfo;
    private final OperatingSystem sistemaOperacional;
    private String processes;
    
    public Processos(){
        systemInfo = new SystemInfo();
        sistemaOperacional = systemInfo.getOperatingSystem();
    }
    
    public String getProcessos(GlobalMemory memoria){
        List<OSProcess> procs = Arrays.asList(sistemaOperacional.getProcesses(5, OperatingSystem.ProcessSort.CPU));

        processes = "   PID  %CPU %MEM       VSZ       RSS Name\n";
        for (int i = 0; i < procs.size() && i < 5; i++) {
            OSProcess p = procs.get(i);
            processes += String.format(String.format(" %5d %5.1f %4.1f %9s %9s %s\n", p.getProcessID(),
                    100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
                    100d * p.getResidentSetSize() / memoria.getTotal(), FormatUtil.formatBytes(p.getVirtualSize()),
                    FormatUtil.formatBytes(p.getResidentSetSize()), p.getName()));
        }
        return processes;
    }
}
