package IHM.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by QKFD7244 on 02/11/2015.
 */
public class AccueilPanel extends javax.swing.JPanel{
    /*Constructeur*/
    public AccueilPanel() {
        initAccueil();
    }

    /*Attributs...*/
    private javax.swing.JPanel accueilPanel;
    private javax.swing.JButton boutonCommencer;
    private javax.swing.JLabel imageAccueil;
    private javax.swing.JLabel labelCredits;
    private javax.swing.JLabel labelMalin;
    private javax.swing.JLabel labelVelo;

    /*Méthode*/
    private void initAccueil() {
        accueilPanel = new javax.swing.JPanel();
        labelVelo = new javax.swing.JLabel();
        labelMalin = new javax.swing.JLabel();
        imageAccueil = new javax.swing.JLabel();
        boutonCommencer = new javax.swing.JButton();
        labelCredits = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        accueilPanel.setBackground(new java.awt.Color(255, 255, 255));

        labelVelo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        labelVelo.setText("vélo'");

        labelMalin.setBackground(new java.awt.Color(255, 0, 0));
        labelMalin.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        labelMalin.setForeground(new java.awt.Color(255, 255, 255));
        labelMalin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMalin.setText("malin");
        labelMalin.setOpaque(true);

        imageAccueil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageAccueil.setIcon(new javax.swing.ImageIcon("C:\\Users\\QKFD7244\\Documents\\Z__Recherches\\projet\\velo_malin\\src\\main\\resources\\img\\image_velovs.jpg")); // NOI18N
        imageAccueil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));

        boutonCommencer.setBackground(new java.awt.Color(255, 0, 0));
        boutonCommencer.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        boutonCommencer.setForeground(new java.awt.Color(255, 255, 255));
        boutonCommencer.setText("commencer");
        boutonCommencer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(250, 240, 240), new java.awt.Color(255, 204, 204), null));
        boutonCommencer.setContentAreaFilled(false);
        boutonCommencer.setOpaque(true);
        boutonCommencer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actionCommencer(evt);
            }
        });
        boutonCommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonCommencerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accueilPanelLayout = new javax.swing.GroupLayout(accueilPanel);
        accueilPanel.setLayout(accueilPanelLayout);
        accueilPanelLayout.setHorizontalGroup(
                accueilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accueilPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boutonCommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(accueilPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelVelo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMalin, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(accueilPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(imageAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        accueilPanelLayout.setVerticalGroup(
                accueilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accueilPanelLayout.createSequentialGroup()
                                .addContainerGap(39, Short.MAX_VALUE)
                                .addGroup(accueilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelVelo)
                                        .addComponent(labelMalin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(boutonCommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(imageAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE))
        );

        labelCredits.setText("<html>\n&nbsp;Crédits:<br/>\n&nbsp;&nbsp;&nbsp;Développé par Maxime Brunet, Christophe Chaumier, Emmanuela Calmel, Florian Vautard et Pierre-Emmanuel Cochet.<br/>\n&nbsp;&nbsp;&nbsp;Licence MIT. Projet CPE Lyon. Données publiques JCDecaux vélo'v du Grand Lyon.\n</html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelCredits, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                        .addComponent(accueilPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(accueilPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
}
