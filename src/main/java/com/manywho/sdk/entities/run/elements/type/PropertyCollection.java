package com.manywho.sdk.entities.run.elements.type;

import com.manywho.sdk.entities.ValueAware;

import java.util.ArrayList;

public class PropertyCollection extends ArrayList<Property> implements ValueAware {
    public String getContentValue(String name) {
        if (!this.isEmpty()) {
            return this.stream().filter(c -> c.getDeveloperName().equals(name)).findFirst().orElse(new Property()).getContentValue();
        }

        return null;
    }

    public ObjectCollection getObjectData(String name) {
        if (!this.isEmpty()) {
            return this.stream().filter(o -> o.getDeveloperName().equals(name)).findFirst().orElse(new Property()).getObjectData();
        }

        return null;
    }
}
