package cn.waggag.file2;

public class Amplifier {
	private Voice voice;
	
	public Amplifier() {
	}
	
	/**
	 * @param voice
	 */
	public Amplifier(Voice voice) {
		super();
		this.voice = voice;
	}

	public Voice getVoice() {
		return voice;
	}
	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
	public void say() {
		System.out.println(voice);
	}
	
}
