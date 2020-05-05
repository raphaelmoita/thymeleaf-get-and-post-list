package org.moita.domain.builders;

import org.moita.domain.Link;
import org.moita.domain.Profile;

import java.util.ArrayList;
import java.util.List;

public final class ProfileBuilder {
    private long id;
    private String description;
    private Long number;
    private List<Link> links = new ArrayList<>();

    private ProfileBuilder() {
    }

    public static ProfileBuilder aProfile() {
        return new ProfileBuilder();
    }

    public ProfileBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public ProfileBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProfileBuilder withNumber(Long number) {
        this.number = number;
        return this;
    }

    public ProfileBuilder withLinks(List<Link> links) {
        this.links = links;
        return this;
    }

    public Profile build() {
        Profile profile = new Profile();
        profile.setId(id);
        profile.setDescription(description);
        profile.setNumber(number);
        profile.setLinks(links);
        return profile;
    }
}
