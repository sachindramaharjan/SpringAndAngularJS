package com.profiler.rest.resources;

import com.profiler.core.entity.BlogEntry;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by sachindra on 24/07/2015.
 */
public class BlogEntryResource extends ResourceSupport {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BlogEntry toBlogEntry() {
        BlogEntry entry = new BlogEntry();
        entry.setTitle(title);
        return entry;
    }
}
