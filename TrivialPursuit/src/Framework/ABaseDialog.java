package Framework;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Base class dialog fragment
 */
public abstract class ABaseDialog extends DialogFragment {

	/**
	 * Fragment tag
	 */
	public static final String TAG_DIALOG_FRAGMENT = "ABaseDialog.TAG_DIALOG_FRAGMENT";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		super.onCancel(dialog);
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		super.onDismiss(dialog);
	}
	
	protected String[] requiredExtras() {
		return new String[0];
	}
}
