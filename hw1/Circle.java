import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
public class Circle implements Shape {

	public Circle(){  //No parameter constructor
		
		Pos_x=0;
		Pos_y=0;
		
		radius_of_circle=0;
		objectCount+=1;
		total_area+=area();//this calculation 0 because it has no size all size are 0.
		total_perimeter+=perimeter();
	}
	public Circle(double radius){
		radius_of_circle=radius;
		Pos_x=radius_of_circle;
		Pos_y=radius_of_circle;
		objectCount+=1;
		total_area+=area();
		total_perimeter+=perimeter();
	}
	public Circle(double radius,double pos_x,double pos_y){ //constructor with parameters
		
		Pos_x=pos_x;
		Pos_y=pos_y;
		
		radius_of_circle=radius;
		objectCount+=1;
		total_area+=area();
		total_perimeter+=perimeter();
	}
	public Circle(Circle copy_other){
		
		Pos_x=copy_other.Pos_x;
		Pos_y=copy_other.Pos_y;
		
		radius_of_circle=copy_other.radius_of_circle;
		objectCount+=1;
		total_area+=area();
		total_perimeter+=perimeter();	
	}
		
	public void setter_radius(double radius){
		
		radius_of_circle=radius;
	}
	public void setter_position_x(double pos_x){
		Pos_x=pos_x;
	}
	public void setter_position_y(double pos_y){
		Pos_y=pos_y;
	}
	public void setter_objectCount(int new_value){ //change the objectCount
		objectCount=new_value;
	} 
		public static void setter_total_area(double new_value){
			total_area=new_value;
		}
		public static void setter_total_perimeter(double new_value){
			total_perimeter=new_value;
		}
		
		public double getter_pos_x(){
			if(Pos_x==0 && radius_of_circle!=0){
				return radius_of_circle;
			}
			return Pos_x;
		}
		public double getter_pos_y(){
			if(Pos_y==0 && radius_of_circle!=0){
				return radius_of_circle;
			}
			return Pos_y;
		}
		public double getter_radius(){
			return radius_of_circle;
		}

		public static int getter_objectCount(){
			return objectCount;
		}	
		public static double getter_total_area(){
			return total_area;
		}
		public static double getter_total_perimeter(){
			return total_perimeter;
		}

		@Override
		public double area(){
			return PI*Math.pow(radius_of_circle,2.0);
		}
		@Override
		public double perimeter(){
			if(radius_of_circle<0){
				return -2*PI*radius_of_circle;
			}
			return 2*PI*radius_of_circle;
		}
		@Override
		public Circle increment(){
			Pos_x+=1.0;
			Pos_y+=1.0;

			return this;
		}
		@Override
		public Circle decrement(){
			Pos_x-=1.0;
			Pos_y-=1.0;

			return this;
		}
		@Override
		public int compareTo(Shape other){
			if(area()>other.area())
				return 1;
			else if(area()<other.area())
				return -1;
			else
				return 0;
		}
		@Override
		public void draw(Graphics g){
			Polygon a;
			PolygonDyn c=new PolygonDyn(this); 
	        int x_t[]= new int[c.get_size()];
	        int y_t[]= new int[c.get_size()];

	        for(int i=0;i<c.get_size();++i){
	        	x_t[i]=(int)c.getter_polygon_points()[i].getter_pos_x();
	        	y_t[i]=(int)c.getter_polygon_points()[i].getter_pos_y();
	        }
	        a=new Polygon(x_t,y_t,c.get_size());
            g.setColor(Color.BLUE);
	        g.drawPolygon(a);
		}
		
		public static  void  plus_circles(){ //increase 1 objectCount
			objectCount+=1;
		} 

		private static int objectCount=0;  //how many circle created for inner shape.
		private static double total_area=0;
		private static double total_perimeter=0;
		private double radius_of_circle;
		
		private double Pos_x;
		private double Pos_y;
		private static final double PI=3.141592;
		
}