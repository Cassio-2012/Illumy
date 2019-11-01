package com.mycompany.projetoillumy;

import com.mycompany.projetoillumy.oshi.Armazenamento;
import com.mycompany.projetoillumy.oshi.Hardware;
import com.mycompany.projetoillumy.oshi.InsertCPU;
import com.mycompany.projetoillumy.oshi.InsertDisco;
import com.mycompany.projetoillumy.oshi.InsertRam;
import com.mycompany.projetoillumy.oshi.Memoria;
import com.mycompany.projetoillumy.oshi.Processador;
import com.mycompany.projetoillumy.oshi.Processos;
import com.mycompany.projetoillumy.oshi.SistemaOperacional;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.TimerTask;
import java.util.Timer;
import oshi.SystemInfo;

public class TelaDashboard extends javax.swing.JFrame {

    private final Memoria memoria;
    private final Processador processador;
    private final Armazenamento armazenamento;
    private final Processos processos;
    private final SistemaOperacional sistemaOperacional;
    private final Hardware hardware;
    private final SystemInfo systemInfo;

    public TelaDashboard() {
        systemInfo = new SystemInfo();
        memoria = new Memoria();
        processador = new Processador();
        armazenamento = new Armazenamento(systemInfo.getOperatingSystem().getFileSystem());
        processos = new Processos();
        sistemaOperacional = new SistemaOperacional();
        hardware = new Hardware();
        initComponents();
    }

    public void exibeDados() {
        lbMarcaComputador.setText(hardware.getMarcaComputador());
        lbModeloCpu.setText(hardware.getModeloCPU());
        lbModeloPlacaMae.setText(hardware.getModeloPlacaMae());
        lbModeloSO.setText(sistemaOperacional.getModeloSO());
        lbMarcaSO.setText(sistemaOperacional.getFabricante());
        lbHostname.setText(sistemaOperacional.getHostname());

        try {
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    lbMemoriaDisponivel.setText(memoria.getMemoriaDisponivel(systemInfo.getHardware().getMemory()));
                    lbMemoriaTotal.setText(memoria.getMemoriaTotal(systemInfo.getHardware().getMemory()));
                    lbArmazenamentoTotal.setText(armazenamento.getDiscoTotal());
                    lbArmazenamentoDisponivel.setText(armazenamento.getDiscoDisponivel());
                    lbUsoProcessador.setText(processador.getUtilizacaoAtualProcessador(systemInfo.getHardware().getProcessor()));
                    lbNucleos.setText(processador.getThreadsAtivos());
                    lbTemperatura.setText(processador.getTemperaturaCpu());
                    txaProcessos.setText(processos.getProcessos(systemInfo.getHardware().getMemory()));
                }
            }, 0, 5000);
        } catch (Exception ex) {
            System.out.println("Erro:" + ex);
        }
    }

    public void insertCPU() {

        try {
            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {

                    String modCPU = String.valueOf(hardware.getModeloCPU());
                    String tempCPU = String.valueOf(processador.getTemperaturaCpu());
                    String usoCPU = String.valueOf(processador.getUtilizacaoAtualProcessador(systemInfo.getHardware().getProcessor()));

                    InsertCPU insert = new InsertCPU(usoCPU, modCPU, tempCPU);

                    insert.insertCPU();

                }
            }, 200, 10000);
        } catch (Exception e) {
            System.out.println("Erro ao inserir" + e);
        }
    }

