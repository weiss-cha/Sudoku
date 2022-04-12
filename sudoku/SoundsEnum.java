package sudoku;

public enum SoundsEnum {
	CORRECT, // correct sound effect
	WRONG, // wrong sound effect
	BGM1; // Background Music
	
	/*public static enum Volume {
		LOW, MEDIUM, HIGH
	}
	
	public static enum VolumeIsMute {
		MUTE, NOTMUTE
	}

	public static Volume volume = Volume.LOW;
	public static VolumeIsMute volumeIsMute = VolumeIsMute.NOTMUTE;

	private Clip clip;
	float currentVolume = 0, previousVolume = 0;
	FloatControl fc;
	
	SoundsEnum(String soundFileName) {
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

	public void play() {
		if (volumeIsMute == VolumeIsMute.MUTE) {
			if (clip.isRunning()) {
				clip.stop(); // Stop the player if it is still playing
			}
		} else if (volume == Volume.LOW) {
			if (clip.isRunning()) {
				clip.stop();
				clip.setFramePosition(0);
				clip.start();
			}
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	public void volumeMute() {
		if (volumeIsMute == VolumeIsMute.NOTMUTE) {
			previousVolume = currentVolume;
			currentVolume = 80.0f; //minimum value of FloatControl and also mute;
			fc.setValue(currentVolume);
			volumeIsMute = VolumeIsMute.MUTE;
		} else if (volumeIsMute == VolumeIsMute.MUTE) {
			currentVolume = previousVolume;
			fc.setValue(currentVolume);
			volumeIsMute = VolumeIsMute.NOTMUTE;
		}
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	static void init() {
		values(); // calls the constructor for all the elements
	}
	*/
}