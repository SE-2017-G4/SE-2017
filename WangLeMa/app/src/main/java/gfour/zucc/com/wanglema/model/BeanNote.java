package gfour.zucc.com.wanglema.model;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/5/28.
 */

public class BeanNote {

    private int noteId;
    private String noteContext;
    private Calendar noteDeleteDate;
    private String notePwd;

    @Override
    public String toString() {
        return "BeanNote{" +
                "noteId=" + noteId +
                ", noteContext='" + noteContext + '\'' +
                ", noteDeleteDate=" + noteDeleteDate +
                ", notePwd='" + notePwd + '\'' +
                '}';
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNoteContext() {
        return noteContext;
    }

    public void setNoteContext(String noteContext) {
        this.noteContext = noteContext;
    }

    public Calendar getNoteDeleteDate() {
        return noteDeleteDate;
    }

    public void setNoteDeleteDate(Calendar noteDeleteDate) {
        this.noteDeleteDate = noteDeleteDate;
    }

    public String getNotePwd() {
        return notePwd;
    }

    public void setNotePwd(String notePwd) {
        this.notePwd = notePwd;
    }
}
