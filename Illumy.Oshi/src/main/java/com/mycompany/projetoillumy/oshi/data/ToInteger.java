
package com.mycompany.projetoillumy.oshi.data;


import com.mycompany.projetoillumy.oshi.Armazenamento;
import com.mycompany.projetoillumy.oshi.Memoria;
import com.mycompany.projetoillumy.oshi.Processador;
import oshi.SystemInfo;
import java.lang.Math;


public class ToInteger {
      
   SystemInfo systemInfo = new SystemInfo(); 
   Memoria memoria = new Memoria();
   Processador processador = new Processador();
   Armazenamento armazenamento = new Armazenamento(systemInfo.getOperatingSystem().getFileSystem());
         
                        
}
