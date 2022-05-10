package com.example.forcastle_app.DatabaseTeam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
/*
Code implemented by Harry Smith
 */

//using SQLite database allows the app to be used offline
public class DataBaseHelper extends SQLiteOpenHelper {

    /*
    This class has been designed to be a singleton class, i.e., only one DatabaseHelper object can exist.
    This ensures the database is only created once per user experience.
     */

    // private constructor to enforce singelton class
    private static DataBaseHelper sInstance;

    // method used to call an isntance of the class. If an instance doesn't exist it triggers the database being created
    public static synchronized DataBaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DataBaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DataBaseHelper(@Nullable Context context) {
        super(context, "time.db", null, 1);
    }

    // on creation of an object of this class a database table is created and then populated
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE TIME_TABLE (COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, COLUMN_JOURNEY_ID TEXT, COLUMN_TOTAL_TIME INTEGER, COLUMN_PART_OF_WEEK TEXT)";
        db.execSQL(createTableStatement);

        String addRows = "INSERT INTO TIME_TABLE (COLUMN_ID, COLUMN_JOURNEY_ID , COLUMN_TOTAL_TIME , COLUMN_PART_OF_WEEK) VALUES (Null, 'ALNNC', 413, 'weekDay'), (Null, 'ALNNC', 473, 'weekDay'), (Null, 'ALNNC', 498, 'weekDay'), (Null, 'ALNNC', 548, 'weekDay'), (Null, 'ALNNC', 603, 'weekDay'), (Null, 'ALNNC', 608, 'weekDay'), (Null, 'ALNNC', 668, 'weekDay'), (Null, 'ALNNC', 723, 'weekDay'), (Null, 'ALNNC', 728, 'weekDay'), (Null, 'ALNNC', 788, 'weekDay'), (Null, 'ALNNC', 843, 'weekDay'), (Null, 'ALNNC', 848, 'weekDay'), (Null, 'ALNNC', 908, 'weekDay'), (Null, 'ALNNC', 973, 'weekDay'), (Null, 'ALNNC', 978, 'weekDay'), (Null, 'ALNNC', 1048, 'weekDay'), (Null, 'ALNNC', 1098, 'weekDay'), (Null, 'ALNNC', 1108, 'weekDay'), (Null, 'ALNNC', 1168, 'weekDay'), (Null, 'ALNNC', 1223, 'weekDay'), (Null, 'ALNNC', 1228, 'weekDay'), (Null, 'ALNNC', 558, 'Sun'), (Null, 'ALNNC', 678, 'Sun'), (Null, 'ALNNC', 798, 'Sun'), (Null, 'ALNNC', 918, 'Sun'), (Null, 'ALNNC', 1038, 'Sun'), (Null, 'ALNNC', 428, 'Sat'), (Null, 'ALNNC', 483, 'Sat'), (Null, 'ALNNC', 488, 'Sat'), (Null, 'ALNNC', 548, 'Sat'), (Null, 'ALNNC', 603, 'Sat'), (Null, 'ALNNC', 608, 'Sat'), (Null, 'ALNNC', 668, 'Sat'), (Null, 'ALNNC', 723, 'Sat'), (Null, 'ALNNC', 728, 'Sat'), (Null, 'ALNNC', 788, 'Sat'), (Null, 'ALNNC', 843, 'Sat'), (Null, 'ALNNC', 848, 'Sat'), (Null, 'ALNNC', 908, 'Sat'), (Null, 'ALNNC', 973, 'Sat'), (Null, 'ALNNC', 978, 'Sat'), (Null, 'ALNNC', 1048, 'Sat'), (Null, 'ALNNC', 1103, 'Sat'), (Null, 'ALNNC', 1108, 'Sat'), (Null, 'ALNNC', 1168, 'Sat'), (Null, 'ALNNC', 1223, 'Sat'), (Null, 'ALNNC', 1228, 'Sat'), (Null, 'AUKNC', 358, 'weekDay'), (Null, 'AUKNC', 386, 'weekDay'), (Null, 'AUKNC', 406, 'weekDay'), (Null, 'AUKNC', 366, 'weekDay'), (Null, 'AUKNC', 446, 'weekDay'), (Null, 'AUKNC', 474, 'weekDay'), (Null, 'AUKNC', 506, 'weekDay'), (Null, 'AUKNC', 544, 'weekDay'), (Null, 'AUKNC', 574, 'weekDay'), (Null, 'AUKNC', 607, 'weekDay'), (Null, 'AUKNC', 637, 'weekDay'), (Null, 'AUKNC', 667, 'weekDay'), (Null, 'AUKNC', 697, 'weekDay'), (Null, 'AUKNC', 727, 'weekDay'), (Null, 'AUKNC', 757, 'weekDay'), (Null, 'AUKNC', 787, 'weekDay'), (Null, 'AUKNC', 817, 'weekDay'), (Null, 'AUKNC', 843, 'weekDay'), (Null, 'AUKNC', 873, 'weekDay'), (Null, 'AUKNC', 907, 'weekDay'), (Null, 'AUKNC', 942, 'weekDay'), (Null, 'AUKNC', 972, 'weekDay'), (Null, 'AUKNC', 1002, 'weekDay'), (Null, 'AUKNC', 1037, 'weekDay'), (Null, 'AUKNC', 1065, 'weekDay'), (Null, 'AUKNC', 1125, 'weekDay'), (Null, 'AUKNC', 1185, 'weekDay'), (Null, 'AUKNC', 1245, 'weekDay'), (Null, 'AUKNC', 1305, 'weekDay'), (Null, 'AUKNC', 1365, 'weekDay'), (Null, 'AUKNC', 480, 'Sun'), (Null, 'AUKNC', 540, 'Sun'), (Null, 'AUKNC', 600, 'Sun'), (Null, 'AUKNC', 660, 'Sun'), (Null, 'AUKNC', 720, 'Sun'), (Null, 'AUKNC', 780, 'Sun'), (Null, 'AUKNC', 840, 'Sun'), (Null, 'AUKNC', 900, 'Sun'), (Null, 'AUKNC', 960, 'Sun'), (Null, 'AUKNC', 1020, 'Sun'), (Null, 'AUKNC', 1080, 'Sun'), (Null, 'AUKNC', 1140, 'Sun'), (Null, 'AUKNC', 1200, 'Sun'), (Null, 'AUKNC', 1265, 'Sun'), (Null, 'AUKNC', 424, 'Sat'), (Null, 'AUKNC', 464, 'Sat'), (Null, 'AUKNC', 489, 'Sat'), (Null, 'AUKNC', 519, 'Sat'), (Null, 'AUKNC', 547, 'Sat'), (Null, 'AUKNC', 577, 'Sat'), (Null, 'AUKNC', 607, 'Sat'), (Null, 'AUKNC', 637, 'Sat'), (Null, 'AUKNC', 667, 'Sat'), (Null, 'AUKNC', 697, 'Sat'), (Null, 'AUKNC', 727, 'Sat'), (Null, 'AUKNC', 757, 'Sat'), (Null, 'AUKNC', 787, 'Sat'), (Null, 'AUKNC', 817, 'Sat'), (Null, 'AUKNC', 847, 'Sat'), (Null, 'AUKNC', 877, 'Sat'), (Null, 'AUKNC', 937, 'Sat'), (Null, 'AUKNC', 967, 'Sat'), (Null, 'AUKNC', 997, 'Sat'), (Null, 'AUKNC', 1027, 'Sat'), (Null, 'AUKNC', 1061, 'Sat'), (Null, 'AUKNC', 1121, 'Sat'), (Null, 'AUKNC', 1185, 'Sat'), (Null, 'AUKNC', 1245, 'Sat'), (Null, 'AUKNC', 1305, 'Sat'), (Null, 'AUKNC', 1365, 'Sat'), (Null, 'BAMNC1', 541, 'weekDay'), (Null, 'BAMNC1', 796, 'weekDay'), (Null, 'BAMNC1', 1041, 'weekDay'), (Null, 'BAMNC2', 472, 'weekDay'), (Null, 'BAMNC2', 577, 'weekDay'), (Null, 'BAMNC2', 697, 'weekDay'), (Null, 'BAMNC2', 817, 'weekDay'), (Null, 'BAMNC2', 937, 'weekDay'), (Null, 'BAMNC2', 1072, 'weekDay'), (Null, 'BAMNC2', 1197, 'weekDay'), (Null, 'BAMNC2', 662, 'Sun'), (Null, 'BAMNC2', 902, 'Sun'), (Null, 'BAMNC2', 1152, 'Sun'), (Null, 'BAMNC2', 457, 'Sat'), (Null, 'BAMNC2', 577, 'Sat'), (Null, 'BAMNC2', 697, 'Sat'), (Null, 'BAMNC2', 817, 'Sat'), (Null, 'BAMNC2', 947, 'Sat'), (Null, 'BAMNC2', 1077, 'Sat'), (Null, 'BAMNC2', 1197, 'Sat'), (Null, 'BARNC1', 418, 'weekDay'), (Null, 'BARNC1', 600, 'weekDay'), (Null, 'BARNC1', 720, 'weekDay'), (Null, 'BARNC1', 840, 'weekDay'), (Null, 'BARNC1', 885, 'weekDay'), (Null, 'BARNC1', 898, 'weekDay'), (Null, 'BARNC1', 1020, 'weekDay'), (Null, 'BARNC1', 600, 'Sat'), (Null, 'BARNC1', 720, 'Sat'), (Null, 'BARNC1', 840, 'Sat'), (Null, 'BARNC1', 898, 'Sat'), (Null, 'BARNC1', 1020, 'Sat'), (Null, 'BARNC2', 450, 'weekDay'), (Null, 'BARNC2', 486, 'weekDay'), (Null, 'BARNC2', 526, 'weekDay'), (Null, 'BARNC2', 556, 'weekDay'), (Null, 'BARNC2', 589, 'weekDay'), (Null, 'BARNC2', 619, 'weekDay'), (Null, 'BARNC2', 649, 'weekDay'), (Null, 'BARNC2', 679, 'weekDay'), (Null, 'BARNC2', 709, 'weekDay'), (Null, 'BARNC2', 739, 'weekDay'), (Null, 'BARNC2', 769, 'weekDay'), (Null, 'BARNC2', 829, 'weekDay'), (Null, 'BARNC2', 859, 'weekDay'), (Null, 'BARNC2', 889, 'weekDay'), (Null, 'BARNC2', 924, 'weekDay'), (Null, 'BARNC2', 954, 'weekDay'), (Null, 'BARNC2', 984, 'weekDay'), (Null, 'BARNC2', 1019, 'weekDay'), (Null, 'BARNC2', 1049, 'weekDay'), (Null, 'BARNC2', 472, 'Sat'), (Null, 'BARNC2', 529, 'Sat'), (Null, 'BARNC2', 559, 'Sat'), (Null, 'BARNC2', 589, 'Sat'), (Null, 'BARNC2', 619, 'Sat'), (Null, 'BARNC2', 649, 'Sat'), (Null, 'BARNC2', 679, 'Sat'), (Null, 'BARNC2', 709, 'Sat'), (Null, 'BARNC2', 739, 'Sat'), (Null, 'BARNC2', 769, 'Sat'), (Null, 'BARNC2', 799, 'Sat'), (Null, 'BARNC2', 829, 'Sat'), (Null, 'BARNC2', 859, 'Sat'), (Null, 'BARNC2', 889, 'Sat'), (Null, 'BARNC2', 919, 'Sat'), (Null, 'BARNC2', 949, 'Sat'), (Null, 'BARNC2', 979, 'Sat'), (Null, 'BARNC2', 1009, 'Sat'), (Null, 'BARNC2', 1043, 'Sat'), (Null, 'BARNC2', 1103, 'Sat'), (Null, 'NCALN', 443, 'weekDay'), (Null, 'NCALN', 518, 'weekDay'), (Null, 'NCALN', 578, 'weekDay'), (Null, 'NCALN', 638, 'weekDay'), (Null, 'NCALN', 698, 'weekDay'), (Null, 'NCALN', 758, 'weekDay'), (Null, 'NCALN', 818, 'weekDay'), (Null, 'NCALN', 883, 'weekDay'), (Null, 'NCALN', 948, 'weekDay'), (Null, 'NCALN', 1008, 'weekDay'), (Null, 'NCALN', 1073, 'weekDay'), (Null, 'NCALN', 1138, 'weekDay'), (Null, 'NCALN', 1198, 'weekDay'), (Null, 'NCALN', 588, 'Sun'), (Null, 'NCALN', 708, 'Sun'), (Null, 'NCALN', 828, 'Sun'), (Null, 'NCALN', 948, 'Sun'), (Null, 'NCALN', 1073, 'Sun'), (Null, 'NCALN', 518, 'Sat'), (Null, 'NCALN', 578, 'Sat'), (Null, 'NCALN', 638, 'Sat'), (Null, 'NCALN', 698, 'Sat'), (Null, 'NCALN', 758, 'Sat'), (Null, 'NCALN', 818, 'Sat'), (Null, 'NCALN', 883, 'Sat'), (Null, 'NCALN', 948, 'Sat'), (Null, 'NCALN', 1013, 'Sat'), (Null, 'NCALN', 1078, 'Sat'), (Null, 'NCALN', 1138, 'Sat'), (Null, 'NCALN', 1198, 'Sat'), (Null, 'NCAUK', 437, 'weekDay'), (Null, 'NCAUK', 470, 'weekDay'), (Null, 'NCAUK', 510, 'weekDay'), (Null, 'NCAUK', 545, 'weekDay'), (Null, 'NCAUK', 575, 'weekDay'), (Null, 'NCAUK', 605, 'weekDay'), (Null, 'NCAUK', 635, 'weekDay'), (Null, 'NCAUK', 665, 'weekDay'), (Null, 'NCAUK', 695, 'weekDay'), (Null, 'NCAUK', 725, 'weekDay'), (Null, 'NCAUK', 755, 'weekDay'), (Null, 'NCAUK', 785, 'weekDay'), (Null, 'NCAUK', 815, 'weekDay'), (Null, 'NCAUK', 845, 'weekDay'), (Null, 'NCAUK', 875, 'weekDay'), (Null, 'NCAUK', 905, 'weekDay'), (Null, 'NCAUK', 935, 'weekDay'), (Null, 'NCAUK', 960, 'weekDay'), (Null, 'NCAUK', 980, 'weekDay'), (Null, 'NCAUK', 1000, 'weekDay'), (Null, 'NCAUK', 1020, 'weekDay'), (Null, 'NCAUK', 1040, 'weekDay'), (Null, 'NCAUK', 1060, 'weekDay'), (Null, 'NCAUK', 1090, 'weekDay'), (Null, 'NCAUK', 1120, 'weekDay'), (Null, 'NCAUK', 1155, 'weekDay'), (Null, 'NCAUK', 1215, 'weekDay'), (Null, 'NCAUK', 1275, 'weekDay'), (Null, 'NCAUK', 572, 'Sun'), (Null, 'NCAUK', 632, 'Sun'), (Null, 'NCAUK', 692, 'Sun'), (Null, 'NCAUK', 752, 'Sun'), (Null, 'NCAUK', 812, 'Sun'), (Null, 'NCAUK', 872, 'Sun'), (Null, 'NCAUK', 932, 'Sun'), (Null, 'NCAUK', 992, 'Sun'), (Null, 'NCAUK', 1052, 'Sun'), (Null, 'NCAUK', 1112, 'Sun'), (Null, 'NCAUK', 1170, 'Sun'), (Null, 'NCAUK', 485, 'Sat'), (Null, 'NCAUK', 515, 'Sat'), (Null, 'NCAUK', 575, 'Sat'), (Null, 'NCAUK', 605, 'Sat'), (Null, 'NCAUK', 635, 'Sat'), (Null, 'NCAUK', 665, 'Sat'), (Null, 'NCAUK', 695, 'Sat'), (Null, 'NCAUK', 725, 'Sat'), (Null, 'NCAUK', 755, 'Sat'), (Null, 'NCAUK', 785, 'Sat'), (Null, 'NCAUK', 815, 'Sat'), (Null, 'NCAUK', 845, 'Sat'), (Null, 'NCAUK', 875, 'Sat'), (Null, 'NCAUK', 905, 'Sat'), (Null, 'NCAUK', 935, 'Sat'), (Null, 'NCAUK', 965, 'Sat'), (Null, 'NCAUK', 995, 'Sat'), (Null, 'NCAUK', 1025, 'Sat'), (Null, 'NCAUK', 1055, 'Sat'), (Null, 'NCAUK', 1095, 'Sat'), (Null, 'NCAUK', 1155, 'Sat'), (Null, 'NCAUK', 1215, 'Sat'), (Null, 'NCAUK', 1275, 'Sat'), (Null, 'NCBAM1', 443, 'weekDay'), (Null, 'NCBAM1', 518, 'weekDay'), (Null, 'NCBAM1', 578, 'weekDay'), (Null, 'NCBAM1', 638, 'weekDay'), (Null, 'NCBAM1', 698, 'weekDay'), (Null, 'NCBAM1', 758, 'weekDay'), (Null, 'NCBAM1', 818, 'weekDay'), (Null, 'NCBAM1', 883, 'weekDay'), (Null, 'NCBAM1', 948, 'weekDay'), (Null, 'NCBAM1', 1008, 'weekDay'), (Null, 'NCBAM1', 1073, 'weekDay'), (Null, 'NCBAM1', 1138, 'weekDay'), (Null, 'NCBAM1', 1198, 'weekDay'), (Null, 'NCBAM1', 518, 'Sat'), (Null, 'NCBAM1', 578, 'Sat'), (Null, 'NCBAM1', 638, 'Sat'), (Null, 'NCBAM1', 698, 'Sat'), (Null, 'NCBAM1', 758, 'Sat'), (Null, 'NCBAM1', 818, 'Sat'), (Null, 'NCBAM1', 883, 'Sat'), (Null, 'NCBAM1', 948, 'Sat'), (Null, 'NCBAM1', 1013, 'Sat'), (Null, 'NCBAM1', 1078, 'Sat'), (Null, 'NCBAM1', 1138, 'Sat'), (Null, 'NCBAM1', 1198, 'Sat'), (Null, 'NCBAM1', 588, 'Sun'), (Null, 'NCBAM1', 708, 'Sun'), (Null, 'NCBAM1', 828, 'Sun'), (Null, 'NCBAM1', 948, 'Sun'), (Null, 'NCBAM1', 1073, 'Sun'), (Null, 'NCBAM2', 427, 'weekDay'), (Null, 'NCBAM2', 637, 'weekDay'), (Null, 'NCBAM2', 877, 'weekDay'), (Null, 'NCBAM2', 1137, 'weekDay'), (Null, 'NCBAR1', 437, 'weekDay'), (Null, 'NCBAR1', 470, 'weekDay'), (Null, 'NCBAR1', 510, 'weekDay'), (Null, 'NCBAR1', 545, 'weekDay'), (Null, 'NCBAR1', 575, 'weekDay'), (Null, 'NCBAR1', 605, 'weekDay'), (Null, 'NCBAR1', 635, 'weekDay'), (Null, 'NCBAR1', 665, 'weekDay'), (Null, 'NCBAR1', 695, 'weekDay'), (Null, 'NCBAR1', 725, 'weekDay'), (Null, 'NCBAR1', 755, 'weekDay'), (Null, 'NCBAR1', 785, 'weekDay'), (Null, 'NCBAR1', 815, 'weekDay'), (Null, 'NCBAR1', 845, 'weekDay'), (Null, 'NCBAR1', 875, 'weekDay'), (Null, 'NCBAR1', 905, 'weekDay'), (Null, 'NCBAR1', 935, 'weekDay'), (Null, 'NCBAR1', 960, 'weekDay'), (Null, 'NCBAR1', 980, 'weekDay'), (Null, 'NCBAR1', 1000, 'weekDay'), (Null, 'NCBAR1', 1020, 'weekDay'), (Null, 'NCBAR1', 1040, 'weekDay'), (Null, 'NCBAR1', 1060, 'weekDay'), (Null, 'NCBAR1', 1090, 'weekDay'), (Null, 'NCBAR1', 1120, 'weekDay'), (Null, 'NCBAR1', 1155, 'weekDay'), (Null, 'NCBAR1', 1215, 'weekDay'), (Null, 'NCBAR1', 1275, 'weekDay'), (Null, 'NCBAR1', 572, 'Sun'), (Null, 'NCBAR1', 632, 'Sun'), (Null, 'NCBAR1', 692, 'Sun'), (Null, 'NCBAR1', 752, 'Sun'), (Null, 'NCBAR1', 812, 'Sun'), (Null, 'NCBAR1', 872, 'Sun'), (Null, 'NCBAR1', 932, 'Sun'), (Null, 'NCBAR1', 992, 'Sun'), (Null, 'NCBAR1', 1052, 'Sun'), (Null, 'NCBAR1', 1112, 'Sun'), (Null, 'NCBAR1', 1170, 'Sun'), (Null, 'NCBAR1', 485, 'Sat'), (Null, 'NCBAR1', 515, 'Sat'), (Null, 'NCBAR1', 575, 'Sat'), (Null, 'NCBAR1', 605, 'Sat'), (Null, 'NCBAR1', 635, 'Sat'), (Null, 'NCBAR1', 665, 'Sat'), (Null, 'NCBAR1', 695, 'Sat'), (Null, 'NCBAR1', 725, 'Sat'), (Null, 'NCBAR1', 755, 'Sat'), (Null, 'NCBAR1', 785, 'Sat'), (Null, 'NCBAR1', 815, 'Sat'), (Null, 'NCBAR1', 845, 'Sat'), (Null, 'NCBAR1', 875, 'Sat'), (Null, 'NCBAR1', 905, 'Sat'), (Null, 'NCBAR1', 935, 'Sat'), (Null, 'NCBAR1', 965, 'Sat'), (Null, 'NCBAR1', 995, 'Sat'), (Null, 'NCBAR1', 1025, 'Sat'), (Null, 'NCBAR1', 1055, 'Sat'), (Null, 'NCBAR1', 1095, 'Sat'), (Null, 'NCBAR1', 1155, 'Sat'), (Null, 'NCBAR1', 1215, 'Sat'), (Null, 'NCBAR1', 1275, 'Sat'), (Null, 'NCBAR2', 480, 'weekDay'), (Null, 'NCBAR2', 557, 'weekDay'), (Null, 'NCBAR2', 677, 'weekDay'), (Null, 'NCBAR2', 793, 'weekDay'), (Null, 'NCBAR2', 902, 'weekDay'), (Null, 'NCBAR2', 1007, 'weekDay'), (Null, 'NCBAR2', 1081, 'weekDay'), (Null, 'NCBAR2', 480, 'Sat'), (Null, 'NCBAR2', 557, 'Sat'), (Null, 'NCBAR2', 677, 'Sat'), (Null, 'NCBAR2', 797, 'Sat'), (Null, 'NCBAR2', 902, 'Sat'), (Null, 'NCBAR2', 1007, 'Sat'), (Null, 'NCBAM2', 637, 'Sat'), (Null, 'NCBAM2', 877, 'Sat'), (Null, 'NCBAM2', 1117, 'Sat'), (Null, 'NCBAM2', 647, 'Sun'), (Null, 'NCBAM2', 887, 'Sun'), (Null, 'NCBAM2', 1127, 'Sun'), (Null, 'BAMNC1', 566, 'Sun'), (Null, 'BAMNC1', 806, 'Sun'), (Null, 'BAMNC1', 1046, 'Sun'), (Null, 'BAMNC1', 541, 'Sat'), (Null, 'BAMNC1', 796, 'Sat'), (Null, 'BAMNC1', 1046, 'Sat')";
        db.execSQL(addRows);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    //method queries database for the 5 times nearest to the user selected time and outputs the results as a  List
    public List<Integer> bus1LeaveTimes(int time, String journey, String partOfWeek) {

        List<Integer> integerList = new ArrayList<>();

        // query string
        String queryString = "SELECT * FROM TIME_TABLE WHERE COLUMN_TOTAL_TIME>=" + time + " AND COLUMN_PART_OF_WEEK='" + partOfWeek + "' AND COLUMN_JOURNEY_ID='" + journey + "' LIMIT 5";

        //creates readable version of database
        SQLiteDatabase db = this.getReadableDatabase();

        // queries database
        Cursor cursor = db.rawQuery(queryString, null);

        // formats and adds query results to List
        if (cursor.moveToFirst()) {
            do {
                int totalTime = cursor.getInt(2);
                integerList.add(totalTime);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return integerList;
    }

    //method queries database for the one nearest times of the second bus journey to the arrival of the first bus journey
    public int bus2LeaveTime(int bus1ArrivalTime, String journey, String partOfWeek) {

        int bus2Leave = 0;

        // query string
        String queryString = "SELECT * FROM TIME_TABLE WHERE COLUMN_TOTAL_TIME>=" + bus1ArrivalTime + " AND COLUMN_PART_OF_WEEK='" + partOfWeek + "' AND COLUMN_JOURNEY_ID='" + journey + "' LIMIT 1";

        //creates readable version of database
        SQLiteDatabase db = this.getReadableDatabase();

        // queries database
        Cursor cursor = db.rawQuery(queryString, null);

        // formats and adds query results to List
        if (cursor.moveToFirst()) {
            do {
                bus2Leave = cursor.getInt(2);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return bus2Leave;
    }
}