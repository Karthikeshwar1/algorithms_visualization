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

public class selectionsort extends PApplet {

int[] values; //values to be visualized
int i = 0, j = 0, min_idx = 0, temp = 0;
PFont font;

public void setup() {
  
  values = new int[width];

  // For the text display
  font = loadFont("SegoeUI-Bold-18.vlw");
  fill(255);
  textFont(font);
  
  // Assign random values to the array
  for (int i = 0; i < values.length; i++) {
    values[i] = (int)random(height);
  }
}

public void draw() {
  background(0);

  text("Selection Sort", 30, 30);

  if (i < values.length) {
    min_idx = i; 
    for (j = i+1; j < values.length; j++) 
      if (values[j] < values[min_idx])
        min_idx = j; 

    temp = values[min_idx]; 
    values[min_idx] = values[i]; 
    values[i] = temp;
  } else {
    println("Animation finished");
    noLoop();
  }
  i++;

  // Each time the array is sorted, print that frame
  // This makes it an animation
  for (int i = 0; i < values.length; i++) {
    stroke(255);
    line(i, height, i, height-values[i]);
  }
}
  public void settings() {  size(650, 450); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "selectionsort" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
