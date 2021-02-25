package nodes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public class Node {
	private Point location;
	private int id;
	
	public Node(Point l, int id) {
		setLocation(l);
		this.setId(id);
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void draw(Graphics g, Color outlineColor, Color fillColor, int diameter) {
		g.setColor(fillColor);
		g.fillOval((location.x - diameter / 2), (location.y - diameter / 2), diameter, diameter);
		
		g.setColor(outlineColor);
		g.drawOval((location.x - diameter / 2), (location.y - diameter / 2), diameter, diameter);
		
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.drawString(Integer.toString(id) , (location.x), (location.y));
	}
	
	public boolean equals(Node n) {
		return(location.equals(n.location) && id == n.getId());
	}
}
