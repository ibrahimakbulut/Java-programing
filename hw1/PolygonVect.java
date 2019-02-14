import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Vector;


public class PolygonVect extends Polygon {
	
	/**
	* <h1>PolygonVect</h1>
	* This class  extends Polygon class.This class keep an ArrayList of Point2D objects.
	*
	* @author Ibrahim Akbulut
	* @version 1.0
	* @since   17-01-2019
	*/
	

		public PolygonVect(){} //do nothing 
		public PolygonVect(Triangle shape_triangle){
			if(shape_triangle.getter_point1_x()<0 || shape_triangle.getter_point1_y()<0 || shape_triangle.getter_point2_x()<0 || shape_triangle.getter_point2_y()<0
					|| shape_triangle.getter_point3_x()<0 || shape_triangle.getter_point3_y()<0){
					double new_1x=shape_triangle.getter_point1_x();
					double new_1y=shape_triangle.getter_point1_y();
					double new_2x=shape_triangle.getter_point2_x();
					double new_2y=shape_triangle.getter_point2_y();
					double new_3x=shape_triangle.getter_point3_x();
					double new_3y=shape_triangle.getter_point3_y();
					
					Scanner reader=new Scanner(System.in);
					
					if(shape_triangle.getter_point1_x()<0){
					System.out.println("Point 1 x coordinate is wrong enter again");
					new_1x=reader.nextDouble();}
					else if(shape_triangle.getter_point1_y()<0){
					System.out.println("Point 1 y coordinate is wrong enter again");
					new_1y=reader.nextDouble();}
					else if(shape_triangle.getter_point2_x()<0){
					System.out.println("Point 2 x coordinate is wrong enter again");
					new_2x=reader.nextDouble();}
					else if(shape_triangle.getter_point2_y()<0){
					System.out.println("Point 2 y coordinate is wrong enter again");
					new_2y=reader.nextDouble();}
					else if(shape_triangle.getter_point3_x()<0){
					System.out.println("Point 3 x coordinate is wrong enter again");
					new_3x=reader.nextDouble();}
					else if(shape_triangle.getter_point2_y()<0){
					System.out.println("Point 3 y coordinate is wrong enter again");
					new_3y=reader.nextDouble();}

					while(new_1x<0 || new_1y<0 || new_2x<0 || new_2y<0 || new_3x<0 || new_3y<0){
					if(new_1x<0){
					System.out.println("Point 1 x coordinate is wrong enter again");
					new_1x=reader.nextDouble();}
					else if(new_1y<0){
					System.out.println("Point 1 y coordinate is wrong enter again");
					new_1y=reader.nextDouble();}
					else if(new_2x<0){
					System.out.println("Point 2 x coordinate is wrong enter again");
					new_2x=reader.nextDouble();}
					else if(new_2y<0){
					System.out.println("Point 2 y coordinate is wrong enter again");
					new_2y=reader.nextDouble();}
					else if(new_3x<0){
					System.out.println("Point 3 x coordinate is wrong enter again");
					new_3x=reader.nextDouble();}
					else if(new_3y<0){
					System.out.println("Point 3 y coordinate is wrong enter again");
					new_3y=reader.nextDouble();}
					}
					shape_triangle.setter_point1(new_1x,new_1y);
					shape_triangle.setter_point2(new_2x,new_2y);
					shape_triangle.setter_point3(new_3x,new_3y);
					reader.close();
				}
			if(!(shape_triangle.getter_point1_y()==0 && shape_triangle.getter_point2_x()==0 )){
				Point2D polygon_points_1=new Point2D(shape_triangle.getter_point1_x(),shape_triangle.getter_point1_y());

				Point2D polygon_points_2=new Point2D(shape_triangle.getter_point2_x(),shape_triangle.getter_point2_y());

				Point2D polygon_points_3=new Point2D(shape_triangle.getter_point3_x(),shape_triangle.getter_point3_y());

				polygon_points.add(polygon_points_1);
				polygon_points.add(polygon_points_2);
				polygon_points.add(polygon_points_3);
			}
				else{
				Point2D polygon_points_1=new Point2D(shape_triangle.getter_lenght_of_triangle()/2,0);

				Point2D polygon_points_2=new Point2D(shape_triangle.getter_lenght_of_triangle(),shape_triangle.getter_lenght_of_triangle()*Math.sqrt(3.0)/2);

				Point2D polygon_points_3=new Point2D(0,shape_triangle.getter_lenght_of_triangle()*Math.sqrt(3.0)/2);
				polygon_points.add(polygon_points_1);
				polygon_points.add(polygon_points_2);
				polygon_points.add(polygon_points_3);
				}

		}
		public PolygonVect(Rectangle shape_rectangle){
			polygon_points=new ArrayList<Point2D>();
			if(shape_rectangle.getter_pos_x()<0 || shape_rectangle.getter_pos_y()<0){
				Scanner reader= new Scanner(System.in);
				double new_x=shape_rectangle.getter_pos_x();
				double new_y=shape_rectangle.getter_pos_y();
				if(shape_rectangle.getter_pos_x()<0){
					System.out.println("Rectangle coordinate x is wrong ,enter again");
					new_x=reader.nextDouble();
				}
				else if(shape_rectangle.getter_pos_y()<0){
					System.out.println("Rectangle coordinate y is wrong ,enter again");  //error check if coordinates are negative
					new_y=reader.nextDouble();
				}
				while(new_x<0 || new_y<0){
					if(new_x<0){
						System.out.println("Rectangle coordinate x is wrong, enter again");
						new_x=reader.nextDouble();
					}
					else if(new_y<0){
						System.out.println("Rectangle coordinate y is wrong, enter again");
						new_y=reader.nextDouble();
					}
				}
				shape_rectangle.setter_position(new_x,new_y);
				reader.close();
			}
			double rectangle_pos_x=shape_rectangle.getter_pos_x();
			double rectangle_pos_y=shape_rectangle.getter_pos_y();

			Point2D polygon_points_1=new Point2D(rectangle_pos_x,rectangle_pos_y);

			Point2D polygon_points_2=new Point2D(rectangle_pos_x+shape_rectangle.getter_width(),rectangle_pos_y);

			Point2D polygon_points_3=new Point2D(rectangle_pos_x+shape_rectangle.getter_width(),rectangle_pos_y+shape_rectangle.getter_height());

			Point2D polygon_points_4=new Point2D(rectangle_pos_x,rectangle_pos_y+shape_rectangle.getter_height());

			polygon_points.add(polygon_points_1);
			polygon_points.add(polygon_points_2);
			polygon_points.add(polygon_points_3);  //push points into vector polygon_points in the polygonvect class
			polygon_points.add(polygon_points_4);
		}
		public PolygonVect (Circle shape_circle){
			polygon_points=new ArrayList<Point2D>();
			if(shape_circle.getter_pos_x()<0 || shape_circle.getter_pos_y()<0){
				Scanner reader=new Scanner(System.in);
				double new_x=shape_circle.getter_pos_x();
				double new_y=shape_circle.getter_pos_y();
				if(shape_circle.getter_pos_x()<0){
					System.out.println("Circle coordinate x is wrong,enter again");
					new_x=reader.nextDouble();
				}
				else if(shape_circle.getter_pos_y()<0){
					System.out.println("Circle coordinate y is wrong, enter again");
					new_y=reader.nextDouble();
				}
				while(new_x<0 || new_y<0){
					if(new_x<0){
					System.out.println("Circle coordinate x is wrong,enter again");
					new_x=reader.nextDouble();				
					}
					else if(new_y<0){
					System.out.println("Circle coordinate y is wrong,enter again");
					new_y=reader.nextDouble();
					}
				}
				shape_circle.setter_position_x(new_x);
				shape_circle.setter_position_y(new_y);
				reader.close();
			}
			double radius=shape_circle.getter_radius();
			for(int i=0;i<100;++i){
				Point2D polygon_points_of_circle=new Point2D(shape_circle.getter_pos_x()+radius*Math.sin((2*PI/100)*i),shape_circle.getter_pos_y()+radius*Math.cos((2*PI/100)*i));
				polygon_points.add(polygon_points_of_circle);
			}
		}

