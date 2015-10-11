package was.model;

import java.util.ArrayList;

/**
 * Created by florian on 2015-10-11.
 */

/* Ce modèle est une representation en java de ce que retourne le service web,
    NE PAS MODIFIER
 */
public class Station
{
    private int number;
    private String contract_name;
    private String name;
    private String address;
    private Position position;
    private boolean banking;
    private boolean bonus;
    private String status;
    private int bike_stands;
    private int available_bike_stands;
    private int available_bikes;
    private double last_update;
}
