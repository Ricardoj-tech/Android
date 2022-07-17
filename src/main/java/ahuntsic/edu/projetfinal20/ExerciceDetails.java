package ahuntsic.edu.projetfinal20;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


// Add to MANIFEST
public class ExerciceDetails extends AppCompatActivity {

    private GridView maListViewPerso;
    private ListView maListViewDetails;
    protected ListAdapter adapter;
    protected int exo;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        exo = getIntent().getIntExtra("Entrai_id",0);
        SQLiteDatabase db = (new DatabaseHelper(this)).getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM table_entraineDetails WHERE categorie_fk_id = ?",
                new String[]{String.valueOf(exo)});

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            maListViewDetails = (ListView) findViewById(R.id.Details);

            adapter = new SimpleCursorAdapter(
                    this, R.layout.listeview2, cursor,
                    new String[]{"title2","description","img2"},
                    new int[]{ R.id.title2, R.id.Description,R.id.img2});
            maListViewDetails.setAdapter(adapter);

            go();
        }
    }

    public void go() {
        maListViewDetails.setOnItemClickListener((parent, view, position, id)->{
            Intent intent = new Intent(getBaseContext(), Exe_details.class);

            Cursor cursor = (Cursor) adapter.getItem(position);
            intent.putExtra("EXERCICE_ID",cursor.getInt(Integer.parseInt(String.valueOf(cursor.getColumnIndex("_id")))));
            startActivity(intent);
        });
    }

    public void Home (){
        maListViewPerso = (GridView) findViewById(R.id.listviewperso);
        SQLiteDatabase db = (new DatabaseHelper(this)).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM table_entraine  ",null);
        adapter = new SimpleCursorAdapter(this, R.layout.listeview, cursor, new String[]{"title", "img"},
                new int[]{R.id.title, R.id.img});
        maListViewPerso.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.Home:
                Home();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
