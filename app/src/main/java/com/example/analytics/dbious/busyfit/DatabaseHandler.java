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

    private static final String DATABASE_NAME = "BusyFit";

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

    private static final String[] INSERT_RECIPE = {
            "INSERT INTO RECIPE (recipesID, name, calories, protein, carb, instructions) VALUES (2001, 'Garlic & Chilli Zucchini Pasta', NULL, NULL, NULL, 'INGREDIENTS (Serves 2)\\\\n 1) 2 medium Zucchinis\\\\n 2) 2 Garlic cloves\\\\n 3) ½ cup fresh Basil Leaves\\\\n 4) 2 tsp. Olive Oil\\\\n 5) Juice from ½ Lemon\\\\n 6) Salt & Pepper, to taste\\\\n 7) 1 pinch Red Chilli Flakes\\\\n 8) 10 Shrimps\\\\n 9) 4 pieces Ham / Chicken Rolls\\\\n 10) A handful of Cherry Tomatoes\\\\n 11) 1 tbsp. Parmesan Cheese\\\\n\\\\r');",
            "INSERT INTO RECIPE (recipesID, name, calories, protein, carb, instructions) VALUES (2002, 'DIY Chipotle Burrito Bowl', 400, 40, 50, 'Ingredients\\\\n Cilantro Lime Rice\\\\n 2 cups brown rice\\\\n 2 bay leaves\\\\n salt for cooking\\\\n 2 tbsp fresh cilantro\\\\n 1 tbsp lemon juice\\\\n 1 tbsp lime juice\\\\n Garlic Beans\\\\n 1 can black or pinto beans\\\\n 1 garlic clove\\\\n ½ tsp dry oregano\\\\n ¼ tsp cumin\\\\n dash of chipotle pepper (optional)\\\\n Vegetables\\\\n 1 green bell pepper\\\\n 1 red bell pepper\\\\n 1 medium red onion\\\\n 1 tsp dry oregano\\\\n ½ tbsp grapeseed oil\\\\n ¼ tsp red pepper flakes (optional)\\\\n ½ tsp salt\\\\n ¼ tsp pepper\\\\n Toppings\\\\n fresh salsa\\\\n guacamole\\\\n vegan cheese\\\\n shredded lettuce\\\\n\\\\n Directions\\\\n Cilantro Lime Rice\\\\n Cook the rice according to the directions on the package (usually for 40-45 minutes). Before water starts to boil add salt and bay leaves.\\\\n Once the rice is cooked, place in a large bowl and add lemon juice, lime juice and cilantro. Mix well.\\\\n Garlic Beans\\\\n Combine all ingredients in a small pot and heat over medium heat for 5 minutes.\\\\n Vegetables\\\\n Cut peppers and onion into strings.\\\\n Heat oil in a large skillet.\\\\n Add red onion to the skillet and sauté for 3 minutes over medium/high heat.\\\\n Add cut peppers and cook for 5 more minutes.\\\\n Add the seasoning and continue cooking until the vegetables are soft (about 2 minutes).\\\\n Burrito Bowls\\\\n To assemble the bowls, simply divide the rice, beans and vegetables between 4 bowls and add the toppings.\\\\n');",
            "INSERT INTO RECIPE (recipesID, name, calories, protein, carb, instructions) VALUES (2003, 'Seven Layer Salad Recipe', 300, 25, 15, NULL);",
            "INSERT INTO RECIPE (recipesID, name, calories, protein, carb, instructions) VALUES (2004, 'Beth\\'s Chinese Chicken Salad', NULL, NULL, NULL, 'BETH\\'S CHINESE CHICKEN SALAD\\\\n Serves 4-6\\\\n\\\\n INGREDIENTS\\\\n 2 chicken breasts, bone in, skin on\\\\n 3 cups (450 g) of iceberg lettuce\\\\n 1½ (225 g)cups of green cabbage\\\\n 1½ (225 g) cups of purple cabbage\\\\n 1 cucumber, sliced into half moons\\\\n 3 carrots, peeled and cut into 2\\\" matchsticks\\\\n 1 cup (150 g) edamame beans, shelled\\\\n 1 red pepper, cut into matchsticks\\\\n ½ cup (75 g) unsalted peanuts\\\\n\\\\n DRESSING:\\\\n 1/3 cup (80 g) smooth peanut butter\\\\n 4 tbsp (60 ml) rice wine vinegar\\\\n Zest and juice of 1 lime\\\\n 3 tbsp (45 ml) warm water\\\\n 1 tsp (5 ml) soy sauce\\\\n 1 tsp (5 ml) honey\\\\n 1 tsp (5 ml) fresh ginger\\\\n 1 garlic clove\\\\n 2 tsp (10 ml) toasted sesame oil\\\\n Pinch of red pepper flakes\\\\n Salt and pepper to taste\\\\n 3 tbsp (45 ml) grapeseed oil\\\\n\\\\n METHOD:\\\\n Preheat oven to 425F (218 C).\\\\n Season chicken with salt and pepper and roast for 25-30 mins until cooked through. Set aside and allow to cool. To make the dressing, combine the peanut butter, vinegar, lime zest, lime juice and water, whisk until smooth. Then add the soy sauce, honey, ginger, garlic, sesame oil, red pepper flakes, salt and pepper. Whisk to combine. Then slowly add the oil, while whisking, to combine. Set dressing aside. Slice lettuce and cabbage into ribbons, slice cucumber into half moons, carrots and red pepper into matchsticks. Thaw edamame if frozen. Shred chicken with a fork. Place lettuce and cabbage on a plate, add veggies, chicken and toss with the dressing. Garnish with 2 tbsp of peanuts. Enjoy!\');"
    };

    private  static final String[] INSERT_RECIPE_VIDEO = {
            "INSERT INTO RECIPE_VIDEO (recipeID, videoURL) VALUES (2001, 'https://youtu.be/pb__4zkNXrg');",
            "INSERT INTO RECIPE_VIDEO (recipeID, videoURL) VALUES (2002, 'https://youtu.be/PNAm7z9gOzk');",
            "INSERT INTO RECIPE_VIDEO (recipeID, videoURL) VALUES (2003, 'https://youtu.be/JAxcnlHSl6Q?list=PLFfHPE7nZa5Ce5EA3G2xCOA5RwXyCZUrJ');"
    };

    private static final String[] INSERT_MUSCLE_GROUP = {
            "INSERT INTO MUSCLE_GROUP (muscleID, muscleGroup) VALUES (1, 'arms');",
            "INSERT INTO MUSCLE_GROUP (muscleID, muscleGroup) VALUES (2, 'legs');",
            "INSERT INTO MUSCLE_GROUP (muscleID, muscleGroup) VALUES (3, 'glutes');",
            "INSERT INTO MUSCLE_GROUP (muscleID, muscleGroup) VALUES (4, 'abs');"
    };

    private static final String[] INSERT_WORKOUT_SCHEDULE = {
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1001, 'Raise the Roof', 4, 3, 2, 1, 2, 5, 'While marching in place, push toward the ceiling with your palms up and thumbs almost touching your shoulders. Make it harder by holding water bottles. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1002, 'Tricept Kick', 2, 2, 3, 1, 2, 5, 'While marching in place, bend at the hips, about 45 degrees. Bend your elbows, then extend them behind you as if you are lifting weights. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1003, 'The Hulk', 4, 3, 3, 1, 2, 6, 'Keep marching and leaning. With your elbows bent and fists together in front, move your arms back like wings. Try to touch your shoulder blades together. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1004, 'Hamstring Curl', 2, 2, 2, 2, 1, 5, 'Bend arms at the elbow. Bring one foot up toward your rear end while straightening your arms so that your hands are down when your foot is up. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1005, 'Knee Lift', 4, 3, 3, 2, 4, 6, 'Bend arms at the elbow. Bring one foot up toward your rear end while straightening your arms so that your hands are down when your foot is up. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1006, 'Hallelujah', 2, 2, 2, 1, 2, 7, 'Sweep arms above your head and down again as you step side-to-side. Actually yelling \'\'Hallelujah!\'\' is optional. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1007, 'Punching', 4, 3, 3, 1, NULL, 6, 'While rocking foot to foot, punch with alternating arms. To reduce elbow stress, try not to fully straighten your arm. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1008, 'Desk Pushup', 2, 3, 2, 1, 4, 7, 'Place hands on edge of desk, shoulder width apart, legs out behind you. Push off with as much force as you can. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1009, 'Side Lunge', 2, 2, 3, 2, NULL, 7, 'Place hands on edge of desk, shoulder width apart, legs out behind you. Push off with as much force as you can. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1010, 'Jump Squats', 2, 2, 2, 2, NULL, 10, 'Make sure you have space in front of you. Bend into a half-squat with your arms behind you, then jump and swing your arms up as if you\\'re celebrating. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1011, 'Char Dips', 2, 3, 3, 4, 3, 7, 'With your legs out in front of you, grab the edge of a chair (or desk) and lift yourself down and back up. At the end, you\\'ll be conveniently back in your seat. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1012, 'Walking', 4, 5, 3, 2, NULL, 4, 'Lap your block or a floor of your office. Try for a pace of 100 steps per minute, which is easy if you don\'t stop to play with tchotchkes on other people\'s desks. ');",
            "INSERT INTO WORKOUT_SCHEDULE (workoutID, name, weekPart, dayPart, hourPart, muscleGroupID1, muscleGroupID2, calPerTime, desc) VALUES (1013, 'BaSuCo', 4, 5, 3, 2, NULL, 4, 'Nod your head. Like this. Nod your Head. Like This. Lemme see you nod your head.');"
    };

    private static  List<String> Base_SQL_Insertions;

    private void ProcessBatchOfSqlStatements(String[] sqlStmts, SQLiteDatabase db) {
        for (int iter = 0; iter < sqlStmts.length; iter++){
            db.execSQL(sqlStmts[iter]);
        }
    }

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

    //Get all workout schedule entries in a List Array
    public List<WorkoutSchedule> getAllWorkoutScheduleEntries()
    {
        List<WorkoutSchedule> entriesList = new ArrayList<WorkoutSchedule>();
        ArrayList<String> entriesNames = new ArrayList<>(entriesList.size());
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_WORKOUT_SCHEDULE;

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
        cursor.close();

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
        //DB- Insertions
            //ProcessBatchOfSqlStatements(INSERT_RECIPE, db);
            //ProcessBatchOfSqlStatements(INSERT_RECIPE_VIDEO, db);
        ProcessBatchOfSqlStatements(INSERT_WORKOUT_SCHEDULE, db);
        ProcessBatchOfSqlStatements(INSERT_MUSCLE_GROUP, db);
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