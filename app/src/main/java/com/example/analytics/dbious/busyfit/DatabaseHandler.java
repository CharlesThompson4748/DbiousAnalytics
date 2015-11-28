package com.example.analytics.dbious.busyfit;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "LazyFit";

    //Tables
    private static final String TABLE_BUSYFITUSER = "BusyFitUser";
    private static final String TABLE_CALORIE_INTAKE = "Calorie_Intake";
    private static final String TABLE_MUSCLE_GROUP = "Muscle_Group";
    private static final String TABLE_USER_DIET = "User_Diet";
    private static final String TABLE_USER_WORKOUT = "User_Workout";
    private static final String TABLE_WORKOUT = "Workout";
    private static final String TABLE_WORKOUT_SCHEDULE = "Workout_Schedule";
    private static final String TABLE_RECIPE = "Recipe";
    private static final String TABLE_RECIPE_VIDEO = "Recipe_Video";

    //Common Columns
    private static final String KEY_USERID = "userID";
    private static final String KEY_FOODID = "foodID";
    private static final String KEY_WORKOUTID = "workoutID";
    private static final String KEY_NAME = "name";

    //Columns - BusyFitUser
    ////private static final String KEY_USERID = "userID";
    private static final String KEY_FNAME = "fname";
    private static final String KEY_LNAME = "lname";
    private static final String KEY_EMAIL = "email";

    //Columns - Calorie_Intake
    ////private static final String KEY_FOODID = "foodID";
    private static final String KEY_FOODNAME = "foodName";
    private static final String KEY_UPC = "UPC";
    private static final String KEY_DATE = "date";
    private static final String KEY_CALORIES = "calories";
    private static final String KEY_PROTEIN = "protein";
    private static final String KEY_CARBS = "carbs";

    //Columns - Muscle_Group
    private static final String KEY_MUSCLEID = "muscleID";
    private static final String KEY_MUSCLEGROUP = "muscleGroup";

    //Columns - User_Diet
    ////private static final String KEY_USERID = "userID";
    ////private static final String KEY_FOODID = "foodID";

    //Columns - User_Workout
    ////private static final String KEY_USERID = "userID";
    ////private static final String KEY_WORKOUTID = "workoutID";

    //Columns - Workout
    ////private static final String KEY_WORKOUTID = "workoutID";
    private static final String KEY_WORKOUTNAME = "name";
    private static final String KEY_WOSCHEDID = "WOSchedID";
    private static final String KEY_TIME = "time";
    private static final String KEY_CALPERTIME = "calPerTime";

    //Columns - Workout_Schedule
    //private static final String KEY_WORKOUTID = "workoutID";
    private static final String KEY_WORKOUTSCHEDULENAME = "name";
    private static final String KEY_WEEKPART = "weekPart";
    private static final String KEY_DAYPART = "dayPart";
    private static final String KEY_HOURPART = "hourPart";
    private static final String KEY_MUSCLEGROUPID1 = "muscleGroupID1";
    private static final String KEY_MUSCLEGROUPID2 = "muscleGroupID2";
    //private static final String KEY_CALPERTIME = "calPerTime";
    private static final String KEY_DESC = "desc";

    //Columns - Recipe
    private static final String KEY_RECIPESID = "recipesID";
    //private static final String KEY_NAME = "name";
    //private static final String KEY_CALORIES = "calories";
    //private static final String KEY_PROTEIN = "protein";
    //private static final String KEY_CARBS = "carbs";
    private static final String KEY_INSTRUCTIONS = "instructions";


    //Columns - Recipe_Video
    private static final String KEY_RECIPEID = "recipeID";
    private static final String KEY_VIDEOURL = "videoURL";

    // Table Create Statements
    private static final String CREATE_TABLE_BUSYFITUSER = "CREATE TABLE "
            + TABLE_BUSYFITUSER + "("
            + KEY_USERID + " INTEGER PRIMARY KEY NOT NULL,"
            + KEY_FNAME + " TEXT,"
            + KEY_LNAME + " TEXT,"
            + KEY_EMAIL + " TEXT"
            + ")";
    private static final String CREATE_TABLE_CALORIEINTAKE = "CREATE TABLE "
            + TABLE_CALORIE_INTAKE + "("
            + KEY_FOODID + " INTEGER PRIMARY KEY NOT NULL,"
            + KEY_FOODNAME + " TEXT,"
            + KEY_UPC + " TEXT,"
            + KEY_DATE + " DATETIME,"
            + KEY_CALORIES + " INTEGER,"
            + KEY_PROTEIN + " INTEGER,"
            + KEY_CARBS + " INTEGER"
            + ")";
    private static final String CREATE_TABLE_MUSCLEGROUP = "CREATE TABLE "
            + TABLE_MUSCLE_GROUP + "("
            + KEY_MUSCLEID + " INTEGER PRIMARY KEY NOT NULL,"
            + KEY_MUSCLEGROUP + " TEXT"
            + ")";
    private static final String CREATE_TABLE_USERDIET = "CREATE TABLE "
            + TABLE_USER_DIET + "("
            + KEY_USERID + " INTEGER PRIMARY KEY NOT NULL,"
            + KEY_FOODID + " INTEGER,"
            + " FOREIGN KEY(" + KEY_USERID + ") REFERENCES " + TABLE_BUSYFITUSER + "(" + KEY_USERID + "),"
            + " FOREIGN KEY(" + KEY_FOODID + ") REFERENCES " + TABLE_CALORIE_INTAKE + "(" + KEY_FOODID + ")"
            + ")";
    private static final String CREATE_TABLE_WORKOUT = "CREATE TABLE "
            + TABLE_WORKOUT + "("
            + KEY_WORKOUTID + " INTEGER PRIMARY KEY,"
            + KEY_WORKOUTNAME + " TEXT,"
            + KEY_WOSCHEDID + " INTEGER,"
            + KEY_TIME + " DATETIME,"
            + KEY_CALPERTIME + " INTEGER,"
            + " FOREIGN KEY(" + KEY_WORKOUTID + ") REFERENCES " + TABLE_USER_WORKOUT + "(" + KEY_WORKOUTID + ")"
            + ")";
    private static final String CREATE_TABLE_USERWORKOUT = "CREATE TABLE "
            + TABLE_USER_WORKOUT + "("
            + KEY_USERID + " INTEGER PRIMARY KEY,"
            + KEY_WORKOUTID + " INTEGER,"
            + " FOREIGN KEY(" + KEY_USERID + ") REFERENCES " + TABLE_BUSYFITUSER + "(" + KEY_USERID + "),"
            + " FOREIGN KEY(" + KEY_WORKOUTID + ") REFERENCES " + TABLE_WORKOUT + "(" + KEY_WORKOUTID + ")"
            + ")";
    private static final String CREATE_TABLE_WORKOUTSCHEDULE = "CREATE TABLE "
            + TABLE_WORKOUT_SCHEDULE + "("
            + KEY_WORKOUTID + " INTEGER PRIMARY KEY,"
            + KEY_WORKOUTSCHEDULENAME + " TEXT,"
            + KEY_WEEKPART + " TEXT,"
            + KEY_DAYPART + " INTEGER,"
            + KEY_HOURPART + " INTEGER,"
            + KEY_MUSCLEGROUPID1 + " INTEGER,"
            + KEY_MUSCLEGROUPID2 + " INTEGER,"
            + KEY_CALPERTIME + " INTEGER,"
            + KEY_DESC + " TEXT"
            + ")";
    private static final String CREATE_TABLE_RECIPE = "CREATE TABLE "
            + TABLE_RECIPE + "("
            + KEY_RECIPESID +  " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_CALORIES + " INTEGER,"
            + KEY_PROTEIN + " INTEGER,"
            + KEY_CARBS + " INTEGER,"
            + KEY_INSTRUCTIONS + " TEXT"
            + ")";
    private static final String CREATE_TABLE_RECIPE_VIDEO = "CREATE TABLE "
            + TABLE_RECIPE_VIDEO + "("
            + KEY_RECIPEID + " INTEGER PRIMARY KEY,"
            + KEY_VIDEOURL + " TEXT"
            + ")";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Define Creates
    public boolean createBusyFitUser(BusyFitUser entry) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(KEY_FNAME, entry.getFName());
            values.put(KEY_LNAME, entry.getLName());
            values.put(KEY_EMAIL, entry.getEmail());

            db.insert(TABLE_BUSYFITUSER, null, values);
            db.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public boolean createCalorieIntake(CalorieIntake entry) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(KEY_FOODNAME, entry.getFoodName());
            values.put(KEY_UPC, entry.getUPC());
            values.put(KEY_DATE, entry.getDate());
            values.put(KEY_CALORIES, entry.getCalories());
            values.put(KEY_PROTEIN, entry.getProtein());
            values.put(KEY_CARBS, entry.getCarbs());

            db.insert(TABLE_CALORIE_INTAKE, null, values);
            db.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public boolean createMuscleGroup(MuscleGroup entry) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(KEY_MUSCLEID, entry.getMuscleID());
            values.put(KEY_MUSCLEGROUP, entry.getMuscleGroup());

            db.insert(TABLE_MUSCLE_GROUP, null, values);
            db.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public boolean createUserDiet(UserDiet entry) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(KEY_USERID, entry.getUserID());
            values.put(KEY_FOODID, entry.getFoodID());

            db.insert(TABLE_USER_DIET, null, values);
            db.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public boolean createUserWorkout(UserWorkout entry) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(KEY_USERID, entry.getUserID());
            values.put(KEY_WORKOUTID, entry.getWorkoutID());

            db.insert(TABLE_USER_WORKOUT, null, values);
            db.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public boolean createWorkout(Workout entry) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(KEY_WORKOUTNAME, entry.getName());
            values.put(KEY_WOSCHEDID, entry.getWOSchedID());
            values.put(KEY_TIME, entry.getTime());
            values.put(KEY_CALPERTIME, entry.getCalPerTime());

            db.insert(TABLE_WORKOUT, null, values);
            db.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public boolean createWorkoutSchedule(WorkoutSchedule entry) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(KEY_WORKOUTSCHEDULENAME, entry.getName());
            values.put(KEY_WEEKPART, entry.getWeekPart());
            values.put(KEY_DAYPART, entry.getDayPart());
            values.put(KEY_HOURPART, entry.getHourPart());
            values.put(KEY_MUSCLEGROUPID1, entry.getMuscleGroupID1());
            values.put(KEY_MUSCLEGROUPID2, entry.getMuscleGroupID2());
            values.put(KEY_DESC, entry.getDesc());

            db.insert(TABLE_WORKOUT_SCHEDULE, null, values);
            db.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    /*
    public boolean createRecipe(Recipe entry)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(KEY_RECIPESID, entry.getRecipesID());
            values.put(KEY_NAME, entry.getName());
            values.put(KEY_CALORIES, entry.getCalories());
            values.put(KEY_PROTEIN, entry.getProtein());
            values.put(KEY_CARBS, entry.getCarbs());
            values.put(KEY_INSTRUCTIONS, entry.getInstructions());

            db.insert(TABLE_RECIPE, null, values);
            db.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }*/
    /*public boolean createRecipeVideo(RecipeVideo entry)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(KEY_RECIPEID, entry.getRecipeId());
            values.put(KEY_VIDEOURL, entry.getVideoUrl());

            db.insert(TABLE_RECIPE_VIDEO, null, values);
            db.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }*/

    //Get all workout schedule entries in a List Array
    public List<WorkoutSchedule> getAllWorkoutScheduleEntries()
    {
        List<WorkoutSchedule> entriesList = new ArrayList<WorkoutSchedule>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_WORKOUT_SCHEDULE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                WorkoutSchedule entry = new WorkoutSchedule();
                entry.setId(Integer.parseInt(cursor.getString(0)));
                entry.setName(cursor.getString(1));
                entry.setWeekPart(Integer.parseInt(cursor.getString(2)));
                entry.setDayPart(Integer.parseInt(cursor.getString(3)));
                entry.setHourPart(Integer.parseInt(cursor.getString(4)));
                entry.setMuscleGroupID1(Integer.parseInt(cursor.getString(5)));
                entry.setMuscleGroupID2(Integer.parseInt(cursor.getString(6)));
                entry.setDesc(cursor.getString(7));

                entriesList.add(entry);
            } while (cursor.moveToNext());
        }

        return entriesList;
    }


    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BUSYFITUSER);
        db.execSQL(CREATE_TABLE_CALORIEINTAKE);
        db.execSQL(CREATE_TABLE_MUSCLEGROUP);
        db.execSQL(CREATE_TABLE_USERDIET);
        db.execSQL(CREATE_TABLE_WORKOUT);
        db.execSQL(CREATE_TABLE_USERWORKOUT);
        db.execSQL(CREATE_TABLE_WORKOUTSCHEDULE);
        db.execSQL(CREATE_TABLE_RECIPE);
        db.execSQL(CREATE_TABLE_RECIPE_VIDEO);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUSYFITUSER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALORIE_INTAKE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MUSCLE_GROUP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_DIET);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_WORKOUT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUT_SCHEDULE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE_VIDEO);

        // Create tables again
        onCreate(db);

    }
}