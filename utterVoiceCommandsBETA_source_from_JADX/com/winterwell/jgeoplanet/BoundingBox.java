package com.winterwell.jgeoplanet;

import winterwell.json.JSONObject;

public class BoundingBox {
    final Location northEast;
    final Location southWest;

    public BoundingBox(Location location, Dx dx) {
        double metres = dx.getMetres();
        this.northEast = location.move(metres, metres);
        this.southWest = location.move(-metres, -metres);
    }

    public BoundingBox(Location location, Location location2) {
        if (location.latitude < location2.latitude) {
            throw new IllegalArgumentException("North east corner is south of south west corner");
        }
        this.northEast = location;
        this.southWest = location2;
    }

    BoundingBox(JSONObject jSONObject) {
        this(getLocation(jSONObject.getJSONObject("northEast")), getLocation(jSONObject.getJSONObject("southWest")));
    }

    static Location getLocation(JSONObject jSONObject) {
        return new Location(jSONObject.getDouble("latitude"), jSONObject.getDouble("longitude"));
    }

    public boolean contains(BoundingBox boundingBox) {
        return contains(boundingBox.southWest) && contains(boundingBox.northEast);
    }

    public boolean contains(Location location) {
        if (location.latitude > this.northEast.latitude || location.latitude < this.southWest.latitude) {
            return false;
        }
        if (this.northEast.longitude >= 0.0d || this.southWest.longitude < 0.0d || this.southWest.longitude <= this.northEast.longitude) {
            if (location.longitude > this.northEast.longitude) {
                return false;
            }
            if (location.longitude < this.southWest.longitude) {
                return false;
            }
        } else if (location.longitude < 0.0d && location.longitude > this.northEast.longitude) {
            return false;
        } else {
            if (location.longitude >= 0.0d && location.longitude < this.southWest.longitude) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BoundingBox boundingBox = (BoundingBox) obj;
        if (this.northEast == null) {
            if (boundingBox.northEast != null) {
                return false;
            }
        } else if (!this.northEast.equals(boundingBox.northEast)) {
            return false;
        }
        return this.southWest == null ? boundingBox.southWest == null : this.southWest.equals(boundingBox.southWest);
    }

    public Location getCenter() {
        Location location = this.northEast;
        Location location2 = this.southWest;
        double d = (location.latitude + location2.latitude) / 2.0d;
        if (Math.abs(location.latitude - location2.latitude) > 90.0d) {
            d = d <= 0.0d ? d + 90.0d : d - 90.0d;
        }
        double d2 = (location.longitude + location2.longitude) / 2.0d;
        if (Math.abs(location.longitude - location2.longitude) > 180.0d) {
            d2 = d2 <= 0.0d ? d2 + 180.0d : d2 - 180.0d;
        }
        return new Location(d, d2);
    }

    public Location getNorthEast() {
        return this.northEast;
    }

    public Location getNorthWest() {
        return new Location(this.northEast.latitude, this.southWest.longitude);
    }

    public Location getSouthEast() {
        return new Location(this.southWest.latitude, this.northEast.longitude);
    }

    public Location getSouthWest() {
        return this.southWest;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.northEast == null ? 0 : this.northEast.hashCode()) + 31) * 31;
        if (this.southWest != null) {
            i = this.southWest.hashCode();
        }
        return hashCode + i;
    }

    public boolean intersects(BoundingBox boundingBox) {
        return contains(boundingBox.northEast) || contains(boundingBox.southWest) || contains(boundingBox.getNorthWest()) || contains(boundingBox.getSouthEast());
    }

    public String toString() {
        return "BoundingBox [northEast=" + this.northEast + ", southWest=" + this.southWest + "]";
    }
}
