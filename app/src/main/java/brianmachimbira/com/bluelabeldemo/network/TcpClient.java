package brianmachimbira.com.bluelabeldemo.network;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    private String TAG = "TcpClient";

    private String SERVER_IP;
    private int SERVER_PORT;
    private String mServerMessage;
    private OnMessageReceived mMessageListener = null;
    private boolean mRun = false;
    private PrintWriter mBufferOut;
    private BufferedReader mBufferIn;

    TcpClient(String path, int port, OnMessageReceived listener) {
        mMessageListener = listener;
        this.SERVER_IP = path;
        this.SERVER_PORT = port;
    }


    void sendMessage(String message) {
        if (mBufferOut != null && !mBufferOut.checkError()) {
            mBufferOut.println(message);
            mBufferOut.flush();
        }
    }

    public void stopClient() {

        mRun = false;

        if (mBufferOut != null) {
            mBufferOut.flush();
            mBufferOut.close();
        }

        mMessageListener = null;
        mBufferIn = null;
        mBufferOut = null;
        mServerMessage = null;
    }

    void run() {

        mRun = true;

        try {
            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);

            try (Socket socket = new Socket(serverAddr, SERVER_PORT)) {
                mBufferOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                mBufferIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (mRun) {
                    mServerMessage = mBufferIn.readLine();
                    if (mServerMessage != null && mMessageListener != null) {
                        mMessageListener.messageReceived(mServerMessage);
                    }
                }
            } catch (Exception e) {
                Log.e(TAG,  e.getLocalizedMessage());
            }

        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
        }

    }
}
