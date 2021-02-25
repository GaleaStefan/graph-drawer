package links;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import nodes.Node;

public class OrientedLink extends Link {
	
	//private boolean bidirectional = false;
	
	public OrientedLink(Node n1, Node n2) {
		super(n1, n2);
	}
	
	@Override
	public void draw(Graphics g, Color c) {
		super.draw(g, c);

		Polygon arrow = createArrow();
		g.drawPolygon(arrow);
		g.fillPolygon(arrow);
	}
	
	private Polygon createArrow() {
		Polygon p = new Polygon();
		p.addPoint(finishN.getLocation().x, finishN.getLocation().y);
		p.addPoint(finishN.getLocation().x - 10, finishN.getLocation().y + (int)((Math.sqrt(3) / 2) * 20));
		p.addPoint(finishN.getLocation().x + 10, finishN.getLocation().y + (int)((Math.sqrt(3) / 2) * 20));
		
		return p;
	}
	
	
}
