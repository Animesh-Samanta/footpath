package com.footpath.online.validation;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;


import com.footpath.online.constrains.EmailConstrain;
import com.footpath.online.dao.AppConfigrationDao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import com.footpath.online.constants.Domain;

public class EmailValidator implements ConstraintValidator<EmailConstrain, String> {
@Autowired
private AppConfigrationDao consts;
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (email == null || !email.contains("@")) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }

        String domain = parts[1];
        List<Domain> validDomains=consts.getUnblockedEmailDomains();
        for (Domain validDomain : validDomains) {
            if (domain.equals(validDomain.getDomain())) {
                return true;
            }
        }

        return false;
	}

}
