import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class Recorder {
	
	
	public static void record(String filename) {
		
		try {
		AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		
		final TargetDataLine targetLine = (TargetDataLine)AudioSystem.getLine(info);
		targetLine.open();
		targetLine.start();
		
		Thread thread = new Thread()
		{
			@Override public void run()
			{
				AudioInputStream audioStream = new AudioInputStream(targetLine);
				File audioFile = new File(filename);
				try {
					AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		};
		
		thread.start();
		Thread.sleep(3000);
		targetLine.stop();
		targetLine.close();
		
			
			
			
		} catch (LineUnavailableException e) {
			e.printStackTrace();

		} catch (InterruptedException e) {
			e.printStackTrace();

		}
		
		
		
		
		
		
		
	}
	
	

}
