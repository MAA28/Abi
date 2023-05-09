float phi = radians(25);
final float x1 = 100;
final float x_final = 5;

void setup() {
  size(600,600);
}

void draw() {
  background(0);
  
  phi = map(mouseX, 0, width, 0, radians(50));
  
  translate(width / 2, height * 9 / 10);
  scale(1, -1);
  
  drawPart(x1, 0, new PVector(0,0)); 
}

void drawPart(float x, float theta, PVector origin) {
  if (x < x_final) return;
  
  noFill();
  stroke(255);
  
  PVector a = new PVector(-x / 2.0, 0).rotate(theta).add(origin);
  PVector b = new PVector(x / 2.0, 0).rotate(theta).add(origin);
  PVector c = new PVector(x / 2.0, x).rotate(theta).add(origin);
  PVector d = new PVector(-x / 2.0, x).rotate(theta).add(origin);
  
  quad(a.x, a.y, b.x, b.y, c.x, c.y, d.x, d.y);
  
  float k = 1 / 2.0 * x * tan(phi);
  PVector e = new PVector(0, k + x).rotate(theta).add(origin);
  
  float s = sqrt(k * k + x * x * 0.25);
  
  PVector o1 = new PVector(-x / 4.0, k / 2.0 + x).rotate(theta).add(origin);
  PVector o2 = new PVector(x / 4.0, k / 2.0 + x).rotate(theta).add(origin);
  
  drawPart(s, theta + phi , o1);
  drawPart(s, theta - phi, o2);
}
