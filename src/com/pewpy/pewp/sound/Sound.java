package com.pewpy.pewp.sound;

import java.applet.AudioClip;
import java.net.URL;

import javax.swing.JApplet;

public class Sound extends JApplet {
	public static AudioClip snd;
	public static AudioClip snd2;// creates AudioClip

	public Sound() {
		URL url = getClass().getResource("/sounds/battlemusic.wav"); // creates
																		// a url
		// that
		// is the path
		// of
		// the soundfile
		snd = this.newAudioClip(url); // sets AudioClip equal to the url
		// plays AudioClip

		url = getClass().getResource("/sounds/theway.wav"); // creates a url
															// that
															// is the path
															// of
															// the soundfile
		snd2 = this.newAudioClip(url); // sets AudioClip equal to the url
		// plays AudioClip
	}
}
