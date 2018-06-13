package com.winterwell.jgeoplanet;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Location implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Location.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final double DIAMETER_OF_EARTH = 1.27562E7d;
    public static final Pattern latLongLocn = Pattern.compile("\\s*(-?[\\d\\.]+),\\s*(-?[\\d\\.]+)\\s*");
    private static final long serialVersionUID = 1;
    public final double latitude;
    public final double longitude;

    public Location(double d, double d2) {
        if (d < -90.0d || d > 90.0d) {
            throw new IllegalArgumentException("Invalid latitude: " + d + ", " + d2);
        }
        double d3;
        if (d2 < -180.0d || d2 > 180.0d) {
            d3 = d2 % 360.0d;
            if (d3 > 180.0d) {
                d3 = 360.0d - d3;
            }
            if (!$assertionsDisabled && d3 < -180.0d && d3 > 180.0d) {
                throw new AssertionError(d3);
            }
        }
        d3 = d2;
        this.latitude = d;
        this.longitude = d3;
    }

    public static Location parse(String str) {
        Matcher matcher = latLongLocn.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        return new Location(Double.valueOf(matcher.group(1)).doubleValue(), Double.valueOf(matcher.group(2)).doubleValue());
    }

    public Dx distance(Location location) {
        double d = (this.latitude * 3.141592653589793d) / 180.0d;
        double d2 = (this.longitude * 3.141592653589793d) / 180.0d;
        double d3 = (location.latitude * 3.141592653589793d) / 180.0d;
        double d4 = (location.longitude * 3.141592653589793d) / 180.0d;
        double sin = Math.sin((d - d3) / 2.0d);
        sin *= sin;
        d2 = Math.sin((d2 - d4) / 2.0d);
        return new Dx(Math.asin(Math.sqrt(((Math.cos(d) * Math.cos(d3)) * (d2 * d2)) + sin)) * DIAMETER_OF_EARTH, LengthUnit.METRE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return $assertionsDisabled;
        }
        if (getClass() != obj.getClass()) {
            return $assertionsDisabled;
        }
        Location location = (Location) obj;
        return Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(location.latitude) ? $assertionsDisabled : Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(location.longitude) ? $assertionsDisabled : true;
    }

    public double[] getLatLong() {
        return new double[]{this.latitude, this.longitude};
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public Location move(double d, double d2) {
        double d3 = ((d / 2.003739210386106E10d) * 180.0d) + this.latitude;
        if (d3 > 90.0d) {
            d3 = 90.0d;
        } else if (d3 < -90.0d) {
            d3 = -90.0d;
        }
        double d4 = this.longitude + d2;
        while (d4 > 180.0d) {
            d4 -= 360.0d;
        }
        while (d4 < -180.0d) {
            d4 += 360.0d;
        }
        return new Location(d3, d4);
    }

    public String toSimpleCoords() {
        return this.latitude + "," + this.longitude;
    }

    public String toString() {
        return "(" + this.latitude + " N, " + this.longitude + " E)";
    }
}
