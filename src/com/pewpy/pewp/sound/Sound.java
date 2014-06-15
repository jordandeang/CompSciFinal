package com.pewpy.pewp.sound;

import java.applet.AudioClip;
import java.net.URL;

import javax.swing.JApplet;



public class Sound extends JApplet {
	public static AudioClip snd; // creates AudioClip

	
	public Sound(int a) {
		if (a == 1) {
			URL url = getClass().getResource("/sounds/battlemusic.wav"); // creates a url
																// that
																// is the path
																// of
																// the soundfile
			snd = this.newAudioClip(url); // sets AudioClip equal to the url
			snd.play(); // plays AudioClip
		}
	}
}
