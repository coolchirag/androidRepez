package com.brandall.nutter;

import java.util.Calendar;

public final class hy {
    public static String m1158a() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(7);
        int i2 = instance.get(5);
        int i3 = instance.get(2);
        int i4 = instance.get(1);
        StringBuilder stringBuilder = new StringBuilder("It's ");
        String str = "";
        switch (i) {
            case 1:
                str = "Sunday";
                break;
            case 2:
                str = "Monday";
                break;
            case 3:
                str = "Tuesday";
                break;
            case 4:
                str = "Wednesday";
                break;
            case 5:
                str = "Thursday";
                break;
            case 6:
                str = "Friday";
                break;
            case 7:
                str = "Saturday";
                break;
        }
        StringBuilder append = stringBuilder.append(str).append(" the ");
        str = "";
        switch (i2) {
            case 1:
                str = "first";
                break;
            case 2:
                str = "second";
                break;
            case 3:
                str = "third";
                break;
            case 4:
                str = "fourth";
                break;
            case 5:
                str = "fifth";
                break;
            case 6:
                str = "sixth";
                break;
            case 7:
                str = "seventh";
                break;
            case 8:
                str = "eighth";
                break;
            case 9:
                str = "ninth";
                break;
            case 10:
                str = "tenth";
                break;
            case 11:
                str = "eleventh";
                break;
            case 12:
                str = "twelth";
                break;
            case 13:
                str = "thirteenth";
                break;
            case 14:
                str = "fourteenth";
                break;
            case 15:
                str = "fifteenth";
                break;
            case 16:
                str = "sixteenth";
                break;
            case 17:
                str = "seventeenth";
                break;
            case 18:
                str = "eighteenth";
                break;
            case 19:
                str = "nineteenth";
                break;
            case 20:
                str = "twentieth";
                break;
            case 21:
                str = "twenty first";
                break;
            case 22:
                str = "twenty second";
                break;
            case 23:
                str = "twenty third";
                break;
            case 24:
                str = "twenty fourth";
                break;
            case 25:
                str = "twenty fifth";
                break;
            case 26:
                str = "twenty sixth";
                break;
            case 27:
                str = "twenty seventh";
                break;
            case 28:
                str = "twenty eighth";
                break;
            case 29:
                str = "twenty ninth";
                break;
            case 30:
                str = "thirtieth";
                break;
            case 31:
                str = "thirty first";
                break;
        }
        append = append.append(str).append(" of ");
        str = "";
        switch (i3) {
            case 0:
                str = "January";
                break;
            case 1:
                str = "February";
                break;
            case 2:
                str = "March";
                break;
            case 3:
                str = "April";
                break;
            case 4:
                str = "May";
                break;
            case 5:
                str = "June";
                break;
            case 6:
                str = "July";
                break;
            case 7:
                str = "August";
                break;
            case 8:
                str = "September";
                break;
            case 9:
                str = "October";
                break;
            case 10:
                str = "November";
                break;
            case 11:
                str = "December";
                break;
        }
        return append.append(str).append(" ").append(i4).toString();
    }
}
