package was.model;

/**
 * Created by florian on 2015-10-11.
 */

/* Ce mod�le est une representation en java de ce que retourne le service web,
    NE PAS MODIFIER
 */
public class StationWas
{
    private int number;
    private String contract_name;
    private String name;
    private String address;
    private PositionWas position;
    private boolean banking;
    private boolean bonus;
    private String status;
    private int bike_stands;
    private int available_bike_stands;
    private int available_bikes;
    private double last_update;

    public int getNumber() {
        return number;
    }

    public String getContract_name() {
        return contract_name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public PositionWas getPosition() {
        return position;
    }

    public boolean isBanking() {
        return banking;
    }

    public boolean isBonus() {
        return bonus;
    }

    public String getStatus() {
        return status;
    }

    public int getBike_stands() {
        return bike_stands;
    }

    public int getAvailable_bike_stands() {
        return available_bike_stands;
    }

    public int getAvailable_bikes() {
        return available_bikes;
    }

    public double getLast_update() {
        return last_update;
    }
}
