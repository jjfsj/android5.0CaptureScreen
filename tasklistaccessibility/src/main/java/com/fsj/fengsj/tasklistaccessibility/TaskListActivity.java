package com.fsj.fengsj.tasklistaccessibility;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageButton;


public class TaskListActivity extends ListActivity {

    /** An intent for launching the system settings. */
    private static final Intent sSettingsIntent =
            new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        // Hard-coded hand-waving here.
        boolean[] checkboxes = {true, true, false, true, false, false, false};
        String[] labels = {"Take out Trash", "Do Laundry",
                "Conquer World", "Nap", "Do Taxes",
                "Abolish IRS", "Tea with Aunt Sharon" };

        TaskAdapter myAdapter = new TaskAdapter(this, labels, checkboxes);
        this.setListAdapter(myAdapter);

        // Add a shortcut to the accessibility settings.
        ImageButton button = (ImageButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sSettingsIntent);
            }
        });
    }
}
