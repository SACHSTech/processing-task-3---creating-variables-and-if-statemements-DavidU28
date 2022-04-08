 /**
  * The program Sketch.java draws a flower in a random location and based on the quadrant the flower is in, the progam will change the 
  * colour of the backround. Red for quadrant 1, blue for quadrant 2, green for quadrant 3, and purple for quadrant 4.
  */

import processing.core.PApplet;

public class Sketch extends PApplet {

    float circleX;
    float circleY;

    int intSeconds;
    int intMinutes;
    int intHours;
    String digitalClock;

  public void settings() {
	  
    // put your size call here
    size(400, 400);

    // Values for time
    intSeconds = second();  
    intMinutes = minute(); 
    intHours = hour();
    
    }

  /** 
  * Called once at the beginning of execution.  Add initial set up
  * values here i.e background, stroke, fill etc.
  */
  
  public void setup() {
 
    circleX = random(32, 368);
    circleY = random(50, 350);

    boolean quad1 = (circleX <= 200) && (circleY <= 200);
    boolean quad2 = (circleX >= 200) && (circleY <= 200);
    boolean quad3 = (circleX <= 200) && (circleY >= 200);
    boolean quad4 = (circleX >= 200) && (circleY >= 200);

    if (quad1){
    background(255, 51, 51);
    }
    else if (quad2){
    background(31, 190, 214);
    }
    else if (quad3){
    background(102, 255, 102);
    }
    else if (quad4){
    background(102, 0, 153);
    } 
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
    
  public void draw() {

    // Grid
    strokeWeight(1);
    stroke(0);
    line(0, 200, width, 200);
    line(200, 0, 200, height);
	  
    // Flower
    
    // Stem
    strokeWeight(5);
    stroke(0, 128, 0);
    line(circleX, circleY + 33, circleX, circleY + 8);

    // Petals
    fill(255, 255, 0);
    stroke(0);
    strokeWeight(0);
    ellipse(circleX - 8, circleY - 8, 16, 16);
    ellipse(circleX + 8, circleY - 8, 16, 16);
    ellipse(circleX - 8, circleY + 8, 16, 16);
    ellipse(circleX + 8, circleY + 8, 16, 16);

    // Middle Petal
    fill(255, 100, 0);
    stroke(0);
    strokeWeight(0);
    ellipse(circleX, circleY, 16, 16);

    // Grid order
    textSize(10);
    fill(0);
    text("1", 5, 20);
    text("2", 205, 20);
    text("3", 5, 215);
    text("4", 205, 215);

    // Digital clock
    boolean time = (intHours >= 12);
    boolean time2 = (intHours <= 12);
  
    if (time){
    digitalClock = (str(intHours - 12) + ":" + str(intMinutes) + ":" + str(intSeconds));
    }
    else if (time2){
    digitalClock = (str(intHours) + ":" + str(intMinutes) + ":" + str(intSeconds));
    }

    fill(0);
    textSize(15);
    text(digitalClock, 340, 390);
 
   }
  
}
