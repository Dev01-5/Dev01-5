package newRemoteControl.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import newRemoteControl.Command.Radio.PowerTv;
import newRemoteControl.Command.Radio.PowerTvOffCommand;
import newRemoteControl.Command.Radio.PowerTvOnCommand;
import newRemoteControl.View.FrameView;
import newRemoteControl.concretes.Radio.RadioRemoteControlFactory;
import newRemoteControl.concretes.Tv.TvRemoteControl;
import newRemoteControl.concretes.Tv.TvRemoteControlFactory;
import newRemoteControl.interfaces.*;

public class TvRemoteControlListeners {

	private ActionListener listener;
	private FrameView view;
	private TvRemoteControlFactory model;
	private TvRemoteControl remoteControl;
	private ITv iTv;
	
	private JButton TvOn, TvOff, TvMinOne, TvPlusOne;
	private JTextArea alertChannelStatus, alertDeviceStatus;
	
	public TvRemoteControlListeners(FrameView view, TvRemoteControlFactory model, ITv iTv){
		this.view = view;
		this.iTv = iTv;
		
		remoteControl = (TvRemoteControl) model.getRemoteControl();
		
		TvOn = view.getPowerOn();
		TvOff = view.getPowerOff();
		TvPlusOne = view.getChannelPlusOne();
		TvMinOne = view.getChannelMinOne();
		
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
					PowerTv power = new PowerTv(iTv);
					PowerTvOnCommand powerOn = new PowerTvOnCommand(power);
					remoteControl.setCommandPowerOn(powerOn);
					remoteControl.powerOnWasPressed();
					
					alertDeviceStatus.setText(power.getState());
				}
				
				if (e.getSource().equals(TvOff)) {
					PowerTv power = new PowerTv(iTv);
					PowerTvOffCommand powerOff = new PowerTvOffCommand(power);
					remoteControl.setCommandPowerOff(powerOff);
					remoteControl.powerOffWasPressed();
					
					alertDeviceStatus.setText(power.getState());
				}
			}
		};
	}
}
