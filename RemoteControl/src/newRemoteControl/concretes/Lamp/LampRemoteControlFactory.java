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
import newRemoteControl.Controllers.LampRemoteControlListeners;
import newRemoteControl.abstracts.ARemoteControl;
import newRemoteControl.abstracts.aRemoteControlFactory;
import newRemoteControl.concretes.Radio.RadioRemoteControl;

public class LampRemoteControlFactory extends aRemoteControlFactory{

	private JButton LightOneOnButton, LightTwoOnButton, LightOneOffButton, LightTwoOffButton;
	private JTextArea alertBox;
	
	private LampRemoteControl lampRemoteControl;
	
	@Override
	public ARemoteControl createRemoteControl() {
		
		remoteControl = new LampRemoteControl();
		lampRemoteControl = ((LampRemoteControl) remoteControl);
		
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
		
		new LampRemoteControlListeners(this);
		
		return remoteControl;
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
