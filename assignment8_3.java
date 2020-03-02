/*
 * Class circle. Has radius and methods related to circles.
 */
class Circle {
  private double radius;

  /* Default constructor
   */
  Circle() {
    radius = 1;
  }

  /* Constructor with radius
   */
  Circle(double radius) {
    this.radius = radius;
  }

  /* Returns area of circle. 
   */
  double getArea() {
    return Math.PI * radius * radius;
  }

  /* Returns circumference of circle. 
   */
  double getCircumference() {
    return 2 * Math.PI * radius;
  }

  /* Returns radius of circle.
   */
  double getRadius() {
    return radius;
  }

  /* Can change radius of circle.
   */
  void setRadius(double radius) {
    if (radius >= 0) {
      this.radius = radius;
    }
  }
}


class Main {
  /* Creates two circles and prints their properties. Then changes the first
   * circle and prints its properties again.
   */
  public static void main(String[] args) {
    Circle circle1 = new Circle();
    Circle circle2 = new Circle(2);

    System.out.println("circle1 default");
    System.out.println(circle1.getRadius());
    System.out.println(circle1.getCircumference());
    System.out.println(circle1.getArea());

    System.out.println("circle2 radius 2");
    System.out.println(circle2.getRadius());
    System.out.println(circle2.getArea());
    System.out.println(circle2.getCircumference());

    System.out.println("circle1 radius 3");
    circle1.setRadius(3);
    System.out.println(circle1.getRadius());
    System.out.println(circle1.getArea());
    System.out.println(circle1.getCircumference());
  }
}

