package was.google_map_api.model;

/**
 * Created by laurel on 04/11/2015.
 */
public class GeometryWas {
    private PositionWas bounds;
    private LocalisationWas location;
    private String location_type;
    private PositionWas viewport;

    public PositionWas getBounds() {
        return bounds;
    }

    public LocalisationWas getLocation() {
        return location;
    }

    public String getLocation_type() {
        return location_type;
    }

    public PositionWas getViewport() {
        return viewport;
    }
}
