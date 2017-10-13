package brianmachimbira.com.bluelabeldemo.network;

import android.os.AsyncTask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import brianmachimbira.com.bluelabeldemo.model.request;

public class NetworkClient extends AsyncTask<String, String, TcpClient> implements OnMessageReceived{
    private final String path;
    private final int port;
    private final request model;
    private String xmlSent;
    private AuthCallback<String> authCallback;
    private TcpClient mTcpClient;

    public NetworkClient(String path, int port, request model) {
        this.path = path;
        this.port = port;
        this.model = model;
    }

    void sendMessage(AuthCallback<String> callback) {
        this.authCallback = callback;
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlSent = xmlMapper.writeValueAsString(model);
            mTcpClient.sendMessage(xmlSent);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected TcpClient doInBackground(String... arg0) {
        mTcpClient = new TcpClient(path, port, new OnMessageReceived() {
            @Override
            public void messageReceived(String message) {
                publishProgress(message);
            }
        });
        mTcpClient.run();
        return null;

    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        messageReceived(values[0]);
    }

    @Override
    public void messageReceived(String message) {
        authCallback.authResult(xmlSent, message);
    }


}