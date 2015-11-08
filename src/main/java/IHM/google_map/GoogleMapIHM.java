package IHM.google_map;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example Application for creating and loading a GoogleMapIHM into a JavaFX
 * application
 *
 * @author Rob Terpilowski
 */
public class GoogleMapIHM extends Application implements MapComponentInitializedListener {

    protected GoogleMapView mapComponent;
    protected com.lynden.gmapsfx.javascript.object.GoogleMap map;
    private Scene scene;

    private Button btnZoomIn;
    private Button btnZoomOut;
    private Label lblZoom;
    private Label lblCenter;
    private Label lblClick;
    private ComboBox<MapTypeIdEnum> mapTypeCombo;

    private MarkerOptions markerOptions2;
    private Marker myMarker2;

    private Map<String, Marker> listMarker = new HashMap<>();

    private Button btnHideMarker;
    private Button btnDeleteMarker;

    private static GoogleMapIHM instance = null;

    private GoogleMapIHM()
    {
        try
        {
            start(new Stage());
        }
        catch (Exception e)
        {

        }
    }

    public static GoogleMapIHM getInstance() {
        if (instance == null) {
            instance = new GoogleMapIHM();
        }
        return instance;
    }

    public void reset()
    {
        try
        {
            start(new Stage());
        }
        catch (Exception e)
        {

        }
    }

    @Override
    public void start(final Stage stage) throws Exception {
        mapComponent = new GoogleMapView();
        mapComponent.addMapInializedListener(this);

        BorderPane bp = new BorderPane();
        ToolBar tb = new ToolBar();

        btnZoomIn = new Button("Zoom In");
        btnZoomIn.setOnAction(e -> {
            map.zoomProperty().set(map.getZoom() + 1);
        });
        btnZoomIn.setDisable(true);

        btnZoomOut = new Button("Zoom Out");
        btnZoomOut.setOnAction(e -> {
            map.zoomProperty().set(map.getZoom() - 1);
        });
        btnZoomOut.setDisable(true);

        lblZoom = new Label();
        lblCenter = new Label();
        lblClick = new Label();

        mapTypeCombo = new ComboBox<>();
        mapTypeCombo.setOnAction(e -> {
            map.setMapType(mapTypeCombo.getSelectionModel().getSelectedItem());
        });
        mapTypeCombo.setDisable(true);

        Button btnType = new Button("Map type");
        btnType.setOnAction(e -> {
            map.setMapType(MapTypeIdEnum.HYBRID);
        });

        btnHideMarker = new Button("Hide Marker");
        btnHideMarker.setOnAction(e -> {
            hideMarker();
        });

        btnDeleteMarker = new Button("Delete Marker");
        btnDeleteMarker.setOnAction(e -> {
            deleteMarker();
        });

        tb.getItems().addAll(btnZoomIn, btnZoomOut, mapTypeCombo,
                new Label("Zoom: "), lblZoom,
                new Label("Center: "), lblCenter,
                new Label("Click: "), lblClick,
                btnHideMarker, btnDeleteMarker);

        bp.setTop(tb);
        bp.setCenter(mapComponent);

        scene = new Scene(bp);
        // stage.setScene(scene);
        // stage.show();
    }

    public Scene getScene()
    {
        return scene;
    }

    @Override
    public void mapInitialized() {
        //Once the map has been loaded by the Webview, initialize the map details.
        LatLong center = new LatLong(45.743317, 4.815747);
        mapComponent.addMapReadyListener(() -> {
            // This call will fail unless the map is completely ready.
            checkCenter(center);
        });

        MapOptions options = new MapOptions();
        options.center(center)
                .mapMarker(true)
                .zoom(15)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .mapType(MapTypeIdEnum.TERRAIN);

        map = mapComponent.createMap(options);

 }

    public void ajouterUnPanneauInformation(String nom, String texteAfficher, Double latitude, Double longitude) {
        Marker marker = creeUnMarker(nom, latitude, longitude);
        InfoWindowOptions infoOptions = new InfoWindowOptions();
        infoOptions.content(texteAfficher);
        map.addMarker(marker);

        InfoWindow window = new InfoWindow(infoOptions);
        window.open(map, marker);
        listMarker.put(nom, marker);
    }

    public void ajouterUnMarker(String nom, Double latitude, Double longitude) {
        Marker marker = creeUnMarker(nom, latitude, longitude);
        listMarker.put(nom, marker);
        map.addMarker(marker);
    }

    private Marker creeUnMarker(String nom, Double latitude, Double longitude) {
        MarkerOptions markerOptions = new MarkerOptions();
        LatLong markerLatLong = new LatLong(latitude, longitude);
        markerOptions.position(markerLatLong)
                .title(nom)
                .visible(true);

        return new Marker(markerOptions);
    }

    public void supprimeMarkerOuPanneau(String nom)
    {
        map.removeMarker(listMarker.get(nom));
        listMarker.remove(nom);
    }



/*
    public void addMarker(double longitude, double latitude)
    {
        MarkerOptions markerOptions = new MarkerOptions();
        LatLong markerLatLong = new LatLong(longitude, latitude);
        markerOptions.position(markerLatLong)
                .title("My new Marker")
                .animation(Animation.DROP)
                .visible(true);
    } */


    private void hideMarker() {
//		System.out.println("deleteMarker");

        //boolean visible = myMarker2.getVisible();

        //System.out.println("Marker was visible? " + visible);

        //myMarker2.setVisible(! visible);

//				markerOptions2.visible(Boolean.FALSE);
//				myMarker2.setOptions(markerOptions2);
//		System.out.println("deleteMarker - made invisible?");
    }

    private void deleteMarker() {
        //System.out.println("Marker was removed?");
        map.removeMarker(myMarker2);
    }

    private void checkCenter(LatLong center) {
//        System.out.println("Testing fromLatLngToPoint using: " + center);
//        Point2D p = map.fromLatLngToPoint(center);
//        System.out.println("Testing fromLatLngToPoint result: " + p);
//        System.out.println("Testing fromLatLngToPoint expected: " + mapComponent.getWidth()/2 + ", " + mapComponent.getHeight()/2);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("java.net.useSystemProxies", "true");
        launch(args);
    }

}
