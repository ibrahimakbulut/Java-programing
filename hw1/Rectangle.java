import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


public class Rectangle implements Shape {

	
	/**
	* <h1>Rectangle</h1>
	* This class  implements Shape interface.
	*
	* @author Ibrahim Akbulut
	* @version 1.0
	* @since   17-01-2019
	*/

	public void setter_position(double pos_x,double pos_y){
		
		Pos_x=pos_x;
		Pos_y=pos_y;
	}
	public void setter_width(double width){
		Width=width;
	}
	public void setter_height(double height){
		Height=height;
	}
	public static void setter_objectCount(int new_value){
		objectCount=new_value;
	}
	public static void setter_total_area(double new_value){
		total_area=new_value;
	}
	public static void setter_total_perimeter(double new_value){
		total_perimeter=new_value;
	}
		
	public static void plus_rectangles(){ //increase 1 objectCount
		objectCount+=1;
	} 


		
	public double getter_pos_x(){
		return Pos_x;
	}
	public double getter_pos_y(){
		return Pos_y;
	}
	public double getter_width(){
		return Width;
	}
	public double getter_height(){
		return Height;
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

	   /**
	   * This method is used to draw Rectangle into panel
	   * @param g
	   */
	@Override 
	public void  draw(Graphics g){
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
	
	   /**
	   * This method is used to compare  Rectangle with another Rectangle
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
	@Override
	public Rectangle increment(){
		Pos_x+=1.0;
		Pos_y+=1.0;

		return this;
	}
	@Override
	public Rectangle decrement(){
		Pos_x-=1.0;
		Pos_y-=1.0;

		return this;
	}

	   /**
	   * This method is used to return perimeter of area
	   * @return double
	   */
	@Override
	public double area(){
		if(Width<0 && Height>0){
			return -Width*Height;
		}
		else if(Width>0 && Height<0){
			return Width*-Height;
		}
		return Width*Height;
	}
	
	   /**
	   * This method is used to return perimeter of Rectangle
	   * @return double
	   */
	@Override
	public double perimeter(){
		if(Width<0 && Height<0){
			return -2*(Width+Height);
		}
		else if(Width<0 && Height>0){
			return 2*(-Width+Height);
		}
		else if(Width>0 && Height<0){
			return 2*(Width+-Height);
		}
		return 2*(Width+Height);
	}
		
	public Rectangle(){ //No parameter constructor
		
		Pos_x=0;
		Pos_y=0;
		
		Width=0;
		Height=0;
		objectCount+=1;
		total_area+=area();  //this calculation 0 because it has no size all size are 0.
		total_perimeter+=perimeter();
	}
	public Rectangle(double width,double height){

		Width=width;
		Height=height;

		Pos_x=0;
		Pos_y=0;
		objectCount+=1;
		total_area+=area();
		total_perimeter+=perimeter();
	}
	public Rectangle(double width,double height,double pos_x,double pos_y){ //constructor with parameters
		
		Pos_x=pos_x;
		Pos_y=pos_y;
		
		Width=width;
		Height=height;
		objectCount+=1;;
		total_area+=area();
		total_perimeter+=perimeter();	
	}
	public Rectangle(Rectangle copy_other){
		Pos_x=copy_other.Pos_x;
		Pos_y=copy_other.Pos_y;
		
		Width=copy_other.Width;
		Height=copy_other.Height;
		total_area+=area();
		total_perimeter+=perimeter();	
	}
		
		
	private double Pos_x;
	private double Pos_y;
		
	private double Width;
	private double Height;

	private static int objectCount=0;
	private static double total_area=0;
	private static double total_perimeter=0;
}


