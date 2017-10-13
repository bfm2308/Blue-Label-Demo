package brianmachimbira.com.bluelabeldemo.view;

import brianmachimbira.com.bluelabeldemo.BuildConfig;
import brianmachimbira.com.bluelabeldemo.model.request;
import brianmachimbira.com.bluelabeldemo.network.AuthResource;
import brianmachimbira.com.bluelabeldemo.network.NetworkClient;

class PresenterFactory {
    static Presenter create(MainActivity view, request model) {
        AuthResource resource = new AuthResource();
        NetworkClient client = new NetworkClient(BuildConfig.BASE_URL, Integer.valueOf(BuildConfig.PORT), model);
        return new Presenter(view, resource, client);
    }
}
