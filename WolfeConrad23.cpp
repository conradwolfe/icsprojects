/**
 * A Circle class, and cylinder class that inherits class circle.
 *                                                                              
 * @author     Wolfe, Conrad
 * @assignment ICS 212 Assignment 23
 * @date       April 21, 2018
 */

#include <iostream>
#include <cmath>

#define TWO 2

using namespace std;

/***********************************************************************
 * Representation of a Circle
 *
 * @author Wolfe, Conrad
 **********************************************************************/
class Circle{

	public:

		const static double PI = 3.1415926;

/**
 * Default constructor that initializes radius to 1.
 */
		Circle(){

			radius = 1;
		}

/**
 * Constructor to initialize the value of radius to the given param.
 * Uses the setRadius method to error check.
 *
 * @param r is the radius of a cirlce.
 */
		Circle(double r){

			setRadius(r);
		}

/**
 * Gets the value of radius.
 *
 * @returns radius the radius of the circle.
 */
		double getRadius(){

			return radius;
		}

/**
 * Set the value of radius to a given value.
 * Defaults to one if the given value is zero, and a positive if a negative is given.
 *
 * @param r is the radius of a cirlce.
 */
		void setRadius(double r){

			if((r < 0) || (r > 0)){
				radius = abs(r);
			}

			if(r == 0){
				radius = 1;
			}
		}

/**
 * Calculates the area of a circle.
 *
 * @returns result the area of a circle.
 */
		double area(){

			double result;

			result = (PI * radius * radius);
			return result;
		}

	protected:

		double radius;

};//end class Circle

/***********************************************************************
 * A representation of a Cylinder
 *
 * @author Wolfe, Conrad
 **********************************************************************/
class Cylinder: public Circle{

	public:

/**
 * Constructor to initialize the value of radius and height to the given params.
 * Uses the setRadius and setHeight methods to error check.
 *
 * @param r is the radius of a cirlce.
 * @param h is the height of a cylinder.
 */
		Cylinder(double r, double h){

			setRadius(r);
			setHeight(h);
		}

/**
 * Gets the value of height.
 *
 * @returns height the height of the cylinder.
 */
		double getHeight(){

			return height;
		}

/**
 * Set the value of height to a given value.
 * Defaults to one if the given value is zero, and a positive if a negative is given.
 *
 * @param h is the height of a cylinder.
 */
		void setHeight(double h){

			if((h < 0) || (h > 0)){
				height = abs(h);
			}

			if(h == 0){
				height = 1;
			}
		}

/**
 * Calculates the surface area of a cylinder
 *
 * @returns result the area of a cylinder.
 */
		double area(){

			double result;

			result = ((TWO * PI * radius * height) + (TWO * PI * radius * radius));
			return result;
		}

/**
 * Calculates the volume of a cylinder
 *
 * @returns result the volume of a cylinder.
 */
		double volume(){

			double result;

			result = (PI * radius * radius * height);
			return result;
		}

	protected:

		double height;

};//end class Cylinder

/***********************************************************************
 *  Driver
 **********************************************************************/

int main() {

  	cout << "Test Circle class default constructor and area() function:" << endl;
  	Circle circle1;
  
  	cout << "Circle circle1: radius = " << circle1.getRadius() << endl;
 	cout << "area = " << circle1.area() << endl;
  
  	cout << "\n";
  
 	cout << "Test Circle class constructor with radius:" << endl;
 	Circle circle2(-10);
 	 
	cout << "Circle circle2: radius = " << circle2.getRadius() << endl;
 	cout << "Test set method, set circle2 to radius 5..." << endl;
 	circle2.setRadius(5);
 	cout << "radius = " << circle2.getRadius() << endl;
  
 	cout << "\n";
  
 	cout << "Test Cylinder class given radius and height:" << endl;
 	Cylinder cylinder1(20, -30);
  
 	cout << "Cylinder cylinder1: radius = " << cylinder1.getRadius();
	cout << "; height = " << cylinder1.getHeight() << endl;
	cout << "surface area = " << cylinder1.area() << endl;
	cout << "volume = " << cylinder1.volume() << endl;
  
 	cout << "\n";
  
 	cout << "Test set method, set cylinder1 to radius 40 and height 50..." << endl;
	cylinder1.setRadius(40);
	cylinder1.setHeight(50);
  	cout << "radius = " << cylinder1.getRadius() << "; height = " << cylinder1.getHeight() << endl;
  	cout << "surface area = " << cylinder1.area() << endl;
  	cout << "volume = " << cylinder1.volume() << endl;

  	return 0;
}