package newRemoteControl.abstracts;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import newRemoteControl.interfaces.iRemoteControl;

public abstract class ARemoteControl implements iRemoteControl{

	private String windowTitle;
	private int windowPositionX, windowPositionY;
	private int windowSizeX, windowSizeY;
	private Color windowBackground;
	private JFrame remote;
	
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

	@Override
	public void setRemoteWindow() {
		this.remote = new JFrame(this.windowTitle);
		
		this.remote.setLocation(this.windowPositionX, this.windowPositionY);
		this.remote.setSize(this.windowSizeX, this.windowSizeY);
		this.remote.getContentPane().setBackground(this.windowBackground);
		
		this.remote.setLayout(new GridLayout(6, 1));
		this.remote.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.remote.setVisible(true);		
	}

	@Override
	public JFrame getRemoteWindow() {
		return this.remote;
	}

	@Override
	public void addButton(JButton button) {
		this.remote.add(button);
	}

	@Override
	public JButton[] getButtons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTextArea(JTextArea field) {
		this.remote.add(field);
	}
}
