package IHM.panel;


import database.MysqlRequester;
import model.Jours;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author Pec
 */
public class StationPanel extends javax.swing.JPanel {

    /*Constructeur*/
    public StationPanel() {
        initComponents();
    }

    /*Variables*/
    private javax.swing.JButton boutonStatistiques;
    private javax.swing.JComboBox comboHeure;
    private javax.swing.JComboBox comboSation;
    private org.jdesktop.swingx.JXDatePicker datePickerOP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelHeure;
    private javax.swing.JLabel labelNombrePlaces;
    private javax.swing.JLabel labelNombreTotal;
    private javax.swing.JLabel labelNombreTrafic;
    private javax.swing.JLabel labelNombreVelos;
    private javax.swing.JLabel labelPlaces;
    private javax.swing.JLabel labelSation;
    private javax.swing.JLabel labelStationIcon;
    private javax.swing.JLabel labelTitre1;
    private javax.swing.JLabel labelTitre2;
    private javax.swing.JLabel labelTitrePan;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTrafic;
    private javax.swing.JLabel labelVelos;
    private javax.swing.JPanel panelGraph1;
    private javax.swing.JPanel panelGraph2;
    private javax.swing.JPanel panelIdentite;


    /*Méthode*/
    private void initComponents(){

        jPanel1 = new javax.swing.JPanel();
        labelTitrePan = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelSation = new javax.swing.JLabel();
        comboSation = new javax.swing.JComboBox();
        labelDate = new javax.swing.JLabel();
        boutonStatistiques = new javax.swing.JButton();
        labelHeure = new javax.swing.JLabel();
        comboHeure = new javax.swing.JComboBox();
        datePickerOP = new org.jdesktop.swingx.JXDatePicker();
        panelGraph1 = new javax.swing.JPanel();
        panelGraph2 = new javax.swing.JPanel();
        labelTitre1 = new javax.swing.JLabel();
        labelTitre2 = new javax.swing.JLabel();
        panelIdentite = new javax.swing.JPanel();
        labelStationIcon = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        labelVelos = new javax.swing.JLabel();
        labelPlaces = new javax.swing.JLabel();
        labelTrafic = new javax.swing.JLabel();
        labelNombreTrafic = new javax.swing.JLabel();
        labelNombrePlaces = new javax.swing.JLabel();
        labelNombreTotal = new javax.swing.JLabel();
        labelNombreVelos = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelTitrePan.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        labelTitrePan.setText("STATISTIQUES SUR UNE STATION");

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        labelSation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSation.setText("Choisir la station :");

        comboSation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        // a remplacer lors de la demo comboSation.setModel(new javax.swing.DefaultComboBoxModel(MysqlRequester.getAdressesToutesLesStations().toArray()));
        comboSation.setModel(new javax.swing.DefaultComboBoxModel(MysqlRequester.getToutesLesStations().toArray()));
        comboSation.setMaximumSize(new java.awt.Dimension(172, 23));
        comboSation.setPreferredSize(new java.awt.Dimension(172, 23));

        labelDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDate.setText("Selectionner une date :");

        boutonStatistiques.setBackground(new java.awt.Color(51, 255, 51));
        boutonStatistiques.setText("Lancer les statistiques");
        boutonStatistiques.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boutonStatistiques.setContentAreaFilled(false);
        boutonStatistiques.setName("boutonStats"); // NOI18N

        labelHeure.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelHeure.setText("Choisir la plage horaire :");

        comboHeure.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboHeure.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "aurore: 00h00-07h00", "matin: 07h00-12h00", "après-midi: 12h00-17h00", "soirée: 17h00-00h00" }));
        comboHeure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboHeureActionPerformed(evt);
            }
        });

        datePickerOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerOPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelSation)
                                        .addComponent(labelDate)
                                        .addComponent(labelHeure))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboHeure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(datePickerOP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboSation, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boutonStatistiques, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelSation)
                                        .addComponent(comboSation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelDate)
                                        .addComponent(datePickerOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelHeure)
                                        .addComponent(comboHeure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addComponent(boutonStatistiques, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout panelGraph1Layout = new javax.swing.GroupLayout(panelGraph1);
        panelGraph1.setLayout(panelGraph1Layout);
        panelGraph1Layout.setHorizontalGroup(
                panelGraph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 484, Short.MAX_VALUE)
        );
        panelGraph1Layout.setVerticalGroup(
                panelGraph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 329, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelGraph2Layout = new javax.swing.GroupLayout(panelGraph2);
        panelGraph2.setLayout(panelGraph2Layout);
        panelGraph2Layout.setHorizontalGroup(
                panelGraph2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 496, Short.MAX_VALUE)
        );
        panelGraph2Layout.setVerticalGroup(
                panelGraph2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 329, Short.MAX_VALUE)
        );
        
       
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(0, "Marks", "1h");
        dataset.setValue(15, "Marks", "2h");
        dataset.setValue(20, "Marks", "3h");
        dataset.setValue(10, "Marks", "4h");
        dataset.setValue(7, "Marks", "5h");
        dataset.setValue(25, "Marks", "6h");
        dataset.setValue(6, "Marks", "7h");
        dataset.setValue(20, "Marks", "8h");
        dataset.setValue(35, "Marks", "9h");
        dataset.setValue(30, "Marks", "10h");
        
      //  getNombreDePlacesSurStationDansInterval(int id_station, Date dateX, Date dateY, List<Jours> jours, String jour_special)
        
      /*  List<Integer> ListeNbrStation;
        int id_station;
        
        for(id_station=0; id_station <8; id_station++)
        {
            dataset.getNombreDePlacesSurStationDansInterval(id_station, "Income",
                Double.toString(percent_array[i]));
        }
*/

      

        labelTitre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTitre1.setText("1. Nombre d'actions (retrait/ajout) en fonction de l'heure");

        labelTitre2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTitre2.setText("2. Evolution du nombre de vélos en fonction de l'heure");

        panelIdentite.setBackground(new java.awt.Color(255, 255, 255));
        panelIdentite.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carte d'identité", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14))); // NOI18N

        labelStationIcon.setIcon(new javax.swing.ImageIcon("src/main/resources/img/station.png")); // NOI18N

        labelTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTotal.setText("Places totales:");

        labelVelos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelVelos.setText("Velos (actuellement):");

        labelPlaces.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPlaces.setText("Places (actuellement):");

        labelTrafic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTrafic.setText("Tafic journalier:");
        labelTrafic.setEnabled(false);

        labelNombreTrafic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNombreTrafic.setIcon(new javax.swing.ImageIcon("src/main/resources/img/star.png")); // NOI18N
        labelNombreTrafic.setText("-");
        labelNombreTrafic.setEnabled(false);

        labelNombrePlaces.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNombrePlaces.setIcon(new javax.swing.ImageIcon("src/main/resources/img/mark.png")); // NOI18N
        labelNombrePlaces.setText("z");

        labelNombreTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNombreTotal.setIcon(new javax.swing.ImageIcon("src/main/resources/img/station.png")); // NOI18N
        labelNombreTotal.setText(String.valueOf(MysqlRequester.getNombreDePlaceTotaleSurUneStation(2470)));//TODO Changer l'id en fonction du choix

        labelNombreVelos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNombreVelos.setIcon(new javax.swing.ImageIcon("src/main/resources/img/velo.png")); // NOI18N
        labelNombreVelos.setText("y");
        
        JFreeChart chart = ChartFactory.createAreaChart(
                "Nombre de dépots et retraits par heure", "Nombre dépotes", "Nbr", dataset,
                PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.BLACK);
            ChartPanel panel = new ChartPanel(chart);
           
            panel.setPreferredSize(new java.awt.Dimension(600, 420));
            panel.setDomainZoomable(true);
            panelGraph1 = panel;
        
            JFreeChart chart2 = ChartFactory.createAreaChart(
                    "Nombre de vélos par heure", "Nombre dépotes", "Nbr", dataset,
                    PlotOrientation.VERTICAL, false, true, false);
                CategoryPlot p2 = chart2.getCategoryPlot();
                p.setRangeGridlinePaint(Color.BLACK);
                ChartPanel panel2 = new ChartPanel(chart2);
                panel2.setPreferredSize(new java.awt.Dimension(600, 420));
                panel2.setDomainZoomable(true);
                panelGraph2 = panel2;
            
            

        javax.swing.GroupLayout panelIdentiteLayout = new javax.swing.GroupLayout(panelIdentite);
        panelIdentite.setLayout(panelIdentiteLayout);
        panelIdentiteLayout.setHorizontalGroup(
                panelIdentiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelIdentiteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelStationIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelIdentiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelIdentiteLayout.createSequentialGroup()
                                                .addComponent(labelTotal)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelNombreTotal))
                                        .addGroup(panelIdentiteLayout.createSequentialGroup()
                                                .addComponent(labelVelos)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelNombreVelos))
                                        .addGroup(panelIdentiteLayout.createSequentialGroup()
                                                .addComponent(labelPlaces)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelNombrePlaces))
                                        .addGroup(panelIdentiteLayout.createSequentialGroup()
                                                .addComponent(labelTrafic)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(labelNombreTrafic)))
                                .addContainerGap(112, Short.MAX_VALUE))
        );
        
        
        
        panelIdentiteLayout.setVerticalGroup(
                panelIdentiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelStationIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelIdentiteLayout.createSequentialGroup()
                                .addGroup(panelIdentiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTotal)
                                        .addComponent(labelNombreTotal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelIdentiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelVelos)
                                        .addComponent(labelNombreVelos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelIdentiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPlaces)
                                        .addComponent(labelNombrePlaces))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelIdentiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTrafic)
                                        .addComponent(labelNombreTrafic)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelTitrePan)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(108, 108, 108)
                                                                .addComponent(panelIdentite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelTitre1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(panelGraph1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelTitre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(panelGraph2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelTitrePan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(19, 19, 19)
                                                .addComponent(panelGraph1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(panelIdentite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(panelGraph2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTitre1)
                                        .addComponent(labelTitre2))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

    }

    /*Listeneurs*/

    private void comboHeureActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void datePickerOPActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

}
