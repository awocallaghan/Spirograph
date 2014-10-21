import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Main extends Applet implements ActionListener {

	TextField inputR, inputr, inputO;
	Choice spiroColor;
	Button drawSpiro;
	Hypocycloid spiro;
	String[] colors = {
			"Red",
			"Black",
			"Blue",
			"Cyan",
			"Orange",
			"Magenta"
	};
	
	public void init() {
		setSize(900,800);
		inputR = new TextField("100",8);
		inputr = new TextField("-4",8);
		inputO = new TextField("150",8);
		spiroColor = new Choice();
		for (int i = 0; i < colors.length; i++) {
			spiroColor.insert(colors[i], i);
		}
		drawSpiro = new Button();
		add(inputR);
		add(inputr);
		add(inputO);
		add(spiroColor);
		drawSpiro.setLabel("Draw spirograph");
		add(drawSpiro);
		drawSpiro.addActionListener(this);
		spiro = new Hypocycloid(100, -4, 150, 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int R = Integer.parseInt(inputR.getText());
		int r = Integer.parseInt(inputr.getText());
		int O = Integer.parseInt(inputO.getText());
		int inputColor = spiroColor.getSelectedIndex();
		spiro = new Hypocycloid(R, r, O, inputColor);
		repaint();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawString("Input values of R, r and O.", 100, 50);
		int R = spiro.getR();
		int r = spiro.getr();
		int O = spiro.getO();
		g.drawString("Current values: [ R = " + R + ", r = " + r + ", O = " + O + " ]", 100, 70);
		
		spiro.paint(g);
	}
	
}
