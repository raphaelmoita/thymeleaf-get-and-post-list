package org.moita.domain.builders;

import org.moita.domain.Link;
import org.moita.domain.Profile;

import java.util.List;

public final class ProfileBuilder {

    private long id;
    private List<Link> links;

    private ProfileBuilder() {
    }

    public static ProfileBuilder aProfile() {
        return new ProfileBuilder();
    }

    public ProfileBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public ProfileBuilder withLinks(List<Link> links) {
        this.links = links;
        return this;
    }

    public Profile build() {
        Profile profile = new Profile();
        profile.setId(id);
        profile.setLinks(links);
        return profile;
    }
}
