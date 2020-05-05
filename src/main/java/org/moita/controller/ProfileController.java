package org.moita.controller;

import org.moita.domain.Profile;
import org.moita.domain.builders.ProfileBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.moita.domain.builders.LinkBuilder.aLink;

@Controller
public class ProfileController {

    private static final Long PROFILE_ID = 1L;

    private static final String VIEW_NAME = "profile_view";
    private static final String EDIT_VIEW_NAME = "profile_edit";

    private static final Profile PROFILE = ProfileBuilder.aProfile()
            .withId(1L)
            .withDescription("My first profile blablabla ...")
            .withNumber(310251977L)
            .withLinks(asList(
                    aLink().withDescription("link-0").withUrl("www.google.com").build(),
                    aLink().withDescription("link-1").withUrl("www.yahoo.com").build()))
            .build();

    @ModelAttribute
    public void populateModel(ModelAndView model) {
        model.addObject("profile", PROFILE);
    }

    @GetMapping("/")
    public ModelAndView root(ModelAndView model) {
        model.setViewName(VIEW_NAME);
        return model;
    }

    @GetMapping("/view")
    public ModelAndView view(ModelAndView model) {
        model.setViewName(VIEW_NAME);
        return model;
    }

    @GetMapping("/edit")
    public ModelAndView edit(ModelAndView model) {
        model.setViewName(EDIT_VIEW_NAME);
        return model;
    }

    @PostMapping("/save")
    public ModelAndView save(ModelAndView model, @ModelAttribute Profile profile) {
        model.setViewName(VIEW_NAME);

        // ProfileId is something related to the logged user
        if (PROFILE_ID.equals(profile.getId())) {
            PROFILE.setId(profile.getId());
            PROFILE.setDescription(profile.getDescription());
            PROFILE.setNumber(profile.getNumber());
            PROFILE.setLinks(profile.getLinks()
                    .stream()
                    .filter(l -> isNotEmpty(l.getDescription())
                            && isNotEmpty(l.getUrl())).collect(toList()));
        }

        return model;
    }

    // https://vkuzel.com/add-or-remove-items-from-a-list-of-objects-in-a-model-attribute-using-spring-mvc-and-thymeleaf

    //javascript:{ var c = 0; while (c < 1000) {document.querySelector(".add").click(); c++}}
}
