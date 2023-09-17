package org.entities;

import java.util.Date;

public record ProductCopy(Boolean found, String id, String name, Category category, int rating, Date createdAt, Date lastModifiedAt) {}
