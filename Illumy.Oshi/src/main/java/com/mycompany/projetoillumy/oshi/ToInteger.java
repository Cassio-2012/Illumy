
package com.mycompany.projetoillumy.oshi;


import oshi.SystemInfo;
import java.lang.Math;


public class ToInteger {
    
  
   SystemInfo systemInfo = new SystemInfo(); 
   Memoria memoria = new Memoria();
   Processador processador = new Processador();
   Armazenamento armazenamento = new Armazenamento(systemInfo.getOperatingSystem().getFileSystem());
       

    public Double getMemoriaDispInteger() {
        
    String memoriaDisponivel = memoria.getMemoriaDisponivel(systemInfo.getHardware().getMemory());
   
    String m = memoriaDisponivel.replace(" MiB", "").replaceAll(",", ".");
        
    Double memoriaDispInteger = Double.parseDouble(m);
        
        return memoriaDispInteger;
        
    }
    public Double getMemoriaTotalInteger() {
        
    String memoriaDisponivel = memoria.getMemoriaTotal(systemInfo.getHardware().getMemory());
   
    String m = memoriaDisponivel.replace(" GiB", "").replaceAll(",", ".");
        
    Double memoriaDispInteger = Double.parseDouble(m);
        
        return memoriaDispInteger;
        
    }
    public Double getArmazenamentoLivreInt() {
        
    String discoLivre = String.valueOf(armazenamento.getDiscoDisponivel());
   
    String m = discoLivre.replace(" GiB", "").replaceAll(",", ".");
        
    Double discoLivreInt = Double.parseDouble(m);
        
        return discoLivreInt;
        
    }
    
    public Double getArmazenamentoTotalInt() {
        
    String discoTotal = String.valueOf(armazenamento.getDiscoTotal());
   
    String m = discoTotal.replace(" GiB", "").replaceAll(",", ".");
        
    Double discoTotalInt = Double.parseDouble(m);
        
        return discoTotalInt;
        
    }
    public Double getUsoCpuInt() {
        
    String discoTotal = String.valueOf(processador.getUtilizacaoAtualProcessador(systemInfo.getHardware().getProcessor()));
   
    String m = discoTotal.replace("%", "").replaceAll(",", ".");
        
    Double discoTotalInt = Double.parseDouble(m);
        
        return discoTotalInt;
        
    }

    public Double getTamanhoUsadoRam() {
      
     Double total = getMemoriaTotalInteger();
     Double livre = getMemoriaDispInteger();
         
 //     #tamanho total em GB   
     Double usado = (total *1024) - livre;
     
        return usado;
    }
    public Double getTamanhoUsadoDisco() {
      
     Double total = getArmazenamentoTotalInt();
     Double livre = getArmazenamentoLivreInt();
     
     
     Double usado = total - livre; 
     
        return usado;
    }
    public long getPorcentagemUsadaRam() {
      
        Double total = getMemoriaTotalInteger();
        Double usado = getTamanhoUsadoRam();
        
        
        Double porcentagem = ((usado / (total *1024)) *100);
             
        
        return Math.round(porcentagem);
    }
    public long getPorcentagemLivreRam() {
      
        Double total = getMemoriaTotalInteger();
        Double livre = getMemoriaDispInteger();
        
        Double porcentagem = ((livre / (total *1024)) *100);
        
        return Math.round(porcentagem);
    }
    public long getPorcentagemUsadaDisco() {
      
        Double total = getArmazenamentoTotalInt();
        Double usado = getTamanhoUsadoDisco();
        
        Double porcentagem = ((usado / total) *100);
        
        return Math.round(porcentagem);
    }
    
    public long getPorcentagemLivreDisco() {
      
        Double total = getArmazenamentoTotalInt();
        Double livre = getArmazenamentoLivreInt();
        
        Double porcentagem = ((livre / (total *1024)) *100);
        
        return Math.round(porcentagem);
    }   
    
          
}
