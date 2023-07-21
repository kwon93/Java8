package me.kwon.optional;

import java.util.Optional;

public class OnlineClass2 {
    private Integer id;
    private String title;
    private boolean closed;

    public Progress progress;

    public OnlineClass2(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress); //null값을 발생시킬 수 있는 상황에서 Optional로 감싼다.
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
