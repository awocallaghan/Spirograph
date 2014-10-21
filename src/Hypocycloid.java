import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Hypocycloid {

	private int R, r, O;
	private Color color;
	Color[] colors = {
			Color.RED,
			Color.BLACK,
			Color.BLUE,
			Color.CYAN,
			Color.ORANGE,
			Color.MAGENTA
	};
	private int X = 800, Y = 800;
	
	public Hypocycloid(int inputR, int inputr, int inputO, int inputColor) {
		R = inputR;
		r = inputr;
		O = inputO;
		color = colors[inputColor];
		System.out.println(" * Hypocycloid created [ R = " + R + ", r = " + r + ", O = " + O + " ]");
	}
	
	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		double MAX = 2 * Math.PI;
		for (double t = 0; t < MAX; t += 0.0005) {
			gg.setColor(color);
			double x = (R + r) * Math.cos(t) - (r + O) * Math.cos(((R + r)/r) * t) + 100 + (X / 2);
			double y = (R + r) * Math.sin(t) - (r + O) * Math.sin(((R + r)/r) * t) + (Y / 2);
			Ellipse2D.Double shape = new Ellipse2D.Double(x, y, 1, 1);
			gg.draw(shape);
			System.out.println(" ** Drawing at (" + x + "," + y + ")");
		}
	}
	
	public int getR() {
		return R;
	}
	
	public int getr() {
		return r;
	}
	
	public int getO() {
		return O;
	}
	
}
