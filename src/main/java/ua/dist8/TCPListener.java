package ua.dist8;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPListener extends Thread{

    @Override
    /***
     * Constantly listens to TCP requests.
     * When there is an incoming request, it generates a new thread to handle it.
     */
    public void run() {
        System.out.println("Initializing TCP listener..." );
        try {
            //Initialize socket
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true){
                System.out.println("Listening on port 5000 ....");
                Socket clientSocket = serverSocket.accept();
                TCPHandlerThread tcpThreadHandler = new TCPHandlerThread(clientSocket);
                tcpThreadHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
