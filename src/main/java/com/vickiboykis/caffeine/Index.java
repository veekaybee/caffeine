package com.vickiboykis.caffeine;

public class Index {
    private String title;
    private String text;
    private boolean done;

    public Index(String title, String text, boolean done) {
        this.title = title;
        this.text = text;
        this.done = done;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
