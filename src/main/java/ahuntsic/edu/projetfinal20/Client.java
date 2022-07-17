package ahuntsic.edu.projetfinal20;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;


// Add to MANIFEST
public class Client extends AppCompatActivity {

    private ListView maListclient;
    private GridView maListViewPerso;

    protected ListAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeclient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SQLiteDatabase db = (new DatabaseHelper(this)).getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM table_Formulaire ",null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            maListclient = (ListView) findViewById(R.id.ListeClient);
            maListViewPerso = (GridView) findViewById(R.id.listviewperso);

            adapter = new SimpleCursorAdapter(this, R.layout.listeviewclient, cursor,
                    new String[]{"Nom","Prenom","Email","Naissance","sexe"},
                    new int[]{ R.id.Nom,R.id.Prenom,R.id.Email,R.id.Naissance, R.id.sexe});
            maListclient.setAdapter(adapter);

        }
    }


    public void Home (){
        maListViewPerso = (GridView) findViewById(R.id.listviewperso);
        SQLiteDatabase db = (new DatabaseHelper(this)).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM table_entraine  ",null);
        adapter = new SimpleCursorAdapter(this, R.layout.listeview, cursor, new String[]{"Contact"},
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
