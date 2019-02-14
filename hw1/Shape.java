import java.awt.Graphics;
public interface Shape extends Comparable<Shape> {


		double area();
		double perimeter();
		Shape increment();
		Shape decrement();
		void draw(Graphics g);
}

