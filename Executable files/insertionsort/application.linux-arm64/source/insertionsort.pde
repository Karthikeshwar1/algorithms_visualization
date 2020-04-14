int[] values; // valuesay to be visualized
int i = 0, j = 0, key;
PFont font;

void setup() {
  size(650, 450); //Window size
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


void draw() {
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
