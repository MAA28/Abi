Triangle t = new Triangle(new PVector(0, 0), 200.0);

void setup() {
  size(939, 1027, P3D);
}

void draw() {
  background(0);
  translate(width / 2, height / 2, 0.0);
  if (mousePressed) {
     ortho();
  } else {
    rotateY(radians(frameCount / 2.0));
  }
  t.draw();
}

void keyPressed() {
   t.subdivide(); 
}
