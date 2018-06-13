package com.winterwell.jgeoplanet;

public interface IPlace {
    public static final String TYPE_CITY = "city";
    public static final String TYPE_COUNTRY = "country";

    BoundingBox getBoundingBox();

    Location getCentroid();

    String getCountryName();

    String getName();

    String getType();

    String getUID();
}
