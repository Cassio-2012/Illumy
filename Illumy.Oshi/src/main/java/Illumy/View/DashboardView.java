package Illumy.View;

import Illumy.Controller.DadosController;
import Illumy.Model.Armazenamento;
import Illumy.Model.Hardware;
import com.mycompany.projetoillumy.oshi.InsertCPU;
import com.mycompany.projetoillumy.oshi.InsertDisco;
import com.mycompany.projetoillumy.oshi.InsertRam;
import Illumy.Model.Memoria;
import Illumy.Model.Processador;
import Illumy.Model.Processos;
import Illumy.Model.SistemaOperacional;
import com.mycompany.projetoillumy.Tela;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import oshi.SystemInfo;

public class DashboardView extends javax.swing.JFrame {

    private final Memoria memoria;
    private final Processador processador;
    private final Armazenamento armazenamento;
    private final Processos processos;
    private final SistemaOperacional sistemaOperacional;
    private final Hardware hardware;
    private final SystemInfo systemInfo;

    public DashboardView() {
        systemInfo = new SystemInfo();
        memoria = new Memoria();
        processador = new Processador();
        armazenamento = new Armazenamento();
        processos = new Processos();
        sistemaOperacional = new SistemaOperacional();
        hardware = new Hardware();
        initComponents();
        DadosController dadosController = new DadosController(this);
    }

    public void exibeDados() {
        try {
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    lbMemoriaDisponivel.setText(memoria.getMemoriaDisponivel());
                    lbMemoriaTotal.setText(memoria.getMemoriaTotal());
                    lbArmazenamentoTotal.setText(armazenamento.getDiscoTotal());
                    lbArmazenamentoDisponivel.setText(armazenamento.getDiscoDisponivel());
                    lbUsoProcessador.setText(processador.getUtilizacaoAtualProcessador());
                    txaProcessos.setText(processos.getProcessos());
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
                    String usoCPU = String.valueOf(processador.getUtilizacaoAtualProcessador());

                    InsertCPU insert = new InsertCPU(usoCPU, modCPU, tempCPU);

                    insert.insertCPU();

                }
            }, 1200, 5000);
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

                    String total = String.valueOf(memoria.getMemoriaTotal());
                    String livre = String.valueOf(memoria.getMemoriaDisponivel());

                    InsertRam insert = new InsertRam(livre, total);

                    insert.InsertRam();

                }
            }, 1200, 5000);
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
            }, 1200, 5000);
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
        jLabel20 = new javax.swing.JLabel();
        lbArmazenamentoTotal = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbArmazenamentoDisponivel = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaProcessos = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbUsoProcessador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbMemoriaDisponivel = new javax.swing.JLabel();
        lbMemoriaTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

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
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbArmazenamentoTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbArmazenamentoTotal.setText("--");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel26.setText("Armazenamento total:");

        lbArmazenamentoDisponivel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbArmazenamentoDisponivel.setText("--");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel28.setText("Armazenamento disponivel:");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setText("Processos");

        txaProcessos.setColumns(20);
        txaProcessos.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txaProcessos.setRows(5);
        txaProcessos.setAutoscrolls(false);
        txaProcessos.setFocusable(false);
        jScrollPane1.setViewportView(txaProcessos);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Memória Total:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Utilização do processador:");

        lbUsoProcessador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbUsoProcessador.setText("--");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Memória Disponivel:");

        lbMemoriaDisponivel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbMemoriaDisponivel.setText("--");

        lbMemoriaTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbMemoriaTotal.setText("--");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setText("Monitoramento de Máquina");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("PID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("%CPU");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("NOME");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("%RAM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbUsoProcessador, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lbMemoriaDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbMemoriaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbArmazenamentoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbArmazenamentoDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel4)
                                .addGap(69, 69, 69))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(jLabel6)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel5))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbMemoriaTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lbArmazenamentoTotal))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbUsoProcessador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbMemoriaDisponivel))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lbArmazenamentoDisponivel))
                .addGap(33, 33, 33)
                .addComponent(jLabel16)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
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

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        exibeDados();
        insertCPU();
        insertRAM();
        insertDISCO();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSairMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DashboardView tela = new DashboardView();
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

    public JLabel getLbUsoProcessador() {
        return lbUsoProcessador;
    }

    public JLabel getLbArmazenamentoDisponivel() {
        return lbArmazenamentoDisponivel;
    }

    public JLabel getLbMemoriaDisponivel() {
        return lbMemoriaDisponivel;
    }

    public JTextArea getTxaProcessos() {
        return txaProcessos;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbArmazenamentoDisponivel;
    private javax.swing.JLabel lbArmazenamentoTotal;
    private javax.swing.JLabel lbMemoriaDisponivel;
    private javax.swing.JLabel lbMemoriaTotal;
    private javax.swing.JLabel lbUsoProcessador;
    private javax.swing.JTextArea txaProcessos;
    // End of variables declaration//GEN-END:variables
}
