//Created by Andrew Garneau.
//This drum kit simulator plays different notes depending on the key pressed.
//sounds were collected from freesound.org

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

//class that runs the entire drum application
public class MyFunDrums extends Application {

	//method sets the text labels for the drums, to remove bulk hard code from main code.
	public void locateLabels(Label[] drumIcons) {
		
		for (int i=0;i<15;i++) {
			drumIcons[i]=new Label();
			drumIcons[i].setTextFill(Color.RED);
			drumIcons[i].setFont(Font.font("Cambria", FontWeight.BOLD,24));
		}
		
		drumIcons[0].setText("SPACE");
		drumIcons[0].setLayoutX(265);
		drumIcons[0].setLayoutY(195);
		
		drumIcons[1].setText("S");
		drumIcons[1].setLayoutX(155);
		drumIcons[1].setLayoutY(275);
		
		drumIcons[2].setText("D");
		drumIcons[2].setLayoutX(195);
		drumIcons[2].setLayoutY(275);
		
		drumIcons[3].setText("J");
		drumIcons[3].setLayoutX(133);
		drumIcons[3].setLayoutY(325);
		
		drumIcons[4].setText("K");
		drumIcons[4].setLayoutX(125);
		drumIcons[4].setLayoutY(357);
		
		drumIcons[5].setText("L");
		drumIcons[5].setLayoutX(175);
		drumIcons[5].setLayoutY(333);
		
		drumIcons[6].setText("Q");
		drumIcons[6].setLayoutX(210);
		drumIcons[6].setLayoutY(140);
		
		drumIcons[7].setText("W");
		drumIcons[7].setLayoutX(235);
		drumIcons[7].setLayoutY(140);
		
		drumIcons[8].setText("E");
		drumIcons[8].setLayoutX(350);
		drumIcons[8].setLayoutY(125);
		
		drumIcons[9].setText("R");
		drumIcons[9].setLayoutX(350);
		drumIcons[9].setLayoutY(155);
		
		drumIcons[10].setText("T");
		drumIcons[10].setLayoutX(410);
		drumIcons[10].setLayoutY(300);
		
		drumIcons[11].setText("Y");
		drumIcons[11].setLayoutX(450);
		drumIcons[11].setLayoutY(300);
		
		drumIcons[12].setText("U");
		drumIcons[12].setLayoutX(160);
		drumIcons[12].setLayoutY(230);
		
		drumIcons[13].setText("H");
		drumIcons[13].setLayoutX(510);
		drumIcons[13].setLayoutY(260);
		
		drumIcons[14].setText("I");
		drumIcons[14].setLayoutX(440);
		drumIcons[14].setLayoutY(200);
	}
	
	//changes the pressed key label to green.
	public void colourSwap(Label[] drumIcons, int selected) {
		for (int i = 0; i<15;i++) {
			drumIcons[i].setTextFill(Color.RED);
		}
		drumIcons[selected].setTextFill(Color.GREEN);
	}
	
	//launches start
	public static void main(String[]args) {
		launch(args);
	}
	
	@Override
	public void start (Stage theStage){
		
		//sets up entire form
		theStage.setTitle("Drums - JavaFX Sound Test");
		Group root = new Group();
		Scene theScene = new Scene(root);
		theStage.setScene(theScene);
		theStage.setResizable(false);
		theStage.sizeToScene();
		Canvas canvas = new Canvas(650,479);
		theScene.setFill(Color.RED);
		root.getChildren().add(canvas);
		theStage.show();
		
		//draws drumkit into window
		Image imDrumKit = new Image("FullKit (2).jpg");
		ImageView testiv;
		testiv= new ImageView(imDrumKit);
		testiv.setX(0);
		testiv.setY(0);
		testiv.setFitWidth(650);
		testiv.setPreserveRatio(true);
		testiv.setSmooth(true);
		testiv.setCache(true);
		root.getChildren().add(testiv);
		
		//mouse location code
//		Label mouseLocation = new Label(); 
//		root.getChildren().add(mouseLocation);
//		theScene.setOnMouseMoved(
//				new EventHandler<MouseEvent>(){
//				
//					public void handle(MouseEvent e){
//						
//						String mousePosition = "("+e.getX()+ "," + e.getY() + ")";
//						
//						mouseLocation.setLayoutX(01);
//						mouseLocation.setLayoutY(theStage.getHeight()-50);
//						mouseLocation.setTextFill(Color.BLACK);
//						mouseLocation.setFont(Font.font("Cambria", FontWeight.BOLD,20));
//						mouseLocation.setText(mousePosition);
//
//					}
//				});
		
		//creates, locates, and adds on labels to indicate which key is which drum.
		Label drumIcons[] = new Label[15];
		locateLabels(drumIcons);
		for (int i=0;i<15;i++) {
			root.getChildren().add(drumIcons[i]);
		}
		
		//all audiofiles for the drum program
		AudioClip snare = new AudioClip(this.getClass().getResource("snare.wav").toString());
		AudioClip kick = new AudioClip(this.getClass().getResource("kick.wav").toString());
		AudioClip china = new AudioClip(this.getClass().getResource("china.wav").toString());
		AudioClip crash = new AudioClip(this.getClass().getResource("crash.wav").toString());
		AudioClip hhClose = new AudioClip(this.getClass().getResource("hihat-closed.wav").toString());
		AudioClip hhOpen = new AudioClip(this.getClass().getResource("hihat-open.wav").toString());
		AudioClip ride = new AudioClip(this.getClass().getResource("ride.wav").toString());
		AudioClip fTom = new AudioClip(this.getClass().getResource("tom-floor.wav").toString());
		AudioClip hTom = new AudioClip(this.getClass().getResource("tom-hi.wav").toString());
		AudioClip mTom = new AudioClip(this.getClass().getResource("tom-mid.wav").toString());
		
		//key events that play the drum sounds
		theScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event){
				
				switch (event.getCode()) {
					case SPACE: kick.play(); colourSwap(drumIcons, 0); break;
		        	case S: snare.play(); colourSwap(drumIcons, 1); break;
		        	case D: snare.play(); colourSwap(drumIcons, 2); break;
		        	case J: hhClose.play(); colourSwap(drumIcons, 3); break;
		        	case K: hhClose.play(); colourSwap(drumIcons, 4); break;
		        	case L: hhOpen.play(); colourSwap(drumIcons, 5); break;
		        	case Q: hTom.play(); colourSwap(drumIcons, 6); break;
		        	case W: hTom.play(); colourSwap(drumIcons, 7); break;
		        	case E: mTom.play(); colourSwap(drumIcons, 8); break;
		        	case R: mTom.play(); colourSwap(drumIcons, 9); break;
		        	case T: fTom.play(); colourSwap(drumIcons, 10); break;
		        	case Y: fTom.play(); colourSwap(drumIcons, 11); break;
		        	case U: crash.play(); colourSwap(drumIcons, 12); break;
		        	case H: ride.play(); colourSwap(drumIcons, 13); break;
		        	case I: china.play(); colourSwap(drumIcons, 14); break;
				default:
					break;
				}
			}
		});
		
	}
}
