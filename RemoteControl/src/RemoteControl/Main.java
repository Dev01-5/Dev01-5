package RemoteControl;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame f = new JFrame("REMOTE TEST");
		f.setSize(400, 150);
		Container content = f.getContentPane();
		content.setBackground(Color.white);
		content.setLayout(new FlowLayout());
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		f.getContentPane().add(button1);
		f.getContentPane().add(button2);

		f.setVisible(true);

		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SimpleRemoteControl remote = new SimpleRemoteControl();
				Light light = new Light();
				LightOnCommand lightOn = new LightOnCommand(light);
				remote.setCommand(lightOn);
				remote.buttonWasPressed();
			}
		});
		
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SimpleRemoteControl remote = new SimpleRemoteControl();
				Light light = new Light();
				LightOffCommand lightOff = new LightOffCommand(light);
				remote.setCommandOff(lightOff);
				remote.buttonWasPressedOff();
			}
		});
	}
}
