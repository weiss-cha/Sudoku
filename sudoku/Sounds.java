package sudoku;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public enum Sounds {
	CORRECT("correct-sound.wav"), // correct sound effect
	WRONG("wrong-sound.wav"), // wrong sound effect
	BGM1("Guitar-Gentle.wav"); // Background Music
	
	public static enum Volume {
		MUTE, LOW, MEDIUM, HIGH
	}

	public static Volume volume = Volume.LOW;

	private Clip clip;

	Sounds(String soundFileName) {
		try {
			// Open an audio input stream.
			URL url = this.getClass().getClassLoader().getResource(soundFileName);
			// Set up an audio input stream piped from the sound file.
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			// Get a clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void play() {
		if (volume != Volume.MUTE) {
			if (clip.isRunning()) {
				clip.stop(); // Stop the player if it is still playing
				clip.setFramePosition(0); // rewind to the beginning
				clip.start(); // Start playing
			}
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	static void init() {
		values(); // calls the constructor for all the elements
	}
}