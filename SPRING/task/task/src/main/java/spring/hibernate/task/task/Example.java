package spring.hibernate.task.task;

import java.text.ParseException;

public class Example {
    private static final String[][] arr = {
            {"Fari", "10:00-12:00", "11:00-14:00", "10:00-11:00", "10:00-14:00", "", "", ""},
            {"Fari", "12:00-18:00", "12:00-18:00", "12:00-18:00", "", "", "", ""},
    };

    public static void main(String[] args) throws ParseException {
        WorkTimeParserService parser = new WorkTimeParserService();
        String[] result = parser.prepareWorkTime(arr);

        display(result);
    }

    private static void display(String [] result) {
        for (String s : result) {
            System.out.println(s);
        }
    }
}
