package newRemoteControl.concretes;

import java.awt.Color;

import newRemoteControl.interfaces.*;

public class RemoteControl implements iRemoteControl{

	private String windowTitle;
	private int windowPositionX, windowPositionY;
	private int windowSizeX, windowSizeY;
	private Color windowBackground;
	
	@Override
	public void PowerDeviceOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PowerDeviceOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWindowTitle(String value) {
		this.windowTitle = value;
	}

	@Override
	public void setWindowSize(int x, int y) {
		this.windowSizeX = x;
		this.windowSizeY = y;
	}

	@Override
	public void setWindowPosition(int x, int y) {
		this.windowPositionX = x;
		this.windowPositionY = y;
	}

	@Override
	public void setWindowBackground(Color color) {
		this.windowBackground = color;
	}

	@Override
	public String getWindowTitle() {
		return this.windowTitle;
	}

	@Override
	public int getWindowSizeX() {
		return windowSizeX;
	}

	@Override
	public int getWindowSizeY() {
		return windowSizeY;
	}

	@Override
	public int getWindowPositionX() {
		return windowPositionX;
	}

	@Override
	public int getWindowPositionY() {
		return windowPositionY;
	}

	@Override
	public Color getWindowBackground() {
		return windowBackground;
	}

}
