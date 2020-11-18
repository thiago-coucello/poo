import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Stage;

public class PlayAudio extends Application{
	
	/**
	 * water_drop_sound_effect.mp3
	 */
	Button btn, btn2;
	String bip = "som_carta.mp3";
	Media hit = new Media(new File(bip).toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(hit);
	FlowPane painel_musica = new FlowPane();
 
	@Override
	public void start(Stage stage1) throws Exception {
		// TODO Auto-generated method stub
		stage1.setTitle("Audio Player");
		btn = new Button("Play");
		btn2 = new Button("Stop");
	
		mediaPlayer.setVolume(0.020);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(mediaPlayer.getStatus().equals(Status.PLAYING)) {
					mediaPlayer.stop();
					mediaPlayer.play();
				}
				else {
					mediaPlayer.play();
				}
			}
			
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mediaPlayer.stop();
			}
			
		});
		
		FlowPane root = new FlowPane();
		root.getChildren().add(btn);
		root.getChildren().add(btn2);
		
		stage1.setScene(new Scene(root,300,250));
		stage1.show();
		
	}
	
	
 
    public static void main(String[] args) {
    	launch(args);
    }

}