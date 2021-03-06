package newRemoteControl;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import newRemoteControl.concretes.Lamp.LampRemoteControlFactory;
import newRemoteControl.concretes.Radio.RadioRemoteControlFactory;
import newRemoteControl.concretes.Tv.TvRemoteControlFactory;
import newRemoteControl.interfaces.iRemoteControlFactory;
import newRemoteControl.View.FrameView;

public class Main {

	private static JButton btnRadioRemote, btnTvRemote, btnLampRemote;
	private static JFrame tvRemoteWindow, radioRemoteWindow, lampRemoteWindow;
	private enum RemoteState {SHOW, CLOSED};
	
	private static RemoteState tvWindow = RemoteState.CLOSED, radioWindow = RemoteState.CLOSED, lampWindow = RemoteState.CLOSED;
	
	public static void main(String[] args) {
		buildMain();
	}
	
	public static void buildMain() {
		JFrame frame = new JFrame("Main Menu");
		frame.setLocation(0, 0);
		frame.setSize(300, 250);
		frame.getContentPane().setBackground(Color.BLACK);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2,2));
		
		btnRadioRemote = new JButton("Open radio remote");
		btnTvRemote = new JButton("Open tv remote");
		btnLampRemote = new JButton("Open lamp remote");
		
		btnRadioRemote.addActionListener(buttonListener());
		btnTvRemote.addActionListener(buttonListener());
		btnLampRemote.addActionListener(buttonListener());
		
		frame.add(btnRadioRemote);
		frame.add(btnTvRemote);
		frame.add(btnLampRemote);
		
		frame.setVisible(true);	
	}
	
	public static JFrame buildRemote(iRemoteControlFactory factory) { 
		FrameView remote = factory.createRemoteControl();

		remote.addWindowListener(windowListener());
		
		return remote;
	}
	
	public static ActionListener buttonListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((e.getSource() == btnTvRemote) && (tvWindow.equals(RemoteState.CLOSED))) {
					tvRemoteWindow = buildRemote(new TvRemoteControlFactory());
					tvWindow = RemoteState.SHOW;
				}
				
				if ((e.getSource() == btnRadioRemote  && (radioWindow.equals(RemoteState.CLOSED)))) {
					radioRemoteWindow = buildRemote(new RadioRemoteControlFactory());

					radioWindow = RemoteState.SHOW;
				}
				
				if ((e.getSource() == btnLampRemote && (lampWindow.equals(RemoteState.CLOSED)))) {
					lampRemoteWindow = buildRemote(new LampRemoteControlFactory());
					lampWindow = RemoteState.SHOW;
				}
			}
		};
	}
	
	public static WindowListener windowListener() {
		return new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource().equals(tvRemoteWindow))
					tvWindow = RemoteState.CLOSED;
				
				if (e.getSource().equals(radioRemoteWindow))
					radioWindow = RemoteState.CLOSED;
				
				if (e.getSource().equals(lampRemoteWindow))
					lampWindow = RemoteState.CLOSED;
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
