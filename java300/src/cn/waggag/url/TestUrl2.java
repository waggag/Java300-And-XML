package cn.waggag.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * ��ȡ��Դ,Դ����
 * @author waggag
 * 2018��4��20�� ����12:46:17
 */
public class TestUrl2 {
	
	public static void main(String[] args) throws IOException {
		//��ҳĬ����Դ
		URL url = new URL("http://www.baidu.com");
		//��ȡ��Դ, ������
		/*InputStream is = url.openStream();
		byte[] flush = new byte[1024];
		int len = 0;
		while((len = is.read(flush)) != -1)
		{
			System.out.println(new String(flush, 0, len));
		}
		is.close();*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html")));
		
		String msg = null;
		while((msg = br.readLine()) != null)
		{
			System.out.println(msg);
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();	
		
	}
}
