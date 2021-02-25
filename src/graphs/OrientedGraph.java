package graphs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import links.Link;
import links.OrientedLink;
import nodes.Node;

public class OrientedGraph extends Graph {
	private Vector<OrientedLink> orientedLinks;
	
	public OrientedGraph(int diam) {
		super(true, diam);
		orientedLinks = new Vector<OrientedLink>();
	}
	
	@Override
	public void paintAllLinks(Graphics g, Color color) {
		for(Link l : orientedLinks) {
			l.draw(g, color);
		}
	}
	
	@Override
	public boolean existsLinkBetweenNodes(Node n1, Node n2) {
		for(Link l : orientedLinks) {
			if(l.getStartingNode().equals(n1) && l.getFinishNode().equals(n2)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void addLinkToGraph(Node from, Node to) {
		if(from == null || to == null) return;
		if(existsLinkBetweenNodes(from, to)) return;
		
		orientedLinks.add(new OrientedLink(from, to));
	}
}
