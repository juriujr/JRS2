package Dialog;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DialogBottomListView extends Dialog {
    public DialogBottomListView(@NonNull Context context) {
        super(context);
    }

    public DialogBottomListView(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DialogBottomListView(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
