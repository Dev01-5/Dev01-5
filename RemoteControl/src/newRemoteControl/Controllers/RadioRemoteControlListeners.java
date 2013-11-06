package newRemoteControl.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import newRemoteControl.View.FrameView;
import newRemoteControl.concretes.Radio.RadioRemoteControl;
import newRemoteControl.concretes.Radio.RadioRemoteControlFactory;
import newRemoteControl.interfaces.IRadio;
import newRemoteControl.Command.Radio.*;

public class RadioRemoteControlListeners {

	private ActionListener listener;
	private FrameView view;
	private RadioRemoteControlFactory model;
	private IRadio iRadio;
	
	private RadioRemoteControl remoteControl;
	
	private JButton RadioOn, RadioOff, RadioMinOne, RadioPlusOne;
	private JTextArea alertChannelStatus, alertDeviceStatus;
	
	public RadioRemoteControlListeners(FrameView view, RadioRemoteControlFactory model, IRadio iRadio) {
		this.view = view;
		this.iRadio = iRadio;
		
		remoteControl = (RadioRemoteControl) model.getRemoteControl();
		
		RadioOn = view.getPowerOn();
		RadioOff = view.getPowerOff();
		RadioPlusOne = view.getChannelPlusOne();
		RadioMinOne = view.getChannelMinOne();
		
		alertChannelStatus = view.getAlertChannelStatus();
		alertDeviceStatus = view.getAlertDeviceStatus();
			
		buttonListener();
		
		RadioPlusOne.addActionListener(listener);
		RadioMinOne.addActionListener(listener);
		RadioOn.addActionListener(listener);
		RadioOff.addActionListener(listener);
	}
	
	public void buttonListener() {
		
		listener =  new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(RadioPlusOne)) {
					remoteControl.setChannelByButton("+");
					
					alertChannelStatus.setText(remoteControl.getState());
				}
				
				if (e.getSource().equals(RadioMinOne)) {
					remoteControl.setChannelByButton("-");
					
					alertChannelStatus.setText(remoteControl.getState());
				}
				
				if (e.getSource().equals(RadioOn)) {
					PowerRadio power = new PowerRadio(iRadio);
					PowerRadioOnCommand powerOn = new PowerRadioOnCommand(power);
					remoteControl.setCommandPowerOn(powerOn);
					remoteControl.powerOnWasPressed();
					
					alertDeviceStatus.setText(power.getState());
				}
				
				if (e.getSource().equals(RadioOff)) {
					PowerRadio power = new PowerRadio(iRadio);
					PowerRadioOffCommand powerOff = new PowerRadioOffCommand(power);
					remoteControl.setCommandPowerOff(powerOff);
					remoteControl.powerOffWasPressed();
					
					alertDeviceStatus.setText(power.getState());
				}
			}
		};
	}
}
