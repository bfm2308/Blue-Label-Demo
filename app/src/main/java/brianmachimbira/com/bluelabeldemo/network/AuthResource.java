package brianmachimbira.com.bluelabeldemo.network;


public class AuthResource{

    public void attemptAuthentication(final NetworkClient client, final AuthCallback<String> authCallback){
        new Thread() {
            @Override
            public void run() {
                client.execute();
                client.sendMessage(authCallback);
            }
        }.start();

    }
}
