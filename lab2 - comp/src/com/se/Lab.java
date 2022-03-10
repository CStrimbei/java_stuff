package com.se;

/**
 * The Lab class, which inherits the Room class, and describes a Laboratory.
 */
public class Lab extends Room {
    /**
     *
     * @param CAP This is the capacity of the Laboratory.
     * @param NAME This is the name of the Laboratory.
     * @param OS This tells you what OS the computers in the Lecture Hall have.
     */
    public Lab(int CAP, String NAME, OSType OS){
        this.name=NAME;
        this.cap=CAP;
        this.type="Laboratory";
        this.os = OS;
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
     * @return Prints an instance of the Lab class.
     */

    @Override
    public String toString() {
        return name + '(' +
                "cap=" + cap +
                ", name='" + name + '\'' +
                ", type=" + type + " os=" + os +
                ')';
    }
}
