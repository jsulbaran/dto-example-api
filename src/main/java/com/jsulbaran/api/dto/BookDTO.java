package com.jsulbaran.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public enum BookDTO {
    ;

    private interface Id {
        @Positive long getId();
    }

    private interface Title {
        @JsonProperty("title")
        @NotBlank @NotNull String getTitle();
    }

    private interface Isbn {
        @JsonProperty("isbn")
        @NotBlank @NotNull String getIsbn();
    }

    private interface Cost {
        @JsonProperty("total_cost")
        @Positive @NotNull BigDecimal getCost();
    }

    public enum Request {
        ;

        @Value
        public static class Create implements Title, Isbn, Cost {
            String title;
            String isbn;
            BigDecimal cost;
        }
    }

    public enum Response {
        ;

        @Value
        public static class OutStock implements Title, Isbn {
            String title;
            String isbn;
        }

        @Value
        public static class InStock implements Title, Isbn, Cost {
            String title;
            String isbn;
            BigDecimal cost;
        }
    }
}
