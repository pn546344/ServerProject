import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class MyServerSocket extends Thread {
	Socket client;
	String str="";
	public MyServerSocket(Socket client)
	{
		this.client=client;
	}
	@Override
	public void run() {
		System.out.println("Client is connect");
		System.out.println(client);
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				int i;
				String str;
				while((str=br.readLine())!=null)    //Ū������Ӧr���,�N�r��s��bstr�ܼƤ�
				{
					System.out.println(str);
					Server.strList.add(str);
					System.out.println("strList.size = "+Server.strList.size());
					Server.broadcastStr(str);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
