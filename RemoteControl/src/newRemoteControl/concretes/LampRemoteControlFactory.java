package newRemoteControl.concretes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import newRemoteControl.States.Lamp.*;
import newRemoteControl.abstracts.aRemoteControlFactory;

public class LampRemoteControlFactory extends aRemoteControlFactory{

	private JButton LightOneButton, LightTwoButton;
	private State AllOffState, AllOnState;
	private StateContext context;
	
	private State state;
	
	@Override
	public RemoteControl createRemoteControl() {
		
		context = new StateContext();
		
		remoteControl = new RemoteControl();
		
		remoteControl.setWindowTitle("Lamp Remote");
		remoteControl.setWindowSize(400, 400);
		remoteControl.setWindowPosition(100, 250);
		remoteControl.setWindowBackground(Color.RED);

		remoteControl.setRemoteWindow();
		
		LightOneButton = new JButton("Alles aan");
		LightTwoButton = new JButton("Alles uit");
		
		remoteControl.addButton(LightOneButton);
		remoteControl.addButton(LightTwoButton);
		
		LightTwoButton.addActionListener(buttonListener());
		LightOneButton.addActionListener(buttonListener());
		
		return remoteControl;
	}
	
	public ActionListener buttonListener() {
		
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(LightOneButton)) {
					context.setState(AllOnState);
					state = AllOnState;
				}
				
				if (e.getSource().equals(LightTwoButton)) {
					context.setState(AllOffState);
					state = AllOffState;
				}
			}
		};
	}
}
