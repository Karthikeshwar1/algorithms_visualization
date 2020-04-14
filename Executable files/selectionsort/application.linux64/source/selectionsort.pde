int[] values; //values to be visualized
int i = 0, j = 0, min_idx = 0, temp = 0;
PFont font;

void setup() {
  size(650, 450);
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

void draw() {
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
