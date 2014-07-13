import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class MyOutPut extends Thread   //輸出Server要廣播的訊息給Client
{
	Socket client;
	String str;
	public MyOutPut(Socket client , String str)
	{
		this.client = client;
		this.str = str ;
	}
	@Override
	public void run() 
	{
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
			out.println(str);
			out.flush();
			System.out.println("MyOutPut is down");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.run();
	}
}
