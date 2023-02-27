import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class WorkTimeParser {
    /*
    * Достаем все дубликаты
    * происходит слияние времен
    *
    *
    * */
    public String[] prepareWorkTime(String[][] grafic) throws ParseException {
        String [] result = new String[1];

        for (int i = 0; i < grafic.length; i++) {
            for (int j = i + 1; j < grafic.length; j++) {
                if (grafic[i][0].equals(grafic[j][0])) {
                    result[i] = Arrays.toString(merge(grafic[i], grafic[j]));
                } else {
                    result[i] = Arrays.toString(grafic[i]);
                }
            }
        }

        return result;
    }

    public String[] merge(String[] a, String[] b) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        String[] mergedSchedule = new String[8];
        mergedSchedule[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i].isEmpty() && b[i].isEmpty()) {
                mergedSchedule[i] = "";
                continue;
            } else if (a[i].isEmpty()) {
                mergedSchedule[i] = b[i];
                continue;
            } else if (b[i].isEmpty()) {
                mergedSchedule[i] = a[i];
                continue;
            }

            String[] aTimes = a[i].split("-");
            String[] bTimes = b[i].split("-");

            Date aFinishesAt = parser.parse(aTimes[1]);
            Date bFinishesAt = parser.parse(bTimes[1]);

            Date aStartsAt = parser.parse(aTimes[0]);
            Date bStartsAt = parser.parse(bTimes[0]);

            if ((bStartsAt.after(aStartsAt)) && (bStartsAt.before(aFinishesAt) || bStartsAt.equals(aFinishesAt))) {
                mergedSchedule[i] = aTimes[0] + "-" + bTimes[1];
            } else if (aStartsAt.after(bStartsAt) && aStartsAt.before(bFinishesAt)) {
                mergedSchedule[i] = bTimes[0] + "-" + aTimes[1];
            } else {
                mergedSchedule[i] = a[i] + " and " + b[i];
            }
        }

        return mergedSchedule;
    }
}
