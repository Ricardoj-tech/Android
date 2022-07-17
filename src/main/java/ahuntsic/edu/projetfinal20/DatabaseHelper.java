package ahuntsic.edu.projetfinal20;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // changer le nom de la database
    public static final String DATABASE_NAME = "entrainement1_directory";


    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,96);
    }

    private static final String CREATE_BDD = "CREATE TABLE IF NOT EXISTS table_entraine ("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "title  TEXT NOT NULL, "
            + "img STRING NOT NULL)";

    private static final String CREATE_BDD2 = "CREATE TABLE IF NOT EXISTS table_entraineDetails ("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "categorie_fk_id INTEGER,"
            + "img2 STRING NOT NULL,"
            + "title2 TEXT NOT NULL, "
            + "description TEXT NOT NULL,"
            + "FOREIGN KEY (categorie_fk_id) REFERENCES table_entraine(_id))";

    private static final String CREATE_Contact = "CREATE TABLE IF NOT EXISTS table_Contact ("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "Numero TEXT NOT NULL, "
            + "Courriel TEXT NOT NULL)";

    private static final String CREATE_Formulaire = "CREATE TABLE IF NOT EXISTS table_Formulaire ("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "Nom STRING NOT NULL,"
            + "Prenom STRING NOT NULL,"
            + "Email STRING NOT NULL,"
            + "Naissance STRING NOT NULL,"
            + "sexe STRING NOT NULL)";

    private static final String sql3 = "CREATE TABLE IF NOT EXISTS exercice_details (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "exeMusc TEXT, " +
            "exeExe TEXT, " +
            "exeVid TEXT, " +
            "exeResp TEXT, " +
            "exeConsi TEXT, " +
            "exeConseil TEXT)";


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_BDD);
        db.execSQL(CREATE_BDD2);
        db.execSQL(CREATE_Contact);
        db.execSQL(CREATE_Formulaire);
        db.execSQL(sql3);

        ContentValues  values = new ContentValues();

        values.put("title","Bruler Gras");
        values.put("img",String.valueOf(R.drawable.bruler));
        db.insert("table_entraine", "title",values);

        values.put("title","Cuisses");
        values.put("img",String.valueOf(R.drawable.cuisses));
        db.insert("table_entraine", "title",values);

        values.put("title","Épaules");
        values.put("img",String.valueOf(R.drawable.epaules));
        db.insert("table_entraine", "title",values);

        values.put("title"," Highintensity");
        values.put("img",String.valueOf(R.drawable.highintensity));
        db.insert("table_entraine", "title",values);

        values.put("title"," Jambes");
        values.put("img",String.valueOf(R.drawable.jambes));
        db.insert("table_entraine", "title",values);

        values.put("title"," Torse");
        values.put("img",String.valueOf(R.drawable.torse));
        db.insert("table_entraine", "title",values);

        // il faut mettre ça
        values.clear();

        //2ieme base de donnée


        values.put("title2"," Crunch au sol");
        values.put("img2",String.valueOf(R.drawable.crunchausol));
        values.put("description","Le crunch est l'exercice de base très efficace pour muscler les abdominaux et raffermir la taille. " +
                "Encore faut-il bien le réaliser ! Tous nos conseils pour faire des crunchs parfaits…");
        values.put("categorie_fk_id",1);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Relevés de bassin sur plan incliné");
        values.put("img2",String.valueOf(R.drawable.relevesdebassinsurplanincline));
        values.put("description","Un bon exercice pour le grand droit des abdominaux. " +
                "Il a la réputation de solliciter le bas des abdos, là ou le crunch classique vise plus le haut. " +
                "On peut le réaliser à l'aide d'un banc ou au sol…");
        values.put("categorie_fk_id",1);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Sit-up");
        values.put("img2",String.valueOf(R.drawable.situp));
        values.put("description","Cet exercice a la réputation de travailler le bas du ventre, " +
                "là où le crunch au sol sollicite plutôt le haut des abdominaux. " +
                "Les sit-up peuvent être réalisés au sol ou sur un banc à abdominaux.");
        values.put("categorie_fk_id",1);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Relevés de genoux");
        values.put("img2",String.valueOf(R.drawable.relevesdegenoux));
        values.put("description","Un exercice souvent pratiqué en salle. " +
                "Les relevés de genoux travaillent les abdominaux et les fléchisseurs de la hanche. " +
                "Ils nécessitent une chaise à abdos…");
        values.put("categorie_fk_id",1);
        db.insert("table_entraineDetails", null,values);






        values.put("title2"," Mollets debout");
        values.put("img2",String.valueOf(R.drawable.molletsdebout));
        values.put("description","Cet exercice renforce les mollets, plus particulièrement les jumeaux , les deux boules tout au-dessus." +
                " Les mollets effectués debout est l'exercice de base pour bien renforcer ces muscles…");
        values.put("categorie_fk_id",2);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Mollets assis");
        values.put("img2",String.valueOf(R.drawable.molletsassis));
        values.put("description","La position assise sur une machine à mollets cible le soléaire, l'intérieur des mollets. " +
                "Le banc à soléaire est efficace pour donner de l'épaisseur au bas des mollets et se travaille en séries plutôt");
        values.put("categorie_fk_id",2);
        db.insert("table_entraineDetails", null,values);


        values.put("title2","Mollets presse à cuisses");
        values.put("img2",String.valueOf(R.drawable.molletspresseacuisses));
        values.put("description","Les mollets effectués à la presse à cuisses est un bon exercice de remplacement " +
                "quand on ne dispose pas de machines spécifiques. Très efficace, " +
                "il donne de bonnes sensations et travaille les mollets dans une position différente…");
        values.put("categorie_fk_id",2);
        db.insert("table_entraineDetails", null,values);


        values.put("title2"," Mollets au donkey");
        values.put("img2",String.valueOf(R.drawable.molletsaudonkey));
        values.put("description","Cet exercice de musculation des mollets est peu pratiqué en salle faute de machine spécifique " +
                "ou de partenaire compréhensif. Il est très efficace et donne de bonnes sensations aux jumeaux…");
        values.put("categorie_fk_id",2);
        db.insert("table_entraineDetails", null,values);



        values.put("title2"," Développé devant");
        values.put("img2",String.valueOf(R.drawable.developpedevant));
        values.put("description","Le développé devant est un exercice de base qui vous aidera à obtenir des épaules bien développées." +
                " Il muscle surtout l'avant et le côté de l'épaule, mais aussi le haut des pectoraux…)");
        values.put("categorie_fk_id",3);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Développé haltère");
        values.put("img2",String.valueOf(R.drawable.developpehaltere));
        values.put("description","Le développé réalisé aux haltères est un exercice de musculation de base qui vous permettra de bien développer vos épaules." +
                " Un mouvement efficace et recommandé aux débutants…");
        values.put("categorie_fk_id",3);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Développé nuque");
        values.put("img2",String.valueOf(R.drawable.developpenuque));
        values.put("description","Le développé nuque est un exercice de musculation efficace pour muscler les épaules," +
                " surtout le côté et l'arrière. En revanche, il faudra prendre des précautions car il ne convient pas à tout le");
        values.put("categorie_fk_id",3);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Rowing menton");
        values.put("img2",String.valueOf(R.drawable.rowingmenton));
        values.put("description","Le rowing menton à la barre est un exercice de musculation plutôt complet. " +
                "Il muscle les épaules et indirectement les trapèzes. C'est le mouvement opposé aux dips, un exercice souvent trop présent");
        values.put("categorie_fk_id",3);
        db.insert("table_entraineDetails", null,values);




        values.put("title2"," Tractions à la barre fixe");
        values.put("img2",String.valueOf(R.drawable.tractionsalabarrefixe));
        values.put("description","Les tractions à la barre fixe sont de formidables bâtisseuses de dorsaux. " +
                "Elles sollicitent les muscles du dos surtout au niveau de la largeur. Nous recommandons d'ajouter cet exercice à tout bon");
        values.put("categorie_fk_id",4);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Tirage poitrine");
        values.put("img2",String.valueOf(R.drawable.tiragepoitrine));
        values.put("description","Le tirage poitrine est un exercice sur machine qui peut remplacer les tractions au poids du corps. " +
                "Très utile pour les débutants et ceux qui ne peuvent soulever leur propre poids, il permet de");
        values.put("categorie_fk_id",4);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Tirage nuque");
        values.put("img2",String.valueOf(R.drawable.tiragenuque));
        values.put("description","Le tirage nuque, où l'on amène la barre derrière la nuque, est un exercice de musculation qui muscle le dos en largeur." +
                " A utiliser avec précaution car il n'est pas très bon pour l'articulation de");
        values.put("categorie_fk_id",4);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Tirage prise serrée");
        values.put("img2",String.valueOf(R.drawable.tiragepriseserree));
        values.put("description","Une variante populaire pour travailler le dos à la poulie haute. " +
                "Le tirage prise serrée permet de se forger un dos complet et de bons biceps. " +
                "Il nécessite un triangle de tirage qu'on trouve facilement");
        values.put("categorie_fk_id",4);
        db.insert("table_entraineDetails", null,values);




        values.put("title2"," Mollets debout");
        values.put("img2",String.valueOf(R.drawable.molletsdebout));
        values.put("description","Cet exercice renforce les mollets, plus particulièrement les jumeaux ," +
                " les deux boules tout au-dessus. Les mollets effectués debout est l'exercice de base pour bien renforcer ces muscles…");
        values.put("categorie_fk_id",5);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Mollets assis");
        values.put("img2",String.valueOf(R.drawable.molletsassis));
        values.put("description","La position assise sur une machine à mollets cible le soléaire, l'intérieur des mollets. " +
                "Le banc à soléaire est efficace pour donner de l'épaisseur au bas des mollets et se travaille en séries plutôt");
        values.put("categorie_fk_id",5);
        db.insert("table_entraineDetails", null,values);


        values.put("title2","Mollets presse à cuisses");
        values.put("img2",String.valueOf(R.drawable.molletspresseacuisses));
        values.put("description","Les mollets effectués à la presse à cuisses est un bon exercice de remplacement" +
                " quand on ne dispose pas de machines spécifiques. " +
                "Très efficace, il donne de bonnes sensations et travaille les mollets dans une position différente…");
        values.put("categorie_fk_id",5);
        db.insert("table_entraineDetails", null,values);


        values.put("title2"," Mollets au donkey");
        values.put("img2",String.valueOf(R.drawable.molletsaudonkey));
        values.put("description","Cet exercice de musculation des mollets est peu pratiqué en salle faute de machine spécifique ou de partenaire compréhensif." +
                " Il est très efficace et donne de bonnes sensations aux jumeaux…");
        values.put("categorie_fk_id",5);
        db.insert("table_entraineDetails", null,values);



        values.put("title2"," Développé couché barre");
        values.put("img2",String.valueOf(R.drawable.developpecouchebarre));
        values.put("description","Le développé couché à la barre est l'exercice de musculation de base pour se forger des pectoraux d'acier." +
                " Très populaire et pratiqué dans les salles, il nécessite une bonne technique…");
        values.put("categorie_fk_id",6);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Développé couché haltères");
        values.put("img2",String.valueOf(R.drawable.developpecouchehalteres));
        values.put("description","Le développé couché avec les haltères sur banc plat permet un mouvement plus naturel, " +
                "une meilleure contraction des pectoraux et un plus grand étirement des muscles…");
        values.put("categorie_fk_id",6);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Pompes au sol");
        values.put("img2",String.valueOf(R.drawable.pompesausol));
        values.put("description","Cet exercice très populaire permet de travailler l'ensemble du buste et notamment les pectoraux, " +
                "épaules et triceps. On peut se construire de bons pectoraux avec seulement les pompes mais à condition de savoir s'y prendre…");
        values.put("categorie_fk_id",6);
        db.insert("table_entraineDetails", null,values);

        values.put("title2","Ecarté couché haltères");
        values.put("img2",String.valueOf(R.drawable.ecartecouchehalteres));
        values.put("description","L'écarté couché sur banc plat est un exercice de musculation d'isolation qui muscle la partie médiane des pectoraux." +
                " On pourra le placer en fin de séance comme exercice de finition des");
        values.put("categorie_fk_id",6);
        db.insert("table_entraineDetails", null,values);

        values.clear();

        //3ieme base de donnée Contact

        values.put("Numero","987-654-7777");
        db.insert("table_Contact", null,values);

        values.put("Courriel","totof2724@hotmail.com");
        db.insert("table_Contact", null,values);

        values.clear();

        values.put("exeMusc", "Le crunch sollicite surtout le grand droit des abdominaux, la fameuse « tablette de chocolat », " +
                "et secondairement les muscles obliques situés sur le côté de la taille. Le grand droit permet la flexion du tronc ; " +
                "il rapproche le pubis du sternum par un enroulement vertébral lorsque le bassin est fixe. " +
                "Il permet également la rétroversion du bassin quand le tronc est fixe.\n" +
                "\n" +
                "Le crunch a la réputation de plus solliciter la partie supérieure des abdominaux (au-dessus du nombril) par rapport aux relevés de bassin " +
                "ou de jambes, qui feraient plutôt travailler la partie basse.");
        values.put("exeExe", "Position de départ allongé sur le sol ou sur un banc. " +
                "Les mains peuvent être placées sur la tête au niveau des tempes, sur la poitrine, ou encore le long du corps (plus facile)." +
                " Evitez de les positionner derrière la nuque.\n" +
                "\n" +
                "Les pieds peuvent être posés sur le sol, près des fesses, ou reposer sur un banc." +
                " On peut aussi placer les cuisses à la verticale, genoux fléchis et écartés, pieds croisés, de sorte à ne pas cambrer le bas du dos lors du mouvement. " +
                "Attention, plus les jambes sont surélevées voire tendues, plus la difficulté augmente.\n" +
                "\n" +
                "Enrouler le buste vers l’avant en contractant les abdominaux. " +
                "Les épaules ne décollent que de quelques centimètres du sol, et le bas du dos et les hanches restent fixes.");
        values.put("exeVid", "https://www.youtube.com/watch?v=zUk1BiL6Ajc");
        values.put("exeResp", "Inspiration en début de mouvement quand la cage thoracique est ouverte. " +
                "Soufflez en exécutant le mouvement et contractez bien vos abdominaux. Le blocage respiratoire doit être évité.");
        values.put("exeConsi", "Évitez de placer vos mains derrière la tête, car souvent on s'aide de celle-ci pour faire l'exercice quand on bloque. " +
                "Cela peut entraîner des problèmes aux cervicales. Le plus simple est de maintenir les mains sur les tempes ou sur la poitrine.\n" +
                "\n" +
                "Ne pas décoller le bas du dos, l'amplitude très réduite n’enlève pas d’efficacité à l’exercice.\n" +
                "\n" +
                "Le fait de travailler les pieds non bloqués, serrés et les genoux écartés, limite l'activité des fléchisseurs de la hanche, psoas-iliaque et droit antérieur, et évite bien des tensions et douleurs dans le bas du dos. Si vous avez mal au dos quand vous faites les exercices d'abdos, cet article devrait vous aider : Pourquoi ai-je mal au dos quand je fais les abdos ?");
        values.put("exeConseil", "En tant que muscles posturaux, les abdominaux sont plutôt endurants et pourront être travaillés en séries assez longues. Nous vous suggérons des séries de 15 à 30 répétitions, mais si vous pouvez en faire plus, n'hésitez pas à durcir les exercices. Au niveau du planning, 3 séances complètes d'abdominaux par semaine feront l'affaire. Mais n'oubliez pas de travailler tous les muscles qui composent ce groupe, pas seulement ceux qui sont visibles, en surface ! Je pense notamment au transverse, ne zappez pas le gainage !\n" +
                "On pourra faire les abdominaux en fin de séance, de sorte à ce qu'ils restent frais pour les exercices globaux où ils sont mis à contribution.\n" +
                "\n" +
                "Si vous trouvez l'exercice trop facile et que vous pouvez enchaîner des séries de plus de 50 répétitions, n'hésitez pas à durcir l'exercice en ajoutant de la résistance. Pour cela, vous pouvez éloigner les mains du buste et tendre les bras derrière la tête. Vous pouvez bien sûr utiliser des poids, disques ou haltère, à placer sur la poitrine ou derrière le cou. Cela est particulièrement valable si l'on souhaite gagner de la masse au niveau de la taille (personnes minces).\n" +
                "\n" +
                "Nous vous rappelons que pour obtenir des abdominaux secs et dessinés, faire des exercices ne sera pas suffisant. Les exercices permettent de muscler les abdominaux et aident à réduire le tour de taille, notamment par la pratique du gainage. Mais seule la diète vous débarassera de la couche de gras qui les recouvre. Pour cela, revoyez votre nutrition et pratiquez régulièrement une activité aérobie (cardio-training) en plus de la musculation.");
        db.insert("exercice_details", null, values);


        values.put("exeMusc", "Le relevé de bassin sur plan incliné sollicite le grand droit des abdominaux.\n" +
                "Le grand droit, la \"tablette de chocolat\" fait partie de la sangle abdominale avec les obliques et le transverse et permet la flexion du tronc. Les exercices d'abdominaux où l’on relève le bassin et les jambes en gardant le buste fixe ont la réputation de travailler plus le bas des abdominaux. Ceux comme les crunchs où l’on enroule la cage thoracique avec les jambes immobiles feraient plus travailler le haut des abdominaux.");
        values.put("exeExe", "Deux variantes légèrement différentes sont possibles. On peut le faire sur banc incliné et également au sol. Couché sur le banc, jambes fléchies, décoller les fessiers en enroulant le bas du dos et amener les genoux vers la poitrine. Revenir lentement à la position de départ.");
        values.put("exeVid", "https://www.youtube.com/watch?v=lpxLgh4d-Zg");
        values.put("exeResp", "Inspiration en début de mouvement quand la cage thoracique est ouverte.");
        values.put("exeConsi", "Suivant l’inclinaison du banc, il faut veiller à ce que les pieds ne touchent jamais le sol. Toujours ralentir l’exécution de l’exercice, en évitant de cambrer les lombaires quand les jambes redescendent. Pour la version sans banc, mettre un tapis au sol pour éviter de vous faire mal au bas du dos.");
        db.insert("exercice_details", "exeConseil", values);

        values.put("exeMusc", "Le crunch sollicite surtout le grand droit des abdominaux, la fameuse « tablette de chocolat », et secondairement les muscles obliques situés sur le côté de la taille. Le grand droit permet la flexion du tronc ; il rapproche le pubis du sternum par un enroulement vertébral lorsque le bassin est fixe. Il permet également la rétroversion du bassin quand le tronc est fixe.\n" +
                "\n" +
                "Le crunch a la réputation de plus solliciter la partie supérieure des abdominaux (au-dessus du nombril) par rapport aux relevés de bassin ou de jambes, qui feraient plutôt travailler la partie basse.");
        values.put("exeExe", "Position de départ allongé sur le sol ou sur un banc. Les mains peuvent être placées sur la tête au niveau des tempes, sur la poitrine, ou encore le long du corps (plus facile). Evitez de les positionner derrière la nuque.\n" +
                "\n" +
                "Les pieds peuvent être posés sur le sol, près des fesses, ou reposer sur un banc. On peut aussi placer les cuisses à la verticale, genoux fléchis et écartés, pieds croisés, de sorte à ne pas cambrer le bas du dos lors du mouvement. Attention, plus les jambes sont surélevées voire tendues, plus la difficulté augmente.\n" +
                "\n" +
                "Enrouler le buste vers l’avant en contractant les abdominaux. Les épaules ne décollent que de quelques centimètres du sol, et le bas du dos et les hanches restent fixes.");
        values.put("exeVid", "https://www.youtube.com/watch?v=zUk1BiL6Ajc");
        values.put("exeResp", "Inspiration en début de mouvement quand la cage thoracique est ouverte. Soufflez en exécutant le mouvement et contractez bien vos abdominaux. Le blocage respiratoire doit être évité.");
        values.put("exeConsi", "Évitez de placer vos mains derrière la tête, car souvent on s'aide de celle-ci pour faire l'exercice quand on bloque. Cela peut entraîner des problèmes aux cervicales. Le plus simple est de maintenir les mains sur les tempes ou sur la poitrine.\n" +
                "\n" +
                "Ne pas décoller le bas du dos, l'amplitude très réduite n’enlève pas d’efficacité à l’exercice.\n" +
                "\n" +
                "Le fait de travailler les pieds non bloqués, serrés et les genoux écartés, limite l'activité des fléchisseurs de la hanche, psoas-iliaque et droit antérieur, et évite bien des tensions et douleurs dans le bas du dos. Si vous avez mal au dos quand vous faites les exercices d'abdos, cet article devrait vous aider : Pourquoi ai-je mal au dos quand je fais les abdos ?");
        values.put("exeConseil", "En tant que muscles posturaux, les abdominaux sont plutôt endurants et pourront être travaillés en séries assez longues. Nous vous suggérons des séries de 15 à 30 répétitions, mais si vous pouvez en faire plus, n'hésitez pas à durcir les exercices. Au niveau du planning, 3 séances complètes d'abdominaux par semaine feront l'affaire. Mais n'oubliez pas de travailler tous les muscles qui composent ce groupe, pas seulement ceux qui sont visibles, en surface ! Je pense notamment au transverse, ne zappez pas le gainage !\n" +
                "On pourra faire les abdominaux en fin de séance, de sorte à ce qu'ils restent frais pour les exercices globaux où ils sont mis à contribution.\n" +
                "\n" +
                "Si vous trouvez l'exercice trop facile et que vous pouvez enchaîner des séries de plus de 50 répétitions, n'hésitez pas à durcir l'exercice en ajoutant de la résistance. Pour cela, vous pouvez éloigner les mains du buste et tendre les bras derrière la tête. Vous pouvez bien sûr utiliser des poids, disques ou haltère, à placer sur la poitrine ou derrière le cou. Cela est particulièrement valable si l'on souhaite gagner de la masse au niveau de la taille (personnes minces).\n" +
                "\n" +
                "Nous vous rappelons que pour obtenir des abdominaux secs et dessinés, faire des exercices ne sera pas suffisant. Les exercices permettent de muscler les abdominaux et aident à réduire le tour de taille, notamment par la pratique du gainage. Mais seule la diète vous débarassera de la couche de gras qui les recouvre. Pour cela, revoyez votre nutrition et pratiquez régulièrement une activité aérobie (cardio-training) en plus de la musculation.");
        db.insert("exercice_details", null, values);


        values.put("exeMusc", "Le relevé de bassin sur plan incliné sollicite le grand droit des abdominaux.\n" +
                "Le grand droit, la \"tablette de chocolat\" fait partie de la sangle abdominale avec les obliques et le transverse et permet la flexion du tronc. Les exercices d'abdominaux où l’on relève le bassin et les jambes en gardant le buste fixe ont la réputation de travailler plus le bas des abdominaux. Ceux comme les crunchs où l’on enroule la cage thoracique avec les jambes immobiles feraient plus travailler le haut des abdominaux.");
        values.put("exeExe", "Deux variantes légèrement différentes sont possibles. On peut le faire sur banc incliné et également au sol. Couché sur le banc, jambes fléchies, décoller les fessiers en enroulant le bas du dos et amener les genoux vers la poitrine. Revenir lentement à la position de départ.");
        values.put("exeVid", "https://www.youtube.com/watch?v=lpxLgh4d-Zg");
        values.put("exeResp", "Inspiration en début de mouvement quand la cage thoracique est ouverte.");
        values.put("exeConsi", "Suivant l’inclinaison du banc, il faut veiller à ce que les pieds ne touchent jamais le sol. Toujours ralentir l’exécution de l’exercice, en évitant de cambrer les lombaires quand les jambes redescendent. Pour la version sans banc, mettre un tapis au sol pour éviter de vous faire mal au bas du dos.");
        db.insert("exercice_details", "exeConseil", values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS table_entraine");
        db.execSQL("DROP TABLE IF EXISTS table_entraineDetails");
        db.execSQL("DROP TABLE IF EXISTS table_Contact");
        db.execSQL("DROP TABLE IF EXISTS table_Formulaire");
        db.execSQL("DROP TABLE IF EXISTS exercice_details");

        onCreate(db);
    }
}
