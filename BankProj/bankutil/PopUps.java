package bankutil;

import java.awt.Component;

import javax.swing.JOptionPane;

public class PopUps {
	public static void showSuccessMsg(Component c, String msg, String title) {
		JOptionPane.showMessageDialog(c, msg, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void showFailureMsg(Component c, String msg, String title) {
		JOptionPane.showMessageDialog(c, msg, title, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showPlainMsg(Component c, String msg, String title) {
		JOptionPane.showMessageDialog(c, msg, title, JOptionPane.PLAIN_MESSAGE);
	}
}