		public PolygonVect(Point2D point){
			polygon_points=new ArrayList<Point2D>();
			Point2D polygon_point=new Point2D(point.getter_pos_x(),point.getter_pos_y());
			polygon_points.add(polygon_point);
		}
		public PolygonVect(Vector<Point2D> points){
			polygon_points=new ArrayList<Point2D>();
			for(int i=0;i<points.size();++i){
				Point2D polygon_point=new Point2D(points.get(i).getter_pos_x(),points.get(i).getter_pos_y());
				polygon_points.add(polygon_point);
			}
		}
		public PolygonVect(PolygonVect copy_Polygonvect){
			polygon_points=new ArrayList<Point2D>();
			for(int i=0;i<copy_Polygonvect.polygon_points.size();++i){
				polygon_points.add(copy_Polygonvect.polygon_points.get(i).clone());
			}
		}


		//ofstream& print_shape(ofstream& outputfile)const;
		   /**
		   * This method is used to return an polygon width
		   * @return double
		   */
		public double difference_mostAndleast_x(){
			double most_right_x;

			most_right_x=polygon_points.get(0).getter_pos_x();
			for(int i=1;i<polygon_points.size();++i){
				if(polygon_points.get(i).getter_pos_x()>most_right_x)
					most_right_x=polygon_points.get(i).getter_pos_x();
			}

			double most_left_x;

			most_left_x=polygon_points.get(0).getter_pos_x();
			for(int i=1;i<polygon_points.size();++i){
				if(polygon_points.get(i).getter_pos_x()<most_left_x)
					most_left_x=polygon_points.get(i).getter_pos_x();
			}	

			return (most_right_x-most_left_x);
		}
		   /**
		   * This method is used to return polygon height
		   * @return double
		   */
		public double difference_mostAndleast_y(){
			double most_down_y;

			most_down_y=polygon_points.get(0).getter_pos_y();
			for(int i=1;i<polygon_points.size();++i){
				if(polygon_points.get(i).getter_pos_y()>most_down_y)
					most_down_y=polygon_points.get(i).getter_pos_y();
			}

			double most_up_y;

			most_up_y=polygon_points.get(0).getter_pos_y();
			for(int i=1;i<polygon_points.size();++i){
				if(polygon_points.get(i).getter_pos_y()<most_up_y)
					most_up_y=polygon_points.get(i).getter_pos_y();
			}	

			return (most_down_y-most_up_y);
		}
		   /**
		   * This method is used to return most_x point in polygon(polygonvect)
		   * @return double
		   */
		public double most_x(){
			double most_right_x;

			most_right_x=polygon_points.get(0).getter_pos_x();
			for(int i=1;i<polygon_points.size();++i){
				if(polygon_points.get(i).getter_pos_x()>most_right_x)
					most_right_x=polygon_points.get(i).getter_pos_x();
			}
			return most_right_x;
		}
		   /**
		   * This method is used to return most_y point in polygon(polygonvect)
		   * @return double
		   */
		public double most_y(){
			double most_down_y;

			most_down_y=polygon_points.get(0).getter_pos_y();
			for(int i=1;i<polygon_points.size();++i){
				if(polygon_points.get(i).getter_pos_y()>most_down_y)
					most_down_y=polygon_points.get(i).getter_pos_y();
			}
			return most_down_y;	
		}
		   /**
		   * This method is used to draw polygon(polyvect) into panel
		   * @param g
		   */
		@Override
		public void draw(Graphics g){
			java.awt.Polygon a;
			PolygonVect c=new PolygonVect(this); 
	        int x_t[]= new int[c.get_size()];
	        int y_t[]= new int[c.get_size()];

	        for(int i=0;i<c.get_size();++i){
	        	x_t[i]=(int)c.getter_polygon_points().get(i).getter_pos_x();
	        	y_t[i]=(int)c.getter_polygon_points().get(i).getter_pos_y();
	        }
	        a=new java.awt.Polygon(x_t,y_t,c.get_size());
            g.setColor(Color.BLUE);
	        g.drawPolygon(a);
		}
		   /**
		   * This method is used to return area of polygon(polygonvect)
		   * @return double
		   */
		@Override
		public double area(){
			if(polygon_points.size()==100){
				Circle a=new Circle(difference_mostAndleast_x()/2);
				return a.area();
			}
			else if(polygon_points.size()==4){
				Rectangle a=new Rectangle(difference_mostAndleast_x(),difference_mostAndleast_y());
				return a.area();
			}
			else if(polygon_points.size()==3){
				Triangle a=new Triangle(difference_mostAndleast_x());
				return a.area();
			}
			else
				return -1;
		}
		   /**
		   * This method is used to return perimeter of polygon(polygonvect)
		   * @return double
		   */
		@Override
		public double perimeter(){
			if(polygon_points.size()==100){
				Circle a=new Circle(difference_mostAndleast_x()/2);
				return a.perimeter();
			}
			else if(polygon_points.size()==4){
				Rectangle a=new Rectangle(difference_mostAndleast_x(),difference_mostAndleast_y());
				return a.perimeter();
			}
			else if(polygon_points.size()==3){
				Triangle a=new Triangle(difference_mostAndleast_x());
				return a.perimeter();
			}
			else
				return -1;	
		}
		   /**
		   * This method is used to increment possition of polygon(polygonvect) one by one
		   * @return PolygonVect
		   */
		@Override
		public PolygonVect increment(){
			for(int i=0;i<polygon_points.size();++i){
				polygon_points.get(i).setter_pos_x(polygon_points.get(i).getter_pos_x()+1);
				polygon_points.get(i).setter_pos_y(polygon_points.get(i).getter_pos_y()+1);
			}
			return this;
		}
		   /**
		   * This method is used to decrement possition of polygon(polygonvect) one by one
		   * @return PolygonVect
		   */
		@Override
		public PolygonVect decrement(){
			for(int i=0;i<polygon_points.size();++i){
				polygon_points.get(i).setter_pos_x(polygon_points.get(i).getter_pos_x()-1);
				polygon_points.get(i).setter_pos_y(polygon_points.get(i).getter_pos_y()-1);
			}
			return this;	
		}
		   /**
		   * This method is used to compare  polygon(polygonvect) with another polygon(polygonvect)
		   * @param other
		   * @return int
		   */
		@Override
		public int compareTo(Shape other){
			if(area()>other.area())
				return 1;
			else if(area()<other.area())
				return -1;
			else
				return 0;
		}
		   /**
		   * This method is used return pos_x of polygon(polygonvect) 
		   * @return double
		   */
		public double getter_pos_x(){
			if(polygon_points.size()==4 || polygon_points.size()==3) //posx of rectangle left-top corner. pos_x of circle middle of circle.pos _x triangle left-down corner
				return  most_x()-difference_mostAndleast_x();
			else 
				return most_x()-(difference_mostAndleast_x()/2);
		}
		   /**
		   * This method is used return pos_y of polygon(polygonvect) 
		   * @return double
		   */
		public double getter_pos_y(){
			if(polygon_points.size()==4)
				return  most_y()-difference_mostAndleast_y(); //pos_y of rectangle left-top corner.pos_y of circle middle of circle.pos_y of triangle left-down corner.
			else if(polygon_points.size()==3)
				return most_y(); 
			else 
				return most_y()-difference_mostAndleast_y()/2;
		}
		   /**
		   * This method is used return polygon_points that keep in a ArrayList 
		   * @return ArrayList<Point2D>
		   */
		public ArrayList<Point2D> getter_polygon_points(){
			return polygon_points;
		}
		   /**
		   * This method is used set polygon points  
		   * @param new_polygon_points
		   */
		public void setter_polygon_points(ArrayList<Point2D> new_polygon_points){

			polygon_points.clear();
			for(int i=0;i<new_polygon_points.size();++i){
				Point2D polygon_point=new Point2D(new_polygon_points.get(i).getter_pos_x(),new_polygon_points.get(i).getter_pos_y());
				polygon_points.add(polygon_point);
			}
		}

		   /**
		   * This method is used return size of polygon(polygonvect) 
		   * @return int
		   */
		public int get_size(){
			return polygon_points.size();
		}

		private ArrayList<Point2D> polygon_points;
		private final double PI=3.141592;



}
