package newRemoteControl.View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import newRemoteControl.abstracts.ARemoteControl;

public class FrameView extends aView{
	
	public static enum Position {LEFTBOTTOM, RIGHTBOTTOM, RIGHTTOP};
	public static enum Size {SMALL, MEDIUM, LARGE};
	
	public static enum Buttons{POWERON, POWEROFF, SETCHANNEL, LAMPONEON, LAMPONEOFF, LAMPTWOON, LAMPTWOOFF};
	public static enum TextFields{DEVICEPOWERALERT, CHANGECHANNELALERT, LAMPPOWER};
	
	private Dimension screenSize;
	private int windowSizeX, windowSizeY;
	private int windowPositionX, windowPositionY;
	private int textFieldColums, textFieldRows;
	
	private ArrayList<Buttons> toBeAddedButtons;
	private ArrayList<TextFields> toBeAddedTextFields;
	
	private JButton ChannelPlusOne, ChannelMinOne, PowerOn, PowerOff, LampOneOn, LampOneOff, LampTwoOn, LampTwoOff;
	private JTextArea alertDeviceStatus, alertChannelStatus;
	
	ARemoteControl remoteControl;

	public FrameView(ARemoteControl remoteControl) {
		this.remoteControl = remoteControl;
		this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		toBeAddedButtons = new ArrayList<Buttons>();
		toBeAddedTextFields = new ArrayList<TextFields>();
	}

	public FrameView buildView() {
		determineSize(remoteControl.getWindowSize());
		determinePosition(remoteControl.getWindowPosition());
		
		determineTextFieldSize();
		addTextFieldsToView();
		addButtonsToView();
		
		this.setTitle(remoteControl.getWindowTitle());
		this.setLocation(this.windowPositionX, this.windowPositionY);
		this.setSize(this.windowSizeX, this.windowSizeY);
		this.getContentPane().setBackground(remoteControl.getWindowBackground());
		
		this.setLayout(new GridLayout(6, 1));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		
		this.setVisible(true);
		
		return this;
	}
	
	public FrameView getView() {
		return this;
	}
	
	private void addButtonsToView() {
		for (Buttons button : toBeAddedButtons) {
			switch (button) {
				case POWERON:
					PowerOn = new JButton("Aan");
					this.add(PowerOn);
				break;
				case POWEROFF:
					PowerOff = new JButton("Uit");
					this.add(PowerOff);
				break;
				case SETCHANNEL:
					ChannelMinOne = new JButton("-");
					this.add(ChannelMinOne);
					
					ChannelPlusOne = new JButton("+");
					this.add(ChannelPlusOne);
				break;
				case LAMPONEON:
					LampOneOn = new JButton("Lamp 1 staat aan");
					this.add(LampOneOn);
				break;
				case LAMPONEOFF:
					LampOneOff = new JButton("Lamp 1 staat uit");
					this.add(LampOneOff);
				break;
				case LAMPTWOON:
					LampTwoOn = new JButton("Lamp 2 staat aan");
					this.add(LampTwoOn);
				break;
				case LAMPTWOOFF:
					LampTwoOff= new JButton("Lamp 2 staat uit");
					this.add(LampTwoOff);
				break;
			}
		}
	}
	
	private void addTextFieldsToView(){
		for (TextFields textfield : toBeAddedTextFields) {
			switch (textfield) {
				case CHANGECHANNELALERT: 
					alertChannelStatus = new JTextArea(this.textFieldRows, this.textFieldColums);
					alertChannelStatus.setEditable(false);
					this.add(alertChannelStatus);
				break;
				case DEVICEPOWERALERT:
					alertDeviceStatus = new JTextArea(this.textFieldRows, this.textFieldColums);
					alertDeviceStatus.setEditable(false);
					this.add(alertDeviceStatus);
				break;
				case LAMPPOWER:
					alertDeviceStatus = new JTextArea(this.textFieldRows, this.textFieldColums);
					alertDeviceStatus.setEditable(false);
					this.add(alertDeviceStatus);
				break;
			}
		}
	}
	
	private void determineSize(Size size) {
		switch(size) {
		case SMALL:
			this.windowSizeX = (int) this.screenSize.width/5;
			this.windowSizeY = (int) this.screenSize.height/4;
			break;
		case MEDIUM: 
			this.windowSizeX = (int) this.screenSize.width/3;
			this.windowSizeY = (int) this.screenSize.height/4;
			break;
		case LARGE: 
			this.windowSizeX = (int) this.screenSize.width/2;
			this.windowSizeY = (int) this.screenSize.height/2;
			break;
		}
	}
	
	private void determinePosition(Position position) {
		switch(position) {
		case LEFTBOTTOM:
			this.windowPositionX = this.screenSize.width - this.screenSize.width;
			this.windowPositionY = (int) this.screenSize.height - this.windowSizeY;
			break;
		case RIGHTBOTTOM: 
			this.windowPositionX = this.screenSize.width - this.windowSizeX;
			this.windowPositionY = (int) this.screenSize.height - this.windowSizeY;
			break;
		case RIGHTTOP: 
			this.windowPositionX = this.screenSize.width - this.windowSizeX;
			this.windowPositionY = 0;
			break;
		}
	}
	
	private void determineTextFieldSize(){
		this.textFieldColums = this.windowSizeX;
		this.textFieldRows = 15;
	}
	
	public void addButton(Buttons button) {
		toBeAddedButtons.add(button);
	}
	
	public void addTextField(TextFields textField){
		toBeAddedTextFields.add(textField);
	}
	
	public JButton getChannelPlusOne() {
		return ChannelPlusOne;
	}

	public JButton getChannelMinOne() {
		return ChannelMinOne;
	}

	public JButton getPowerOn() {
		return PowerOn;
	}

	public JButton getPowerOff() {
		return PowerOff;
	}

	public JTextArea getAlertDeviceStatus() {
		return alertDeviceStatus;
	}

	public JTextArea getAlertChannelStatus() {
		return alertChannelStatus;
	}

	public JButton getLampOneOn() {
		return LampOneOn;
	}

	public JButton getLampOneOff() {
		return LampOneOff;
	}

	public JButton getLampTwoOn() {
		return LampTwoOn;
	}

	public JButton getLampTwoOff() {
		return LampTwoOff;
	}
}
