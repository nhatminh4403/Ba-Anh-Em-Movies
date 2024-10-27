package com.example.movietickets.demo.Enum;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Provider {
    LOCAL("Local"),
    GOOGLE("Google"),
    FACEBOOK("Facebook");

    public final String value;
}