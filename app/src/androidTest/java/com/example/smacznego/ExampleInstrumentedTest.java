package com.example.smacznego;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.smacznego.data.LoginDataSource;
import com.example.smacznego.data.Result;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

    @Mock
    DBHelper dbHelper = new DBHelper(appContext.getApplicationContext());

    @Mock
    LoginDataSource loginDataSource = new LoginDataSource();

    Result result = new Result.Success(new Result());


    @Test
    public void useAppContext() {
        // Context of the app under test.
        assertEquals("com.example.smacznego", appContext.getPackageName());
    }

    @Test
    public void checkLoginCorrectly() {
        assertEquals(result.toString().startsWith("Success[data="), loginDataSource.login("9", "9").toString().startsWith("Success[data="));
    }

    @Test
    public void checkAddUser() {
        assertEquals(true, dbHelper.insertData("9", "9"));
    }

    @Test
    public void checkLoginName() {
        assertEquals(true, dbHelper.checkusername("9"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkLoginNameForNullName() {
        assertEquals(true, dbHelper.checkusername(null));
    }

    @Test
    public void checkLoginNameForEmptyString() {
        assertEquals(false, dbHelper.checkusername(""));
    }

    @Test
    public void checkPassword() {
        assertEquals(true, dbHelper.checkusernamepassword("9", "9"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPasswordForNullName() {
        assertEquals(true, dbHelper.checkusernamepassword(null, null));
    }

    @Test
    public void checkPasswordForEmptyString() {
        assertEquals(false, dbHelper.checkusernamepassword("", ""));
    }

    @Test
    public void checkDatabaseName() {
        assertEquals("Login.db", dbHelper.getDatabaseName());
    }

    @Test
    public void checkRemovedUser() {
        assertEquals(true, dbHelper.removeUser("9", "9"));
    }

    @Test
    public void checkLoginFalse() {
        assertEquals(result.toString().startsWith("Success[data="), loginDataSource.login("93333333333", "9").toString().startsWith("Success[data="));
    }

}