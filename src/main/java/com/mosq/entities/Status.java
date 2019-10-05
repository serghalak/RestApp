package com.mosq.entities;


public class Status {
    private Byte id;
    private String title;

    public Status() {
    }

    public Status(Byte id, String title) {
        this.id = id;
        this.title = title;
    }

    public Status(Byte id) {
        this.id = id;
    }


    public Status(Byte id, String title, Boolean byDefault) {
        this.id = id;
        this.title = title;
    }

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

}