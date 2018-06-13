package br.com.dina.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import br.com.dina.ui.C0094c;
import br.com.dina.ui.C0095d;
import br.com.dina.ui.widget.UITableView;

public abstract class UITableViewActivity extends Activity {
    private UITableView f301a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0095d.f313d);
        this.f301a = (UITableView) findViewById(C0094c.f304b);
        this.f301a.m291a();
    }
}
