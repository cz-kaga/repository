package gui;

import javax.swing.JFrame;
import locale.*;

public class Windows {
	protected String _title = "title";
	protected JFrame windows = new JFrame();

	public JFrame createwindows() {

		windows.setSize(800, 600);
		// windows.setBounds(500, 500, 800, 600);
		windows.setLocationRelativeTo(null);
		windows.setTitle(Locale.getTrans(_title));
		windows.setVisible(true);
		return windows;
	}
}
