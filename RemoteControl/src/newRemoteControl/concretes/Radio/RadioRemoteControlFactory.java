package newRemoteControl.concretes.Radio;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextArea;

import newRemoteControl.Controllers.RadioRemoteControlListeners;
import newRemoteControl.abstracts.ARemoteControl;
import newRemoteControl.abstracts.aRemoteControlFactory;
import newRemoteControl.interfaces.IRadio;

public class RadioRemoteControlFactory extends aRemoteControlFactory{

	private JButton RadioPlusOne, RadioMinOne, RadioOn, RadioOff;
	private JTextArea alertDeviceStatus, alertChannelStatus;
	
	@Override
	public ARemoteControl createRemoteControl() {
		IRadio iRadio = new RadioTypeOne();
		
		remoteControl = new RadioRemoteControl(iRadio);
		remoteControl = ((RadioRemoteControl) remoteControl);
		
		remoteControl.setWindowTitle("Radio Remote");
		remoteControl.setWindowSize(400, 200);
		remoteControl.setWindowPosition(800, 250);
		remoteControl.setWindowBackground(Color.GREEN);
		
		remoteControl.setRemoteWindow();
		
		alertDeviceStatus = new JTextArea(15, remoteControl.getWindowSizeX());
		alertDeviceStatus.setEditable(false);
		
		alertChannelStatus = new JTextArea(15, remoteControl.getWindowSizeX());
		alertChannelStatus.setEditable(false);
		
		RadioPlusOne = new JButton("+");
		RadioMinOne = new JButton("-");
		RadioOn = new JButton("Aan");
		RadioOff = new JButton("Uit");
		
		remoteControl.addTextArea(alertDeviceStatus);
		remoteControl.addTextArea(alertChannelStatus);
		
		remoteControl.addButton(RadioPlusOne);
		remoteControl.addButton(RadioMinOne);
		remoteControl.addButton(RadioOn);
		remoteControl.addButton(RadioOff);
		
		new RadioRemoteControlListeners(this);
		
		return remoteControl;
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
