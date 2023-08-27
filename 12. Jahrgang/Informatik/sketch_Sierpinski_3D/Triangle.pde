class Triangle {
  PVector origin;
  float size;
  boolean subdivided = false;
  Triangle[] children;
  Triangle(PVector origin_, float size_) {
    origin = origin_;
    size = size_;

    children = new Triangle[4];
  }

  void draw() {
    if (subdivided) {
      for (Triangle t : children)
        t.draw();
    } else {
      pushMatrix();
      translate(origin.x, origin.y, origin.z);
      PVector a = new PVector(-size * .5, -size * .5, size * .5);
      PVector b = new PVector(size * .5, size * .5, size * .5);
      PVector c = new PVector(size * .5, -size * .5, -size * .5);
      PVector d = new PVector(-size * .5, size * .5, -size * .5);
      
      fill(255);
      noStroke();
      beginShape();
      vertex(a.x, a.y, a.z);
      vertex(b.x, b.y, b.z);
      vertex(c.x, c.y, c.z);
      endShape();

      beginShape();
      vertex(a.x, a.y, a.z);
      vertex(b.x, b.y, b.z);
      vertex(d.x, d.y, d.z);
      endShape();

      beginShape();
      vertex(a.x, a.y, a.z);
      vertex(d.x, d.y, d.z);
      vertex(c.x, c.y, c.z);
      endShape();

      beginShape();
      vertex(b.x, b.y, b.z);
      vertex(d.x, d.y, d.z);
      vertex(c.x, c.y, c.z);
      endShape();

      
      popMatrix();
    }
  }

  void subdivide() {
    if (!subdivided) {
      PVector a = new PVector(-size * .25, -size * .25, size * .25).add(origin);
      PVector b = new PVector(size * .25, size * .25, size * .25).add(origin);
      PVector c = new PVector(size * .25, -size * .25, -size * .25).add(origin);
      PVector d = new PVector(-size * .25, size * .25, -size * .25).add(origin);
      
      children[0] = new Triangle(a, size / 2.0);
      children[1] = new Triangle(b, size / 2.0);
      children[2] = new Triangle(c, size / 2.0);
      children[3] = new Triangle(d, size / 2.0);
      subdivided = true;
    } else {
      for (Triangle t : children)
        t.subdivide();
    }
  }
}
