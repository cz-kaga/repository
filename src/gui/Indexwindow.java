package gui;
import java.awt.Container;
import javax.swing.*;
import locale.Locale;
/*
 * 用于打开软件的界面的派生类
 */
public class Indexwindow extends Windows{
	Container indexpane = windows.getContentPane();
	JList serveraddr = new JList();
	indexpane.add(serveraddr);
}
