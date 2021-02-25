package listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.GraphsManager;

public class ButtonPressListener implements ActionListener {
	private GraphsManager manager;
	private boolean oriented;
	
	public ButtonPressListener(GraphsManager manager, boolean oriented) {
		this.manager = manager;
		this.oriented = oriented;
	}
	public void actionPerformed(ActionEvent e) {
		if(oriented == manager.getIsOriented()) return;
		manager.switchGraph(oriented);

	}

}
