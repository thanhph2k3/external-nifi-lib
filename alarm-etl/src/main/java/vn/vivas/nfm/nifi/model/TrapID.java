package vn.vivas.nfm.nifi.model;

import java.util.Objects;

public record TrapID(String value) {

    public TrapID {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Trap id must not be blank");
        }
        value = value.trim();
    }

    public static TrapID of(String value) {
        return new TrapID(value);
    }

    public boolean matches(Object candidate) {
        return candidate != null && Objects.equals(value, String.valueOf(candidate).trim());
    }

    @Override
    public String toString() {
        return value;
    }
}
