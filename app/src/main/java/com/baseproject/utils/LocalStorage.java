package com.baseproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.baseproject.App;
import com.google.gson.Gson;


/**
 * A wrapper/abstraction layer over SharedPreferences
 * which features storage/retrieving data from/to SharedPreferences
 */
public class LocalStorage {

    private static final String APP_PREFS = "AppPrefs";

    public static final String KEY_AUTH_TOKEN = "X-AUTH-TOKEN";
    public static final String KEY_USER_DATA = "userData";
    public static final String KEY_ENCRYPTION = "encrption";
    public static final String KEY_IV = "iv";
    public static final String KEY_LOGGED_IN = "loggedIn";


    // Get instance of shared preferences in private mode
    private static SharedPreferences getSharedPrefs() {
        return App.Companion.applicationContext().getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
    }

    // Get instance of Editor
    private static SharedPreferences.Editor getEditor() {
        return getSharedPrefs().edit();
    }


    /**
     * Get locally stored value for specific key in the desired data type
     * The value can be null if it does not exist or cannot be casted to the desired data type
     *
     * @param key          name of key
     * @param defaultValue default value to map to the key in case not found
     * @param type         type of class (e.g. String, Boolean, Integer) used to store value
     * @param <T>          Generic type
     * @return returns value mapped to the key. Can be of any type
     */
    public static <T> T getValue(String key, Object defaultValue, Class<T> type) {
        Object value = null;
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (type.equals(String.class)) {    // String
            String defVal = "";
            if (defaultValue instanceof String) {
                defVal = (String) defaultValue;
            }
            try {
                value = sharedPrefs.getString(key, defVal);
            } catch (Exception e) {
                android.util.Log.e("LocalStorage", "Error getting value for key: " + key + "\nError: " + e.getMessage());
            }

        } else if (type.equals(Integer.class)) {    // Integer
            int defVal = 0;
            if (defaultValue instanceof Integer) {
                defVal = (int) defaultValue;
            }
            try {
                value = sharedPrefs.getInt(key, defVal);
            } catch (Exception e) {
                android.util.Log.e("LocalStorage", "Error getting value for key: " + key + "\nError: " + e.getMessage());
            }

        } else if (type.equals(Float.class)) {  // Float
            float defVal = 0;
            if (defaultValue instanceof Float) {
                defVal = (float) defaultValue;
            }
            try {
                value = sharedPrefs.getFloat(key, defVal);
            } catch (Exception e) {
                android.util.Log.e("LocalStorage", "Error getting value for key: " + key + "\nError: " + e.getMessage());
            }

        } else if (type.equals(Boolean.class)) {    // Boolean
            boolean defVal = false;
            if (defaultValue instanceof Boolean) {
                defVal = (boolean) defaultValue;
            }
            try {
                value = sharedPrefs.getBoolean(key, defVal);
            } catch (Exception e) {
                android.util.Log.e("LocalStorage", "Error getting value for key: " + key + "\nError: " + e.getMessage());
            }

        } else if (type.equals(Long.class)) {   // Long
            long defVal = 0;
            if (defaultValue instanceof Long) {
                defVal = (long) defaultValue;
            }
            try {
                value = sharedPrefs.getLong(key, defVal);
            } catch (Exception e) {
                android.util.Log.e("LocalStorage", "Error getting value for key: " + key + "\nError: " + e.getMessage());
            }

        }
        return type.cast(value);
    }


    /**
     * Store data locally for specific key
     *
     * @param value store value
     * @param key   name of key to map value against
     */
    public static void putValue(Object value, String key) {
        SharedPreferences.Editor editor = getEditor();
        if (value instanceof String) {    // String
            editor.putString(key, (String) value);

        } else if (value instanceof Integer) {    // Integer
            editor.putInt(key, (int) value);

        } else if (value instanceof Float) {  // Float
            editor.putFloat(key, (float) value);

        } else if (value instanceof Boolean) {    // Boolean
            editor.putBoolean(key, (boolean) value);

        } else if (value instanceof Long) {   // Long
            editor.putLong(key, (long) value);
        }
        editor.commit();
    }

    public static void setToken(@NonNull String token) {
        putValue(token, KEY_AUTH_TOKEN);
    }

    public static @NonNull
    String getToken() {
        return getValue(KEY_AUTH_TOKEN, "", String.class);
    }
/*
    public static void saveUser(@NonNull User user) {
        String rawUser = new Gson().toJson(user);
        putValue(rawUser, KEY_USER_DATA);
    }

    public static @Nullable
    User getUser() {
        String rawUser = getValue(KEY_USER_DATA, null, String.class);
        return new Gson().fromJson(rawUser, User.class);
    }
*/



    public static void clearData() {
        SharedPreferences.Editor sharesPrefEdit = getEditor();
        sharesPrefEdit.clear();
        sharesPrefEdit.commit();
    }

    public static void setLoggedInStatus(Boolean loggedInStatus) {
        putValue(loggedInStatus, KEY_LOGGED_IN);
    }

    public static Boolean getLoggedInStatus() {
        return getValue(KEY_LOGGED_IN, false, Boolean.class);
    }

    public static void logout() {

    }
}
