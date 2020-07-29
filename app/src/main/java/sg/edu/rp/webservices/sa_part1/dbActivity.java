package sg.edu.rp.webservices.sa_part1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dbActivity extends AppCompatActivity {

    Button button;
    EditText etName,etSchool,etCode,etnumStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        button = findViewById(R.id.btnSubmit);
        etName = findViewById(R.id.etName);
        etSchool = findViewById(R.id.etSchool);
        etCode = findViewById(R.id.etCode);
        etnumStudent = findViewById(R.id.etnumStudent);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = etName.getText().toString();
                String school = etSchool.getText().toString();
                String code = etCode.getText().toString();
                int numStudent = Integer.parseInt(etnumStudent.getText().toString());

                DBHelper dbh = new DBHelper(dbActivity.this);
                dbh.insertModules(name,code,school,numStudent);
                dbh.close();
                    }
                }
        );

    }


}
