import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


// TODO: Auto-generated Javadoc
/**
 * The Class ClockPane.
 */
public class ClockPane extends Pane {
	
	/** The hour. */
	private double hour;
	
	/** The minute. */
	private double minute;
	
	/** The second. */
	private double second;
	
	/** The ms. */
	private double ms; 
	
	/**
	 * Instantiates a new clock pane.
	 */
	public ClockPane() {
		setCurrentTime();
			
	}

	/**
	 * Instantiates a new clock pane.
	 *
	 * @param hour the hour
	 * @param minute the minute
	 * @param second the second
	 */
	public ClockPane(int hour, int minute, int second) {
		this.hour = hour; 
		this.minute = minute; 
		this.second = second; 
	}

	/**
	 * Gets the hour.
	 *
	 * @return the hour
	 */
	public double getHour() {
		return hour;
	}
	
	/**
	 * Sets the hour.
	 *
	 * @param hour the new hour
	 */
	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
	}

	/**
	 * Gets the minute.
	 *
	 * @return the minute
	 */
	public double getMinute() {
		return minute;
	}
	
	/**
	 * Sets the minute.
	 *
	 * @param minute the new minute
	 */
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
	}
	
	/**
	 * Gets the second.
	 *
	 * @return the second
	 */
	public double getSecond() {
		return second;
	}
	
	/**
	 * Sets the second.
	 *
	 * @param second the new second
	 */
	public void setSecond(int second) {
		this.second = second;
		paintClock();
	}
	
	
	/**
	 * Sets the current time.
	 */
	public void setCurrentTime() {
			Calendar calendar = new GregorianCalendar();
			this.ms = calendar.get(Calendar.MILLISECOND);
			this.second = calendar.get(Calendar.SECOND)+ ms/1000;
			this.minute = calendar.get(Calendar.MINUTE)+ second/60;
			this.hour = calendar.get(Calendar.HOUR_OF_DAY) + minute/60;
			paintClock();
			
	}
	
	/**
	 * Paint clock.
	 */
	private void paintClock() {
		// Code the clock based upon getWidth(), getHeight();
		double clockRadius = Math.min(getWidth(),getHeight()) * 0.4;
		double centerX = getWidth()/2;
		double centerY = getHeight()/2;
		
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		
		// don't touch this code...
		Text t1 = new Text(centerX-5,centerY-clockRadius+12,"12");
		Text t2 = new Text(centerX-clockRadius+3,centerY+5,"9");
		Text t3 = new Text(centerX+clockRadius-10,centerY+3,"3");
		Text t4 = new Text(centerX-3,centerY+clockRadius-3,"6");
		
                // sLength is the length of the second hand
		double sLength = clockRadius * 0.8;
		// You need to calculate the X,Y values of the endpoint
		double secondX = centerX + sLength * Math.sin(getSecond() * Math.PI/30);
		double secondY = centerY - sLength * Math.cos((getSecond()) * Math.PI/30); 
		Line sLine = new Line(centerX,centerY,secondX,secondY);
		sLine.setStroke(Color.RED); // adjust your own color here
		
                // mLength is the length of the minute hand
		double mLength = clockRadius * 0.65;
		// You need to calculate the X,Y values of the endpoint
		double minuteX = centerX + (mLength * Math.sin(getMinute() * Math.PI/30));
		double minuteY = centerY - (mLength * Math.cos(getMinute()* Math.PI/30));
		Line mLine = new Line(centerX,centerY,minuteX,minuteY);
		mLine.setStroke(Color.BLUE); // adjust your own color here
		
                // hLength is the length of the hour hand
		double hLength = clockRadius * 0.5;
		// You need to calculate the X,Y values of the endpoint
		double hourX = centerX + (hLength * Math.sin(getHour() * Math.PI/6)); 
		double hourY = centerY - (hLength * Math.cos(getHour() * Math.PI/6));
		Line hLine = new Line(centerX,centerY,hourX,hourY);
		hLine.setStroke(Color.GREEN); // adjust your own color here...
		
		getChildren().clear();
		getChildren().addAll(circle,t1,t2,t3,t4,sLine,mLine,hLine);
	}
	
	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	// The next two methods of BorderPane are overridden because we need to force a repaint of the clock
	@Override 
	public void setWidth(double width) {
		super.setWidth(width);
		paintClock();
		//setCurrentTime();
	}
	
	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	@Override
	public void setHeight(double height) {
		super.setHeight(height); 
		paintClock();
	}
	
}
