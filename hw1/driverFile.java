import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class driverFile {
    
     public static void main(String[] args) {
         
         
        Rectangle e=new Rectangle(20,30);
        Rectangle y=new Rectangle(445,330);
        Triangle tb=new Triangle(550);
        Triangle ts=new Triangle(17);           
        Circle k=new Circle(20);
        Circle l=new Circle(350);               
        PolygonDyn f1=new PolygonDyn(l);
        PolygonVect gf=new PolygonVect(y);
        PolygonVect fv=new PolygonVect(gf);
        
        
         composedShape h1=new composedShape(y,e);
         h1.optimalFit();
         composedShape h2=new composedShape(y,ts);
         h2.optimalFit();
         composedShape h3=new composedShape(y,k);
         h3.optimalFit();
         
         composedShape h4=new composedShape(tb,e);        //create all possible composedShape(9)
         h4.optimalFit();
         composedShape h5=new composedShape(tb,ts);
         h5.optimalFit();
         composedShape h6=new composedShape(tb,k);
         h6.optimalFit();
         
         composedShape h7=new composedShape(l,e);
         h7.optimalFit();
         composedShape h8=new composedShape(l,k);
         h8.optimalFit();
         composedShape h9=new composedShape(l,ts);
         h9.optimalFit();

         Shapes s1=new Shapes(h1);               //draw  all possible composedShapes(9) in panels
         Shapes s2=new Shapes(h2);
         Shapes s3=new Shapes(h3);
         Shapes s4=new Shapes(h4);
         Shapes s5=new Shapes(h5);
         Shapes s6=new Shapes(h6);
         Shapes s7=new Shapes(h7);
         Shapes s8=new Shapes(h8);
         Shapes s9=new Shapes(h9);
         
         
         JFrame application=new JFrame();
         JFrame application1=new JFrame();
         JFrame application2=new JFrame();
         JFrame application3=new JFrame();
         JFrame application4=new JFrame();
         JFrame application5=new JFrame();
         JFrame application6=new JFrame();
         JFrame application7=new JFrame();
         JFrame application8=new JFrame();

         application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         application.add(s1);
         application.setSize(700,710);
         application.setVisible(true);

         application1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         application1.add(s2);
         application1.setSize(700,710);
         application1.setVisible(true);

        application2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         application2.add(s3);
         application2.setSize(700,710);
         application2.setVisible(true);

        application3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         application3.add(s4);
         application3.setSize(700,710);
         application3.setVisible(true);

         application4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         application4.add(s5);
         application4.setSize(900,710);
         application4.setVisible(true);
         
         application5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         application5.add(s6);
         application5.setSize(700,710);
         application5.setVisible(true);
         
         application6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         application6.add(s7);
         application6.setSize(700,710);
         application6.setVisible(true);
         
         application7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         application7.add(s8);
         application7.setSize(700,710);
         application7.setVisible(true);
         
         application8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         application8.add(s9);
         application8.setSize(700,710);
         application8.setVisible(true);

         
         
         Shape[] array=new Shape[4];
         
         array[0]=gf;
         array[1]=k;
         array[2]=ts;
         array[3]=f1;
   
         
         Shape[] poly_shapes=StaticMethods.convertAll(array); //static method convertAll convert all shape polygon
         if(poly_shapes[1] instanceof Polygon){
             System.out.println("convert process is successed");
         }
         
       
        try{
       StaticMethods.drawAll(array);
        }
        catch(NullPointerException ex){
            System.out.println("exception handled in main ");
        }
        finally{
           System.out.println("exception occuring doesnt worry me :)");
        }



        if(y.area()>e.area())
            System.out.println("object y is bigger than e");
        else
            System.out.println("Object e is bigger than y");

        if(y.perimeter()>e.perimeter()){
            System.out.println("Object y' perimeter is bigger than e");
        }
        else
            System.out.println("Object e' perimeter is bigger than y");


        if(tb.area()>ts.area())
            System.out.println("object tb is bigger than ts");
        else
            System.out.println("Object ts is bigger than tb");

        if(tb.perimeter()>ts.perimeter()){
            System.out.println("Object tb' perimeter is bigger than ts");         //T
        }																		  //r
        else																	  //y
            System.out.println("Object ts' perimeter is bigger than tb");


        if(l.area()>k.area())
            System.out.println("object l is bigger than k");					 //A
        else																     //l
            System.out.println("Object k is bigger than l");					 //l
        if(l.perimeter()>k.perimeter()){
            System.out.println("Object l' perimeter is bigger than k");
        }
        else
            System.out.println("Object k' perimeter is bigger than l");

        																		//F
       if(gf.area()>fv.area())												    //u
            System.out.println("object gf is bigger than fv");					//n
        else																	//c
            System.out.println("Object fv is bigger than gf");					//t
            																	//i
        if(gf.perimeter()>fv.perimeter()){										//o
            System.out.println("Object gf' perimeter is bigger than fv");		//n
        }																		//s
        else
            System.out.println("Object fv' perimeter is bigger than gf");



        if(gf.compareTo(fv)==1)
             System.out.println("object gf is bigger than fv");
        else if(gf.compareTo(fv)==-1)
            System.out.println("Object fv is bigger than gf");
        else if(gf.compareTo(fv)==0)
            System.out.println("These two shapes are equal to their areas");

        if(l.compareTo(k)==1)
             System.out.println("object l is bigger than k");
        else if(l.compareTo(k)==-1)
            System.out.println("Object k is bigger than l");
        else if(l.compareTo(k)==0)
            System.out.println("These two shapes are equal to their areas");

        if(tb.compareTo(ts)==1)
             System.out.println("object tb is bigger than ts");
        else if(tb.compareTo(ts)==-1)
            System.out.println("Object ts is bigger than tb");
        else if(tb.compareTo(ts)==0)
            System.out.println("These two shapes are equal to their areas");


        if(y.compareTo(e)==1)
             System.out.println("object y is bigger than e");
        else if(y.compareTo(e)==-1)
            System.out.println("Object e is bigger than y");
        else if(y.compareTo(e)==0)
            System.out.println("These two shapes are equal to their areas");



        e.increment();
        y.decrement();

        tb.increment();
        ts.decrement();

        l.increment();
        k.decrement();

        gf.increment();
        f1.decrement();


     }

     }
    
