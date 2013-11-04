package newRemoteControl.concretes.Tv;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextArea;

import newRemoteControl.Controllers.TvRemoteControlListeners;
import newRemoteControl.abstracts.ARemoteControl;
import newRemoteControl.abstracts.aRemoteControlFactory;
import newRemoteControl.interfaces.ITv;

public class TvRemoteControlFactory extends aRemoteControlFactory{

	private JButton TvPlusOne, TvMinOne, TvOn, TvOff;
	private JTextArea alertDeviceStatus, alertChannelStatus;
	
	@Override
	public ARemoteControl createRemoteControl() {
		ITv iTv = new TvTypeOne();
		
		remoteControl = new TvRemoteControl(iTv);
		remoteControl = ((TvRemoteControl) remoteControl);
		
		remoteControl.setWindowTitle("Tv Remote");
		remoteControl.setWindowSize(400, 200);
		remoteControl.setWindowPosition(800, 250);
		remoteControl.setWindowBackground(Color.GREEN);
		
		remoteControl.setRemoteWindow();
		
		alertDeviceStatus = new JTextArea(15, remoteControl.getWindowSizeX());
		alertDeviceStatus.setEditable(false);
		
		alertChannelStatus = new JTextArea(15, remoteControl.getWindowSizeX());
		alertChannelStatus.setEditable(false);
		
		TvPlusOne = new JButton("+");
		TvMinOne = new JButton("-");
		TvOn = new JButton("Aan");
		TvOff = new JButton("Uit");
		
		remoteControl.addTextArea(alertDeviceStatus);
		remoteControl.addTextArea(alertChannelStatus);
		
		remoteControl.addButton(TvPlusOne);
		remoteControl.addButton(TvMinOne);
		remoteControl.addButton(TvOn);
		remoteControl.addButton(TvOff);

		new TvRemoteControlListeners(this);

		return remoteControl;
	}
	
	public JTextArea getAlertDeviceStatus() {
		return alertDeviceStatus;
	}
	
	public JTextArea getAlertChannelStatus() {
		return alertChannelStatus;
	}
	
	public JButton getTvPlusOne() {
		return TvPlusOne;
	}
	
	public JButton getTvMinOne() {
		return TvMinOne;
	}
	
	public JButton getTvOn() {
		return TvOn;
	}
	
	public JButton getTvOff() {
		return TvOff;
	}
}
