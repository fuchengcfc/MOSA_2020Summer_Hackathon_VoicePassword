import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.fingerprint.FingerprintSimilarityComputer;

public class Comparer {
	
	public static byte[] readAudioFileData(final String filePath) {
	    byte[] data = null;
	    try {
	        final ByteArrayOutputStream baout = new ByteArrayOutputStream();
	        final File file = new File(filePath);
	        final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

	        byte[] buffer = new byte[4096];
	        int c;
	        while ((c = audioInputStream.read(buffer, 0, buffer.length)) != -1) {
	            baout.write(buffer, 0, c);
	        }
	        audioInputStream.close();
	        baout.close();
	        data = baout.toByteArray();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return data;
	}
	
	
	public static boolean compareTwoFile(String fileName1, String fileName2 ) {
		
		byte[] firstAudio = readAudioFileData(fileName1);
		byte[] secondAudio = readAudioFileData(fileName2);

		FingerprintSimilarityComputer fingerprint = 
		            new FingerprintSimilarityComputer(firstAudio, secondAudio);

		FingerprintSimilarity fingerprintSimilarity = fingerprint.getFingerprintsSimilarity();
		float score = fingerprintSimilarity.getScore();
		
		if (score > 0.8) {
			return true;
		}
		else {
			return false;
		}

		
	}
	
	

}
