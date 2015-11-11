package IHM.panel;


import IHM.IHMApplication;
import database.MysqlRequester;
import model.Station;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import recherche.StatistiquesStation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Pec
 */
public class StationPanel extends javax.swing.JPanel {
	
//	DefaultCategoryDataset datasetVelo24;
//    DefaultCategoryDataset datasetVelo;
//    ChartPanel panel;
//    ChartPanel panel2;
	
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
        datePickerOP = new org.jdesktop.swingx.JXDatePicker(new Date());
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
        comboSation.setMaximumSize(new java.awt.Dimension(400, 23));
        comboSation.setPreferredSize(new java.awt.Dimension(400, 23));
        
        labelDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDate.setText("Selectionner une date :");

        boutonStatistiques.setBackground(new java.awt.Color(51, 255, 51));
        boutonStatistiques.setText("Lancer les statistiques");
        boutonStatistiques.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boutonStatistiques.setContentAreaFilled(false);
        boutonStatistiques.setName("boutonStats"); // NOI18N
        
        boutonStatistiques.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id_station = ((Station) comboSation.getSelectedItem()).getId_station();
				int placesMax = ((Station) comboSation.getSelectedItem()).getPlaces();
				int indexHeure = comboHeure.getSelectedIndex();
				Calendar cal = Calendar.getInstance();
				cal.setTime(datePickerOP.getDate());
				
				Calendar cal2 = (Calendar) cal.clone();
				if(indexHeure == 0){
					cal2.set(Calendar.HOUR_OF_DAY, 00);
	                cal2.set(Calendar.MINUTE, 00);
				} else if(indexHeure == 1){
					cal2.set(Calendar.HOUR_OF_DAY, 06);
	                cal2.set(Calendar.MINUTE, 00);
				} else if(indexHeure == 2){
					cal2.set(Calendar.HOUR_OF_DAY, 12);
	                cal2.set(Calendar.MINUTE, 00);
				} else if(indexHeure == 3){
					cal2.set(Calendar.HOUR_OF_DAY, 18);
	                cal2.set(Calendar.MINUTE, 00);
				} else {
					cal2.set(Calendar.HOUR_OF_DAY, 06);
	                cal2.set(Calendar.MINUTE, 00);
				}

				DefaultCategoryDataset datasetVelo24 = createVeloDataset(id_station, placesMax, cal, 24);
			    DefaultCategoryDataset datasetVelo = createVeloDataset(id_station, placesMax, cal2, 6);
			 
			    if (panelGraph1 != null && panelGraph2 != null)
			    {
			    	if (panelGraph1.getComponentCount() != 0 && panelGraph2.getComponentCount() != 0)
			    	{
				    	panelGraph1.remove(0);
				    	panelGraph2.remove(0);
			    	}
			    }
			    panelGraph1.add(createPanel(createTableau24h(datasetVelo24)));
			    panelGraph1.repaint();
			    panelGraph1.revalidate();
			    
			    panelGraph2.add(createPanel(createTableauPlage(datasetVelo)));
			    panelGraph2.repaint();
			    panelGraph2.revalidate();
			}
		});

        labelHeure.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelHeure.setText("Choisir la plage horaire :");

        comboHeure.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboHeure.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "aurore: 00h00-06h00", "matin: 06h00-12h00", "après-midi: 12h00-18h00", "soirée: 18h00-00h00" }));
        
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
        
        panelGraph1 = createPanel(createTableau24h(new DefaultCategoryDataset()));
        panelGraph2 = createPanel(createTableauPlage(new DefaultCategoryDataset()));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(IHMApplication.panel3);
        IHMApplication.panel3.setLayout(layout);
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

    private DefaultCategoryDataset createVeloDataset(int id_station, int placesMax, Calendar cal, int heure){
    	
    	Calendar cal1 = (Calendar) cal.clone();	
    	Calendar cal2 = (Calendar) cal.clone();
    	cal2.set(Calendar.HOUR_OF_DAY, cal2.get(Calendar.HOUR_OF_DAY)+1);
    	cal2.set(Calendar.SECOND, cal2.get(Calendar.SECOND)-1);
    	
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	for(int i=0; i < heure+1; i++){
    		int  nbVelos = StatistiquesStation.getMoyenneNbVelosSurStation(id_station, cal1.getTime(), cal2.getTime(), null, null);
    		//int  nbPlaces = StatistiquesStation.getMoyenneNbPlacesSurStation(id_station, cal1.getTime(), cal2.getTime(), null, null);
     		if(nbVelos != -1){
    			dataset.setValue(nbVelos, "Velos", cal1.get(Calendar.HOUR_OF_DAY)+"h");
    		} else {
    			dataset.setValue(null, "Velos", cal1.get(Calendar.HOUR_OF_DAY)+"h");
    		}
    		//dataset.setValue(nbPlaces, "Places", cal.get(Calendar.HOUR)+"h");
    		dataset.setValue(placesMax, "Max", cal1.get(Calendar.HOUR_OF_DAY)+"h");
    		cal1.set(Calendar.HOUR_OF_DAY, cal1.get(Calendar.HOUR_OF_DAY)+1);
    		cal2.set(Calendar.HOUR_OF_DAY, cal2.get(Calendar.HOUR_OF_DAY)+1);
    	}
    	
		return dataset;
    }
    
    private JFreeChart createTableau24h(DefaultCategoryDataset dataset){
    	JFreeChart chart = ChartFactory.createLineChart(
                "Nombre de vélos sur 24h", "Temps", "Nombre de vélos", dataset,
                PlotOrientation.VERTICAL, false, true, false);
        return chart;
    }        		
    
    private ChartPanel createPanel(JFreeChart chart ){
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartPanel panel = new ChartPanel(chart);
       
        panel.setPreferredSize(new java.awt.Dimension(600, 420));
        panel.setDomainZoomable(true);
        return panel;
    }
    
    private JFreeChart createTableauPlage(DefaultCategoryDataset dataset){
	    JFreeChart chart2 = ChartFactory.createLineChart(
	            "Nombre de vélos sur la plage", "Temps", "Nombre de vélos", dataset,
	            PlotOrientation.VERTICAL, false, true, false);
	    return chart2;
    }

}
