import javax.swing.JFrame;


public class StaticMethods {
	
	/**
	* <h1>StaticMethods</h1>
	* This class  have some static functions.
	*
	* @author Ibrahim Akbulut
	* @version 1.0
	* @since   17-01-2019
	*/
	
	
	   /**
	   * This method is used to draw all given shapes in array on a panel
	   * @param shapes
	   * @exception NullPointerException on null parameter as array
	   */
	public static void drawAll(Shape[] shapes)throws NullPointerException{
		
		if(shapes==null)
			throw new NullPointerException();
		
        Shapes a=new Shapes(shapes); //Shapes consctructor that take Shape[]
        JFrame application=new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(a);
        application.setSize(700,710);
        application.setVisible(true);
	}
	
	   /**
	   * This method is used to convert all given shapes in array into polygons
	   * @param shapes
	   * @return Shape[]
	   */
	public static Shape[] convertAll(Shape[] shapes){
		Shape[] new_shapes=new Polygon[shapes.length];
		for(int i=0;i<shapes.length;++i){
			if(shapes[i] instanceof PolygonDyn)
			new_shapes[i]=new PolygonDyn((PolygonDyn)shapes[i]);
			else if(shapes[i] instanceof Triangle)
			new_shapes[i]=new PolygonDyn((Triangle)shapes[i]);
			else if(shapes[i] instanceof Rectangle)
			new_shapes[i]=new PolygonDyn((Rectangle)shapes[i]);
			else if(shapes[i] instanceof Circle)
			new_shapes[i]=new PolygonDyn((Circle)shapes[i]);
			else if(shapes[i] instanceof PolygonVect)
			new_shapes[i]=new PolygonVect((PolygonVect)shapes[i]);
			
		}
		return new_shapes;
	}

	   /**
	   * This method is used to sort shapes for their areeas incresingly.
	   * @param shapes
	   */
	public static void sortShapes(Shape[] shapes){
		for(int i=0; i<shapes.length; i++)
		{
			for(int j=i+1; j<shapes.length; j++)
			{
				if(shapes[i].area()>shapes[j].area())
				{
					Shape temp=shapes[i];
					shapes[i]=shapes[j];
					shapes[j]=temp;
				}
			}
		}
	}

}
