package com.example.android.pets.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.android.pets.R;
import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by Dasha on 29.09.2017.
 */

public class PetProvider extends ContentProvider {

    public static final String LOG_TAG = PetProvider.class.getSimpleName();

    PetDbHelper mDbHelper;

    private static final int PETS=100;
    private static final int PETS_ID=101;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY, PetContract.PATH_PETS, PETS);
        sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY, PetContract.PATH_PETS+"/#",PETS_ID);
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new PetDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {

        SQLiteDatabase databse = mDbHelper.getReadableDatabase();

        Cursor cursor = null;

        int match = sUriMatcher.match(uri);
        switch(match){
            case PETS:
                cursor = databse.query(PetEntry.TABLE_NAME, projection,selection,selectionArgs,
                        null, null, sortOrder);
                break;
            case PETS_ID:
                selection = PetEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = databse.query(PetEntry.TABLE_NAME, projection,selection,selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw
                        new IllegalArgumentException("Cannot query unknown URI "+uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch(match){
            case PETS:
                return PetEntry.CONTENT_LIST_TYPE;
            case PETS_ID:
                return  PetEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI " +uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch(match){
            case PETS:
                return insertPet(uri, contentValues);
            default:
                throw  new IllegalArgumentException("Insertion is not supported for "+uri);
        }
    }

    private Uri insertPet(Uri uri, ContentValues values){
        String name = values.getAsString(PetEntry.COLUMN_PET_NAME);
        if(name == null){
            throw new IllegalArgumentException("Pet requires a name");
        }

        SQLiteDatabase databse = mDbHelper.getWritableDatabase();
        long id = databse.insert(PetEntry.TABLE_NAME, null, values);
        if(id !=-1){
            Toast.makeText(getContext(), getContext().getString(R.string.saved_pet), Toast.LENGTH_LONG).show();
        }

        getContext().getContentResolver().notifyChange(uri, null);

        return ContentUris.withAppendedId(uri,id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        Log.e(LOG_TAG, "delete PetProvider");

        int rowsDeleted;

        final int match = sUriMatcher.match(uri);
        switch(match){
            case PETS:
                rowsDeleted = database.delete(PetEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case PETS_ID:
                selection = PetEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                rowsDeleted = database.delete(PetEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Deletion is not supported for "+uri);

        }

        if(rowsDeleted !=0){
            Toast.makeText(getContext(), getContext().getString(R.string.editor_delete_pet_successful), Toast.LENGTH_LONG).show();
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rowsDeleted;

    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection,
                      @Nullable String[] selectionArgs) {
        final int match = sUriMatcher.match(uri);
        switch(match){
            case PETS:
                return updatePet(uri, contentValues, selection, selectionArgs);
            case PETS_ID:
                selection = PetEntry._ID+"=?";
                selectionArgs=new String[]{String.valueOf(ContentUris.parseId(uri))};
                return updatePet(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Update is not supported for "+uri);
        }
    }

    private int updatePet(Uri uri, ContentValues values, String selection,
                          String[] selectionArgs){
        if(values.containsKey(PetEntry.COLUMN_PET_NAME)){
            String name = values.getAsString(PetEntry.COLUMN_PET_NAME);
            if(name == null){
                throw new IllegalArgumentException("pet requires a name");
            }
        }

        if(values.containsKey(PetEntry.COLUMN_PET_GENDER)){
            Integer gender =values.getAsInteger(PetEntry.COLUMN_PET_GENDER);
            if(gender == null /*|| !PetEntry.isValidGender(gender)*/){
                throw new IllegalArgumentException("Pet requires valid gender");
            }
        }

        if(values.containsKey(PetEntry.COLUMN_PET_WEIGHT)){
            Integer weight = values.getAsInteger(PetEntry.COLUMN_PET_WEIGHT);
            if(weight != null && weight <0){
                throw  new IllegalArgumentException("Pet requires valid weight");
            }
        }

        if(values.size() == 0){
            return 0;
        }

        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        int rowsUpdated = database.update(PetEntry.TABLE_NAME, values, selection, selectionArgs);

        if(rowsUpdated !=0 && rowsUpdated !=-1){
            Toast.makeText(getContext(), getContext().getString(R.string.update_pet), Toast.LENGTH_LONG).show();
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rowsUpdated;
    }
}
