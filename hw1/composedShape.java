import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
public class composedShape implements Shape {

	/**
	* <h1>composedShape</h1>
	* This class  implements Shape interface.This class keeps an array of shapes that fixed into container shape.
	*
	* @author Ibrahim Akbulut
	* @version 1.0
	* @since   17-01-2019
	*/

			
			public composedShape(){
				inner_shapes_vector=new Shape[10];
				inner_shapes_vector_size=0;
			}
			public composedShape(Rectangle Container_shape,Rectangle inner_small_shape){
				container_shape=new PolygonDyn(Container_shape);
				inner_shape=new PolygonDyn(inner_small_shape);
				inner_shapes_vector=new Shape[10];
				inner_shapes_vector_size=0;
			}
			public composedShape(Rectangle Container_shape,Triangle inner_small_shape){
				container_shape=new PolygonDyn(Container_shape);
				inner_shape=new PolygonDyn(inner_small_shape);
				inner_shapes_vector=new Shape[10];
				inner_shapes_vector_size=0;
			}
			public composedShape(Rectangle Container_shape,Circle inner_small_shape){
				container_shape=new PolygonDyn(Container_shape);
				inner_shape=new PolygonDyn(inner_small_shape);
				inner_shapes_vector=new Shape[10];
				inner_shapes_vector_size=0;
			}
			
			public composedShape(Triangle Container_shape,Rectangle inner_small_shape){
				container_shape=new PolygonDyn(Container_shape);
				inner_shape=new PolygonDyn(inner_small_shape);
				inner_shapes_vector=new Shape[10];
				inner_shapes_vector_size=0;
			}
			public composedShape(Triangle Container_shape,Triangle inner_small_shape){
				container_shape=new PolygonDyn(Container_shape);
				inner_shape=new PolygonDyn(inner_small_shape);
				inner_shapes_vector=new Shape[10];
				inner_shapes_vector_size=0;
			}
			public composedShape(Triangle Container_shape,Circle inner_small_shape){
				container_shape=new PolygonDyn(Container_shape);
				inner_shape=new PolygonDyn(inner_small_shape);
				inner_shapes_vector=new Shape[10];
				inner_shapes_vector_size=0;
			}
			
			public composedShape(Circle Container_shape,Rectangle inner_small_shape){
				container_shape=new PolygonDyn(Container_shape);
				inner_shape=new PolygonDyn(inner_small_shape);
				inner_shapes_vector=new Shape[10];
				inner_shapes_vector_size=0;
			}
			public composedShape(Circle Container_shape,Triangle inner_small_shape){
				container_shape=new PolygonDyn(Container_shape);
				inner_shape=new PolygonDyn(inner_small_shape);
				inner_shapes_vector=new Shape[10];
				inner_shapes_vector_size=0;
			}
			public composedShape(Circle Container_shape,Circle inner_small_shape){
				container_shape=new PolygonDyn(Container_shape);
				inner_shape=new PolygonDyn(inner_small_shape);
				inner_shapes_vector=new Shape[10];
				inner_shapes_vector_size=0;
			}

			public composedShape(composedShape copy_composed){ //copy constructor
				
				container_shape=new PolygonDyn(copy_composed.container_shape);
				inner_shape=new PolygonDyn(copy_composed.inner_shape);
				
				inner_shapes_vector=new Shape[copy_composed.inner_shapes_vector_size];
				inner_shapes_vector_size=copy_composed.inner_shapes_vector_size;
				for(int i=0;i<inner_shapes_vector_size;++i){
					if(copy_composed.inner_shapes_vector[i] instanceof PolygonDyn)
					inner_shapes_vector[i]=new PolygonDyn((PolygonDyn)copy_composed.inner_shapes_vector[i]);
					else if(copy_composed.inner_shapes_vector[i] instanceof Triangle)
					inner_shapes_vector[i]=new Triangle((Triangle)copy_composed.inner_shapes_vector[i]);
					else if(copy_composed.inner_shapes_vector[i] instanceof Rectangle)
					inner_shapes_vector[i]=new Rectangle((Rectangle)copy_composed.inner_shapes_vector[i]);
					else if(copy_composed.inner_shapes_vector[i] instanceof Circle)
					inner_shapes_vector[i]=new Circle((Circle)copy_composed.inner_shapes_vector[i]);
					else if(copy_composed.inner_shapes_vector[i] instanceof composedShape)
					inner_shapes_vector[i]=new composedShape((composedShape)copy_composed.inner_shapes_vector[i]);
				}
				
			}
			
