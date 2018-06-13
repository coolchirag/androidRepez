package org.p033a.p034a.p035a;

public final class C0553d {
    public int f3082a = 0;
    public Object f3083b = null;

    public C0553d(int i, Object obj) {
        this.f3082a = i;
        this.f3083b = obj;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.f3082a) {
            case -1:
                stringBuffer.append("END OF FILE");
                break;
            case 0:
                stringBuffer.append("VALUE(").append(this.f3083b).append(")");
                break;
            case 1:
                stringBuffer.append("LEFT BRACE({)");
                break;
            case 2:
                stringBuffer.append("RIGHT BRACE(})");
                break;
            case 3:
                stringBuffer.append("LEFT SQUARE([)");
                break;
            case 4:
                stringBuffer.append("RIGHT SQUARE(])");
                break;
            case 5:
                stringBuffer.append("COMMA(,)");
                break;
            case 6:
                stringBuffer.append("COLON(:)");
                break;
        }
        return stringBuffer.toString();
    }
}
