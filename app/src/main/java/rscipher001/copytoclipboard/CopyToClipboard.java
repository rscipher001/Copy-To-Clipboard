package rscipher001.copytoclipboard;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class CopyToClipboard extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String action = intent.getAction();
        String data = "";

        if (Intent.ACTION_VIEW.equals(action)) {
            if (intent.getData() != null)
                data = intent.getData().toString();
        } else if (Intent.ACTION_SEND.equals(action)) {
            data = intent.getStringExtra(Intent.EXTRA_TEXT);
        }

        ((ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("simple text", data));
        Toast.makeText(this, "Copied: " + data, Toast.LENGTH_SHORT).show();
        finish();
    }
}
