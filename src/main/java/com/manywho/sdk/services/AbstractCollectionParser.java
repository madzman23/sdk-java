package com.manywho.sdk.services;

import com.manywho.sdk.entities.ContentValueAware;
import com.manywho.sdk.entities.ObjectDataAware;
import com.manywho.sdk.entities.ValueAware;
import com.manywho.sdk.entities.run.elements.type.ObjectCollection;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public abstract class AbstractCollectionParser {
    public abstract <T> T parse(ValueAware properties, Class<T> tClass) throws Exception;
    public abstract <T> T parse(ValueAware properties, String id, Class<T> tClass) throws Exception;

    protected static void validate(Object entity) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(entity);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    protected void setListField(Field field, String annotationValue, ObjectDataAware properties, Object entity) throws Exception {
        ObjectCollection nestedPropertyCollection = properties.getObjectData(annotationValue);
        if (CollectionUtils.isNotEmpty(nestedPropertyCollection)) {
            Class fieldClass = (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
            List<Object> list = new ArrayList<>();

            for (com.manywho.sdk.entities.run.elements.type.Object object : nestedPropertyCollection) {
                Object a = parse(object.getProperties(), object.getExternalId(), fieldClass);
                list.add(a);
            }

            field.set(entity, list);
        }
    }

    protected void setObjectField(Field field, String annotationValue, ObjectDataAware properties, Object entity) throws Exception {
        ObjectCollection nestedPropertyCollection = properties.getObjectData(annotationValue);
        if (CollectionUtils.isNotEmpty(nestedPropertyCollection)) {
            field.set(entity, parse(nestedPropertyCollection.get(0).getProperties(), nestedPropertyCollection.get(0).getExternalId(), field.getType()));
        }
    }

    protected void setScalarField(Field field, String annotationValue, ContentValueAware properties, Object entity) throws IllegalAccessException, ParseException {
        String propertyValue = properties.getContentValue(annotationValue);

        Class fieldType = field.getType();
        if (fieldType.equals(long.class)) {
            field.set(entity, Long.parseLong(propertyValue));
        } else if (fieldType.equals(int.class)) {
            field.set(entity, Integer.parseInt(propertyValue));
        } else if (fieldType.equals(float.class)) {
            field.set(entity, Float.parseFloat(propertyValue));
        } else if (fieldType.equals(Date.class)) {
            // TODO: Check if this date format is sent the same from everywhere
            field.set(entity, new SimpleDateFormat("MM/dd/yyyy H:m:s a").parse(propertyValue));
        } else {
            field.set(entity, properties.getContentValue(annotationValue));
        }
    }
}
