package gfour.zucc.com.wanglema.model;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/5/28.
 */

public class BeanTime {

    private int eventId;
    private Calendar warn;

    @Override
    public String toString() {
        return "BeanTime{" +
                "eventId=" + eventId +
                ", warn=" + warn +
                '}';
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Calendar getWarn() {
        return warn;
    }

    public void setWarn(Calendar warn) {
        this.warn = warn;
    }
}
