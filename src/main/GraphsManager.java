package main;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphs.Graph;
import graphs.OrientedGraph;
import listeners.ButtonPressListener;
import listeners.MouseListener;
import listeners.MouseMotionListener;

public class GraphsManager extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private final int linesThickness = 2;
	
	private final Color nodeOutlineColor = Color.red;
	private final Color nodeBackgroundColor = Color.white;
	private final int nodeDiameter = 30;
	
	private final Color orientedLinkColor = Color.green;
	private final Color normalLinkColor = Color.red;
	private final Color motionLinkColor = Color.blue;
	
	private final Color selectedButtonColor = Color.green;
	
	
	private boolean isOriented = false;
	private boolean isDragging;
	private Point start, end;
	private Graph graph;
	
	private Button orientedButton, neOrientedButton;
	private JFrame frame;
	
	public GraphsManager (JFrame f) {
		frame = f;
		
		
		if(isOriented) {
			graph = new OrientedGraph(nodeDiameter);
		}
		else {
			graph = new Graph(nodeDiameter);
		}
		
		// Creare butoane
		createButtons();
		
		// Event-uri
		addMouseListener(new MouseListener(this));
		addMouseMotionListener(new MouseMotionListener(this));
		orientedButton.addActionListener(new ButtonPressListener(this, true));
		neOrientedButton.addActionListener(new ButtonPressListener(this, false));
	}
	
	public void switchGraph(boolean toOriented) {
		start = null;
		end = null;
		isDragging = false;
		
		if(toOriented) {
			isOriented = true;
			graph = new OrientedGraph(30);
			
			orientedButton.setBackground(selectedButtonColor);
			neOrientedButton.setBackground(null);
		}
		else {
			isOriented = false;
			graph = new Graph(30);
			
			orientedButton.setBackground(null);
			neOrientedButton.setBackground(selectedButtonColor);
		}
		
		repaint();
	}
	
	public void addNodeOnMouseRelease(Point p) {
		graph.addNodeToGraph(p);
	}
	
	public void addLinkOnMouseRelease() {
		graph.addLinkToGraph(graph.getNodeAtLocation(start), graph.getNodeAtLocation(end));
	}
	
	public boolean getIsOriented() {
		return isOriented;
	}

	public boolean getIsDragging() {
		return isDragging;
	}

	public void setDragging(boolean isDragging) {
		this.isDragging = isDragging;
	}

	public Graph getGraph() {
		return graph;
	}

	public Point getStartPoint() {
		return start;
	}

	public void setStartPoint(Point start) {
		this.start = start;
	}

	public Point getEndPoint() {
		return end;
	}

	public void setEndPoint(Point end) {
		this.end = end;
	}
	
	private void createButtons() {
		// Creare butoane setare graf orientat/neorientat
		orientedButton = new Button("Graf Orientat");
		orientedButton.setBounds(5, 430, 240, 70);
		frame.add(orientedButton);
		
		neOrientedButton = new Button("Graf Neorientat");
		neOrientedButton.setBounds(255, 430, 220, 70);
		neOrientedButton.setBackground(selectedButtonColor);
		frame.add(neOrientedButton);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Seteaza grosimea liniilor
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(linesThickness));
		
		
		// Alege culoarea arcelor si le deseneaza
		if(isOriented) {
			graph.paintAllLinks(g, orientedLinkColor);
		}
		else {
			graph.paintAllLinks(g, normalLinkColor);
		}
		
		// Deseneaza nodurile
		graph.paintAllNodes(g, nodeOutlineColor, nodeBackgroundColor);
		
		// Linia desenata cand utilizatorul vrea sa creeze un arc nou
		if(start != null && end != null) {
			g.setColor(motionLinkColor);
			g.drawLine(start.x, start.y, end.x, end.y);
		}
		
		// Partea de jos
		g.setColor(Color.black);
		g.drawLine(0, 425, 500, 425);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 425, 500, 76);
	}
}
