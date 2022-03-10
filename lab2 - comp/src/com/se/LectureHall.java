package com.se;

/**
 * The LectureHall class, that inherits the Room class, and describes a Lecture Hall.
 */

public class LectureHall extends Room{
    /**
     * This is a constructor for the LectureHall class.
     * @param CAP This is the capacity of the Lecture Hall.
     * @param NAME This is the name of the Lecture Hall.
     * @param PROJECTOR This tells you if the Lecture Hall is equipped with a Projector.
     */
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


    /**
     * The new, overwritten toString method.
     * @return Prints an instance of the LectureHall class.
     */
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
