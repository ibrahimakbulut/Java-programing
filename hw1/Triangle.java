import java.awt.Graphics;


public class Triangle implements Shape{
	
		@Override
		public	double area(){
			return ((Math.pow(lenght_of_Triangle,2.0)*Math.sqrt(3.0))/4.0);
		}
		@Override
		public	double perimeter(){
			if(lenght_of_Triangle<0){
				return -3*lenght_of_Triangle;
			}
			return 3*lenght_of_Triangle;
		}
		//@Override
		//public void print_shape(); 

		@Override
		public int compareTo(Shape other){
			if(area()>other.area())
				return 1;
			else if(area()<other.area())
				return -1;
			else
				return 0;
		}
		public void setter_point1(double pos_x,double pos_y){
			point1_pos_x=pos_x;
			point1_pos_y=pos_y;
		}
		public void setter_point2(double pos_x,double pos_y){
			point2_pos_x=pos_x;
			point2_pos_y=pos_y;
		}
		public void setter_point3(double pos_x,double pos_y){
			point3_pos_x=pos_x;
			point3_pos_y=pos_y;
		}
		public static void setter_total_area(double new_value){
			total_area=new_value;
		}
		public static void setter_total_perimeter(double new_value){
			total_perimeter=new_value;
		}
		
		public void setter_lenght_of_triangle(double lenght_of_triangle){
			
			lenght_of_Triangle=lenght_of_triangle;   //Triangle_lenght is actual lenght ,triangle_lenght is user input
		}
		
		public double getter_point1_x(){
			return point1_pos_x;
		}
		public double getter_point1_y(){
			return point1_pos_y;
		}
		public double getter_point2_x(){
			return point2_pos_x;
		}
		public double getter_point2_y(){
			return point2_pos_y;
		}
		public double getter_point3_x(){
			return point3_pos_x;
		}
		public double getter_point3_y(){
			return point3_pos_y;
		}
		
		@Override
		public Triangle increment(){
			point1_pos_x+=1.0;
			point1_pos_y+=1.0;

			point2_pos_x+=1.0;
			point2_pos_y+=1.0;

			point3_pos_x+=1.0;
			point3_pos_y+=1.0;

			return this;
		}
		@Override 
		public void  draw(Graphics g){}
		@Override
		public	Triangle decrement(){
			point1_pos_x-=1.0;
			point1_pos_y-=1.0;

			point2_pos_x-=1.0;
			point2_pos_y-=1.0;

			point3_pos_x-=1.0;
			point3_pos_y-=1.0;

			return this;
		}

		//ofstream& print_shape(ofstream& outputfile)const override;
		//friend ostream& operator <<(ostream& outputStream,const Triangle& shape);

		public static int getter_objectCount(){
			return objectCount;
		}
		public static double getter_total_area(){
			return total_area;
		}
		public static double getter_total_perimeter(){
			return total_perimeter;
		}
		
		public double getter_lenght_of_triangle(){
			return lenght_of_Triangle;
		}
		
		public	Triangle(){ //No parameter constructor
			
			point1_pos_x=0;
			point1_pos_y=0;
				
			point2_pos_x=0;
			point2_pos_y=0;
				
			point3_pos_x=0;
			point3_pos_y=0;
				
			lenght_of_Triangle=0;
			total_area+=area();  //this calculation 0 because it has no size all size are 0.
			total_perimeter+=perimeter();
		}
		//constructor with parameters
		public Triangle(double lenght_of_triangle){
			lenght_of_Triangle=lenght_of_triangle;

			point1_pos_x=lenght_of_Triangle/2;
			point1_pos_y=0;
				
			point2_pos_x=0;
			point2_pos_y=lenght_of_Triangle*Math.sqrt(3.0)/2;
				
			point3_pos_x=lenght_of_Triangle;
			point3_pos_y=lenght_of_Triangle*Math.sqrt(3.0)/2;
			total_area+=area();
			total_perimeter+=perimeter();

		}
		public Triangle(double lenght_of_triangle,double pos1_x,double pos1_y,double pos2_x,double pos2_y,double pos3_x,double pos3_y){
			
			point1_pos_x=pos1_x;
			point1_pos_y=pos1_y;
				
			point2_pos_x=pos2_x;
			point2_pos_y=pos2_y;
				
			point3_pos_x=pos3_x;
			point3_pos_y=pos3_y;
				
			lenght_of_Triangle=lenght_of_triangle;
			total_area+=area();	
			total_perimeter+=perimeter();
		}
		public Triangle(Triangle other_copy){
			point1_pos_x=other_copy.point1_pos_x;
			point1_pos_y=other_copy.point1_pos_y;
			
			point2_pos_x=other_copy.point2_pos_x;
			point2_pos_y=other_copy.point2_pos_y;
			
			point3_pos_x=other_copy.point3_pos_x;
			point3_pos_y=other_copy.point3_pos_y;
			
			lenght_of_Triangle=other_copy.lenght_of_Triangle;
			total_area+=area();	
			total_perimeter+=perimeter();
			
			
		}
		//public void draw()
		
		
		
		private static int objectCount;
		private static double total_area;
		private static double total_perimeter;
		
		private double point1_pos_x;
		private double point1_pos_y;
		
		private double point2_pos_x;
		private double point2_pos_y;
		
		private double point3_pos_x;
		private double point3_pos_y;
		
		private double lenght_of_Triangle;
		

}
