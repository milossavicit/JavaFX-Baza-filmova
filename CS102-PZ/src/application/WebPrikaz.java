package application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class WebPrikaz{

    //Web prikaz IMDB sajta.
    public void IMDB() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("IMDB");
        primaryStage.setWidth(1100);
        primaryStage.setHeight(700);
        Scene scene = new Scene(new Group());
        AnchorPane root = new AnchorPane();    
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        browser.setPrefSize(1100, 700);

        webEngine.load("http://www.imdb.com/");
        
        root.getChildren().addAll(browser);
        scene.setRoot(root);
 
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
