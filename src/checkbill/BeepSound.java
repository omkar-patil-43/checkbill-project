/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbill;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import java.net.URL;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BeepSound {

	public void playBeep() {
		System.out.println("playing beep..");
		Toolkit tk = Toolkit.getDefaultToolkit();
		tk.beep();
	}

	public void playAudio() {
		System.out.println("playing audio..");
		try {
			URL url = new URL("file:C:/temp/beep-5.wav");
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void playClip() {
		System.out.println("playing clip..");
		try {
			URL url = new URL("file:C:/Users/admin/Desktop/checkbill/src/checkbill/sound/bell.wav");
			Clip clip = AudioSystem.getClip();
			//getAudioInputStream() can also accepts a File or InputStream
			AudioInputStream ais = AudioSystem.getAudioInputStream(url);
			clip.open(ais);
			//clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void playMidi() {
		System.out.println("playing midi..");
		try {
			URL url = new URL("file:C:/temp/song.midi");
			Sequence sequence = MidiSystem.getSequence(url);
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		BeepSound ps = new BeepSound();
		ps.playBeep();
		ps.playAudio();
		ps.playClip();
		//ps.playMidi();

	}

}
