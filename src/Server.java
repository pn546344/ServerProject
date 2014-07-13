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
		ServerSocket server;    //�ŧiserver
			try {
				server = new ServerSocket(1234);
				while(true)       //��server�i�H�h�H�P�ɳs�u
				{
					Socket client = server.accept();   //����client�s�u ,�ñN��T�s�bclient�ܼ�
					list.add(client);       //�N��ƥ[�J�w�s�u�M��
					(new MyServerSocket(client)).start();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public static synchronized void broadcastStr(String str) {
		
		for(int i=0;i<list.size();i++)   //��Ҧ����w�s�u���˸m�ǳƼs��
		{
			(new MyOutPut(list.get(i), str)).start();
		}
		Server.strList.removeFirst();
		
	}
}
