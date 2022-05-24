package com.example.smacznego;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.smacznego.data.LoginDataSource;
import com.example.smacznego.data.Result;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

    @Mock
    DBHelper dbHelper = Mockito.mock(DBHelper.class);


    @Mock
    LoginDataSource loginDataSource = new LoginDataSource();

    Result result = new Result.Success(new Result());


    @Test
    public void useAppContext() {
        // Context of the app under test.
        assertEquals("com.example.smacznego", appContext.getPackageName());
    }

    @Test
    public void checkAddUser() {
        when(dbHelper.insertData("9", "9")).thenReturn(true);
    }

    @Test
    public void checkLoginName() {
        when(dbHelper.checkusername("9")).thenReturn(true);
    }

    @Test
    public void checkLoginNameForNullName() {
        when(dbHelper.checkusername(null)).thenThrow(NullPointerException.class);
    }

    @Test
    public void checkLoginNameForEmptyString() {
        when(dbHelper.checkusername("")).thenReturn(false);
    }

    @Test
    public void checkPassword() {
        when(dbHelper.checkusernamepassword("9", "9")).thenReturn(true);
    }

    @Test
    public void checkPasswordForNullName() {
        when(dbHelper.checkusernamepassword(null, null)).thenThrow(NullPointerException.class);
    }

    @Test
    public void checkPasswordForEmptyString() {
        when(dbHelper.checkusernamepassword("", "")).thenReturn(false);
    }

    @Test
    public void checkDatabaseName() {
        when(dbHelper.getDatabaseName()).thenReturn("Login.db");
    }

    @Test
    public void checkRemovedUser() {
        when(dbHelper.removeUser("9", "9")).thenReturn(true);
    }
    
    @Test
    public void checkLoginCorrectly() {
        assertEquals(result.toString().startsWith("Success[data="), loginDataSource.login("9", "9").toString().startsWith("Success[data="));
    }
}