			/**
		   * This method is used to return size of array that keeps fixed into container shape
		   * @return int
		   */
			public int get_size(){
				return inner_shapes_vector_size;
			}
			/**
		   * This method is used to draw composedShape into panel
		   * @param g
		   */
			@Override 
			public void  draw(Graphics g){
				Polygon a;
				PolygonDyn c=new PolygonDyn(container_shape); 
		        int x_t[]= new int[c.get_size()];
		        int y_t[]= new int[c.get_size()];

		        for(int i=0;i<c.get_size();++i){
		        	x_t[i]=(int)c.getter_polygon_points()[i].getter_pos_x();
		        	y_t[i]=(int)c.getter_polygon_points()[i].getter_pos_y();
		        }
		        a=new Polygon(x_t,y_t,c.get_size());
	            g.setColor(Color.RED);
		        g.drawPolygon(a);
		        for(int k=0;k<inner_shapes_vector_size;++k){
					Polygon r;
					PolygonDyn p=new PolygonDyn((PolygonDyn)inner_shapes_vector[k]); 
			        int x_r[]= new int[p.get_size()];
			        int y_r[]= new int[p.get_size()];

			        for(int i=0;i<p.get_size();++i){
			        	x_r[i]=(int)p.getter_polygon_points()[i].getter_pos_x();
			        	y_r[i]=(int)p.getter_polygon_points()[i].getter_pos_y();
			        }
			        r=new Polygon(x_r,y_r,p.get_size());
		            g.setColor(Color.BLUE);
			        g.drawPolygon(r);
		        }
			}
			/**
		   * This method is used to return area of composedShape(container shape area+ inner shape area)
		   * @return double
		   */
			@Override
			public double area(){
				return (container_shape.area()+inner_shape.area());
			}
			/**
		   * This method is used to return perimeter of composedShape(container shape perimeter+ inner shape perimeter)
		   * @return double
		   */
			@Override
			public double perimeter(){
				return (container_shape.perimeter()+inner_shape.perimeter());
			}
			/**
		   * This function dont make any sense for this class so do nothing just return itself
		   * @return composedShape
		   */
			@Override
			public composedShape increment(){
				return this;
			}
			/**
		   * This function dont make any sense for this class so do nothing just return itself
		   * @return composedShape
		   */
			@Override
			public composedShape decrement(){
				return this;
			}
		   /**
		   * This method is used to compare  composedShape with another composedShape
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
		   * This method is used to fixed inner shapes into container shape
		   *
		   */
			public void optimalFit(){ 
				if(container_shape.get_size()==4 && inner_shape.get_size()==100){


				double width=container_shape.difference_mostAndleast_x();
				double height=container_shape.difference_mostAndleast_y();
				double radius=inner_shape.difference_mostAndleast_y()/2;
					
				double width_remaning=width-((int)(width/(2*radius))*radius*2);
				double height_remaning=height-((int)(height/(2*radius))*radius*2);


				int total_circles_first=0;int total_circles_second=0;

				/* this for count the circles in rectangular parttern */
				for(int i=1;(i*radius*2)<=(height-height_remaning);++i){
					for(int j=1;(j*radius*2)<=(width-width_remaning);++j,++total_circles_first){
						
					}
				}
				int height_counter=0;
				/*this for loop and while loop counts circle in triangular pattern */
				for(int i=1;((i*radius*2)+height_remaning)<=height;i++){
					for(int j=1;((j*radius*2)+(height_counter%2)*radius+(i%2)*width_remaning)<=width;j++,++total_circles_second){
						}
				height_counter=i;
				}

				while((2*radius+(height_counter)*radius*Math.pow(3,(1/2.0)))<=height){
					for(int j=1;((j*radius*2)+(height_counter%2)*radius+((height_counter+1)%2)*width_remaning)<=width;++j,++total_circles_second){		
					}
					height_counter+=1;
				}
				/*whic pattern is more efficient then apply that */
				if(total_circles_second>total_circles_first){

				 height_counter=0;
				/*triangular pattern fitting circles part */
				for(int i=1;((i*radius*2)+height_remaning)<=height;i++){
					for(int j=1;((j*radius*2)+(height_counter%2)*radius+(i%2)*width_remaning)<=width;++j){
						Circle current_shape=new Circle();
						//current_shape.plus_circles();
							
						if(i%2==0){
						if((j*radius*2+radius)<=width){
								
							current_shape.setter_position_x((2*j)*radius);
							current_shape.setter_position_y(radius+(i-1)*(radius*Math.pow(3,(1/2.0))));
							current_shape.setter_radius(radius);}
						}
						else{
							
							current_shape.setter_position_x(j*radius+(j-1)*radius);
							current_shape.setter_position_y(radius+(i-1)*(radius*Math.pow(3,(1/2.0))));
							current_shape.setter_radius(radius);
						}
					//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
					//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
					PolygonDyn a=new PolygonDyn(current_shape);//type of current_shape is circle.PolygonDyn assigment operator take rtSide polygonDyn type.
																//The PolygonDyn(circle&) constructor convert circle to PolygonDyn.
					this.add(a); //+= operator is used here.
				}
				height_counter=i;
				}
				
				while((2*radius+(height_counter)*radius*Math.pow(3,(1/2.0)))<=height){
					for(int j=1;((j*radius*2)+(height_counter%2)*radius+((height_counter+1)%2)*width_remaning)<=width;++j){
							
						Circle current_shape=new Circle();
						//current_shape.plus_circles();
							
						if((height_counter-1)%2==0){
						if((j*radius*2)<width){
							current_shape.setter_position_x((2*j)*radius);
						}
						
						current_shape.setter_position_y(radius+(height_counter)*(radius*Math.pow(3,(1/2.0))));
						current_shape.setter_radius(radius);
						}
						else{
						current_shape.setter_position_x(j*radius+(j-1)*radius);
						current_shape.setter_position_y(radius+(height_counter)*(radius*Math.pow(3,(1/2.0))));
						current_shape.setter_radius(radius);

						}
						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());	
					PolygonDyn a=new PolygonDyn(current_shape);
					this.add(a);
					}
					height_counter+=1;
				}
				}
				/*rectangular pattern fitting circles part*/
				else{
				for(int i=1;(i*radius*2)<=(height-height_remaning);i++){
					for(int j=1;(j*radius*2)<=(width-width_remaning);j++){
						Circle current_shape=new Circle();
					//	current_shape.plus_circles();

						current_shape.setter_position_x(width_remaning/2+j*(radius)+(j-1)*radius);
						current_shape.setter_position_y(height_remaning/2+i*(radius)+(i-1)*radius);
						current_shape.setter_radius(radius);
						
						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
					PolygonDyn a=new PolygonDyn(current_shape);
					this.add(a);
					}
				}
				}
				}
				else if(container_shape.get_size()==4 && inner_shape.get_size()==3){
					
					double width=container_shape.difference_mostAndleast_x();
					double height=container_shape.difference_mostAndleast_y();
					double lenght_of_triangle_edge=inner_shape.difference_mostAndleast_x();
					
					if((height<lenght_of_triangle_edge*Math.sqrt(3.0)/2) && width>=lenght_of_triangle_edge){
						width=container_shape.difference_mostAndleast_y();
						height=container_shape.difference_mostAndleast_x();
					}

					double triangle_lenght;

					triangle_lenght=(lenght_of_triangle_edge*Math.pow(3,(1/2.0)))/2;

					int k=0;
					int line_counter=0;
					for(int i=1;((i-k)*(triangle_lenght))<=height;++i){

						if(i%2==0)
							k+=1;
					/*This condition mechanism is used to place triangles by oppositly*/
						if(i%2==0){
						for(int j=1;(j*lenght_of_triangle_edge+lenght_of_triangle_edge/2)<=width;++j){
							
							Triangle current_shape=new Triangle();
		//triangle için pluss yap				//	current_shape.plus_triangles();
						
							current_shape.setter_point1(2*j*lenght_of_triangle_edge/2,(i-1-k)*triangle_lenght);
							current_shape.setter_point2((2*j+1)*lenght_of_triangle_edge/2,(i-k)*triangle_lenght);
							current_shape.setter_point3((2*j-1)*lenght_of_triangle_edge/2,(i-k)*triangle_lenght);
							current_shape.setter_lenght_of_triangle(lenght_of_triangle_edge);
							
						//	current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//	current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
							}
						}	
						else{
						for(int j=1;(j*lenght_of_triangle_edge)<=width;++j){

							Triangle current_shape=new Triangle();
							//current_shape.plus_triangles();
							
							current_shape.setter_point1((2*j-1)*lenght_of_triangle_edge/2,(i-k)*triangle_lenght);
							current_shape.setter_point2((2*j-2)*lenght_of_triangle_edge/2,(i-1-k)*triangle_lenght);
							current_shape.setter_point3((j*2)*lenght_of_triangle_edge/2,(i-1-k)*triangle_lenght);
							current_shape.setter_lenght_of_triangle(lenght_of_triangle_edge);

						//	current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area()); //this statement increase total area of inner shapes.
						//	current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
							}			
						}
					line_counter=i;
					}
					for(int j=1;(j*lenght_of_triangle_edge+lenght_of_triangle_edge/2)<=width;++j){
						
						Triangle current_shape=new Triangle();
						//current_shape.plus_triangles();
						
						current_shape.setter_point1(2*j*lenght_of_triangle_edge/2,(line_counter-1-k)*triangle_lenght);
						current_shape.setter_point2((2*j+1)*lenght_of_triangle_edge/2,(line_counter-k)*triangle_lenght);
						current_shape.setter_point3((2*j-1)*lenght_of_triangle_edge/2,(line_counter-k)*triangle_lenght);
						current_shape.setter_lenght_of_triangle(lenght_of_triangle_edge);

					//	current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
					//	current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
					}
					}
				else if(container_shape.get_size()==4 && inner_shape.get_size()==4){
					
					double container_width=container_shape.difference_mostAndleast_x();
					double container_height=container_shape.difference_mostAndleast_y();
					double shape_width=inner_shape.difference_mostAndleast_x();
					double shape_height=inner_shape.difference_mostAndleast_y();

					
					/*if there is a solution that is fully divided on both sides then call it */
				if( ((int)(container_width/shape_height)*shape_height==container_width) && ((int)(container_height/shape_width)*shape_width==container_height) ){
					
					shape_width=inner_shape.difference_mostAndleast_y();
					shape_height=inner_shape.difference_mostAndleast_x();
				}
					if(!((shape_width>container_width && shape_height>container_height) || (shape_height>container_width && shape_width>container_height) || (shape_width>container_width && shape_width>container_height && shape_height>container_height && shape_height>container_width))){
						
					int height_counter=0,width_counter=0;
					
				/*likewise continues to lay shapes.*/
					for(int i=1;i*shape_height<=container_height;++i){

						for(int j=1;j*shape_width<=container_width;++j){
							
							Rectangle current_shape=new Rectangle();
							//current_shape.plus_rectangles();
							
							current_shape.setter_position((j-1)*shape_width,(i-1)*shape_height);
							current_shape.setter_width(shape_width);
							current_shape.setter_height(shape_height);
					
							width_counter=j;
							
						//	current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//	current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
							PolygonDyn a=new PolygonDyn(current_shape);
							this.add(a);
						}
						height_counter=i;
					}
					/*if there is space left on the right side, it tries to rotate and fit*/
					for(int i=1;i*shape_width<=container_height;++i){

						for(int j=1;j*shape_height<=(container_width-width_counter*shape_width);++j){
						
							Rectangle current_shape=new Rectangle();
						//	current_shape.plus_rectangles();
							
							current_shape.setter_position(width_counter*shape_width+(j-1)*shape_height,(i-1)*shape_width);
							current_shape.setter_width(shape_height);
							current_shape.setter_height(shape_width);
							
							//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
							//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
							PolygonDyn a=new PolygonDyn(current_shape);
							this.add(a);
						}
					}	
					/*if the space is left below, it tries to rotate and fit*/
					for(int i=1;i*shape_width<=(container_height-height_counter*shape_height);++i){

						for(int j=1;j*shape_height<=container_width;++j){
							Rectangle current_shape=new Rectangle();
							//current_shape.plus_rectangles();
							
							current_shape.setter_position((j-1)*shape_height,height_counter*shape_height+(i-1)*shape_height);
							current_shape.setter_width(shape_height);
							current_shape.setter_height(shape_width);
							
							//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
							//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
							PolygonDyn a=new PolygonDyn(current_shape);
							this.add(a);
						}
					}	
					}	
					}
				else if(container_shape.get_size()==3 && inner_shape.get_size()==100){

					double lenght_of_triangle=container_shape.difference_mostAndleast_x();
					double radius_of_circle=inner_shape.difference_mostAndleast_x();
					
					for(int i=1;i*radius_of_circle*Math.sqrt(3.0)+radius_of_circle<=lenght_of_triangle*Math.sqrt(3.0)/2;++i){
					for(int j=1;(j*2)*radius_of_circle+(radius_of_circle*Math.sqrt(3.0)-radius_of_circle)<=lenght_of_triangle-(radius_of_circle*Math.sqrt(3.0)-radius_of_circle)-(i-1)*2*radius_of_circle;++j){
						
						Circle current_shape=new Circle();
						//current_shape.plus_circles();
						
						current_shape.setter_position_x((i-2)*radius_of_circle+radius_of_circle*Math.sqrt(3.0)+(j*2-1)*radius_of_circle);
						current_shape.setter_position_y(lenght_of_triangle*Math.sqrt(3.0)/2+radius_of_circle-(2*radius_of_circle+(i-1)*radius_of_circle*Math.sqrt(3.0)));
						current_shape.setter_radius(radius_of_circle);

						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
					}
				}	
				}
	
