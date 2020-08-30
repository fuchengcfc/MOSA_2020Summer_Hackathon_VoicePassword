

import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.wave.Wave;

public class Comparer {
	
//	public static byte[] readAudioFileData(final String filePath) {
//	    byte[] data = null;
//	    try {
//	        final ByteArrayOutputStream baout = new ByteArrayOutputStream();
//	        final File file = new File(filePath);
//	        final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
//	        
//	        System.out.println(audioInputStream.getFrameLength());
//
//	        byte[] buffer = new byte[4096];
//	        int c;
//	        while ((c = audioInputStream.read(buffer, 0, buffer.length)) != -1) {
//	            baout.write(buffer, 0, c);
//	        }
//	        audioInputStream.close();
//	        baout.close();
//	        data = baout.toByteArray();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return data;
//	}
	
	
	public static boolean compareTwoFile(String fileName1, String fileName2 ) {
		
		
		Wave w1 = new Wave(fileName1);
		Wave w2 = new Wave(fileName2);
		

		FingerprintSimilarity fingerprint = w1.getFingerprintSimilarity(w2);

		float score = fingerprint.getScore();
		
		System.out.println(score);
		
		if (score > 0.1) {
			return true;
		}
		else {
			return false;
		}

		
	}
	
	

}
