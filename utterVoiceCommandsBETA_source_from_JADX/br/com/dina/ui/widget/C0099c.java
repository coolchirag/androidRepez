package br.com.dina.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

final class C0099c implements OnClickListener {
    final /* synthetic */ UITableView f330a;

    C0099c(UITableView uITableView) {
        this.f330a = uITableView;
    }

    public final void onClick(View view) {
        if (this.f330a.f328f != null) {
            this.f330a.f328f.mo73a(((Integer) view.getTag()).intValue());
        }
    }
}
