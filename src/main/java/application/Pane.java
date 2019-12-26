package application;

import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.Tile.SkinType;
import eu.hansolo.tilesfx.Tile.TileColor;
import eu.hansolo.tilesfx.tools.FlowGridPane;
import eu.hansolo.tilesfx.tools.Location;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Pane extends Application{
	  
	private Tile            worldTile;

	
	
    private long            lastTimerCall;
    private AnimationTimer  timer;
    private DoubleProperty  value;
    
	@Override public void init() {
		
		 worldTile = TileBuilder.create()
                 .prefSize(1000, 1000)
                 .skinType(SkinType.WORLDMAP)
                 .title("Ground Track")
                 .borderWidth(0)
                 //.text("")
                 .textVisible(false)
                 .currentLocation(new Location(-15, -47, "Brasilia", TileColor.RED.color))
                 .build();
		 worldTile.addPoiLocation(new Location(-15, -47, "Brasilia", TileColor.RED.color));
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		FlowGridPane pane = new FlowGridPane(1, 1, worldTile);
		
        stage.getIcons().add(new Image("file:lib/images/logo.png"));
        stage.setTitle("Ground Station");
        //stage.setScene(scene);
        stage.show();
		
	}
	 
    @Override 
    public void stop() {

        timer.stop();

        System.exit(0);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
