package com.khai.voroshylov.validator;

import com.khai.voroshylov.exception.ConstraintException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstraintHandler {

    public void validate(Object validateObject) throws Exception {

        Map<String, List<String>> errorMap = new HashMap<>();

        Validator validator = new Validator();

        List<ConstraintViolation> violations = validator.validate(validateObject);


        if(!violations.isEmpty()) {

            String oldErrorField = "";
            List<String> message = new ArrayList<>();

            for (ConstraintViolation violation: violations) {

                String errorFieldPath = violation.getContextPath().get(0).toString();
                String errorField = errorFieldPath.substring(errorFieldPath.lastIndexOf('.') + 1);

                if (!oldErrorField.equals(errorField)) {

                    message = new ArrayList<>();
                    oldErrorField = errorField;

                }
                message.add(violation.getMessage());
                errorMap.put(errorField, message);

            }

        }

        throw new ConstraintException(errorMap);
    }
}
