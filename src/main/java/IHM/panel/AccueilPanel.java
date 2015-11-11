package IHM.panel;

import IHM.IHMApplication;

/**
 * Created by QKFD7244 on 02/11/2015.
 */
public class AccueilPanel extends javax.swing.JPanel{
    /*Constructeur*/
    public AccueilPanel() {
        initAccueil();
    }

    /*Attributs...*/
    private javax.swing.JButton boutonCommencer;
    private javax.swing.JLabel imageAccueil;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCredits;
    private javax.swing.JLabel labelMalin;
    private javax.swing.JLabel labelVelo;

    /*Méthode*/
    private void initAccueil() {
        imageAccueil = new javax.swing.JLabel();
        labelCredits = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelMalin = new javax.swing.JLabel();
        labelVelo = new javax.swing.JLabel();
        boutonCommencer = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        imageAccueil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageAccueil.setIcon(new javax.swing.ImageIcon("src/main/resources/img/image_velovs.jpg")); // NOI18N
        imageAccueil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));

        labelCredits.setBackground(new java.awt.Color(204, 204, 204));
        labelCredits.setText("<html> &nbsp;Crédits:<br/> &nbsp;&nbsp;&nbsp;Développé par <b>Maxime Brunet, Christophe Chaumier, Emmanuela Calmel, Florian Vautard et Pierre-Emmanuel Cochet.</b><br/> &nbsp;&nbsp;&nbsp;Licence MIT. Projet CPE Lyon. Données publiques JCDecaux vélo'v du Grand Lyon." +
                "<br/> &nbsp;&nbsp;&nbsp;Icons made by Freepik from www.flaticon.com is licensed by CC BY 3.0</html>");
        labelCredits.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelMalin.setBackground(new java.awt.Color(255, 0, 0));
        labelMalin.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        labelMalin.setForeground(new java.awt.Color(255, 255, 255));
        labelMalin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMalin.setText("malin");
        labelMalin.setOpaque(true);

        labelVelo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        labelVelo.setText("vélo'");

        boutonCommencer.setBackground(new java.awt.Color(255, 0, 0));
        boutonCommencer.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        boutonCommencer.setForeground(new java.awt.Color(255, 255, 255));
        boutonCommencer.setText("Commencer");
        boutonCommencer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(250, 240, 240), new java.awt.Color(255, 204, 204), null));
        boutonCommencer.setContentAreaFilled(false);
        boutonCommencer.setOpaque(true);
        boutonCommencer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boutonCommenceractionCommencer(evt);
            }
        });
        boutonCommencer.setVisible(false);
        //boutonCommencer.addActionListener(new EcouteurBoutonCommencer()); 
    
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(labelVelo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelMalin, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(boutonCommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelMalin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelVelo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(boutonCommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(IHMApplication.panel0);
        IHMApplication.panel0.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelCredits)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(94, Short.MAX_VALUE)
                                .addComponent(imageAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(94, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(35, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(imageAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    private void boutonCommenceractionCommencer(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
		//onglets.setSelected(2);
    }
    
    private void boutonCommencerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }
}
