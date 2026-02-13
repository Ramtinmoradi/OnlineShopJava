package com.ramtinmoradiii.onlineshopjava.util;

public class ApiPaths {
    public static final String V1 = "/api/v1";

    public static class Common {
        public static final String BY_ALL = "/all";
        public static final String BY_ID = "/{id}";
        public static final String BY_NAME = "/{name}";
        public static final String SEARCH = "/search";
    }

    public static class Auth {
        public static final String BASE = V1 + "/auth";
        public static final String REGISTER = "/register";
        public static final String LOGIN = "/login";
        public static final String REFRESH_TOKEN = "/refresh_token";
    }

    public static class Blog {
        public static final String BASE = V1 + "/blog";
        public static final String SEARCH_BY_STATUS = Common.SEARCH + "/{status}";
    }

    public static class Content {
        public static final String BASE = V1 + "/content";
        public static final String SEARCH_BY_NAME = Common.SEARCH + "/{name}";
    }

    public static class Slider {
        public static final String BASE = V1 + "/slider";
    }

    public static class Navigation {
        public static final String BASE = V1 + "/navigation";
    }

    public static class Product {
        public static final String BASE = V1 + "/product";
    }
}
