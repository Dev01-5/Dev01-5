package newRemoteControl.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import newRemoteControl.Command.Radio.Power;
import newRemoteControl.Command.Radio.PowerOffCommand;
import newRemoteControl.Command.Radio.PowerOnCommand;
import newRemoteControl.concretes.Tv.TvRemoteControl;
import newRemoteControl.concretes.Tv.TvRemoteControlFactory;

public class TvRemoteControlListeners {

	private ActionListener listener;
	private TvRemoteControlFactory view;
	private TvRemoteControl remoteControl;
	
	private JButton TvOn, TvOff, TvMinOne, TvPlusOne;
	private JTextArea alertChannelStatus, alertDeviceStatus;
	
	public TvRemoteControlListeners(TvRemoteControlFactory view) {
		this.view = view;
		
		remoteControl = (TvRemoteControl) view.getRemoteControl();
		
		TvOn = view.getTvOn();
		TvOff = view.getTvOff();
		TvPlusOne = view.getTvPlusOne();
		TvMinOne = view.getTvMinOne();
		
		alertChannelStatus = view.getAlertChannelStatus();
		alertDeviceStatus = view.getAlertDeviceStatus();
			
		buttonListener();
		
		TvPlusOne.addActionListener(listener);
		TvMinOne.addActionListener(listener);
		TvOn.addActionListener(listener);
		TvOff.addActionListener(listener);
	}
	
	public void buttonListener() {
		listener = new ActionListener() {	
				
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(TvPlusOne)) {
					remoteControl.setChannelByButton("+");
					
					alertChannelStatus.setText(remoteControl.getState());
				}
				
				if (e.getSource().equals(TvMinOne)) {
					remoteControl.setChannelByButton("-");
					
					alertChannelStatus.setText(remoteControl.getState());
				}
				
				if (e.getSource().equals(TvOn)) {
					Power power = new Power();
					PowerOnCommand powerOn = new PowerOnCommand(power);
					remoteControl.setCommandPowerOn(powerOn);
					remoteControl.powerOnWasPressed();
					
					alertDeviceStatus.setText(power.getState());
					
					remoteControl.setPowerOn();
				}
				
				if (e.getSource().equals(TvOff)) {
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
