package aexp.buttonlist;

import android.test.ActivityInstrumentationTestCase;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class aexp.buttonlist.ButtonListTest \
 * aexp.buttonlist.tests/android.test.InstrumentationTestRunner
 */
public class ButtonListTest extends ActivityInstrumentationTestCase<ButtonList> {

    public ButtonListTest() {
        super("aexp.buttonlist", ButtonList.class);
    }

}
