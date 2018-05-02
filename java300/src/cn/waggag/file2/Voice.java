package cn.waggag.file2;

public class Voice {
	private int voice=10;
	public Voice() {
	}
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
	/**
	 * @param voice
	 */
	public Voice(int voice) {
		super();
		this.voice = voice;
	}
	
	public void say() {
		System.out.println(voice);
	}
	
	
}
