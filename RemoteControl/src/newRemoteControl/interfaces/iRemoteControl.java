package newRemoteControl.interfaces;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import newRemoteControl.View.FrameView.Position;
import newRemoteControl.View.FrameView.Size;
import newRemoteControl.View.FrameView;

public interface iRemoteControl {

	void addButton(FrameView view, JButton button);
	void addTextArea(FrameView view, JTextArea field);
	
	void setWindowTitle(String value);
	void setWindowSize(Size value);
	void setWindowPosition(Position value);
	void setWindowBackground(Color color);
	void setRemoteWindow();
	
	String getWindowTitle();
	Size getWindowSize();
	Position getWindowPosition();
	JButton[] getButtons();
	Color getWindowBackground();
	
	JFrame getRemoteWindow();
}
