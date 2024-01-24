package cn;

import javax.swing.*;

import com.github.sarxos.webcam.Webcam;

//import com.github.sarxos.webcam.Webcam;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.*;
import java.rmi.server.*;
import java.io.*;
public class client {
	static Socket socket;

	public static void main(String[] args) throws UnknownHostException,IOException, InterruptedException{
		// TODO Auto-generated method stub
		Webcam web= Webcam.getDefault();
		web.open();
		socket=new Socket("localhost",123);
		BufferedImage bm=web.getImage();
		ObjectOutputStream dout=new ObjectOutputStream(socket.getOutputStream());
		ImageIcon im=new ImageIcon(bm);
		JFrame fr=new JFrame("PC 1");
		fr.setSize(640, 360);
		fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
		JLabel l=new JLabel();
		l.setVisible(true);
		fr.add(l);
		fr.setVisible(true);
		while(true) {
		bm=web.getImage();
		im=new ImageIcon(bm);
		dout.writeObject(im);
		l.setIcon(im);
		dout.flush();
		}

	}

}