//    public void insertServidor(){
//        try {
//            Timer timer = new Timer();
// 
//            timer.scheduleAtFixedRate(new TimerTask() {
//     
//            public void run() {                
//                String modSO = String.valueOf(sistemaOperacional.getModeloSO());
//                String host = String.valueOf(sistemaOperacional.getHostname());
//                InsertServidor insert = new InsertServidor(modSO, host);
//                insert.InsertServidor();
//                timer.cancel();
//                timer.purge();
//                
//        }
//    }, 200, 10000);
//        } catch (Exception e) {
//            System.out.println("Erro ao inserir"+ e);
//        }
//    }
    public void insertRAM() {

        try {
            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {

                    String total = String.valueOf(memoria.getMemoriaTotal(systemInfo.getHardware().getMemory()));
                    String livre = String.valueOf(memoria.getMemoriaDisponivel(systemInfo.getHardware().getMemory()));

                    InsertRam insert = new InsertRam(livre, total);

                    insert.InsertRam();

                }
            }, 300, 10000);
        } catch (Exception e) {
            System.out.println("Erro ao inserir" + e);
        }
    }

    public void insertDISCO() {

        try {
            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {

                    String total = String.valueOf(armazenamento.getDiscoTotal());
                    String livre = String.valueOf(armazenamento.getDiscoDisponivel());

                    InsertDisco insert = new InsertDisco(livre, total);

                    insert.InsertDisco();

                }
            }, 400, 10000);
        } catch (Exception e) {
            System.out.println("Erro ao inserir" + e);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnSair = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnProvisionar = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTemperatura = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbArmazenamentoTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbArmazenamentoDisponivel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaProcessos = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbUsoProcessador = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbMarcaComputador = new javax.swing.JLabel();
        lbModeloCpu = new javax.swing.JLabel();
        lbModeloPlacaMae = new javax.swing.JLabel();
        lbModeloSO = new javax.swing.JLabel();
        lbMarcaSO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbHostname = new javax.swing.JLabel();
        lbMemoriaDisponivel = new javax.swing.JLabel();
        lbMemoriaTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbNucleos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        jPanel3.setBackground(new java.awt.Color(166, 166, 166));

        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Monitorar");

        btnProvisionar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnProvisionar.setForeground(new java.awt.Color(255, 255, 255));
        btnProvisionar.setText("Provisionar");
        btnProvisionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProvisionarMouseClicked(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/illumy-navbar (3).png"))); // NOI18N
        jLabel20.setText("jLabel5");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProvisionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProvisionar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setText("Informações de hardware");

        lbTemperatura.setText("--");

        jLabel4.setText("Informações de SO");

        lbArmazenamentoTotal.setText("--");

        jLabel5.setText("Marca do computador: ");

        jLabel6.setText("Modelo Placa Mãe: ");

        jLabel26.setText("Armazenamento total:");

        lbArmazenamentoDisponivel.setText("--");

        jLabel7.setText("Modelo CPU: ");

        jLabel28.setText("Armazenamento disponivel:");

        jLabel8.setText("Modelo SO:");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setText("Processos");

        jLabel9.setText("Marca SO:");

        txaProcessos.setColumns(20);
        txaProcessos.setRows(5);
        txaProcessos.setFocusable(false);
        jScrollPane1.setViewportView(txaProcessos);

        jLabel10.setText("Hostname:");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setText("Dados Atuais");

        jLabel12.setText("Memória Total:");

        jLabel13.setText("Utilização do processador:");

        lbUsoProcessador.setText("--");

        jLabel14.setText("Threads em execução");

        jLabel15.setText("Temperatura atual:");

        lbMarcaComputador.setText("--");

        lbModeloCpu.setText("--");

        lbModeloPlacaMae.setText("--");

        lbModeloSO.setText("--");

        lbMarcaSO.setText("--");

        jLabel1.setText("Memória Disponivel:");

        lbHostname.setText("--");

        lbMemoriaDisponivel.setText("--");

        lbMemoriaTotal.setText("--");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setText("Monitoramento de Máquina");

        lbNucleos.setText("--");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbModeloPlacaMae, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbMemoriaDisponivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbMemoriaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbArmazenamentoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbArmazenamentoDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbModeloCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbMarcaComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbMarcaSO, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbHostname, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbModeloSO, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbUsoProcessador, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNucleos, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(162, 162, 162))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(279, 279, 279)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(294, 294, 294)
                                .addComponent(jLabel16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(lbMarcaComputador)
                    .addComponent(lbModeloSO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(lbModeloCpu)
                    .addComponent(lbMarcaSO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(lbModeloPlacaMae)
                    .addComponent(lbHostname))
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbMemoriaDisponivel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lbMemoriaTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(lbArmazenamentoTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(lbArmazenamentoDisponivel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lbUsoProcessador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(lbNucleos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lbTemperatura))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSairMouseClicked

    private void btnProvisionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProvisionarMouseClicked
        new Tela().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProvisionarMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        exibeDados();
        insertCPU();
        insertRAM();
        insertDISCO();
    }//GEN-LAST:event_formWindowGainedFocus

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaDashboard tela = new TelaDashboard();
                tela.setVisible(true);
                tela.addWindowListener(new WindowListener() {

                    @Override
                    public void windowOpened(WindowEvent we) {
                        tela.exibeDados();
                        tela.insertCPU();
                        tela.insertRAM();
                        tela.insertDISCO();
                    }

                    @Override
                    public void windowClosing(WindowEvent we) {
                    }

                    @Override
                    public void windowClosed(WindowEvent we) {
                    }

                    @Override
                    public void windowIconified(WindowEvent we) {
                    }

                    @Override
                    public void windowDeiconified(WindowEvent we) {
                    }

                    @Override
                    public void windowActivated(WindowEvent we) {
                        tela.exibeDados();
                        tela.insertCPU();
                        tela.insertRAM();
                        tela.insertDISCO();
                    }

                    @Override
                    public void windowDeactivated(WindowEvent we) {
                    }
                });
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnProvisionar;
    private javax.swing.JLabel btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbArmazenamentoDisponivel;
    private javax.swing.JLabel lbArmazenamentoTotal;
    private javax.swing.JLabel lbHostname;
    private javax.swing.JLabel lbMarcaComputador;
    private javax.swing.JLabel lbMarcaSO;
    private javax.swing.JLabel lbMemoriaDisponivel;
    private javax.swing.JLabel lbMemoriaTotal;
    private javax.swing.JLabel lbModeloCpu;
    private javax.swing.JLabel lbModeloPlacaMae;
    private javax.swing.JLabel lbModeloSO;
    private javax.swing.JLabel lbNucleos;
    private javax.swing.JLabel lbTemperatura;
    private javax.swing.JLabel lbUsoProcessador;
    private javax.swing.JTextArea txaProcessos;
    // End of variables declaration//GEN-END:variables
}
