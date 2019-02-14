import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import java.util.Vector;


public class PolygonDyn extends Polygon {
	

	/**
	* <h1>PolygonDyn</h1>
	* This class  extends Polygon class.This class keep an array of Point2D objects.
	*
	* @author Ibrahim Akbulut
	* @version 1.0
	* @since   17-01-2019
	*/

		public PolygonDyn(){
			polygon_points=null;
			size_of_points=0;
		}
		public PolygonDyn(Triangle shape_triangle){
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
				polygon_points=new Point2D[3];
				polygon_points[0]=new Point2D();
				polygon_points[1]=new Point2D();
				polygon_points[2]=new Point2D();
				

				if(!(shape_triangle.getter_point1_y()==0 && shape_triangle.getter_point2_x()==0 )){
				polygon_points[0].setter_pos_x(shape_triangle.getter_point1_x());
				polygon_points[0].setter_pos_y(shape_triangle.getter_point1_y());

				polygon_points[1].setter_pos_x(shape_triangle.getter_point2_x());
				polygon_points[1].setter_pos_y(shape_triangle.getter_point2_y());

				polygon_points[2].setter_pos_x(shape_triangle.getter_point3_x());
				polygon_points[2].setter_pos_y(shape_triangle.getter_point3_y());
				}
				else{
				polygon_points[0].setter_pos_x(shape_triangle.getter_lenght_of_triangle()/2);
				polygon_points[0].setter_pos_y(0);

				polygon_points[1].setter_pos_x(shape_triangle.getter_lenght_of_triangle());
				polygon_points[1].setter_pos_y(shape_triangle.getter_lenght_of_triangle()*Math.sqrt(3.0)/2);

				polygon_points[2].setter_pos_x(0);
				polygon_points[2].setter_pos_y(shape_triangle.getter_lenght_of_triangle()*Math.sqrt(3.0)/2);}
				size_of_points=3;
		}
		public PolygonDyn(Rectangle shape_rectangle){

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

			polygon_points=new Point2D[4];
			polygon_points[0]=new Point2D();
			polygon_points[1]=new Point2D();
			polygon_points[2]=new Point2D();
			polygon_points[3]=new Point2D();

			double rectangle_pos_x=shape_rectangle.getter_pos_x();
			double rectangle_pos_y=shape_rectangle.getter_pos_y();

			polygon_points[0].setter_pos_x(rectangle_pos_x);
			polygon_points[0].setter_pos_y(rectangle_pos_y);

			polygon_points[1].setter_pos_x(rectangle_pos_x+shape_rectangle.getter_width());
			polygon_points[1].setter_pos_y(rectangle_pos_y);

			polygon_points[2].setter_pos_x(rectangle_pos_x+shape_rectangle.getter_width());
			polygon_points[2].setter_pos_y(rectangle_pos_y+shape_rectangle.getter_height());

			polygon_points[3].setter_pos_x(rectangle_pos_x);
			polygon_points[3].setter_pos_y(rectangle_pos_y+shape_rectangle.getter_height());
			size_of_points=4;
		}
		public PolygonDyn(Circle shape_circle){
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
			polygon_points=new Point2D[100];
			for(int i=0;i<100;++i){
				polygon_points[i]=new Point2D();
			}

			double radius=shape_circle.getter_radius();
			for(int i=0;i<100;++i){
				polygon_points[i].setter_pos_x(shape_circle.getter_pos_x()+radius*Math.sin((2*PI/100)*i));
				polygon_points[i].setter_pos_y(shape_circle.getter_pos_y()+radius*Math.cos((2*PI/100)*i));
			}
			size_of_points=100;
		}

		public PolygonDyn(Point2D point){
			polygon_points=new Point2D[1];
			polygon_points[0]=new Point2D();

			polygon_points[0].setter_pos_x(point.getter_pos_x());
			polygon_points[0].setter_pos_y(point.getter_pos_y());
			size_of_points=1;
		}
		public PolygonDyn(Vector<Point2D> points){
			polygon_points=new Point2D[points.size()];

			for(int i=0;i<points.size();++i){
				polygon_points[i]=new Point2D();
				polygon_points[i].setter_pos_x(points.get(i).getter_pos_x());
				polygon_points[i].setter_pos_y(points.get(i).getter_pos_y());
			}
			size_of_points=points.size();
		}
		public PolygonDyn(PolygonDyn copy_Polygondyn){
			size_of_points=copy_Polygondyn.size_of_points;
			
			polygon_points=new Point2D[copy_Polygondyn.size_of_points];
			for(int i=0;i<size_of_points;++i){
				polygon_points[i]=copy_Polygondyn.polygon_points[i].clone();
			}
		}


