package newRemoteControl.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import newRemoteControl.Command.Lamp.LightOne;
import newRemoteControl.Command.Lamp.LightOneOffCommand;
import newRemoteControl.Command.Lamp.LightOneOnCommand;
import newRemoteControl.Command.Lamp.LightTwo;
import newRemoteControl.Command.Lamp.LightTwoOffCommand;
import newRemoteControl.Command.Lamp.LightTwoOnCommand;
import newRemoteControl.concretes.Lamp.LampRemoteControl;
import newRemoteControl.concretes.Lamp.LampRemoteControlFactory;
import newRemoteControl.View.FrameView;

public class LampRemoteControlListeners {

	private ActionListener listener;
	private FrameView view; 
	private LampRemoteControlFactory model;
	private LampRemoteControl remoteControl;
	
	private JButton LightOneOffButton, LightOneOnButton, LightTwoOffButton, LightTwoOnButton;
	private JTextArea alertBox;
	
	public LampRemoteControlListeners(FrameView view, LampRemoteControlFactory model) {
		this.view = view;
		
		remoteControl = (LampRemoteControl) model.getRemoteControl();
		
		LightOneOnButton = view.getLampOneOn();
		LightOneOffButton = view.getLampOneOff();
		LightTwoOnButton = view.getLampTwoOn();
		LightTwoOffButton = view.getLampTwoOff();
		
		alertBox = view.getAlertDeviceStatus();
			
		buttonListener();
		
		LightOneOffButton.addActionListener(listener);
		LightOneOnButton.addActionListener(listener);
		LightTwoOffButton.addActionListener(listener);
		LightTwoOnButton.addActionListener(listener);
	}
	
	public void buttonListener() {
			
			listener = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(LightOneOnButton)) {
						LightOne light = new LightOne();
						LightOneOnCommand lightOn = new LightOneOnCommand(light);
						remoteControl.setCommandOneOn(lightOn);
						remoteControl.lampOneOnWasPressed();
						
						alertBox.setText(light.getState());
					}
					
					if (e.getSource().equals(LightOneOffButton)) {
						LightOne light = new LightOne();
						LightOneOffCommand lightOff = new LightOneOffCommand(light);
						remoteControl.setCommandOneOff(lightOff);
						remoteControl.lampOneOffWasPressed();
						
						alertBox.setText(light.getState());
					}
					
					if (e.getSource().equals(LightTwoOnButton)) {
						LightTwo light = new LightTwo();
						LightTwoOnCommand lightOn = new LightTwoOnCommand(light);
						remoteControl.setCommandTwoOn(lightOn);
						remoteControl.lampTwoOnWasPressed();
						
						alertBox.setText(light.getState());
					}
					
					if (e.getSource().equals(LightTwoOffButton)) {
						LightTwo light = new LightTwo();
						LightTwoOffCommand lightOff = new LightTwoOffCommand(light);
						remoteControl.setCommandTwoOff(lightOff);
						remoteControl.lampTwoOffWasPressed();
						
						alertBox.setText(light.getState());
					}
				}
			};
		}
}
