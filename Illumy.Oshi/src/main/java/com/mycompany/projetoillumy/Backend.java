package com.mycompany.projetoillumy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backend {
    
    public String executaPowerShell(Integer valor) throws IOException {
        //String command = "powershell.exe  your command";
  
 // String comando = String.format(" echo 'Hello World %d'", valor);
  String comando = "get-vmmemory IllumyW001";
  String command = "powershell.exe "+comando;
  // Executando o comando
  Process powerShellProcess = Runtime.getRuntime().exec(command);
  // Capturando os resultados
  powerShellProcess.getOutputStream().close();
  String line;
  //Saída principal
  System.out.println("Standard Output:");
        try (BufferedReader stdout = new BufferedReader(new InputStreamReader(
                powerShellProcess.getInputStream()))) {
            while ((line = stdout.readLine()) != null) {
                System.out.println(line);
            }     }
  //Saída de erro
  System.out.println("Standard Error:");
        try (BufferedReader stderr = new BufferedReader(new InputStreamReader(
                powerShellProcess.getErrorStream()))) {
            while ((line = stderr.readLine()) != null) {
                System.out.println(line);
            }     }
  System.out.println("Done");
  return line;
    }
    
}

