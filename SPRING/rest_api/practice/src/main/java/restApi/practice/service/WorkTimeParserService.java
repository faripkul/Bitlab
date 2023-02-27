package restApi.practice.service;

import org.springframework.stereotype.Service;
import restApi.practice.WorkTimeParser;

import java.text.ParseException;

@Service
public class WorkTimeParserService {
    public String[][] handle(String[][] payload) throws ParseException {
        WorkTimeParser parser = new WorkTimeParser();
        return parser.prepareWorkTime(payload);
    }
}
