package newRemoteControl.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import newRemoteControl.Command.Radio.Power;
import newRemoteControl.Command.Radio.PowerOffCommand;
import newRemoteControl.Command.Radio.PowerOnCommand;
import newRemoteControl.concretes.Radio.RadioRemoteControl;
import newRemoteControl.concretes.Radio.RadioRemoteControlFactory;

public class RadioRemoteControlListeners {

	private ActionListener listener;
	private RadioRemoteControlFactory view;
	private RadioRemoteControl remoteControl;
	
	private JButton RadioOn, RadioOff, RadioMinOne, RadioPlusOne;
	private JTextArea alertChannelStatus, alertDeviceStatus;
	
	public RadioRemoteControlListeners(RadioRemoteControlFactory view) {
		this.view = view;
		
		remoteControl = (RadioRemoteControl) view.getRemoteControl();
		RadioOn = view.getRadioOn();
		RadioOff = view.getRadioOff();
		RadioPlusOne = view.getRadioPlusOne();
		RadioMinOne = view.getRadioMinOne();
		
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
					Power power = new Power();
					PowerOnCommand powerOn = new PowerOnCommand(power);
					remoteControl.setCommandPowerOn(powerOn);
					remoteControl.powerOnWasPressed();
					
					alertDeviceStatus.setText(power.getState());
					
					remoteControl.setPowerOn();
				}
				
				if (e.getSource().equals(RadioOff)) {
					Power power = new Power();
					PowerOffCommand powerOff = new PowerOffCommand(power);
					remoteControl.setCommandPowerOff(powerOff);
					remoteControl.powerOffWasPressed();
					
					alertDeviceStatus.setText(power.getState());
					
					remoteControl.setPowerOff();
				}
			}
		};
	}
}
