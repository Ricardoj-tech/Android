package ahuntsic.edu.projetfinal20;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


// Add to MANIFEST
public class Contact extends AppCompatActivity {

    private ListView maListcontact;
    private GridView maListViewPerso;
    ArrayList<ContactAction> actions = new ArrayList<>();

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
        setContentView(R.layout.activity_maincontact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SQLiteDatabase db = (new DatabaseHelper(this)).getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM table_Contact ",null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            maListcontact = (ListView) findViewById(R.id.ListeContact);

            adapter = new SimpleCursorAdapter(this, R.layout.listecontact, cursor,
                    new String[]{"Courriel","Numero"},
                    new int[]{R.id.Courriel,R.id.Numero});
            maListcontact.setAdapter(adapter);


            String email = cursor.getString(Integer.parseInt(String.valueOf(cursor.getColumnIndex("Courriel"))));
            if (email != null) {
                actions.add(new ContactAction("Email", email,
                        ContactAction.ACTION_EMAIL));
            } String num = cursor.getString(Integer.parseInt(String.valueOf(cursor.getColumnIndex("Numero"))));
            if (num != null) {
                actions.add(new ContactAction("Call mobile", num,
                        ContactAction.ACTION_CALL));
            }

            go();
        }
    }

    public void go(){

        maListcontact.setOnItemClickListener((parent, view, position, id)-> {
            ContactAction action = actions.get(position);
            Intent intent;
            switch (action.getType()) {
                case ContactAction.ACTION_CALL:
                    Uri callUri = Uri.parse("tel:" +
                            action.getData());
                    intent = new Intent(Intent.ACTION_CALL,
                            callUri);
                    startActivity(intent);
                    break;
                case ContactAction.ACTION_EMAIL:
                    intent = new
                            Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL,
                            new String[]{action.getData()});
                    startActivity(intent);
                    break;

                case ContactAction.ACTION_SMS:
                    Uri smsUri = Uri.parse("sms:" +
                            action.getData());
                    intent = new Intent(Intent.ACTION_VIEW,
                            smsUri);
                    startActivity(intent);
                    break;
            }
        });

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
