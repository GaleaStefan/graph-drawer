package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.GraphsManager;

public class MouseListener extends MouseAdapter {
	private GraphsManager manager;
	
	public MouseListener(GraphsManager instance) {
		super();
		manager = instance;
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getPoint().y <= 425) {
			manager.setStartPoint(e.getPoint());
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if(e.getPoint().y <= 395) {
			if(manager.getIsDragging()) {
				manager.setEndPoint(e.getPoint());
				manager.addLinkOnMouseRelease();
			}
			else {
				manager.addNodeOnMouseRelease(e.getPoint());
			}
		}
		manager.setStartPoint(null);
		manager.setDragging(false);
		manager.repaint();
	}
}
