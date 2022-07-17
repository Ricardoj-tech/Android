package ahuntsic.edu.projetfinal20;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GridView maListViewPerso;

    protected SQLiteDatabase db;
    protected Cursor cursor;
    protected ListAdapter adapter;
    protected EditText searchText;

    // pou faire apparaitre le menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise la base de données
        db = (new DatabaseHelper(this)).getWritableDatabase();
        searchText = (EditText) findViewById(R.id.searchText);
        maListViewPerso = (GridView) findViewById(R.id.listviewperso);


        cursor = db.rawQuery("SELECT * FROM table_entraine  ",null);
        adapter = new SimpleCursorAdapter(this, R.layout.listeview, cursor, new String[]{"title", "img"},
                new int[]{R.id.title, R.id.img});
        maListViewPerso.setAdapter(adapter);

        // appel la méthode go
        go();
    }

    public void search (View view){

            cursor = db.rawQuery("SELECT _id, title, img FROM table_entraine WHERE title ||''||img like ?",
                    new String[]{"%" + searchText.getText().toString() + "%"});
            adapter = new SimpleCursorAdapter(this, R.layout.listeview, cursor, new String[]{"title", "img"},
                    new int[]{R.id.title, R.id.img});
            maListViewPerso.setAdapter(adapter);

    }
    public void go() {
        maListViewPerso.setOnItemClickListener((parent, view, position, id)->{
            Intent intent = new Intent(getBaseContext(),ExerciceDetails.class);

            Cursor cursor = (Cursor) adapter.getItem(position);
            intent.putExtra("Entrai_id",cursor.getInt(Integer.parseInt(String.valueOf(cursor.getColumnIndex("_id")))));
            startActivity(intent);
        });
    }

    public void Contact (){
        Intent i = new Intent(this,Contact.class);
        this.startActivity(i);
    }
    public void Formulaire (){
        Intent i = new Intent(this,Formulaire.class);
        this.startActivity(i);
    }

    public void Client (){
        Intent i = new Intent(this,Client.class);
        this.startActivity(i);
    }

    public void Home (){

        cursor = db.rawQuery("SELECT * FROM table_entraine  ",null);
        adapter = new SimpleCursorAdapter(this, R.layout.listeview, cursor, new String[]{"title", "img"},
                new int[]{R.id.title, R.id.img});
        maListViewPerso.setAdapter(adapter);
        go();

    }



    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.Home:
                Home();
                return  true;
            case R.id.Contact:
                Contact();
                return true;
            case R.id.Formulaire:
                Formulaire();
                return true;
            case R.id.Client:
                Client();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}