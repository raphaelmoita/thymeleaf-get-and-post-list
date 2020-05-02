package org.moita.domain.builders;

import org.moita.domain.Link;

public final class LinkBuilder {

    private long id;
    private String description;
    private String url;

    private LinkBuilder() {
    }

    public static LinkBuilder aLink() {
        return new LinkBuilder();
    }

    public LinkBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public LinkBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public LinkBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public Link build() {
        Link link = new Link();
        link.setId(id);
        link.setDescription(description);
        link.setUrl(url);
        return link;
    }
}
