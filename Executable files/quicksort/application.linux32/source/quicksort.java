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

public class quicksort extends PApplet {

int[] values; // Array to be visualized
int i = 0, j = 0, top = -1, high, low, temp, pivot, part;
int[] stack;
PFont font, font1;
String disp_iterations, disp_exec_time;


public void setup() {
   //Window size
  values = new int[width]; // Create an array of size 'width'(of screen)

  // For the text display
  font = loadFont("SegoeUI-Bold-18.vlw");
  font1 = loadFont("SegoeUI-Light-15.vlw");
  fill(255);

  // Assign a random value (any integer within 'height' of screen)
  // to each of 'width' number of values
  for (int i = 0; i < values.length; i++) {
    values[i] = (int)random(height);
  }

  // Quicksort setup
  stack = new int[values.length];
  high = (values.length-1);
  low = 0;
  stack[++top] = low;
  stack[++top] = high;
}


public int partition(int arr[], int low, int high) {
  pivot = arr[high];
  i = (low-1);

  for (j = low; j <= high-1; j++) {
    if (arr[j] <= pivot) {
      i++;
      temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  temp = arr[i+1];
  arr[i+1] = arr[high];
  arr[high] = temp;

  return i+1;
}


public void draw() {
  background(0);
  
  disp_iterations = "Iterations : "+Integer.toString(values.length-i);
  textFont(font);
  text("Quick Sort", 30, 30);
  textFont(font1);
  text(disp_iterations, 30, 50);

  // Iterative Quicksort
  // Store the starting and ending values
  // of partitions onto the stack
  // to perform sorting
  if (top >= 0) {
    // Pop high and low
    high = stack[top--];
    low = stack[top--];

    // Set pivot element at its correct position
    // in the sorted array
    part = partition(values, low, high);

    // If there are elements on left side of pivot
    // then push left side to stack
    if (part-1 > low) {
      stack[++top] = low;
      stack[++top] = part-1;
    }

    // If there are elements on right side of pivot
    // then push right to stack
    if (part+1 < high) {
      stack[++top] = part+1;
      stack[++top] = high;
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
    String[] appletArgs = new String[] { "quicksort" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
