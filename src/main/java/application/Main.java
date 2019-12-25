
package application;

import java.io.File;
import java.io.InputStream;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	private double xOffset = 0;
	private double yOffset = 0;

	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(Main.class.getResource("view/View.fxml"));

			primaryStage.initStyle(StageStyle.TRANSPARENT);

			root.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {

					xOffset = event.getSceneX();
					yOffset = event.getSceneY();

				}

			});

			root.setOnMouseDragged(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					primaryStage.setX(event.getScreenX() - xOffset);

					primaryStage.setY(event.getScreenY() - yOffset);

				}
			});

			Scene scene = new Scene(root);
			scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
			//scene.getStylesheets().add()
			primaryStage.setScene(scene);

			// System.out.println(new Image("file:resources/images/toolkit.png"));
			primaryStage.getIcons().add(new Image("file:lib/images/logo.png"));
			primaryStage.setTitle("Ground Station");

			primaryStage.centerOnScreen();
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);
	}

	public static String runPath() {
		File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
		return jarDir.getAbsolutePath().replace("\\target\\classes", "\\");
	}
}
