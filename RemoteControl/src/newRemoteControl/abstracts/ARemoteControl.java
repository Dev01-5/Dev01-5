package newRemoteControl.abstracts;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import newRemoteControl.View.FrameView;
import newRemoteControl.View.FrameView.Position;
import newRemoteControl.View.FrameView.Size;
import newRemoteControl.interfaces.iRemoteControl;

public abstract class ARemoteControl implements iRemoteControl{

	private String windowTitle = "RemoteControl";
	private Color windowBackground;
	private JFrame remote;
	
	private Position windowPosition;
	private Size windowSize;
	
	@Override
	public void setWindowTitle(String value) {
		this.windowTitle = value;
	}

	@Override
	public void setWindowSize(Size value) {
		this.windowSize = value;
	}

	@Override
	public void setWindowPosition(Position value) {
		this.windowPosition = value;
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
	public Size getWindowSize() {
		return windowSize;
	}
	
	@Override
	public Position getWindowPosition() {
		return windowPosition;
	}

	@Override
	public Color getWindowBackground() {
		return windowBackground;
	}

	@Override
	public void setRemoteWindow() {
		this.remote = new JFrame(this.windowTitle);
		
//		this.remote.setLocation(this.windowPositionX, this.windowPositionY);
//		this.remote.setSize(this.windowSizeX, this.windowSizeY);
//		this.remote.getContentPane().setBackground(this.windowBackground);
//		
//		this.remote.setLayout(new GridLayout(6, 1));
//		this.remote.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		this.remote.setVisible(true);		
	}

	@Override
	public JFrame getRemoteWindow() {
		return this.remote;
	}

	@Override
	public void addButton(FrameView view, JButton button) {
		view.add(button);
	}

	@Override
	public JButton[] getButtons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTextArea(FrameView view, JTextArea field) {
		view.add(field);
	}
}
