package com.gornostaeva.Router.entity;

public class ResponseEntity {

    private int from;
    private int to;
    private boolean direct;

    public ResponseEntity() {

    }

    public ResponseEntity(int from, int to, boolean direct) {
        super();
        this.from = from;
        this.to = to;
        this.direct = direct;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public boolean getDirect() {
        return direct;
    }

}
