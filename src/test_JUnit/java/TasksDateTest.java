import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class TasksDateTest {
    private LocalizedDateService testedDate = new LocalizedDateService();


    @Test
    public void testFormatDate() throws Exception {
        assumeThat(System.getProperty("date.language"), is("ru"));
        Calendar date = Calendar.getInstance();
        date.set(2021,05,30);
        assertThat(testedDate.formatDate(date.getTime()), is("2021-05-30"));
    }


    public class LocalizedDateService {

        private final DateFormat dateFormat =
                new SimpleDateFormat("yyyy, MM, dd");


        public final String formatDate(final Date date) {
            return dateFormat.format(date);
        }

    }
}
