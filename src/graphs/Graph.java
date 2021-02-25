package graphs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import links.Link;
import math.AxisMath;
import nodes.Node;

public class Graph {
	private Vector<Link> links;
	protected Vector<Node> nodes;
	
	protected int nodeNr;
	protected int diameter;
	
	public Graph(int nodeDiam) {
		links = new Vector<Link>();
		nodes = new Vector<Node>();
		
		diameter = nodeDiam;
		setNodeNr(1);
	}
	
	public Graph(boolean isOriented, int nodeDiam) {
		if(!isOriented) {
			links = new Vector<Link>();
		}
		diameter = nodeDiam;
		setNodeNr(1);
		nodes = new Vector<Node>();
	}
	
	public int getNodeNr() {
		return nodeNr;
	}

	public void setNodeNr(int nodeNr) {
		this.nodeNr = nodeNr;
	}
	
	public void paintAllNodes(Graphics g, Color outline, Color fill) {
		for(Node n : nodes) {
			n.draw(g, outline, fill, diameter);
		}
	}
	
	public void paintAllLinks(Graphics g, Color color) {
		for(Link l : links) {
			l.draw(g, color);
		}
	}
	
	public Node getNodeAtLocation(Point location) {
		for(Node n : nodes) {
			if(AxisMath.GetDistanceBetweenPoints(location, n.getLocation()) <= diameter) {
				return n;
			}
		}
		
		return null;
	}
	
	public boolean existsLinkBetweenNodes(Node n1, Node n2) {
		for(Link l : links) {
			if((l.getStartingNode().equals(n1) && l.getFinishNode().equals(n2)) ||
					(l.getStartingNode().equals(n2) && l.getFinishNode().equals(n1))) {
				return true;
			}
		}
		
		return false;
	}
	
	public void addNodeToGraph(Point location) {
		if(getNodeAtLocation(location) != null) return;
		
		nodes.add(new Node(location, nodeNr));
		nodeNr++;
	}
	
	public void addLinkToGraph(Node from, Node to) {
		if(from == null || to == null) return;
		if(existsLinkBetweenNodes(from, to)) return;
		
		links.add(new Link(from, to));
	}
}
