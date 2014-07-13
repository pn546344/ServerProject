import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Server {
	static ArrayList<Socket> list = new ArrayList<Socket>();
	static LinkedList<String> strList = new LinkedList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket server;    //宣告server
			try {
				server = new ServerSocket(1234);
				while(true)       //讓server可以多人同時連線
				{
					Socket client = server.accept();   //等待client連線 ,並將資訊存在client變數
					list.add(client);       //將資料加入已連線清單
					(new MyServerSocket(client)).start();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public static synchronized void broadcastStr(String str) {
		
		for(int i=0;i<list.size();i++)   //把所有的已連線的裝置準備廣播
		{
			(new MyOutPut(list.get(i), str)).start();
		}
		Server.strList.removeFirst();
		
	}
}
