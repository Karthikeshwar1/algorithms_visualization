import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class bubblesort extends PApplet {

int[] values; // Array to be visualized
int i = 0, j = 0;
PFont font, font1;
String disp_iterations, disp_exec_time;

public void setup() {
   //Window size
  values = new int[width]; // Create an array of size 'width'(of screen)
  //frameRate(60);

  // For the text display
  font = loadFont("SegoeUI-Bold-18.vlw");
  font1 = loadFont("SegoeUI-Light-15.vlw");
  fill(255);

  // Assign a random value (any integer within 'height' of screen)
  // to each of 'width' number of values
  for (int i = 0; i < values.length; i++) {
    values[i] = (int)random(height);
  }
}


public void draw() {
  background(0);

  disp_iterations = "Iterations : "+Integer.toString(values.length-i);
  textFont(font);
  text("Bubble Sort", 30, 30);
  textFont(font1);
  text(disp_iterations, 30, 50);

  // The following is just bubble sort implemented
  // in a way so that it is easy to visualize
  // Note : draw() executes 60 times a second

  if (i < values.length) {
    for (int j = 0; j < values.length-i-1; j++) {
      if (values[j] > values[j+1]) {
        int temp = values[j];
        values[j] = values[j+1];
        values[j+1] = temp;
      }
    }
  } else {
    println("Animation finished");
    noLoop();
    float exec_time = millis();
    disp_exec_time = "Execution time : " + Float.toString(exec_time/1000) + " seconds";
    text(disp_exec_time, 30, 80);
  }
  i++;

  // Each time the array is sorted, print that frame
  // This makes it an animation
  for (int i = 0; i < values.length; i++) {
    stroke(255); //color of lines
    // line(x1,y1,x2,y2) where (x1,y1) and (x2,y2) are two points of the line
    line(i, height, i, height-values[i]);
  }
}
  public void settings() {  size(650, 450); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "bubblesort" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
