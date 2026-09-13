package com.prog4.payment_receipts.service.email;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailVariableResolverService {

    private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\{\\{\\s*(\\w+)\\s*\\}\\}");

    public String resolve(String template, Map<String, String> variables) {
        Matcher matcher = VARIABLE_PATTERN.matcher(template);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String variableName = matcher.group(1);
            String value = variables.getOrDefault(variableName, "");
            matcher.appendReplacement(result, Matcher.quoteReplacement(value));
        }
        matcher.appendTail(result);

        return result.toString();
    }
}