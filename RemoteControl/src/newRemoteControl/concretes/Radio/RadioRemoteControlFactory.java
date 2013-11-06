package newRemoteControl.concretes.Radio;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import newRemoteControl.Controllers.RadioRemoteControlListeners;
import newRemoteControl.View.FrameView;
import newRemoteControl.abstracts.aRemoteControlFactory;
import newRemoteControl.interfaces.IRadio;

public class RadioRemoteControlFactory extends aRemoteControlFactory{

	private JButton RadioPlusOne, RadioMinOne, RadioOn, RadioOff;
	private JTextArea alertDeviceStatus, alertChannelStatus;
	
	@Override
	public FrameView createRemoteControl() {
		IRadio iRadio = new RadioTypeOne();
		
		remoteControl = new RadioRemoteControl(iRadio);
		remoteControl = ((RadioRemoteControl) remoteControl);
		
		remoteControl.setWindowSize(FrameView.Size.SMALL);
		remoteControl.setWindowPosition(FrameView.Position.RIGHTBOTTOM);
		remoteControl.setWindowBackground(Color.GREEN);
		
		FrameView frameView = new FrameView(remoteControl);
		
		frameView.addButton(FrameView.Buttons.POWERON);
		frameView.addButton(FrameView.Buttons.POWEROFF);
		frameView.addButton(FrameView.Buttons.SETCHANNEL);
		
		frameView.addTextField(FrameView.TextFields.DEVICEPOWERALERT);
		frameView.addTextField(FrameView.TextFields.CHANGECHANNELALERT);
		
		frameView.buildView();
		
		new RadioRemoteControlListeners(frameView, this, iRadio);
		
		return frameView;
	}
	
	public JTextArea getAlertDeviceStatus() {
		return alertDeviceStatus;
	}
	
	public JTextArea getAlertChannelStatus() {
		return alertChannelStatus;
	}
	
	public JButton getRadioPlusOne() {
		return RadioPlusOne;
	}
	
	public JButton getRadioMinOne() {
		return RadioMinOne;
	}
	
	public JButton getRadioOn() {
		return RadioOn;
	}
	
	public JButton getRadioOff() {
		return RadioOff;
	}
}
