package newRemoteControl.concretes.Lamp;

import java.awt.Color;
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
import newRemoteControl.abstracts.ARemoteControl;
import newRemoteControl.abstracts.aRemoteControlFactory;

public class LampRemoteControlFactory extends aRemoteControlFactory{

	private JButton LightOneOnButton, LightTwoOnButton, LightOneOffButton, LightTwoOffButton;
	private JTextArea alertBox;
	
	@Override
	public ARemoteControl createRemoteControl() {
		
		remoteControl = new LampRemoteControl();
		
		remoteControl.setWindowTitle("Lamp Remote");
		remoteControl.setWindowSize(400, 200);
		remoteControl.setWindowPosition(100, 250);
		remoteControl.setWindowBackground(Color.BLACK);

		remoteControl.setRemoteWindow();

		alertBox = new JTextArea(15, remoteControl.getWindowSizeX());
		alertBox.setEditable(false);
		
		LightOneOnButton = new JButton("Lamp 1 aan");
		LightOneOffButton = new JButton("Lamp 1 uit");
		LightTwoOnButton = new JButton("Lamp 2 aan");
		LightTwoOffButton = new JButton("Lamp 2 uit");
		
		remoteControl.addTextArea(alertBox);
		remoteControl.addButton(LightOneOnButton);
		remoteControl.addButton(LightOneOffButton);
		remoteControl.addButton(LightTwoOnButton);
		remoteControl.addButton(LightTwoOffButton);
		
		LightOneOnButton.addActionListener(buttonListener());
		LightOneOffButton.addActionListener(buttonListener());
		LightTwoOnButton.addActionListener(buttonListener());
		LightTwoOffButton.addActionListener(buttonListener());
		
		return remoteControl;
	}
	
	public ActionListener buttonListener() {
		
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(LightOneOnButton)) {
					LightOne light = new LightOne();
					LightOneOnCommand lightOn = new LightOneOnCommand(light);
					((LampRemoteControl) remoteControl).setCommandOneOn(lightOn);
					((LampRemoteControl) remoteControl).lampOneOnWasPressed();
					
					alertBox.setText(light.getState());
				}
				
				if (e.getSource().equals(LightOneOffButton)) {
					LightOne light = new LightOne();
					LightOneOffCommand lightOff = new LightOneOffCommand(light);
					((LampRemoteControl) remoteControl).setCommandOneOff(lightOff);
					((LampRemoteControl) remoteControl).lampOneOffWasPressed();
					
					alertBox.setText(light.getState());
				}
				
				if (e.getSource().equals(LightTwoOnButton)) {
					LightTwo light = new LightTwo();
					LightTwoOnCommand lightOn = new LightTwoOnCommand(light);
					((LampRemoteControl) remoteControl).setCommandTwoOn(lightOn);
					((LampRemoteControl) remoteControl).lampTwoOnWasPressed();
					
					alertBox.setText(light.getState());
				}
				
				if (e.getSource().equals(LightTwoOffButton)) {
					LightTwo light = new LightTwo();
					LightTwoOffCommand lightOff = new LightTwoOffCommand(light);
					((LampRemoteControl) remoteControl).setCommandTwoOff(lightOff);
					((LampRemoteControl) remoteControl).lampTwoOffWasPressed();
					
					alertBox.setText(light.getState());
				}
			}
		};
	}
}
