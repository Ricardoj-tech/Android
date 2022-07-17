package ahuntsic.edu.projetfinal20;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Formulaire extends AppCompatActivity {


    private Button enregistrer;
    private EditText nom;
    private EditText prenom;
    private EditText email;
    private Spinner jour;
    private Spinner mois;
    private Spinner annee;

    private RadioGroup sexe;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);
        enregistrer = (Button) findViewById(R.id.save);
        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        email = (EditText) findViewById(R.id.email);
        jour = (Spinner) findViewById(R.id.jours);
        mois = (Spinner) findViewById(R.id.mois);
        annee = (Spinner) findViewById(R.id.annee);
        sexe = (RadioGroup) findViewById(R.id.radioSex);
        go();
    }

   // pour enregistrer les informations du formulaire dans la base de données
    public void insertData(String Nom, String Prenom, String Email,String Naissance, String sexe){
        SQLiteDatabase db =  (new DatabaseHelper(this)).getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nom",Nom);
        contentValues.put("Prenom",Prenom);
        contentValues.put("Email",Email);
        contentValues.put("Naissance",Naissance);
        contentValues.put("sexe",sexe);
        db.insert("table_Formulaire", null, contentValues);
    }

    public void go() {
        enregistrer.setOnClickListener(v -> {
            String str_nom = "";
            String str_prenom = "";
            String str_email = "";
            String str_date = "";
            String str_sexe = "";

            int int_jour = 0;
            int int_mois = 0;
            int int_annee = 0;

            //Validation
            boolean info_valable = true;

            if (nom.getText().toString().equals("") == false) {
                str_nom = nom.getText().toString();
            } else {
                info_valable = false;
            }
            if (prenom.getText().toString().equals("") == false) {
                str_prenom = prenom.getText().toString();
            } else {
                info_valable = false;
            }
            if (email.getText().toString().equals("") == false) {
                str_email = email.getText().toString();
            } else {
                info_valable = false;
            }


            int_jour = Integer.valueOf(String.valueOf(jour.getSelectedItem()));
            int_mois = Integer.valueOf(String.valueOf(mois.getSelectedItem()));
            int_annee = Integer.valueOf(String.valueOf(annee.getSelectedItem()));

            str_date = String.valueOf(int_jour) + "-" + String.valueOf(int_mois) + "-" + String.valueOf(int_annee);

            int selectedId = sexe.getCheckedRadioButtonId();

            if (selectedId != -1) {
                RadioButton radioSexButton;
                radioSexButton = (RadioButton) findViewById(selectedId);
                str_sexe = radioSexButton.getText().toString();
            } else {
                info_valable = false;
            }

            // Masquer le clavier lorsque vous appuyez sur le bouton
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            if (info_valable == false) {
                Toast.makeText(getApplicationContext(), "Il manque des informations", Toast.LENGTH_SHORT).show();
            } else {
                // enregistrer les informations
                insertData(str_nom,str_prenom,str_email,str_date,str_sexe);
                Toast.makeText(getApplicationContext(), "Le formulaire a été enregistré avec succàs", Toast.LENGTH_SHORT).show();
            }
        });
    }
}