		   /**
		   * This method is used to return an polygon width
		   * @return double
		   */
		public double difference_mostAndleast_x(){
			double most_right_x;

			most_right_x=polygon_points[0].getter_pos_x();
			for(int i=1;i<size_of_points;++i){
				if(polygon_points[i].getter_pos_x()>most_right_x)
					most_right_x=polygon_points[i].getter_pos_x();
			}

			double most_left_x;

			most_left_x=polygon_points[0].getter_pos_x();
			for(int i=1;i<size_of_points;++i){
				if(polygon_points[i].getter_pos_x()<most_left_x)
					most_left_x=polygon_points[i].getter_pos_x();
			}	

			return (most_right_x-most_left_x);
		}
		   /**
		   * This method is used to return polygon height
		   * @return double
		   */
		public double difference_mostAndleast_y(){
			double most_down_y;

			most_down_y=polygon_points[0].getter_pos_y();
			for(int i=1;i<size_of_points;++i){
				if(polygon_points[i].getter_pos_y()>most_down_y)
					most_down_y=polygon_points[i].getter_pos_y();
			}

			double most_up_y;

			most_up_y=polygon_points[0].getter_pos_y();
			for(int i=1;i<size_of_points;++i){
				if(polygon_points[i].getter_pos_y()<most_up_y)
					most_up_y=polygon_points[i].getter_pos_y();
			}	

			return (most_down_y-most_up_y);
		}
		   /**
		   * This method is used to return most_x point in polygon(polygondyn)
		   * @return double
		   */
		public double most_x(){
			double most_right_x;

			most_right_x=polygon_points[0].getter_pos_x();
			for(int i=1;i<size_of_points;++i){
				if(polygon_points[i].getter_pos_x()>most_right_x)
					most_right_x=polygon_points[i].getter_pos_x();
			}
			return most_right_x;
		}
		   /**
		   * This method is used to return most_y point in polygon(polygondyn)
		   * @return double
		   */
		public double most_y(){
			double most_down_y;

			most_down_y=polygon_points[0].getter_pos_y();
			for(int i=1;i<size_of_points;++i){
				if(polygon_points[i].getter_pos_y()>most_down_y)
					most_down_y=polygon_points[i].getter_pos_y();
			}
			return most_down_y;	
		}
		   /**
		   * This method is used to return area of polygon(polygondyn)
		   * @return double
		   */
		@Override
		public double area(){
			if(size_of_points==100){
				Circle a=new Circle(difference_mostAndleast_x()/2);
				return a.area();
			}
			else if(size_of_points==4){
				Rectangle a=new Rectangle(difference_mostAndleast_x(),difference_mostAndleast_y());
				return a.area();
			}
			else if(size_of_points==3){
				Triangle a=new Triangle(difference_mostAndleast_x());
				return a.area();
			}
			else
				return -1;
		}
		   /**
		   * This method is used to return perimeter of polygon(polygondyn)
		   * @return double
		   */
		@Override
		public double perimeter(){
			if(size_of_points==100){
				Circle a=new Circle(difference_mostAndleast_x()/2);
				return a.perimeter();
			}
			else if(size_of_points==4){
				Rectangle a=new Rectangle(difference_mostAndleast_x(),difference_mostAndleast_y());
				return a.perimeter();
			}
			else if(size_of_points==3){
				Triangle a=new Triangle(difference_mostAndleast_x());
				return a.perimeter();
			}
			else
				return -1;	
		}
		   /**
		   * This method is used to increment possition of polygon(polygondyn) one by one
		   * @return PolygonDyn
		   */
		@Override
		public PolygonDyn increment(){
			for(int i=0;i<size_of_points;++i){
				polygon_points[i].setter_pos_x(polygon_points[i].getter_pos_x()+1);
				polygon_points[i].setter_pos_y(polygon_points[i].getter_pos_y()+1);
			}

			return this;
		}
		   /**
		   * This method is used to decrement possition of polygon(polygondyn) one by one
		   * @return PolygonDyn
		   */
		@Override
		public PolygonDyn decrement(){
			for(int i=0;i<size_of_points;++i){
				polygon_points[i].setter_pos_x(polygon_points[i].getter_pos_x()-1);
				polygon_points[i].setter_pos_y(polygon_points[i].getter_pos_y()-1);
			}
			return this;	
		}
		   /**
		   * This method is used to compare  polygon(polygondyn) with another polygon(polygondyn)
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
		   * This method is used to draw polygon(polygondyn) into panel
		   * @param g
		   */
		@Override
		public void draw(Graphics g){
			java.awt.Polygon a;
			PolygonDyn c=new PolygonDyn(this); 
	        int x_t[]= new int[c.get_size()];
	        int y_t[]= new int[c.get_size()];

	        for(int i=0;i<c.get_size();++i){
	        	x_t[i]=(int)c.getter_polygon_points()[i].getter_pos_x();
	        	y_t[i]=(int)c.getter_polygon_points()[i].getter_pos_y();
	        }
	        a=new java.awt.Polygon(x_t,y_t,c.get_size());
            g.setColor(Color.BLUE);
	        g.drawPolygon(a);
			
		}
		   /**
		   * This method is used return polygon_points that keep in a array of Point2D 
		   * @return Point2D[]
		   */
		public Point2D[] getter_polygon_points(){
			return polygon_points;
		}
		   /**
		   * This method is used set polygon points  
		   * @param new_polygon_points
		   */
		public void setter_polygon_points(Point2D[] new_polygon_points){
				polygon_points=new_polygon_points;
		}
		   /**
		   * This method is used return size of polygon(polygondyn) 
		   * @return int
		   */
		int get_size(){
			return size_of_points;
		}
		   /**
		   * This method is used set size of polygon(polygondyn) 
		   * @param new_size
		   */
		void set_size(int new_size){
			size_of_points=new_size;
		}

		   /**
		   * This method is used return pos_x of polygon(polygondyn) 
		   * @return double
		   */
		public double getter_pos_x(){
			if(size_of_points==4 || size_of_points==3)
			return  most_x()-difference_mostAndleast_x();
			else 
				return most_x()-difference_mostAndleast_x()/2;
		}
		   /**
		   * This method is used return pos_y of polygon(polygondyn) 
		   * @return double
		   */
		public double getter_pos_y(){
			if(size_of_points==4)
				return  most_y()-difference_mostAndleast_y();
			else if(size_of_points==3)
				return most_y(); 
			else 
				return most_y()-difference_mostAndleast_y()/2;
		}

		private Point2D[] polygon_points;
		private int size_of_points;
		private final double PI=3.141592;

}
