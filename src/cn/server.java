package cn;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class server {

	public static void main(String[] args) throws IOException,ClassNotFoundException{
		// TODO Auto-generated method stub
		ServerSocket server=new ServerSocket(123);
		System.out.println("waiting...");
		Socket socket=server.accept();
		System.out.println("Connected");
		ObjectInputStream in = new
		ObjectInputStream(socket.getInputStream());
		JLabel label=new JLabel();
		JFrame fr=new JFrame();
		fr.setSize(640,360);
		fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
		label=new JLabel();
		label.setSize(640,360);
		label.setVisible(true);
		
		while(true) {
		label.setIcon((ImageIcon)in.readObject());
		}

	}

}

