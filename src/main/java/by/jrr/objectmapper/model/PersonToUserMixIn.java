package by.jrr.objectmapper.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class PersonToUserMixIn {

    @JsonProperty("userName")
    String name;

    @JsonProperty("userLastName")
    String lastName;
}