				else if(container_shape.get_size()==3 && inner_shape.get_size()==3){
					

					double lenght_of_container_triangle=container_shape.difference_mostAndleast_x();
					double lenght_of_small_triangle=inner_shape.difference_mostAndleast_x();
					
						/*This loop determines the total height*/
				for(int i=1;i*(lenght_of_small_triangle*Math.pow(3,1/2.0)/2)<=lenght_of_container_triangle*Math.pow(3,1/2.0)/2;++i){
					
					/*this loop fit triangles in one way*/
					int j=1;
					for( ;j*lenght_of_small_triangle<=(lenght_of_container_triangle-(i-1)*lenght_of_small_triangle);++j){
						
						Triangle current_shape=new Triangle();
						//current_shape.plus_triangles();
						
						current_shape.setter_point1((i-1)*lenght_of_small_triangle/2+(2*j-1)*lenght_of_small_triangle/2,lenght_of_container_triangle*Math.pow(3,1/2.0)/2-i*(lenght_of_small_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_point2(j*lenght_of_small_triangle+(i-1)*lenght_of_small_triangle/2,lenght_of_container_triangle*Math.pow(3,1/2.0)/2-(i-1)*(lenght_of_small_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_point3((j-1)*lenght_of_small_triangle+(i-1)*lenght_of_small_triangle/2,lenght_of_container_triangle*Math.pow(3,1/2.0)/2-(i-1)*(lenght_of_small_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_lenght_of_triangle(lenght_of_small_triangle);

						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);

					}
					/*this loop fit triangles in other way(dont use the rotate property)*/
					for(int k=1;k<j-1;++k){
						
						Triangle current_shape=new Triangle();
						//current_shape.plus_triangles();
						
						current_shape.setter_point1((i-1)*lenght_of_small_triangle/2+k*lenght_of_small_triangle,lenght_of_container_triangle*Math.pow(3,1/2.0)/2-(i-1)*(lenght_of_small_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_point2((2*k+1)*lenght_of_small_triangle/2+(i-1)*lenght_of_small_triangle/2,lenght_of_container_triangle*Math.pow(3,1/2.0)/2-i*(lenght_of_small_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_point3((2*k-1)*lenght_of_small_triangle/2+(i-1)*lenght_of_small_triangle/2,lenght_of_container_triangle*Math.pow(3,1/2.0)/2-i*(lenght_of_small_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_lenght_of_triangle(lenght_of_small_triangle);

					//	current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
					//	current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
					}

				}
				}
				
				else if(container_shape.get_size()==3 && inner_shape.get_size()==4){
					
					double lenght_of_triangle=container_shape.difference_mostAndleast_x();
					double rectangle_width=inner_shape.difference_mostAndleast_x();
					double rectangle_height=inner_shape.difference_mostAndleast_y();
					
					
					if(rectangle_height>rectangle_width){
						rectangle_width=inner_shape.difference_mostAndleast_y();
						rectangle_height=inner_shape.difference_mostAndleast_x();
					}
					
					for(int i=1;i*rectangle_height<=lenght_of_triangle*Math.sqrt(3.0)/2;++i){ /*The total height should be up to the length of the triangle*/
					
				/* the total width of the rectangles in the line + lenght_of_triangle*sqrt(3.0)/2 should be equall lenght of triangle*/
					for(int j=1;j*rectangle_width<=lenght_of_triangle-((i*rectangle_height*2)/Math.sqrt(3.0));++j){

						Rectangle current_shape=new Rectangle();
						//current_shape.plus_rectangles(); /*the number of rectangles that fit to triangle is constantly updated */
						
						current_shape.setter_position((j-1)*rectangle_width+i*rectangle_height/Math.sqrt(3.0),(lenght_of_triangle*Math.sqrt(3.0)/2-(i)*rectangle_height));
						current_shape.setter_width(rectangle_width);
						current_shape.setter_height(rectangle_height);
						
						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
					}
				}
				}
				else if(container_shape.get_size()==100 && inner_shape.get_size()==100){
					
					double radius_of_container_circle=container_shape.difference_mostAndleast_x()/2;
					double radius_of_small_circle=inner_shape.difference_mostAndleast_x()/2;
					
					int height_counter=0;

					/*first for loop is to find out how many circles can fit verticaly*/
					for(int i=1;i*2*radius_of_small_circle<=radius_of_container_circle;++i){
						
						Circle current_shape=new Circle();
						//current_shape.plus_circles();
						
						current_shape.setter_position_x(radius_of_container_circle);
						current_shape.setter_position_y((2*i-1)*radius_of_small_circle);
						current_shape.setter_radius(radius_of_small_circle);
						
						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
					
						/*this for is to find out how many circles fits into the beam(the length of the beam varies depending on where it cuts the circle.) */
						for(int j=1;((((j*2-1)*radius_of_small_circle+radius_of_small_circle*Math.sqrt(3.0))<=Math.sqrt(2*(radius_of_container_circle)*(2*i*radius_of_small_circle)-Math.pow(2*i*radius_of_small_circle,2.0))) && (((j*2-2)*radius_of_small_circle+radius_of_small_circle*Math.sqrt(3.0))+radius_of_small_circle/3<=Math.sqrt(2*(radius_of_container_circle)*((2*i-1)*radius_of_small_circle)-Math.pow((2*i-1)*radius_of_small_circle,2.0))));++j){
							
							Circle current_shapee=new Circle();
							//current_shapee.plus_circles(); /*increases the total number of circles*/
							
							current_shapee.setter_position_x(radius_of_container_circle+radius_of_small_circle*Math.sqrt(3.0)+(2*j-1)*radius_of_small_circle-1*radius_of_small_circle);
							current_shapee.setter_position_y((i*2)*radius_of_small_circle);
							current_shapee.setter_radius(radius_of_small_circle);
							
						//	current_shapee.setter_total_area(current_shapee.getter_total_area()+current_shapee.area());
						//	current_shapee.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
							PolygonDyn b=new PolygonDyn(current_shapee);
							this.add(b);
					
							Circle current_shapee2=new Circle();
							//current_shapee2.plus_circles();
							
							current_shapee2.setter_position_x(radius_of_container_circle-(radius_of_small_circle*Math.sqrt(3.0)+(2*j-2)*radius_of_small_circle));
							current_shapee2.setter_position_y((i*2)*radius_of_small_circle);
							current_shapee2.setter_radius(radius_of_small_circle);
							
							//current_shapee2.setter_total_area(current_shapee2.getter_total_area()+current_shapee2.area());
							//current_shapee2.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
							PolygonDyn c=new PolygonDyn(current_shapee2);
							this.add(c);
						}
					height_counter=i; /*to know and to use later where we are vertically */

					}
					/* up to here the top of the main circle is filling */
					height_counter+=1;
					 
					/* this part for to filling remaining circle which is under part of circle */
					for( ;height_counter*2*radius_of_small_circle<=2*radius_of_container_circle;++height_counter){
						
						Circle current_shape=new Circle();
					//	current_shape.plus_circles();
						
						current_shape.setter_position_x(radius_of_container_circle);
						current_shape.setter_position_y((2*height_counter-1)*radius_of_small_circle);
						current_shape.setter_radius(radius_of_small_circle);
						
					//	current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
					//	current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);

						for(int j=1;((((j*2-1)*radius_of_small_circle+radius_of_small_circle*Math.sqrt(3.0))<=Math.sqrt(2*(radius_of_container_circle)*(2*radius_of_container_circle-2*height_counter*radius_of_small_circle)-Math.pow(2*radius_of_container_circle-2*height_counter*radius_of_small_circle,2.0))) &&  (((j*2-2)*radius_of_small_circle+radius_of_small_circle*Math.sqrt(3.0))+radius_of_small_circle/3<=Math.sqrt(2*(radius_of_container_circle)*(2*radius_of_container_circle-(2*height_counter+1)*radius_of_small_circle)-Math.pow(2*radius_of_container_circle-(2*height_counter+1)*radius_of_small_circle,2.0))));++j){
							
							Circle current_shapee=new Circle();
							//current_shapee.plus_circles();
							
							current_shapee.setter_position_x(radius_of_container_circle+radius_of_small_circle*Math.sqrt(3.0)+(2*j-1)*radius_of_small_circle-1*radius_of_small_circle);
							current_shapee.setter_position_y((height_counter*2)*radius_of_small_circle);
							current_shapee.setter_radius(radius_of_small_circle);
							
							//current_shapee.setter_total_area(current_shapee.getter_total_area()+current_shapee.area());
							//current_shapee.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
							PolygonDyn b=new PolygonDyn(current_shapee);
							this.add(b);

							Circle current_shapee2=new Circle();
							//current_shapee2.plus_circles();
							
							current_shapee2.setter_position_x(radius_of_container_circle-(radius_of_small_circle*Math.sqrt(3.0)+(2*j-2)*radius_of_small_circle));
							current_shapee2.setter_position_y((height_counter*2)*radius_of_small_circle);
							current_shapee2.setter_radius(radius_of_small_circle);
							
						//	current_shapee2.setter_total_area(current_shapee2.getter_total_area()+current_shapee2.area());
						//	current_shapee2.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
							PolygonDyn c=new PolygonDyn(current_shapee2);
							this.add(c);

						}
					}
					}

				else if(container_shape.get_size()==100 && inner_shape.get_size()==3){
					
					double radius_of_circle=container_shape.difference_mostAndleast_x()/2;
					double lenght_of_triangle=inner_shape.difference_mostAndleast_x();
					
					/*to put one triangle the top of circle if the beam is enough long */
					if(2*Math.pow(2*radius_of_circle*(2*radius_of_circle-lenght_of_triangle)-Math.pow(2*radius_of_circle-lenght_of_triangle,2.0),1/2.0)>=lenght_of_triangle){
					Triangle current_shape=new Triangle();
					//current_shape.plus_triangles();
					
					current_shape.setter_point1(radius_of_circle,0);
					current_shape.setter_point2(radius_of_circle+lenght_of_triangle/2,1*(lenght_of_triangle*Math.pow(3,(1/2.0))/2));
					current_shape.setter_point3(radius_of_circle-lenght_of_triangle/2,1*(lenght_of_triangle*Math.pow(3,(1/2.0))/2));
					current_shape.setter_lenght_of_triangle(lenght_of_triangle);

				//	current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
				//	current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
					PolygonDyn a=new PolygonDyn(current_shape);
					this.add(a);
					}
				int copy_i=0;

				/*these three nested for loop are used to fill above half of circle */
				for(int i=2;(i*(lenght_of_triangle*Math.pow(3,(1/2.0))/2))<=radius_of_circle;++i){
				
					for(int j=1;(j*lenght_of_triangle)<=2*(Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0));++j){
					
						Triangle current_shape=new Triangle();
						//current_shape.plus_triangles();
						
						current_shape.setter_point1(radius_of_circle-(Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+(2*j-1)*lenght_of_triangle/2,i*(lenght_of_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_point2(radius_of_circle-(Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+(j-1)*lenght_of_triangle,(i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_point3(radius_of_circle-(Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+j*lenght_of_triangle,(i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_lenght_of_triangle(lenght_of_triangle);

					//	current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
					//	current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
						}
					int k=0;
					if((Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+lenght_of_triangle/2<=(Math.pow(2*radius_of_circle*(i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))){

						Triangle current_shape=new Triangle();
						//current_shape.plus_triangles();
					
						current_shape.setter_point1(radius_of_circle-(Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+0*lenght_of_triangle,((i-1)*(lenght_of_triangle*Math.pow(3,(1/2.0)))/2));
						current_shape.setter_point2(radius_of_circle-(Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))-lenght_of_triangle/2+0*lenght_of_triangle/2,i*(lenght_of_triangle*Math.pow(3,(1/2.0))/2));
						current_shape.setter_point3(radius_of_circle-(Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))-lenght_of_triangle/2+2*lenght_of_triangle/2,i*(lenght_of_triangle*Math.pow(3,(1/2.0))/2));
						current_shape.setter_lenght_of_triangle(lenght_of_triangle);
						k=1;
						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
					}
					/*these two for loop are used to fill one beam that in the middle of circle width triangle*/
					for(int j=2;(((j-1+k)*lenght_of_triangle)+((lenght_of_triangle/2)-(2*k*lenght_of_triangle/2)))<=2*(Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0));++j){
					
						Triangle current_shape=new Triangle();
					//	current_shape.plus_triangles();

						current_shape.setter_point1(radius_of_circle-(Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+(j-1)*lenght_of_triangle,((i-1)*(lenght_of_triangle*Math.pow(3,(1/2.0)))/2));
						current_shape.setter_point2(radius_of_circle-(Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))-lenght_of_triangle/2+(2*j-2)*lenght_of_triangle/2,i*(lenght_of_triangle*Math.pow(3,(1/2.0))/2));
						current_shape.setter_point3(radius_of_circle-(Math.pow(2*radius_of_circle*((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))-lenght_of_triangle/2+2*j*lenght_of_triangle/2,i*(lenght_of_triangle*Math.pow(3,(1/2.0))/2));
						current_shape.setter_lenght_of_triangle(lenght_of_triangle);

						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
						}
					copy_i=i;
					}
					
					for(int j=1 ;(j*lenght_of_triangle)<=2*(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0));++j){
					
						Triangle current_shape=new Triangle();
						//current_shape.plus_triangles();
						
						current_shape.setter_point1(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+(2*j-1)*lenght_of_triangle/2,(copy_i+1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_point2(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+(j-1)*lenght_of_triangle,copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_point3(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+j*lenght_of_triangle,copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_lenght_of_triangle(lenght_of_triangle);

						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
						
						Triangle current_shapee=new Triangle();
						//current_shapee.plus_triangles();
					
						current_shapee.setter_point1(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+(2*j-1)*lenght_of_triangle/2,(copy_i+1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2));
						current_shapee.setter_point2(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+j*lenght_of_triangle,copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2));
						current_shapee.setter_point3(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+(2*j+1)*lenght_of_triangle/2,(copy_i+1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2));
						current_shapee.setter_lenght_of_triangle(lenght_of_triangle);	

						//current_shapee.setter_total_area(current_shapee.getter_total_area()+current_shapee.area());
						//current_shapee.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn b=new PolygonDyn(current_shapee);
						this.add(b);
					}
					copy_i+=2;
					
					/*these three for loop are used to fill below of circle width triangle*/
					for( ;copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2)<=2*radius_of_circle;++copy_i){
				
					for(int j=1;(j*lenght_of_triangle)<=2*Math.pow((2*radius_of_circle*(2*radius_of_circle-copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((2*radius_of_circle-copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2)),2.0)),1/2.0);++j){
						Triangle current_shape=new Triangle();
						//current_shape.plus_triangles();
						
						current_shape.setter_point1(radius_of_circle-Math.pow(2*radius_of_circle*(2*radius_of_circle-copy_i*(lenght_of_triangle*Math.pow(3,1/2.0))/2)-Math.pow(2*radius_of_circle-copy_i*(lenght_of_triangle*Math.pow(3,1/2.0))/2,2.0),1/2.0)+(2*j-1)*lenght_of_triangle/2,(copy_i-1)*(lenght_of_triangle*Math.pow(3,1/2.0))/2);
						current_shape.setter_point2(radius_of_circle-Math.pow(2*radius_of_circle*(2*radius_of_circle-copy_i*(lenght_of_triangle*Math.pow(3,1/2.0))/2)-Math.pow(2*radius_of_circle-copy_i*(lenght_of_triangle*Math.pow(3,1/2.0))/2,2.0),1/2.0)+(j-1)*lenght_of_triangle,copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_point3(radius_of_circle-Math.pow(2*radius_of_circle*(2*radius_of_circle-copy_i*(lenght_of_triangle*Math.pow(3,1/2.0))/2)-Math.pow(2*radius_of_circle-copy_i*(lenght_of_triangle*Math.pow(3,1/2.0))/2,2.0),1/2.0)+j*lenght_of_triangle,copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2));
						current_shape.setter_lenght_of_triangle(lenght_of_triangle);

					//	current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
					//	current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
						}
					
					int z=0;
					if((Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+lenght_of_triangle/2<=(Math.pow(2*radius_of_circle*((copy_i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow((copy_i-1)*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))){
						Triangle current_shape=new Triangle();
						//current_shape.plus_triangles();
						
						current_shape.setter_point1(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+0*lenght_of_triangle,(copy_i*(lenght_of_triangle*Math.pow(3,(1/2.0)))/2));
						current_shape.setter_point2(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))-lenght_of_triangle/2+0*lenght_of_triangle/2,(copy_i-1)*(lenght_of_triangle*Math.pow(3,(1/2.0))/2));
						current_shape.setter_point3(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))-lenght_of_triangle/2+2*lenght_of_triangle/2,(copy_i-1)*(lenght_of_triangle*Math.pow(3,(1/2.0))/2));
						current_shape.setter_lenght_of_triangle(lenght_of_triangle);

						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
						z=1;
					}
					/*and the last for loop is used to fill beam(if there is enough long) that in bottom of circle */
					for(int j=2;((j-1+z)*lenght_of_triangle)+((lenght_of_triangle/2)-(2*z*lenght_of_triangle/2))<=2*(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0));++j){
						
						Triangle current_shape=new Triangle();
						//current_shape.plus_triangles();
						
						current_shape.setter_point1(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))+(j-1)*lenght_of_triangle,(copy_i*(lenght_of_triangle*Math.pow(3,(1/2.0)))/2));
						current_shape.setter_point2(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))-lenght_of_triangle/2+(2*j-2)*lenght_of_triangle/2,(copy_i-1)*(lenght_of_triangle*Math.pow(3,(1/2.0))/2));
						current_shape.setter_point3(radius_of_circle-(Math.pow(2*radius_of_circle*(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2))-Math.pow(copy_i*(lenght_of_triangle*Math.pow(3,1/2.0)/2),2.0),1/2.0))-lenght_of_triangle/2+2*j*lenght_of_triangle/2,(copy_i-1)*(lenght_of_triangle*Math.pow(3,(1/2.0))/2));
						current_shape.setter_lenght_of_triangle(lenght_of_triangle);	

					//	current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
					//	current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
					}
				}
				}

				else if(container_shape.get_size()==100 && inner_shape.get_size()==4){
					
					double radius_of_circle=container_shape.difference_mostAndleast_x()/2;
					double rectangle_width=inner_shape.difference_mostAndleast_x();
					double rectangle_height=inner_shape.difference_mostAndleast_y();
					
					if(rectangle_height>rectangle_width){
						rectangle_width=inner_shape.difference_mostAndleast_y();
						rectangle_height=inner_shape.difference_mostAndleast_x();
					}
				double starter_y=0.0;
				int height_counter=1;

				do{  /*searches for a length value that can be used to obtain the beam to fit at least one rectangle*/

				starter_y+=0.001;

				}while(Math.sqrt(2*radius_of_circle*starter_y-Math.pow(starter_y,2.0))*2<rectangle_width);

				for(int i=1;starter_y+i*rectangle_height<=radius_of_circle;++i){ /*to progress vertically fit to rectangles until reach diameter */

					/*to reach diameter horizontally */
					for(int j=1;j*rectangle_width<=(2*Math.sqrt(2*radius_of_circle*(starter_y+(i-1)*rectangle_height)-Math.pow((starter_y+(i-1)*rectangle_height),2.0)));++j){
						
						Rectangle current_shape=new Rectangle();
						//current_shape.plus_rectangles();
						
						current_shape.setter_position(radius_of_circle-Math.sqrt(2*radius_of_circle*(starter_y+(i-1)*rectangle_height)-Math.pow((starter_y+(i-1)*rectangle_height),2.0))+(j-1)*rectangle_width,starter_y+(i-1)*rectangle_height);
						current_shape.setter_width(rectangle_width);
						current_shape.setter_height(rectangle_height);
						
						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
					}
					height_counter=i;
				}
					/*to fill the upper part of the two circles we use above, fill the rest with two loops in the bottom */
				for(int i=height_counter+1;starter_y+i*rectangle_height<=2*radius_of_circle;++i){
					for(int j=1;j*rectangle_width<=(2*Math.sqrt(2*radius_of_circle*(2*radius_of_circle-(starter_y+(i)*rectangle_height))-Math.pow((2*radius_of_circle-(starter_y+(i)*rectangle_height)),2.0)));++j){
						
						Rectangle current_shape=new Rectangle();
						//current_shape.plus_rectangles();
						
						current_shape.setter_position(radius_of_circle-Math.sqrt(2*radius_of_circle*(2*radius_of_circle-(starter_y+(i)*rectangle_height))-Math.pow((2*radius_of_circle-(starter_y+(i)*rectangle_height)),2.0))+(j-1)*rectangle_width,starter_y+(i-1)*rectangle_height);
						current_shape.setter_width(rectangle_width);
						current_shape.setter_height(rectangle_height);
						
					//	current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
					//	current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
					}
				}
				if(Rectangle.getter_objectCount()==0){

					if(Math.sqrt(Math.pow(rectangle_width/2,2.0)+Math.pow(rectangle_height/2,2.0))<=radius_of_circle){
						
						Rectangle current_shape=new Rectangle();
						//current_shape.plus_rectangles();
						
						current_shape.setter_position(radius_of_circle-rectangle_width/2,radius_of_circle-rectangle_height/2);
						current_shape.setter_width(rectangle_width);
						current_shape.setter_height(rectangle_height);
						
						//current_shape.setter_total_area(current_shape.getter_total_area()+current_shape.area());
						//current_shape.setter_total_perimeter(current_shape.getter_total_perimeter()+current_shape.perimeter());
						PolygonDyn a=new PolygonDyn(current_shape);
						this.add(a);
					}
				}
				}	
			}
				
		   /**
		   * This method is used to return inner shapes array that fixed into container
		   *
		   * @return Shape[]
		   */
			public Shape[] getter_inner_shapes_vector(){ //reach inner shapes vektor data
				
				
				return inner_shapes_vector;
			}
		   /**
		   * This method is used to add an shape element to inner shapes (that fixed into container)
		   * @param element
		   * @return composedShape
		   */
			public composedShape add(Shape element){
				if(inner_shapes_vector_size>=inner_shapes_vector.length){
					Shape[] temp=new Shape[inner_shapes_vector.length+10];
					for(int i=0;i<inner_shapes_vector_size;++i){
						temp[i]=inner_shapes_vector[i];
					}
					if(element instanceof PolygonDyn)
					temp[inner_shapes_vector_size]=new PolygonDyn((PolygonDyn)element);
					else if(element instanceof Triangle)
					temp[inner_shapes_vector_size]=new Triangle((Triangle)element);
					else if(element instanceof Rectangle)
					temp[inner_shapes_vector_size]=new Rectangle((Rectangle)element);
					else if(element instanceof Circle)
					temp[inner_shapes_vector_size]=new Circle((Circle)element);
					else if(element instanceof composedShape)
					temp[inner_shapes_vector_size]=new composedShape((composedShape)element);
					else if(element instanceof PolygonVect)
					temp[inner_shapes_vector_size]=new PolygonVect((PolygonVect)element);
					inner_shapes_vector_size+=1;
					inner_shapes_vector=temp;
				}
				else{
					if(element instanceof PolygonDyn)
					inner_shapes_vector[inner_shapes_vector_size]=new PolygonDyn((PolygonDyn)element);
					else if(element instanceof Triangle)
					inner_shapes_vector[inner_shapes_vector_size]=new Triangle((Triangle)element);
					else if(element instanceof Rectangle)
					inner_shapes_vector[inner_shapes_vector_size]=new Rectangle((Rectangle)element);
					else if(element instanceof Circle)
					inner_shapes_vector[inner_shapes_vector_size]=new Circle((Circle)element);
					else if(element instanceof composedShape)
					inner_shapes_vector[inner_shapes_vector_size]=new composedShape((composedShape)element);
					else if(element instanceof PolygonVect)
					inner_shapes_vector[inner_shapes_vector_size]=new PolygonVect((PolygonVect)element);
					inner_shapes_vector_size+=1;
				}
				return this;
			}
		   /**
		   * This method is used to return container shape
		   * @return Shape
		   */
			public Shape getter_container_shape(){   //reach container shape polygon
				return container_shape;
			}
		   /**
		   * This method is used to return inner shape
		   * @return Shape
		   */
			public Shape getter_inner_shape(){  //reach inner shape polygon
				return inner_shape;
			}
		   /**
		   * This method is used to set container shape
		   * @param Container_shape
		   */
			public void setter_container_shape(PolygonDyn Container_shape){
				container_shape=new PolygonDyn(Container_shape);
			}
		   /**
		   * This method is used to set cinner shape
		   * @param innerr_shape
		   */
			public void setter_inner_shape(PolygonDyn innerr_shape){
				inner_shape=new PolygonDyn(innerr_shape);
			}



		private PolygonDyn container_shape;

		private PolygonDyn inner_shape;
		
		private int inner_shapes_vector_size;
		
		private Shape[] inner_shapes_vector;//these vectors are for inner shapes that inner shapes fit into container shape as polygonDyn
			
	}

