package cl.option.validateinput.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import cl.option.validateinput.model.ValidationResult;
import lombok.var;

@Service
public class InputValidation {
    public ValidationResult validate(String input) {
        var res = new ValidationResult();
        res.setValue(input);
        res.setValid(validateExpression(input));
        res.setValidated(true);
        res.setFormatedValue(ucWords(input));
        return res;
    }

    private boolean validateExpression(String input) {
        Pattern p = Pattern.compile("[a-z0-9 ñáéíóú]+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        return m.matches();
    }

    private String ucWords(String input) {
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                String word = words[i].substring(0, 1).toUpperCase()
                        + words[i].substring(1, words[i].length()).toLowerCase();
                words[i] = word;
            }
        }
        return String.join(" ", words);
    }
}