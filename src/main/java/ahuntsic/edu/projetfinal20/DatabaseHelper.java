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

        values.put("title","??paules");
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

        // il faut mettre ??a
        values.clear();

        //2ieme base de donn??e


        values.put("title2"," Crunch au sol");
        values.put("img2",String.valueOf(R.drawable.crunchausol));
        values.put("description","Le crunch est l'exercice de base tr??s efficace pour muscler les abdominaux et raffermir la taille. " +
                "Encore faut-il bien le r??aliser ! Tous nos conseils pour faire des crunchs parfaits???");
        values.put("categorie_fk_id",1);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Relev??s de bassin sur plan inclin??");
        values.put("img2",String.valueOf(R.drawable.relevesdebassinsurplanincline));
        values.put("description","Un bon exercice pour le grand droit des abdominaux. " +
                "Il a la r??putation de solliciter le bas des abdos, l?? ou le crunch classique vise plus le haut. " +
                "On peut le r??aliser ?? l'aide d'un banc ou au sol???");
        values.put("categorie_fk_id",1);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Sit-up");
        values.put("img2",String.valueOf(R.drawable.situp));
        values.put("description","Cet exercice a la r??putation de travailler le bas du ventre, " +
                "l?? o?? le crunch au sol sollicite plut??t le haut des abdominaux. " +
                "Les sit-up peuvent ??tre r??alis??s au sol ou sur un banc ?? abdominaux.");
        values.put("categorie_fk_id",1);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Relev??s de genoux");
        values.put("img2",String.valueOf(R.drawable.relevesdegenoux));
        values.put("description","Un exercice souvent pratiqu?? en salle. " +
                "Les relev??s de genoux travaillent les abdominaux et les fl??chisseurs de la hanche. " +
                "Ils n??cessitent une chaise ?? abdos???");
        values.put("categorie_fk_id",1);
        db.insert("table_entraineDetails", null,values);






        values.put("title2"," Mollets debout");
        values.put("img2",String.valueOf(R.drawable.molletsdebout));
        values.put("description","Cet exercice renforce les mollets, plus particuli??rement les jumeaux , les deux boules tout au-dessus." +
                " Les mollets effectu??s debout est l'exercice de base pour bien renforcer ces muscles???");
        values.put("categorie_fk_id",2);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Mollets assis");
        values.put("img2",String.valueOf(R.drawable.molletsassis));
        values.put("description","La position assise sur une machine ?? mollets cible le sol??aire, l'int??rieur des mollets. " +
                "Le banc ?? sol??aire est efficace pour donner de l'??paisseur au bas des mollets et se travaille en s??ries plut??t");
        values.put("categorie_fk_id",2);
        db.insert("table_entraineDetails", null,values);


        values.put("title2","Mollets presse ?? cuisses");
        values.put("img2",String.valueOf(R.drawable.molletspresseacuisses));
        values.put("description","Les mollets effectu??s ?? la presse ?? cuisses est un bon exercice de remplacement " +
                "quand on ne dispose pas de machines sp??cifiques. Tr??s efficace, " +
                "il donne de bonnes sensations et travaille les mollets dans une position diff??rente???");
        values.put("categorie_fk_id",2);
        db.insert("table_entraineDetails", null,values);


        values.put("title2"," Mollets au donkey");
        values.put("img2",String.valueOf(R.drawable.molletsaudonkey));
        values.put("description","Cet exercice de musculation des mollets est peu pratiqu?? en salle faute de machine sp??cifique " +
                "ou de partenaire compr??hensif. Il est tr??s efficace et donne de bonnes sensations aux jumeaux???");
        values.put("categorie_fk_id",2);
        db.insert("table_entraineDetails", null,values);



        values.put("title2"," D??velopp?? devant");
        values.put("img2",String.valueOf(R.drawable.developpedevant));
        values.put("description","Le d??velopp?? devant est un exercice de base qui vous aidera ?? obtenir des ??paules bien d??velopp??es." +
                " Il muscle surtout l'avant et le c??t?? de l'??paule, mais aussi le haut des pectoraux???)");
        values.put("categorie_fk_id",3);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," D??velopp?? halt??re");
        values.put("img2",String.valueOf(R.drawable.developpehaltere));
        values.put("description","Le d??velopp?? r??alis?? aux halt??res est un exercice de musculation de base qui vous permettra de bien d??velopper vos ??paules." +
                " Un mouvement efficace et recommand?? aux d??butants???");
        values.put("categorie_fk_id",3);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," D??velopp?? nuque");
        values.put("img2",String.valueOf(R.drawable.developpenuque));
        values.put("description","Le d??velopp?? nuque est un exercice de musculation efficace pour muscler les ??paules," +
                " surtout le c??t?? et l'arri??re. En revanche, il faudra prendre des pr??cautions car il ne convient pas ?? tout le");
        values.put("categorie_fk_id",3);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Rowing menton");
        values.put("img2",String.valueOf(R.drawable.rowingmenton));
        values.put("description","Le rowing menton ?? la barre est un exercice de musculation plut??t complet. " +
                "Il muscle les ??paules et indirectement les trap??zes. C'est le mouvement oppos?? aux dips, un exercice souvent trop pr??sent");
        values.put("categorie_fk_id",3);
        db.insert("table_entraineDetails", null,values);




        values.put("title2"," Tractions ?? la barre fixe");
        values.put("img2",String.valueOf(R.drawable.tractionsalabarrefixe));
        values.put("description","Les tractions ?? la barre fixe sont de formidables b??tisseuses de dorsaux. " +
                "Elles sollicitent les muscles du dos surtout au niveau de la largeur. Nous recommandons d'ajouter cet exercice ?? tout bon");
        values.put("categorie_fk_id",4);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Tirage poitrine");
        values.put("img2",String.valueOf(R.drawable.tiragepoitrine));
        values.put("description","Le tirage poitrine est un exercice sur machine qui peut remplacer les tractions au poids du corps. " +
                "Tr??s utile pour les d??butants et ceux qui ne peuvent soulever leur propre poids, il permet de");
        values.put("categorie_fk_id",4);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Tirage nuque");
        values.put("img2",String.valueOf(R.drawable.tiragenuque));
        values.put("description","Le tirage nuque, o?? l'on am??ne la barre derri??re la nuque, est un exercice de musculation qui muscle le dos en largeur." +
                " A utiliser avec pr??caution car il n'est pas tr??s bon pour l'articulation de");
        values.put("categorie_fk_id",4);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Tirage prise serr??e");
        values.put("img2",String.valueOf(R.drawable.tiragepriseserree));
        values.put("description","Une variante populaire pour travailler le dos ?? la poulie haute. " +
                "Le tirage prise serr??e permet de se forger un dos complet et de bons biceps. " +
                "Il n??cessite un triangle de tirage qu'on trouve facilement");
        values.put("categorie_fk_id",4);
        db.insert("table_entraineDetails", null,values);




        values.put("title2"," Mollets debout");
        values.put("img2",String.valueOf(R.drawable.molletsdebout));
        values.put("description","Cet exercice renforce les mollets, plus particuli??rement les jumeaux ," +
                " les deux boules tout au-dessus. Les mollets effectu??s debout est l'exercice de base pour bien renforcer ces muscles???");
        values.put("categorie_fk_id",5);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Mollets assis");
        values.put("img2",String.valueOf(R.drawable.molletsassis));
        values.put("description","La position assise sur une machine ?? mollets cible le sol??aire, l'int??rieur des mollets. " +
                "Le banc ?? sol??aire est efficace pour donner de l'??paisseur au bas des mollets et se travaille en s??ries plut??t");
        values.put("categorie_fk_id",5);
        db.insert("table_entraineDetails", null,values);


        values.put("title2","Mollets presse ?? cuisses");
        values.put("img2",String.valueOf(R.drawable.molletspresseacuisses));
        values.put("description","Les mollets effectu??s ?? la presse ?? cuisses est un bon exercice de remplacement" +
                " quand on ne dispose pas de machines sp??cifiques. " +
                "Tr??s efficace, il donne de bonnes sensations et travaille les mollets dans une position diff??rente???");
        values.put("categorie_fk_id",5);
        db.insert("table_entraineDetails", null,values);


        values.put("title2"," Mollets au donkey");
        values.put("img2",String.valueOf(R.drawable.molletsaudonkey));
        values.put("description","Cet exercice de musculation des mollets est peu pratiqu?? en salle faute de machine sp??cifique ou de partenaire compr??hensif." +
                " Il est tr??s efficace et donne de bonnes sensations aux jumeaux???");
        values.put("categorie_fk_id",5);
        db.insert("table_entraineDetails", null,values);



        values.put("title2"," D??velopp?? couch?? barre");
        values.put("img2",String.valueOf(R.drawable.developpecouchebarre));
        values.put("description","Le d??velopp?? couch?? ?? la barre est l'exercice de musculation de base pour se forger des pectoraux d'acier." +
                " Tr??s populaire et pratiqu?? dans les salles, il n??cessite une bonne technique???");
        values.put("categorie_fk_id",6);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," D??velopp?? couch?? halt??res");
        values.put("img2",String.valueOf(R.drawable.developpecouchehalteres));
        values.put("description","Le d??velopp?? couch?? avec les halt??res sur banc plat permet un mouvement plus naturel, " +
                "une meilleure contraction des pectoraux et un plus grand ??tirement des muscles???");
        values.put("categorie_fk_id",6);
        db.insert("table_entraineDetails", null,values);

        values.put("title2"," Pompes au sol");
        values.put("img2",String.valueOf(R.drawable.pompesausol));
        values.put("description","Cet exercice tr??s populaire permet de travailler l'ensemble du buste et notamment les pectoraux, " +
                "??paules et triceps. On peut se construire de bons pectoraux avec seulement les pompes mais ?? condition de savoir s'y prendre???");
        values.put("categorie_fk_id",6);
        db.insert("table_entraineDetails", null,values);

        values.put("title2","Ecart?? couch?? halt??res");
        values.put("img2",String.valueOf(R.drawable.ecartecouchehalteres));
        values.put("description","L'??cart?? couch?? sur banc plat est un exercice de musculation d'isolation qui muscle la partie m??diane des pectoraux." +
                " On pourra le placer en fin de s??ance comme exercice de finition des");
        values.put("categorie_fk_id",6);
        db.insert("table_entraineDetails", null,values);

        values.clear();

        //3ieme base de donn??e Contact

        values.put("Numero","987-654-7777");
        db.insert("table_Contact", null,values);

        values.put("Courriel","totof2724@hotmail.com");
        db.insert("table_Contact", null,values);

        values.clear();

        values.put("exeMusc", "Le crunch sollicite surtout le grand droit des abdominaux, la fameuse ?? tablette de chocolat ??, " +
                "et secondairement les muscles obliques situ??s sur le c??t?? de la taille. Le grand droit permet la flexion du tronc ; " +
                "il rapproche le pubis du sternum par un enroulement vert??bral lorsque le bassin est fixe. " +
                "Il permet ??galement la r??troversion du bassin quand le tronc est fixe.\n" +
                "\n" +
                "Le crunch a la r??putation de plus solliciter la partie sup??rieure des abdominaux (au-dessus du nombril) par rapport aux relev??s de bassin " +
                "ou de jambes, qui feraient plut??t travailler la partie basse.");
        values.put("exeExe", "Position de d??part allong?? sur le sol ou sur un banc. " +
                "Les mains peuvent ??tre plac??es sur la t??te au niveau des tempes, sur la poitrine, ou encore le long du corps (plus facile)." +
                " Evitez de les positionner derri??re la nuque.\n" +
                "\n" +
                "Les pieds peuvent ??tre pos??s sur le sol, pr??s des fesses, ou reposer sur un banc." +
                " On peut aussi placer les cuisses ?? la verticale, genoux fl??chis et ??cart??s, pieds crois??s, de sorte ?? ne pas cambrer le bas du dos lors du mouvement. " +
                "Attention, plus les jambes sont sur??lev??es voire tendues, plus la difficult?? augmente.\n" +
                "\n" +
                "Enrouler le buste vers l???avant en contractant les abdominaux. " +
                "Les ??paules ne d??collent que de quelques centim??tres du sol, et le bas du dos et les hanches restent fixes.");
        values.put("exeVid", "https://www.youtube.com/watch?v=zUk1BiL6Ajc");
        values.put("exeResp", "Inspiration en d??but de mouvement quand la cage thoracique est ouverte. " +
                "Soufflez en ex??cutant le mouvement et contractez bien vos abdominaux. Le blocage respiratoire doit ??tre ??vit??.");
        values.put("exeConsi", "??vitez de placer vos mains derri??re la t??te, car souvent on s'aide de celle-ci pour faire l'exercice quand on bloque. " +
                "Cela peut entra??ner des probl??mes aux cervicales. Le plus simple est de maintenir les mains sur les tempes ou sur la poitrine.\n" +
                "\n" +
                "Ne pas d??coller le bas du dos, l'amplitude tr??s r??duite n???enl??ve pas d???efficacit?? ?? l???exercice.\n" +
                "\n" +
                "Le fait de travailler les pieds non bloqu??s, serr??s et les genoux ??cart??s, limite l'activit?? des fl??chisseurs de la hanche, psoas-iliaque et droit ant??rieur, et ??vite bien des tensions et douleurs dans le bas du dos. Si vous avez mal au dos quand vous faites les exercices d'abdos, cet article devrait vous aider : Pourquoi ai-je mal au dos quand je fais les abdos ?");
        values.put("exeConseil", "En tant que muscles posturaux, les abdominaux sont plut??t endurants et pourront ??tre travaill??s en s??ries assez longues. Nous vous sugg??rons des s??ries de 15 ?? 30 r??p??titions, mais si vous pouvez en faire plus, n'h??sitez pas ?? durcir les exercices. Au niveau du planning, 3 s??ances compl??tes d'abdominaux par semaine feront l'affaire. Mais n'oubliez pas de travailler tous les muscles qui composent ce groupe, pas seulement ceux qui sont visibles, en surface ! Je pense notamment au transverse, ne zappez pas le gainage !\n" +
                "On pourra faire les abdominaux en fin de s??ance, de sorte ?? ce qu'ils restent frais pour les exercices globaux o?? ils sont mis ?? contribution.\n" +
                "\n" +
                "Si vous trouvez l'exercice trop facile et que vous pouvez encha??ner des s??ries de plus de 50 r??p??titions, n'h??sitez pas ?? durcir l'exercice en ajoutant de la r??sistance. Pour cela, vous pouvez ??loigner les mains du buste et tendre les bras derri??re la t??te. Vous pouvez bien s??r utiliser des poids, disques ou halt??re, ?? placer sur la poitrine ou derri??re le cou. Cela est particuli??rement valable si l'on souhaite gagner de la masse au niveau de la taille (personnes minces).\n" +
                "\n" +
                "Nous vous rappelons que pour obtenir des abdominaux secs et dessin??s, faire des exercices ne sera pas suffisant. Les exercices permettent de muscler les abdominaux et aident ?? r??duire le tour de taille, notamment par la pratique du gainage. Mais seule la di??te vous d??barassera de la couche de gras qui les recouvre. Pour cela, revoyez votre nutrition et pratiquez r??guli??rement une activit?? a??robie (cardio-training) en plus de la musculation.");
        db.insert("exercice_details", null, values);


        values.put("exeMusc", "Le relev?? de bassin sur plan inclin?? sollicite le grand droit des abdominaux.\n" +
                "Le grand droit, la \"tablette de chocolat\" fait partie de la sangle abdominale avec les obliques et le transverse et permet la flexion du tronc. Les exercices d'abdominaux o?? l???on rel??ve le bassin et les jambes en gardant le buste fixe ont la r??putation de travailler plus le bas des abdominaux. Ceux comme les crunchs o?? l???on enroule la cage thoracique avec les jambes immobiles feraient plus travailler le haut des abdominaux.");
        values.put("exeExe", "Deux variantes l??g??rement diff??rentes sont possibles. On peut le faire sur banc inclin?? et ??galement au sol. Couch?? sur le banc, jambes fl??chies, d??coller les fessiers en enroulant le bas du dos et amener les genoux vers la poitrine. Revenir lentement ?? la position de d??part.");
        values.put("exeVid", "https://www.youtube.com/watch?v=lpxLgh4d-Zg");
        values.put("exeResp", "Inspiration en d??but de mouvement quand la cage thoracique est ouverte.");
        values.put("exeConsi", "Suivant l???inclinaison du banc, il faut veiller ?? ce que les pieds ne touchent jamais le sol. Toujours ralentir l???ex??cution de l???exercice, en ??vitant de cambrer les lombaires quand les jambes redescendent. Pour la version sans banc, mettre un tapis au sol pour ??viter de vous faire mal au bas du dos.");
        db.insert("exercice_details", "exeConseil", values);

        values.put("exeMusc", "Le crunch sollicite surtout le grand droit des abdominaux, la fameuse ?? tablette de chocolat ??, et secondairement les muscles obliques situ??s sur le c??t?? de la taille. Le grand droit permet la flexion du tronc ; il rapproche le pubis du sternum par un enroulement vert??bral lorsque le bassin est fixe. Il permet ??galement la r??troversion du bassin quand le tronc est fixe.\n" +
                "\n" +
                "Le crunch a la r??putation de plus solliciter la partie sup??rieure des abdominaux (au-dessus du nombril) par rapport aux relev??s de bassin ou de jambes, qui feraient plut??t travailler la partie basse.");
        values.put("exeExe", "Position de d??part allong?? sur le sol ou sur un banc. Les mains peuvent ??tre plac??es sur la t??te au niveau des tempes, sur la poitrine, ou encore le long du corps (plus facile). Evitez de les positionner derri??re la nuque.\n" +
                "\n" +
                "Les pieds peuvent ??tre pos??s sur le sol, pr??s des fesses, ou reposer sur un banc. On peut aussi placer les cuisses ?? la verticale, genoux fl??chis et ??cart??s, pieds crois??s, de sorte ?? ne pas cambrer le bas du dos lors du mouvement. Attention, plus les jambes sont sur??lev??es voire tendues, plus la difficult?? augmente.\n" +
                "\n" +
                "Enrouler le buste vers l???avant en contractant les abdominaux. Les ??paules ne d??collent que de quelques centim??tres du sol, et le bas du dos et les hanches restent fixes.");
        values.put("exeVid", "https://www.youtube.com/watch?v=zUk1BiL6Ajc");
        values.put("exeResp", "Inspiration en d??but de mouvement quand la cage thoracique est ouverte. Soufflez en ex??cutant le mouvement et contractez bien vos abdominaux. Le blocage respiratoire doit ??tre ??vit??.");
        values.put("exeConsi", "??vitez de placer vos mains derri??re la t??te, car souvent on s'aide de celle-ci pour faire l'exercice quand on bloque. Cela peut entra??ner des probl??mes aux cervicales. Le plus simple est de maintenir les mains sur les tempes ou sur la poitrine.\n" +
                "\n" +
                "Ne pas d??coller le bas du dos, l'amplitude tr??s r??duite n???enl??ve pas d???efficacit?? ?? l???exercice.\n" +
                "\n" +
                "Le fait de travailler les pieds non bloqu??s, serr??s et les genoux ??cart??s, limite l'activit?? des fl??chisseurs de la hanche, psoas-iliaque et droit ant??rieur, et ??vite bien des tensions et douleurs dans le bas du dos. Si vous avez mal au dos quand vous faites les exercices d'abdos, cet article devrait vous aider : Pourquoi ai-je mal au dos quand je fais les abdos ?");
        values.put("exeConseil", "En tant que muscles posturaux, les abdominaux sont plut??t endurants et pourront ??tre travaill??s en s??ries assez longues. Nous vous sugg??rons des s??ries de 15 ?? 30 r??p??titions, mais si vous pouvez en faire plus, n'h??sitez pas ?? durcir les exercices. Au niveau du planning, 3 s??ances compl??tes d'abdominaux par semaine feront l'affaire. Mais n'oubliez pas de travailler tous les muscles qui composent ce groupe, pas seulement ceux qui sont visibles, en surface ! Je pense notamment au transverse, ne zappez pas le gainage !\n" +
                "On pourra faire les abdominaux en fin de s??ance, de sorte ?? ce qu'ils restent frais pour les exercices globaux o?? ils sont mis ?? contribution.\n" +
                "\n" +
                "Si vous trouvez l'exercice trop facile et que vous pouvez encha??ner des s??ries de plus de 50 r??p??titions, n'h??sitez pas ?? durcir l'exercice en ajoutant de la r??sistance. Pour cela, vous pouvez ??loigner les mains du buste et tendre les bras derri??re la t??te. Vous pouvez bien s??r utiliser des poids, disques ou halt??re, ?? placer sur la poitrine ou derri??re le cou. Cela est particuli??rement valable si l'on souhaite gagner de la masse au niveau de la taille (personnes minces).\n" +
                "\n" +
                "Nous vous rappelons que pour obtenir des abdominaux secs et dessin??s, faire des exercices ne sera pas suffisant. Les exercices permettent de muscler les abdominaux et aident ?? r??duire le tour de taille, notamment par la pratique du gainage. Mais seule la di??te vous d??barassera de la couche de gras qui les recouvre. Pour cela, revoyez votre nutrition et pratiquez r??guli??rement une activit?? a??robie (cardio-training) en plus de la musculation.");
        db.insert("exercice_details", null, values);


        values.put("exeMusc", "Le relev?? de bassin sur plan inclin?? sollicite le grand droit des abdominaux.\n" +
                "Le grand droit, la \"tablette de chocolat\" fait partie de la sangle abdominale avec les obliques et le transverse et permet la flexion du tronc. Les exercices d'abdominaux o?? l???on rel??ve le bassin et les jambes en gardant le buste fixe ont la r??putation de travailler plus le bas des abdominaux. Ceux comme les crunchs o?? l???on enroule la cage thoracique avec les jambes immobiles feraient plus travailler le haut des abdominaux.");
        values.put("exeExe", "Deux variantes l??g??rement diff??rentes sont possibles. On peut le faire sur banc inclin?? et ??galement au sol. Couch?? sur le banc, jambes fl??chies, d??coller les fessiers en enroulant le bas du dos et amener les genoux vers la poitrine. Revenir lentement ?? la position de d??part.");
        values.put("exeVid", "https://www.youtube.com/watch?v=lpxLgh4d-Zg");
        values.put("exeResp", "Inspiration en d??but de mouvement quand la cage thoracique est ouverte.");
        values.put("exeConsi", "Suivant l???inclinaison du banc, il faut veiller ?? ce que les pieds ne touchent jamais le sol. Toujours ralentir l???ex??cution de l???exercice, en ??vitant de cambrer les lombaires quand les jambes redescendent. Pour la version sans banc, mettre un tapis au sol pour ??viter de vous faire mal au bas du dos.");
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
