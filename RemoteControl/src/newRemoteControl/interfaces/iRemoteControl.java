package newRemoteControl.interfaces;

import java.awt.Color;

public interface iRemoteControl {
	void PowerDeviceOn();
	void PowerDeviceOff();
	
	void setWindowTitle(String value);
	void setWindowSize(int x, int y);
	void setWindowPosition(int x, int y);
	void setWindowBackground(Color color);
	
	String getWindowTitle();
	int getWindowSizeX();
	int getWindowSizeY();
	int getWindowPositionX();
	int getWindowPositionY();
	Color getWindowBackground();
}
