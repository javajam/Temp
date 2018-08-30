package com.safeway.scanandgo.views.activities;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertNotNull;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
public class MainActivityTest {

    private MainActivity testActivity;

    private Context mockContext = mock(Context.class);

    @Before
    public void setup() {
        testActivity = new MainActivity();
    }

    @Test
    public void testInstance() {
        assertNotNull(testActivity);
    }
}
