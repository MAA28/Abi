Triangle t = new Triangle(new PVector(0, 0), 500.0);

void setup() {
  // fullScreen(P3D);
  size(939, 1027, P3D);
}

void draw() {
  background(0);
  translate(width / 2, height / 2 * 1.05, 0.0);

  lights();
  pointLight(255.0, 0.0, 0.0, 600.0, 0.0, 0.0);
  pointLight(0.0, 255.0, 0.0, 0.0, 600.0, 0.0);
  pointLight(0.0, 0.0, 255.0, 0.0, 0.0, 600.0);

  if (!mousePressed) {
    rotateY(radians(45));
    ortho();
  } else {
    perspective();
    rotateY(radians(frameCount / 2.0));
  }
  t.draw();
}

void keyPressed() {
  t.subdivide();
}
