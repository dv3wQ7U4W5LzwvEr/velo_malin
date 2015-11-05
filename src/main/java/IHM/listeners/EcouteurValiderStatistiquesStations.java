package IHM.listeners;

import database.MysqlConnecter;
import database.MysqlRequester;
import model.Client;
import model.Station;
import recherche.StatistiquesStation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * Created by laurel on 03/11/2015.
 */
public class EcouteurValiderStatistiquesStations implements ActionListener{

    private int id_station;
    private Date date_station;
    
    //List<Integer> tab_test_dep = new ArrayList<Integer>();
    //List<Integer> tab_test_arr = new ArrayList<Integer>();

    public EcouteurValiderStatistiquesStations(int id_station, Date date_station) {
        this.id_station = id_station;
        this.date_station = date_station;
    }


	public void actionPerformed(ActionEvent e) {


        
        
    }
}
