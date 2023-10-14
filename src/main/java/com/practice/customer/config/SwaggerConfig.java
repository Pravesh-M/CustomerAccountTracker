package com.practice.customer.config;

import org.springdoc.core.models.GroupedOpenApi;

import static org.springdoc.core.utils.Constants.DEFAULT_GROUP_NAME;

public class SwaggerConfig {

    public GroupedOpenApi publicApi() {

        return GroupedOpenApi
                .builder()
                .group(DEFAULT_GROUP_NAME)
                .packagesToScan("com.practice.customer.controller")
                .build();
    }
}
