package gfour.zucc.com.wanglema.model;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/5/28.
 */

public class BeanEvent {

    private int eventId;
    private int projectId;
    private String eventContext;
    private Calendar eventBegin;
    private Calendar eventEnd;
    private Calendar eventDeleteDate;
    private String eventVoiceSrc;
    private int eventLevel;
    private String eventImgSrc;
    private String eventPwd;
    private boolean eventIsSuccess;

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setEventContext(String eventContext) {
        this.eventContext = eventContext;
    }

    public void setEventBegin(Calendar eventBegin) {
        this.eventBegin = eventBegin;
    }

    public void setEventEnd(Calendar eventEnd) {
        this.eventEnd = eventEnd;
    }

    public void setEventDeleteDate(Calendar eventDeleteDate) {
        this.eventDeleteDate = eventDeleteDate;
    }

    public void setEventVoiceSrc(String eventVoiceSrc) {
        this.eventVoiceSrc = eventVoiceSrc;
    }

    public void setEventLevel(int eventLevel) {
        this.eventLevel = eventLevel;
    }

    public void setEventImgSrc(String eventImgSrc) {
        this.eventImgSrc = eventImgSrc;
    }

    public void setEventPwd(String eventPwd) {
        this.eventPwd = eventPwd;
    }

    public void setEventIsSuccess(boolean eventIsSuccess) {
        this.eventIsSuccess = eventIsSuccess;
    }

    public int getEventId() {

        return eventId;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getEventContext() {
        return eventContext;
    }

    public Calendar getEventBegin() {
        return eventBegin;
    }

    public Calendar getEventEnd() {
        return eventEnd;
    }

    public Calendar getEventDeleteDate() {
        return eventDeleteDate;
    }

    public String getEventVoiceSrc() {
        return eventVoiceSrc;
    }

    public int getEventLevel() {
        return eventLevel;
    }

    public String getEventImgSrc() {
        return eventImgSrc;
    }

    public String getEventPwd() {
        return eventPwd;
    }

    public boolean getEventIsSuccess() {
        return eventIsSuccess;
    }

    @Override
    public String toString() {
        return "BeanEvent{" +
                "eventId=" + eventId +
                ", projectId=" + projectId +
                ", eventContext='" + eventContext + '\'' +
                ", eventBegin=" + eventBegin +
                ", eventEnd=" + eventEnd +
                ", eventDeleteDate=" + eventDeleteDate +
                ", eventVoiceSrc='" + eventVoiceSrc + '\'' +
                ", eventLevel=" + eventLevel +
                ", eventImgSrc='" + eventImgSrc + '\'' +
                ", eventPwd='" + eventPwd + '\'' +
                ", eventIsSuccess=" + eventIsSuccess +
                '}';
    }
}
