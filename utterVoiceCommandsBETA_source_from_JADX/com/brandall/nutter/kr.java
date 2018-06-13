package com.brandall.nutter;

import java.io.File;
import java.io.FilenameFilter;

final class kr implements FilenameFilter {
    final /* synthetic */ FileBrowserActivity f1619a;

    kr(FileBrowserActivity fileBrowserActivity) {
        this.f1619a = fileBrowserActivity;
    }

    public final boolean accept(File file, String str) {
        File file2 = new File(file, str);
        boolean z = this.f1619a.f756f || file2.canRead();
        return FileBrowserActivity.f750h == 1 ? file2.isDirectory() && z : FileBrowserActivity.f750h == 2 ? z : true;
    }
}
