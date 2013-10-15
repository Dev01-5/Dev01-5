package newRemoteControl.interfaces;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public interface iRemoteControl {

	void PowerDeviceOn();
	void PowerDeviceOff();
	void addButton(JButton button);
	
	void setWindowTitle(String value);
	void setWindowSize(int x, int y);
	void setWindowPosition(int x, int y);
	void setWindowBackground(Color color);
	void setRemoteWindow();
	
	String getWindowTitle();
	int getWindowSizeX();
	int getWindowSizeY();
	int getWindowPositionX();
	int getWindowPositionY();
	JButton[] getButtons();
	Color getWindowBackground();
	
	JFrame getRemoteWindow();
}
