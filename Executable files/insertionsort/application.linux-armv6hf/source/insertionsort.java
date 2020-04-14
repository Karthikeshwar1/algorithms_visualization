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

public class insertionsort extends PApplet {

int[] values; // valuesay to be visualized
int i = 0, j = 0, key;
PFont font;

public void setup() {
   //Window size
  values = new int[width]; // Create an valuesay of size 'width'(of screen)

  // For the text display
  font = loadFont("SegoeUI-Bold-18.vlw");
  fill(255);
  textFont(font);

  // Assign a random value (any integer within 'height' of screen)
  // to each of 'width' number of values
  for (int i = 0; i < values.length; i++) {
    values[i] = (int)random(height);
  }
}


public void draw() {
  background(0);

  text("Insertion Sort", 30, 30);

  if (i < values.length) {
    key = values[i]; 
    j = i - 1; 

    while (j >= 0 && values[j] > key) { 
      values[j + 1] = values[j]; 
      j = j - 1;
    } 
    values[j + 1] = key;
  } else {
    println("Animation finished");
    noLoop();
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
    String[] appletArgs = new String[] { "insertionsort" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
