package org.p033a.p034a.p035a;

public final class C0551b extends Exception {
    private int f3058a;
    private Object f3059b;
    private int f3060c;

    public C0551b(int i, int i2, Object obj) {
        this.f3060c = i;
        this.f3058a = i2;
        this.f3059b = obj;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.f3058a) {
            case 0:
                stringBuffer.append("Unexpected character (").append(this.f3059b).append(") at position ").append(this.f3060c).append(".");
                break;
            case 1:
                stringBuffer.append("Unexpected token ").append(this.f3059b).append(" at position ").append(this.f3060c).append(".");
                break;
            case 2:
                stringBuffer.append("Unexpected exception at position ").append(this.f3060c).append(": ").append(this.f3059b);
                break;
            default:
                stringBuffer.append("Unkown error at position ").append(this.f3060c).append(".");
                break;
        }
        return stringBuffer.toString();
    }
}
