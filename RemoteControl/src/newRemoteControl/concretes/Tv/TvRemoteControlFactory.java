package newRemoteControl.concretes.Tv;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextArea;

import newRemoteControl.Controllers.RadioRemoteControlListeners;
import newRemoteControl.Controllers.TvRemoteControlListeners;
import newRemoteControl.abstracts.ARemoteControl;
import newRemoteControl.abstracts.aRemoteControlFactory;
import newRemoteControl.interfaces.ITv;
import newRemoteControl.View.*;

public class TvRemoteControlFactory extends aRemoteControlFactory{

	private JButton TvPlusOne, TvMinOne, TvOn, TvOff;
	private JTextArea alertDeviceStatus, alertChannelStatus;
	
	@Override
	public FrameView createRemoteControl() {
		ITv iTv = new TvTypeOne();
		
		remoteControl = new TvRemoteControl(iTv);
		remoteControl = ((TvRemoteControl) remoteControl);
		
		remoteControl.setWindowSize(FrameView.Size.MEDIUM);
		remoteControl.setWindowPosition(FrameView.Position.RIGHTTOP);
		remoteControl.setWindowBackground(Color.BLACK);

		FrameView frameView = new FrameView(remoteControl);
		
		frameView.addButton(FrameView.Buttons.POWERON);
		frameView.addButton(FrameView.Buttons.POWEROFF);
		frameView.addButton(FrameView.Buttons.SETCHANNEL);
		
		frameView.addTextField(FrameView.TextFields.DEVICEPOWERALERT);
		frameView.addTextField(FrameView.TextFields.CHANGECHANNELALERT);
		
		frameView.buildView();
		
		new TvRemoteControlListeners(frameView, this, iTv);
		
		return frameView;
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
