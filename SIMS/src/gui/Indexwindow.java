package gui;
import java.awt.Container;
import javax.swing.*;
import locale.Locale;
/*
 * ���ڴ�����Ľ����������
 */
public class Indexwindow extends Windows{
	Container indexpane = windows.getContentPane();
	JList serveraddr = new JList();
	indexpane.add(serveraddr);
}
