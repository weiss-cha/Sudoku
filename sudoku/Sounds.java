package sudoku;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public class Sounds {
	Clip clip;
	float prevVolume = 0; // Previous volume
	float currVolume = 0; // Current Volume
	FloatControl fc;
	Boolean isMute = false;
	
	public Sounds(String soundFileName) {
		try {
			// Open an audio input stream.
			URL url = this.getClass().getClassLoader().getResource(soundFileName);
			// Set up an audio input stream piped from the sound file.
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			// Get a clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioInputStream);
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN); // Represents a control for the overall gain
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public void switchSong(String soundFileName) {
		stop();
		try {
			// Open an audio input stream.
			URL url = this.getClass().getClassLoader().getResource(soundFileName);
			// Set up an audio input stream piped from the sound file.
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			// Get a clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioInputStream);
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		loop();
	}
	
	public void play() {
		if(clip.isRunning()) {
			clip.stop();
			clip.setFramePosition(0);
			clip.start();
		}
		clip.setFramePosition(0);
		clip.start();
	}
	
	public void stop() {
		clip.stop();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void volumeMute() {
		if (isMute == true) {
			currVolume = prevVolume;
			fc.setValue(currVolume);
			isMute = false;
		} else if (isMute == false) {
			prevVolume = currVolume; // Save current volume value
			currVolume = -80.0f; // Minimal value possible for Float Control
			fc.setValue(currVolume);
			isMute = true;
		}
	}
	
	public void setVolume(float volume) {
		if (volume > 6.0f) {
			currVolume = 6.0f;
		} else if (volume < -80.0f) {
			currVolume = -80.0f; //lowest possible for Float Control
		} else {
			currVolume = volume;
		}
		fc.setValue(currVolume);
	}
}
