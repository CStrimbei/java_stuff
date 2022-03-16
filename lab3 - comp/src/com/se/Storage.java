package com.se;

import java.util.Objects;

public interface Storage {
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
