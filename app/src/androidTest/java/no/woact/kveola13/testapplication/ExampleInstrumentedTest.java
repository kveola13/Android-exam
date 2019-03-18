package no.woact.kveola13.testapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    void useAppContext() {
        // Context of the app under test.
        final Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("no.woact.kveola13.testapplication", appContext.getPackageName());
    }
}
