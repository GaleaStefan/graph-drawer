package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import main.GraphsManager;

public class MouseMotionListener extends MouseMotionAdapter {
	private GraphsManager manager;
	
	public MouseMotionListener(GraphsManager instance) {
		super();
		manager = instance;
	}
	
	public void mouseDragged(MouseEvent e) {
		if(e.getPoint().y <= 425) {
			manager.setEndPoint(e.getPoint());
			manager.setDragging(true);
			manager.repaint();
		}
	}
}
