package com.winterwell.jgeoplanet;

public enum LengthUnit {
    METRE(1.0d),
    KILOMETRE(1000.0d),
    MILE(1609.344d);
    
    public final Dx Dx;
    public final double metres;

    private LengthUnit(double d) {
        this.metres = d;
        this.Dx = new Dx(1.0d, this);
    }

    @Deprecated
    public final double convert(double d, LengthUnit lengthUnit) {
        return new Dx(d, lengthUnit).convertTo(this).getValue();
    }

    public final Dx getDx() {
        return this.Dx;
    }

    public final double getMetres() {
        return this.metres;
    }
}
