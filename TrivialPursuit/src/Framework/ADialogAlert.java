package Framework;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

/**
 * Base class for an alert-based dialog
 */
public abstract class ADialogAlert extends ABaseDialog {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return buildDialog(new AlertDialog.Builder(getActivity())).create();
	}

	public abstract AlertDialog.Builder buildDialog(AlertDialog.Builder builder);

}
