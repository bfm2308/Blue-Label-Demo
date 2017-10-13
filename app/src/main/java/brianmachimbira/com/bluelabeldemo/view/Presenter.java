package brianmachimbira.com.bluelabeldemo.view;

import brianmachimbira.com.bluelabeldemo.network.AuthCallback;
import brianmachimbira.com.bluelabeldemo.network.AuthResource;
import brianmachimbira.com.bluelabeldemo.network.NetworkClient;

class Presenter{

    private final AuthResource authResource;
    private final NetworkClient client;
    private final MainActivity view;

    Presenter(MainActivity view, AuthResource authResource, NetworkClient client){
        this.view = view;
        this.authResource = authResource;
        this.client = client;
    }

    void authenticate() {
        authResource.attemptAuthentication(client, new AuthCallback<String>() {
            @Override
            public void authResult(String request, String response) {
                view.setRequestText(request);
                view.setResponseText(response);
            }
        });
    }


}
