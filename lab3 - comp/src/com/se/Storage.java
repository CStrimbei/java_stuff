package com.se;

import java.util.Objects;

/**
 * The Storage interface.
 */

public interface Storage {
    /**
     * The default function for getting the storage capacity.
     * @param CAP The object's capacity.
     * @param TYPE The memory type in which we want to convert it.
     * @return Returns a String, containing the capacity.
     */
    default String getStorageCapacity(double CAP, String TYPE) {
        if(Objects.equals(TYPE, "M"))
            return "Storage capacity in MB: " + (CAP * 1000 + CAP*24);
        if(Objects.equals(TYPE, "K"))
            return "Storage capacity in KB: " + (CAP * 1000000 + CAP*48576);
        if(Objects.equals(TYPE, "B"))
            return "Storage capacity in BYTES: " + (CAP * 1000000000 + CAP * 73741824);
        return "No type was specified!";
    }
}
