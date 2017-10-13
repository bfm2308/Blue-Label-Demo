package brianmachimbira.com.bluelabeldemo.model;


public class Event {
    public String UserPin;
    public String DeviceId;
    public String DeviceSer;
    public String DeviceVer;
    public String TransType;

    public Event(String userPin, String deviceId, String deviceSer, String deviceVer, String transType) {
        this.UserPin = userPin;
        this.DeviceId = deviceId;
        this.DeviceSer = deviceSer;
        this.DeviceVer = deviceVer;
        this.TransType = transType;
    }
}
