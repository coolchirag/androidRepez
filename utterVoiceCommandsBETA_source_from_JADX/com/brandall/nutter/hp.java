package com.brandall.nutter;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Locale;

public final class hp {
    public static ArrayList<String> m1130a(ArrayList<String> arrayList) {
        ls.m1346c("in convertToCalc");
        ArrayList<String> arrayList2 = new ArrayList();
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            String trim = ((String) listIterator.next()).toString().toLowerCase(Locale.US).trim();
            ls.m1344a("toConvert: " + trim);
            trim = trim.replaceAll(" divided by ", " \\/ ").replaceAll(" divided ", " \\/ ").replaceAll(" plus ", " \\+ ").replaceAll(" minus ", " \\- ").replaceAll("-", " - ").replaceAll(" times ", " \\* ").replaceAll(" time ", " \\* ").replaceAll(" add ", " \\+ ").replaceAll(" multiplied by ", " \\* ").replaceAll(" multiplied ", " \\* ").replaceAll(" subtract ", " \\- ").replaceAll(" percent ", "\\% ").replaceAll(" to the power of ", " \\^ ").replaceAll(" to the power ", " \\^ ").replaceAll(" squared", " \\^ 2 ").replaceAll(" cubed", " \\^ 3 ").replaceAll("square root", "sqrt").replaceAll("calculate", " ").replaceAll("the", "").replaceAll("of", "").replaceAll("equals", " ").trim().replaceAll(" +", " ");
            ls.m1344a("Post conversion toConvert: " + trim);
            if (trim.replaceAll("sqrt", "").matches("[^a-z]+")) {
                ls.m1346c("toConvert.contains[^a-z]+: true");
                try {
                    double a = new lm().m1337a(trim);
                    ls.m1344a("answer: " + a);
                    arrayList2.add(String.valueOf(a));
                    arrayList2.add(trim);
                    return arrayList2;
                } catch (NumberFormatException e) {
                    ls.m1348e("EstablishCalculation NumberFormatException");
                } catch (ArithmeticException e2) {
                    ls.m1348e("EstablishCalculation ArithmeticException");
                }
            } else {
                ls.m1347d("Skipping simple mathEval: " + trim);
            }
        }
        return arrayList2;
    }
}
