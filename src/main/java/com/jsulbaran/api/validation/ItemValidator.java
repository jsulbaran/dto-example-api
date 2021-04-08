package com.jsulbaran.api.validation;

import com.jsulbaran.api.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.jsulbaran.api.model.Constants.MAXIMUM_DESCRIPTION_SIZE;
import static com.jsulbaran.api.model.Constants.MAXIMUM_PART_NUMBER_SIZE;

@Component("beforeCreateItemValidator")
public class ItemValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Item.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        final Item receivedItem = (Item) obj;

        if (!StringUtils.hasLength(receivedItem.getDescription())) {
            errors.rejectValue("description", "item.description.empty");
        }
        if (receivedItem.getDescription() != null && receivedItem.getDescription().length() > MAXIMUM_DESCRIPTION_SIZE) {
            errors.rejectValue("description", "item.description.maxsize");
        }

        if (!checkPartNumber(receivedItem.getPartNumber())) {
            errors.rejectValue("partNumber", "item.partNumber.wrong");
        }

    }


    private boolean checkPartNumber(final String partNumber) {
        return StringUtils.hasLength(partNumber) && partNumber.length() < MAXIMUM_PART_NUMBER_SIZE;
    }
}
