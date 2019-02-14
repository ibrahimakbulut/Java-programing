import java.awt.Graphics;


public abstract class Polygon implements Shape{

	class Point2D{

		@Override
		public Point2D clone(){
			return new Point2D(pos_x,pos_y);
		}
		public	Point2D(){
			pos_x=0;pos_y=0;
		}
		public	Point2D(double initialize_pos_x,double initialize_pos_y){
			pos_x=initialize_pos_x;
			pos_y=initialize_pos_y;
		}
		public	void setter_pos_x(double new_pos_x){
			pos_x=new_pos_x;
		}
		public	void setter_pos_y(double new_pos_y){
			pos_y=new_pos_y;
		}
		public	double getter_pos_x(){
			return pos_x;
		}
		public	double getter_pos_y(){
			return pos_y;
		}

		private	double pos_x;
		private	double pos_y;
	}
	@Override 
	public void  draw(Graphics g){}

	//ofstream& print_shape(ofstream& outputfile)const{}; 


	
}

