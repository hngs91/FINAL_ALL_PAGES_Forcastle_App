package com.example.forcastle_app.DatabaseTeam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

//using SQLite database allows the app to be used offline
public class DataBaseHelper extends SQLiteOpenHelper {

    private static DataBaseHelper sInstance;

    public static synchronized DataBaseHelper getInstance(Context context) {
        if(sInstance == null) {
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
        String createTableStatement = "CREATE TABLE TIME_TABLE (COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, COLUMN_JOURNEY_ID TEXT, COLUMN_HOUR INTEGER, COLUMN_MINUTE INTEGER, COLUMN_TOTAL_TIME INTEGER, COLUMN_BUS_NO TEXT)";
        db.execSQL(createTableStatement);

        String addRows = "INSERT INTO TIME_TABLE (COLUMN_ID, COLUMN_JOURNEY_ID, COLUMN_HOUR, COLUMN_MINUTE, COLUMN_TOTAL_TIME, COLUMN_BUS_NO) VALUES (Null, 'NCALN', 7, 23, 443, 'X15 MAX'), (Null, 'NCALN', 8, 38, 518, 'X15 MAX'), (Null, 'NCALN', 9, 38, 578, 'X15 MAX'), (Null, 'NCALN', 10, 38, 638, 'X15 MAX'), (Null, 'NCALN', 11, 38, 698, 'X15 MAX'), (Null, 'NCALN', 12, 38, 758, 'X15 MAX'), (Null, 'NCALN', 13, 38, 818, 'X15 MAX'), (Null, 'NCALN', 14, 43, 883, 'X15 MAX'), (Null, 'NCALN', 15, 48, 948, 'X15 MAX'), (Null, 'NCALN', 16, 48, 1008, 'X15 MAX'), (Null, 'NCALN', 17, 53, 1073, 'X15 MAX'), (Null, 'NCALN', 18, 58, 1138, 'X15 MAX'), (Null, 'NCALN', 19, 58, 1198, 'X15 MAX'), (Null, 'ALNNC', 6, 53, 413, 'X15 MAX'), (Null, 'ALNNC', 7, 53, 473, 'X15 MAX'), (Null, 'ALNNC', 8, 18, 498, 'X15 MAX'), (Null, 'ALNNC', 9, 8, 548, 'X15 MAX'), (Null, 'ALNNC', 10, 3, 603, 'X15 MAX'), (Null, 'ALNNC', 10, 8, 608, 'X15 MAX'), (Null, 'ALNNC', 11, 8, 668, 'X15 MAX'), (Null, 'ALNNC', 12, 3, 723, 'X15 MAX'), (Null, 'ALNNC', 12, 8, 728, 'X15 MAX'), (Null, 'ALNNC', 13, 8, 788, 'X15 MAX'), (Null, 'ALNNC', 14, 3, 843, 'X15 MAX'), (Null, 'ALNNC', 14, 8, 848, 'X15 MAX'), (Null, 'ALNNC', 15, 8, 908, 'X15 MAX'), (Null, 'ALNNC', 16, 13, 973, 'X15 MAX'), (Null, 'ALNNC', 16, 18, 978, 'X15 MAX'), (Null, 'ALNNC', 17, 28, 1048, 'X15 MAX'), (Null, 'ALNNC', 18, 18, 1098, 'X15 MAX'), (Null, 'ALNNC', 18, 28, 1108, 'X15 MAX'), (Null, 'ALNNC', 19, 28, 1168, 'X15 MAX'), (Null, 'ALNNC', 20, 23, 1223, 'X15 MAX'), (Null, 'ALNNC', 20, 28, 1228, 'X15 MAX'), (Null, 'NCBAR1', 7, 17, 437, 'X21'), (Null, 'NCBAR1', 7, 50, 470, 'X21'), (Null, 'NCBAR1', 8, 30, 510, 'X21'), (Null, 'NCBAR1', 9, 5, 545, 'X21'), (Null, 'NCBAR1', 9, 35, 575, 'X21'), (Null, 'NCBAR1', 10, 5, 605, 'X21'), (Null, 'NCBAR1', 10, 35, 635, 'X21'), (Null, 'NCBAR1', 11, 5, 665, 'X21'), (Null, 'NCBAR1', 11, 35, 695, 'X21'), (Null, 'NCBAR1', 12, 5, 725, 'X21'), (Null, 'NCBAR1', 12, 35, 755, 'X21'), (Null, 'NCBAR1', 13, 5, 785, 'X21'), (Null, 'NCBAR1', 13, 35, 815, 'X21'), (Null, 'NCBAR1', 14, 5, 845, 'X21'), (Null, 'NCBAR1', 14, 35, 875, 'X21'), (Null, 'NCBAR1', 15, 5, 905, 'X21'), (Null, 'NCBAR1', 15, 35, 935, 'X21'), (Null, 'NCBAR1', 16, 0, 960, 'X21'), (Null, 'NCBAR1', 16, 20, 980, 'X21'), (Null, 'NCBAR1', 16, 40, 1000, 'X21'), (Null, 'NCBAR1', 17, 0, 1020, 'X21'), (Null, 'NCBAR1', 17, 20, 1040, 'X21'), (Null, 'NCBAR1', 17, 40, 1060, 'X21'), (Null, 'NCBAR1', 18, 10, 1090, 'X21'), (Null, 'NCBAR1', 18, 40, 1120, 'X21'), (Null, 'NCBAR1', 19, 15, 1155, 'X21'), (Null, 'NCBAR1', 20, 15, 1215, 'X21'), (Null, 'NCBAR1', 21, 15, 1275, 'X21'), (Null, 'NCBAR2', 7, 26, 446, '85'), (Null, 'NCBAR2', 10, 39, 639, '85'), (Null, 'NCBAR2', 12, 39, 759, '85'), (Null, 'NCBAR2', 14, 39, 879, '85'), (Null, 'NCBAR2', 15, 42, 942, '85'), (Null, 'NCBAR2', 15, 39, 939, '85'), (Null, 'NCBAR2', 17, 39, 1059, '85'), (Null, 'BARNC1', 6, 58, 418, '85'), (Null, 'BARNC1', 10, 0, 600, '85'), (Null, 'BARNC1', 12, 0, 720, '85'), (Null, 'BARNC1', 14, 0, 840, '85'), (Null, 'BARNC1', 14, 45, 885, '85'), (Null, 'BARNC1', 14, 58, 898, '85'), (Null, 'BARNC1', 17, 0, 1020, '85'), (Null, 'BARNC2', 7, 30, 450, 'X21'), (Null, 'BARNC2', 8, 6, 486, 'X21'), (Null, 'BARNC2', 8, 46, 526, 'X21'), (Null, 'BARNC2', 9, 16, 556, 'X21'), (Null, 'BARNC2', 9, 49, 589, 'X21'), (Null, 'BARNC2', 10, 19, 619, 'X21'), (Null, 'BARNC2', 10, 49, 649, 'X21'), (Null, 'BARNC2', 11, 19, 679, 'X21'), (Null, 'BARNC2', 11, 49, 709, 'X21'), (Null, 'BARNC2', 12, 19, 739, 'X21'), (Null, 'BARNC2', 12, 49, 769, 'X21'), (Null, 'BARNC2', 13, 49, 829, 'X21'), (Null, 'BARNC2', 14, 19, 859, 'X21'), (Null, 'BARNC2', 14, 49, 889, 'X21'), (Null, 'BARNC2', 15, 24, 924, 'X21'), (Null, 'BARNC2', 15, 54, 954, 'X21'), (Null, 'BARNC2', 16, 24, 984, 'X21'), (Null, 'BARNC2', 16, 59, 1019, 'X21'), (Null, 'BARNC2', 17, 29, 1049, 'X21'), (Null, 'NCAUK', 7, 17, 437, 'X21'), (Null, 'NCAUK', 7, 50, 470, 'X21'), (Null, 'NCAUK', 8, 30, 510, 'X21'), (Null, 'NCAUK', 9, 5, 545, 'X21'), (Null, 'NCAUK', 9, 35, 575, 'X21'), (Null, 'NCAUK', 10, 5, 605, 'X21'), (Null, 'NCAUK', 10, 35, 635, 'X21'), (Null, 'NCAUK', 11, 5, 665, 'X21'), (Null, 'NCAUK', 11, 35, 695, 'X21'), (Null, 'NCAUK', 12, 5, 725, 'X21'), (Null, 'NCAUK', 12, 35, 755, 'X21'), (Null, 'NCAUK', 13, 5, 785, 'X21'), (Null, 'NCAUK', 13, 35, 815, 'X21'), (Null, 'NCAUK', 14, 5, 845, 'X21'), (Null, 'NCAUK', 14, 35, 875, 'X21'), (Null, 'NCAUK', 15, 5, 905, 'X21'), (Null, 'NCAUK', 15, 35, 935, 'X21'), (Null, 'NCAUK', 16, 0, 960, 'X21'), (Null, 'NCAUK', 16, 20, 980, 'X21'), (Null, 'NCAUK', 16, 40, 1000, 'X21'), (Null, 'NCAUK', 17, 0, 1020, 'X21'), (Null, 'NCAUK', 17, 20, 1040, 'X21'), (Null, 'NCAUK', 17, 40, 1060, 'X21'), (Null, 'NCAUK', 18, 10, 1090, 'X21'), (Null, 'NCAUK', 18, 40, 1120, 'X21'), (Null, 'NCAUK', 19, 15, 1155, 'X21'), (Null, 'NCAUK', 20, 15, 1215, 'X21'), (Null, 'NCAUK', 21, 15, 1275, 'X21'), (Null, 'AUKNC', 5, 58, 358, 'X21'), (Null, 'AUKNC', 6, 26, 386, 'X21'), (Null, 'AUKNC', 6, 46, 406, 'X21'), (Null, 'AUKNC', 6, 6, 366, 'X21'), (Null, 'AUKNC', 7, 26, 446, 'X21'), (Null, 'AUKNC', 7, 54, 474, 'X21'), (Null, 'AUKNC', 8, 26, 506, 'X21'), (Null, 'AUKNC', 9, 4, 544, 'X21'), (Null, 'AUKNC', 9, 34, 574, 'X21'), (Null, 'AUKNC', 10, 7, 607, 'X21'), (Null, 'AUKNC', 10, 37, 637, 'X21'), (Null, 'AUKNC', 11, 7, 667, 'X21'), (Null, 'AUKNC', 11, 37, 697, 'X21'), (Null, 'AUKNC', 12, 7, 727, 'X21'), (Null, 'AUKNC', 12, 37, 757, 'X21'), (Null, 'AUKNC', 13, 7, 787, 'X21'), (Null, 'AUKNC', 13, 37, 817, 'X21'), (Null, 'AUKNC', 14, 3, 843, 'X21'), (Null, 'AUKNC', 14, 33, 873, 'X21'), (Null, 'AUKNC', 15, 7, 907, 'X21'), (Null, 'AUKNC', 15, 42, 942, 'X21'), (Null, 'AUKNC', 16, 12, 972, 'X21'), (Null, 'AUKNC', 16, 42, 1002, 'X21'), (Null, 'AUKNC', 17, 17, 1037, 'X21'), (Null, 'AUKNC', 17, 45, 1065, 'X21'), (Null, 'AUKNC', 18, 45, 1125, 'X21'), (Null, 'AUKNC', 19, 45, 1185, 'X21'), (Null, 'AUKNC', 20, 45, 1245, 'X21'), (Null, 'AUKNC', 21, 45, 1305, 'X21'), (Null, 'AUKNC', 22, 45, 1365, 'X21'), (Null, 'NCBAM1', 7, 23, 443, 'X15 MAX'), (Null, 'NCBAM1', 8, 38, 518, 'X15 MAX'), (Null, 'NCBAM1', 9, 38, 578, 'X15 MAX'), (Null, 'NCBAM1', 10, 38, 638, 'X15 MAX'), (Null, 'NCBAM1', 11, 38, 698, 'X15 MAX'), (Null, 'NCBAM1', 12, 38, 758, 'X15 MAX'), (Null, 'NCBAM1', 13, 38, 818, 'X15 MAX'), (Null, 'NCBAM1', 14, 43, 883, 'X15 MAX'), (Null, 'NCBAM1', 15, 48, 948, 'X15 MAX'), (Null, 'NCBAM1', 16, 48, 1008, 'X15 MAX'), (Null, 'NCBAM2', 7, 7, 427, 'X18'), (Null, 'NCBAM2', 10, 37, 637, 'X18'), (Null, 'NCBAM2', 14, 37, 877, 'X18'), (Null, 'NCBAM2', 18, 57, 1137, 'X18'), (Null, 'BAMNC1', 9, 1, 541, 'X18'), (Null, 'BAMNC1', 13, 16, 796, 'X18'), (Null, 'BAMNC1', 17, 21, 1041, 'X18'), (Null, 'BAMNC2', 7, 52, 472, 'X15 MAX'), (Null, 'BAMNC2', 9, 37, 577, 'X15 MAX'), (Null, 'BAMNC2', 11, 37, 697, 'X15 MAX'), (Null, 'BAMNC2', 13, 37, 817, 'X15 MAX'), (Null, 'BAMNC2', 15, 47, 947, 'X15 MAX'), (Null, 'BAMNC2', 17, 42, 1062, 'X15 MAX'), (Null, 'BAMNC2', 19, 47, 1187, 'X15 MAX')";
        db.execSQL(addRows);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    //method queries database for the 5 times nearest to the user selected time and puts results into a List
    public List<Integer> outboundTimeListInt(int time, String journey) {

        List<Integer> integerList = new ArrayList<>();

        // query string
        String queryString = "SELECT * FROM TIME_TABLE WHERE COLUMN_TOTAL_TIME>=" + time + " AND COLUMN_JOURNEY_ID='" + journey + "' LIMIT 5";

        //creates readable version of database
        SQLiteDatabase db = this.getReadableDatabase();

        // queries database
        Cursor cursor = db.rawQuery(queryString, null);

        // formats and adds query results to List
        if (cursor.moveToFirst()) {
            do {
                int totalTime = cursor.getInt(4);
                integerList.add(totalTime);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        // if list not populate by 5 bus times, then morning bus times added in
        if (integerList.size() < 5) {
            int i = 5 - integerList.size();
            for (int j = 0; j < i; j++) {
                integerList.add(morningTimeListInt(journey).get(j));
            }
        }
        return integerList;
    }

    //method queries database for the one nearest times of the second bus journey to the arrival of the first bus journey
    public List<Integer> outboundTimeListInt2(int outboundTime1, String journey, int journeyTime1) {

        List<Integer> integerList = new ArrayList<>();

        int arrivalAtChangeBusStop = outboundTime1 + journeyTime1;

        // query string
        String queryString = "SELECT * FROM TIME_TABLE WHERE COLUMN_TOTAL_TIME>=" + arrivalAtChangeBusStop + " AND COLUMN_JOURNEY_ID='" + journey + "' LIMIT 1";

        //creates readable version of database
        SQLiteDatabase db = this.getReadableDatabase();

        // queries database
        Cursor cursor = db.rawQuery(queryString, null);

        // formats and adds query results to List
        if (cursor.moveToFirst()) {
            do {
                int totalTime = cursor.getInt(4);
                integerList.add(totalTime);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return integerList;
    }

    // produces a list of the 5 earliest bus times available
    public List<Integer> morningTimeListInt(String journey) {

        List<Integer> integerList = new ArrayList<>();

        // query string
        String queryString = "SELECT * FROM TIME_TABLE WHERE COLUMN_TOTAL_TIME>=0 AND COLUMN_JOURNEY_ID='" + journey + "' LIMIT 5";

        //creates readable version of database
        SQLiteDatabase db = this.getReadableDatabase();

        // queries database
        Cursor cursor = db.rawQuery(queryString, null);

        // formats and adds query results to List
        if (cursor.moveToFirst()) {
            do {
                int totalTime = cursor.getInt(4);
                integerList.add(totalTime);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return integerList;
    }
}