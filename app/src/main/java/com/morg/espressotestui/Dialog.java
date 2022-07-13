package com.morg.espressotestui;

import android.content.Context;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;

public class Dialog extends android.app.Dialog {
    private final Context context;
    private OnClick onClick;

    public Dialog(@NonNull Context context, OnClick onClick) {
        super(context);
        this.context = context;
        this.onClick = onClick;
        init();
    }

    private void init() {
        setContentView(R.layout.dialog_file);
        MaterialButton materialButton = findViewById(R.id.btn_ok);
        EditText editText = findViewById(R.id.et_text);

        materialButton.setOnClickListener(view -> {
            onClick.add(editText.getText().toString());
            dismiss();
        });
    }
}
