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

public class bin_sel_sort extends PApplet {

int[] value1, value2; // Arrays to be visualized
int i = 0, j = 0, min_idx = 0, temp = 0;
PFont font;

public void setup() {
   //Window size
  // Create two arrays of size 'width/2'(of screen)
  value1 = new int[width/2]; // For Bubble sort
  value2 = new int[width/2]; // For Selection sort
  
  // For the text display
  font = loadFont("SegoeUI-Bold-18.vlw");
  fill(255);
  textFont(font);
  
  for (int i = 0; i < value1.length; i++) {
    // Assign a random value (any integer within 'height' of screen)
    // to each of 'width' number of value1
    value1[i] = (int)random(height);
    value2[i] = (int)random(height);
  }
}


public void draw() {
  background(0);


  text("Bubble Sort", 30, 30);
  text("Selection Sort", value1.length+30, 30);
  // The following is just buuble sort implemented
  // in a way so that it is easy to visualize
  // Note : draw() executes 60 times a second
  // This can make visualization slow
  // Hence we are updating it 300 times every frame

  if (i < value1.length) {
    for (int j = 0; j < value1.length-i-1; j++) {
      if (value1[j] > value1[j+1]) {
        int temp = value1[j];
        value1[j] = value1[j+1];
        value1[j+1] = temp;
      }
    }
  } else {
    println("finished");
    noLoop();
  }
  if (i < value2.length) {
    min_idx = i; 
    for (j = i+1; j < value2.length; j++) 
      if (value2[j] < value2[min_idx])
        min_idx = j; 

    // Swap the found minimum element with the first 
    // element 
    temp = value2[min_idx]; 
    value2[min_idx] = value2[i]; 
    value2[i] = temp;
  }
  i++;

  for (int i = 0; i < value1.length; i++) {
    //color of lines
    stroke(255);
    // line(x1,y1,x2,y2) where (x1,y1) and (x2,y2) are two points of the line
    line(i, height, i, height-value1[i]);
  }
  for (int i = 0; i < value2.length; i++) {
    stroke(255);
    
    line(i+value1.length, height, i+value1.length, height-value2[i]);
  }
}
  public void settings() {  size(650, 450); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "bin_sel_sort" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
