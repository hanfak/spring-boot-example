package com.hanfak.entrypoints.controllers.dto;

public class ObjectDto {
    private final boolean hasBoolean;
    private final boolean isEven;
    private final String someString;

    public ObjectDto(boolean hasBoolean, boolean isEven, String someString) {
        this.hasBoolean = hasBoolean;
        this.isEven = isEven;
        this.someString = someString;
    }

    public boolean getHasBoolean() {
        return hasBoolean;
    }

    public boolean getEven() {
        return isEven;
    }

    public String getSomeString() {
        return someString;
    }
}
