//
PVector[] corners;
PVector p;
ArrayList<PVector> points;
void setup() {
  size(1000, 1000);

  background(0);

  corners = new PVector[]{
    new PVector(width * .1, height * .1),
    new PVector(width * .9, height * .1),
    new PVector(width * .5, height * .9),
   };

  points = new ArrayList<PVector>();
  points.add(new PVector(width, height).mult(.5));

  p = new PVector(width, height).mult(.5);
}

void draw() {
  background(0);
  for (PVector p : points) {
    stroke(255);
    strokeWeight(1);
    point(p.x, p.y);
  }
  
  if (!keyPressed) {
    frameRate(120);
    for (int i = 0; i < 100; i ++) {
      addPoint();
    }
    return;
  }
  
  frameRate(1);
  PVector corner = addPoint();


  stroke(0, 0, 255);
  strokeWeight(2);
  line(corner.x, corner.y, points.get(points.size() - 2).x, points.get(points.size() - 2).y);


  float n = 5;
  for (int i = 0; i < n && points.size() - (2 + i) > 0; i++) {
    strokeWeight(3);
    stroke(0, 255, 0, map(i, 0, n, 255, 10));
    drawArrow(
      points.get(points.size() - (2 + i)),
      PVector.sub(points.get(points.size() - (1 + i)), points.get(points.size() - (2 + i)))
      );
  }

  float r = 30;
  for (PVector p : corners) {
    noStroke();
    fill(255, 0, 0);
    ellipse(p.x, p.y, r * .5, r * .5);
  }
}

PVector addPoint() {

  int index = (int) random(corners.length);
  PVector corner = corners[index];

  points.add(PVector.add(points.get(points.size() - 1), corner).mult(.5));
  
  return corner;
}


void drawArrow(PVector a, PVector b) {
  float cx = a.x;
  float cy = a.y;

  float angle = degrees(b.heading());
  float len = b.mag();
  pushMatrix();
  translate(cx, cy);
  rotate(radians(angle));
  line(0, 0, len, 0);
  line(len, 0, len - 8, -8);
  line(len, 0, len - 8, 8);
  popMatrix();
}
