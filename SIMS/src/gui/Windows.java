package gui;
import javax.swing.JFrame;
import locale.*;
public class Windows {
	private String _title = "title";
	public JFrame createwindows()
	{
		JFrame windows = new JFrame();
		windows.setSize(800,600);
		//windows.setBounds(500, 500, 800, 600);
		windows.setLocationRelativeTo(null);
		windows.setTitle(Locale.getTrans(_title));
		windows.setVisible(true);
		return windows;
	}
}
