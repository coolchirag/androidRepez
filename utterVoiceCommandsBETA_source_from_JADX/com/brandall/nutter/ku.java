package com.brandall.nutter;

import java.util.Comparator;

final class ku implements Comparator<kt> {
    final /* synthetic */ FileBrowserActivity f1624a;

    private ku(FileBrowserActivity fileBrowserActivity) {
        this.f1624a = fileBrowserActivity;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((kt) obj).f1621a.toLowerCase().compareTo(((kt) obj2).f1621a.toLowerCase());
    }
}
