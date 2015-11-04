package was.google_map_api.model;

/**
 * Created by laurel on 04/11/2015.
 */
public class ResultsWas {

        private AdressWas adress_components;
        private String formatted_address;
        private GeometryWas geometry;
        private String place_id;
        private String types[];

        public AdressWas getAdress_components() {
                return adress_components;
        }

        public String getFormatted_address() {
                return formatted_address;
        }

        public GeometryWas getGeometry() {
                return geometry;
        }

        public String getPlace_id() {
                return place_id;
        }

        public String[] getTypes() {
                return types;
        }
}
