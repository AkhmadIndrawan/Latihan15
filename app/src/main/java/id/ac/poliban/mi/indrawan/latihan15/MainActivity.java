package id.ac.poliban.mi.indrawan.latihan15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etFileName;
    private Button btCreate;
    private Button btDelete;
    private Button btShowFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etFileName = findViewById(R.id.etFileName);
        Button btCreate = findViewById(R.id.btCreate);
        Button btDelete = findViewById(R.id.btDelete);
        Button btShowFiles = findViewById(R.id.btShowFiles);

        initComponent();


    }

    private void initComponent() {
        btCreate.setOnClickListener(v -> {
            File file = new File(getFilesDir(), etFileName.getText().toString().trim());
            try {
                file.createNewFile();

                Toast.makeText(this, etFileName.getText().toString() + "File Berhasil Dibuat", Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btDelete.setOnClickListener(v -> {
            File file = new File(getFilesDir(), etFileName.getText().toString().trim());
            if(file.delete())
            Toast.makeText(this, etFileName.getText().toString() +  "Sudah Dihapus", Toast.LENGTH_SHORT).show();
        });

        btShowFiles.setOnClickListener(v -> {
            File file = new File(getFilesDir(), ".");
            String[] files = file.list();
            String output = "";

            for(String f : files)
                output += f + "\n";

            new AlertDialog.Builder(this)
                    .setTitle("File Yang Ada Di Sistem App Anda")
                    .setMessage(output)
                    .setPositiveButton("OK", null). show();
        });
    }
}
