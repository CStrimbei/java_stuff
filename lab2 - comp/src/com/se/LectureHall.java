package com.se;

public class LectureHall extends Room{
    public LectureHall(int CAP, String NAME, int PROJECTOR){
        this.name=NAME;
        this.cap=CAP;
        this.type="Lecture Hall";
        this.projector=PROJECTOR;
    }
    public int getCap() {
        return cap;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {

        if(projector==1)
            return name + '(' +
                    "cap=" + cap +
                    ", name='" + name + '\'' +
                    ", type=" + type + " and has a projector"+
                    ')';
        return name + '(' +
                "cap=" + cap +
                ", name='" + name + '\'' +
                ", type=" + type + " and doesn't have a projector" +
                ')';
    }

}
