package brianmachimbira.com.bluelabeldemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import brianmachimbira.com.bluelabeldemo.R;
import brianmachimbira.com.bluelabeldemo.model.Event;
import brianmachimbira.com.bluelabeldemo.model.request;

public class MainActivity extends AppCompatActivity {

    TextView requestTextView;
    TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestTextView = findViewById(R.id.request);
        responseTextView = findViewById(R.id.response);

        Event event = new Event(getString(R.string.pin), getString(R.string.device_id), getString(R.string.device_ser), getString(R.string.device_ver), getString(R.string.trans_type));
        request request = new request(getString(R.string.authentication), event);
        Presenter presenter = PresenterFactory.create(this, request);
        presenter.authenticate();
    }

    public void setRequestText(String request) {
        requestTextView.setText(String.format(getString(R.string.request_string), request));
    }

    public void setResponseText(String response) {
        responseTextView.setText(String.format(getString(R.string.response_string), response));
    }


}
