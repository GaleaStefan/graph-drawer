package links;

import java.awt.Color;
import java.awt.Graphics;
import nodes.Node;

public class Link {
	protected Node startN;
	protected Node finishN;
	
	public Link(Node n1, Node n2) {
		startN = n1;
		finishN = n2;
	}
	
	public Node getStartingNode() {
		return startN;
	}
	
	public Node getFinishNode() {
		return finishN;
	}
	
	public void draw(Graphics g, Color color) {
		g.setColor(color);
		g.drawLine(startN.getLocation().x, startN.getLocation().y, finishN.getLocation().x, finishN.getLocation().y);
	}
}
