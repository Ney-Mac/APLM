package ao.co.isptec.aplm.listadetarefas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private EditText text;
    private ListView task;
    private ArrayAdapter<String> taskAdapter;
    private ArrayList<String> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        task = findViewById(R.id.lista);

        taskList = new ArrayList<>();
        taskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        task.setAdapter(taskAdapter);

        text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    String _task = text.getText().toString().trim();
                    if (!_task.isEmpty()) {
                        addTask(_task);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void addTask(String _task) {
        taskList.add(0, _task);
        taskAdapter.notifyDataSetChanged();
        text.getText().clear();
    }

}
