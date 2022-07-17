package ahuntsic.edu.projetfinal20;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exe_details extends AppCompatActivity {
    private TextView muscles;
    private TextView execution;
    private TextView video;
    private TextView resp;
    private TextView consignes;
    private TextView conseils;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsexo);

        id = getIntent().getIntExtra("EXERCICE_ID", 0);
        SQLiteDatabase db = (new DatabaseHelper(this)).getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM exercice_details as e WHERE e._id = ?", new String[] {"" + id});

        // mettre le +++++++++++ avnt le cursor

        if(cursor.getCount() == 1) {
            cursor.moveToFirst();
            muscles = (TextView) findViewById(R.id.muscles);
            muscles.setText(cursor.getString(+ cursor.getColumnIndex("exeMusc")));
            execution = (TextView) findViewById(R.id.execution);
            execution.setText(cursor.getString(+ cursor.getColumnIndex("exeExe")));
            video = (TextView) findViewById(R.id.video);
            video.setText(cursor.getString(+ cursor.getColumnIndex("exeVid")));
            resp = (TextView) findViewById(R.id.resp);
            resp.setText(cursor.getString(+ cursor.getColumnIndex("exeResp")));
            consignes = (TextView) findViewById(R.id.consignes);
            consignes.setText(cursor.getString(+ cursor.getColumnIndex("exeConsi")));
            conseils = (TextView) findViewById(R.id.conseils);
            conseils.setText(cursor.getString(+ cursor.getColumnIndex("exeConseil")));
        }

    }

}