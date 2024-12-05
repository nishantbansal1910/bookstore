package com.personal.bookstore.model.response;

import lombok.Data;

@Data
public class Views {

    /** The type Public. */
    public static class Public {}

    /** The type Internal. */
    public static final class Internal extends Public {}
}
