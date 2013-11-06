package newRemoteControl.concretes.Lamp;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextArea;

import newRemoteControl.Controllers.LampRemoteControlListeners;
import newRemoteControl.Controllers.TvRemoteControlListeners;
import newRemoteControl.abstracts.aRemoteControlFactory;
import newRemoteControl.View.*;

public class LampRemoteControlFactory extends aRemoteControlFactory{

	private JButton LightOneOnButton, LightTwoOnButton, LightOneOffButton, LightTwoOffButton;
	private JTextArea alertBox;
	
	private LampRemoteControl lampRemoteControl;
	
	@Override
	public FrameView createRemoteControl() {
		
		remoteControl = new LampRemoteControl();
		lampRemoteControl = ((LampRemoteControl) remoteControl);
		
		remoteControl.setWindowSize(FrameView.Size.LARGE);
		remoteControl.setWindowPosition(FrameView.Position.LEFTBOTTOM);
		remoteControl.setWindowBackground(Color.YELLOW);
		
		FrameView frameView = new FrameView(remoteControl);
		
		frameView.addButton(FrameView.Buttons.LAMPONEON);
		frameView.addButton(FrameView.Buttons.LAMPONEOFF);
		frameView.addButton(FrameView.Buttons.LAMPTWOON);
		frameView.addButton(FrameView.Buttons.LAMPTWOOFF);
		
		frameView.addTextField(FrameView.TextFields.DEVICEPOWERALERT);
		
		frameView.buildView();
		
		new LampRemoteControlListeners(frameView, this);
		
		return frameView;
	}
	
	public JTextArea getAlert() {
		return alertBox;
	}

	public JButton getLightOneOnButton() {
		return LightOneOnButton;
	}
	
	public JButton getLightOneOffButton() {
		return LightOneOffButton;
	}
	
	public JButton getLightTwoOnButton() {
		return LightTwoOnButton;
	}
	
	public JButton getLightTwoOffButton() {
		return LightTwoOffButton;
	}
}
