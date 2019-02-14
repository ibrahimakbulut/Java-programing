import javax.swing.JPanel;
import java.awt.Graphics;
public class Shapes extends JPanel{

	/**
	* <h1>Shapes</h1>
	* This class  extends JPanel class.This class for drawing shapes on panels
	*
	* @author Ibrahim Akbulut
	* @version 1.0
	* @since   17-01-2019
	*/
	public Shapes(Shape[] shapes){
		printed_shapes=shapes;
		more_than_one=1;
		a_shape=null;
	}
	public Shapes(Shape shape){
		printed_shapes=null;
		more_than_one=0;
		a_shape=shape;
	}
	   /**
	   * This method is draw shapes
	   * @param g
	   */
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		if(more_than_one==1){
			int size=0;
			int j=0;
			while(j<printed_shapes.length){
				if(printed_shapes[j]!=null){
				size+=1;
				j++;}
			}
			for(int i=0;i<size;++i){
				printed_shapes[i].draw(g);
			}
		}
			
		else if(more_than_one==0)
			a_shape.draw(g);
	}
	
	private Shape[] printed_shapes;
	private Shape a_shape;
	private int more_than_one=-1;
}
