
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class DisplayClock.
 */
public class DisplayClock extends Application {
	 
 	/** The hour. */
 	public double hour; 
	 
 	/** The minute. */
 	public double minute;
	 
 	/** The second. */
 	public double second;
	 
 	/** The millisecond. */
 	public double millisecond; 
 /** The clock. */
 private static ClockPane clock; //idk why static
 
 /** The time string. */
 private String timeString; 
 
 /** The lbl current time. */
 private static Label lblCurrentTime;
 
 /** The pane. */
 private static BorderPane pane;
 
 
  /**
 * Start.
 *
 * @param primaryStage the primary stage
 */
@Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a clock and a label
    clock = new ClockPane();
    timeString = clock.getHour() + ":" + clock.getMinute() 
      + ":" + clock.getSecond();
    lblCurrentTime = new Label(timeString);

    // Place clock and label in border pane
    pane = new BorderPane();
    pane.setCenter(clock);
    pane.setBottom(lblCurrentTime);
    BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("DisplayClock"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    timer();
  }



  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
	  launch(args);  
  }
  
  /**
   * Update clock.
   */
  public void timer() {
	  Timeline t = 
			  new Timeline(new KeyFrame(Duration.millis(30), ae->
				  updateClock(clock, lblCurrentTime)));
	  t.setCycleCount(Animation.INDEFINITE);
	  t.play();
  }
  
  /**
   * Update clock.
   *
   * @param clock the clock
   * @param lblCurrentTime the lbl current time
   */
  public void updateClock(ClockPane clock, Label lblCurrentTime) {
	  clock.setCurrentTime(); 
	  setTimeString(clock);
	  lblCurrentTime = new Label(timeString);
	  pane.setBottom(lblCurrentTime);
	  BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
	  
  }
  
  /**
   * Sets the time string.
   *
   * @param clock the new time string
   */
  private void setTimeString(ClockPane clock) {
	  int hour =  (int) clock.getHour();
	  int minute = (int) clock.getMinute();
	  int second = (int)(clock.getSecond());
	  timeString = (hour < 10) ?"0"+hour : "" + hour;
	  timeString = timeString + ":" +((minute < 10) ? "0"+minute : minute);
	  timeString = timeString + ":" +((second < 10) ? "0"+second : second);

	  }


}