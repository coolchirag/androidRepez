package com.winterwell.jgeoplanet;

public final class Dx implements Comparable<Dx> {
    static final /* synthetic */ boolean $assertionsDisabled = (!Dx.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final long serialVersionUID = 1;
    private final double f3050n;
    private final LengthUnit unit;

    public Dx(double d) {
        this(d, LengthUnit.METRE);
    }

    public Dx(double d, LengthUnit lengthUnit) {
        this.f3050n = d;
        this.unit = lengthUnit;
        if (!$assertionsDisabled && lengthUnit == null) {
            throw new AssertionError();
        }
    }

    public static Dx ZERO() {
        return new Dx(0.0d, LengthUnit.METRE);
    }

    public final int compareTo(Dx dx) {
        double metres = getMetres();
        double metres2 = dx.getMetres();
        return metres == metres2 ? 0 : metres < metres2 ? -1 : 1;
    }

    public final Dx convertTo(LengthUnit lengthUnit) {
        return new Dx(divide(lengthUnit.Dx), lengthUnit);
    }

    public final double divide(Dx dx) {
        return this.f3050n == 0.0d ? 0.0d : (this.f3050n * this.unit.metres) / (dx.f3050n * dx.unit.metres);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != Dx.class) {
            return $assertionsDisabled;
        }
        return getMetres() == ((Dx) obj).getMetres() ? true : $assertionsDisabled;
    }

    public final LengthUnit geKLength() {
        return this.unit;
    }

    public final double getMetres() {
        return this.unit.metres * this.f3050n;
    }

    public final double getValue() {
        return this.f3050n;
    }

    public final int hashCode() {
        return new Double(getMetres()).hashCode();
    }

    public final boolean isShorterThan(Dx dx) {
        if ($assertionsDisabled || dx != null) {
            return Math.abs(getMetres()) < Math.abs(dx.getMetres()) ? true : $assertionsDisabled;
        } else {
            throw new AssertionError();
        }
    }

    public final Dx multiply(double d) {
        return new Dx(this.f3050n * d, this.unit);
    }

    public final String toString() {
        return new StringBuilder(String.valueOf((float) this.f3050n)).append(" ").append(this.unit.toString().toLowerCase()).append(this.f3050n != 1.0d ? "s" : "").toString();
    }
}
