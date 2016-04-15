package org.socialman.domain;

import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;

/**
 * Defines the address of a user.
 */
@Embeddable
public class Address {

    @Getter
    private final String city;

    @Getter
    private final String postalCode;

    @Getter
    private final String streetAddress;

    @Getter
    private final String country;

    public Address(final String city, final String postalCode, final String streetAddress, final String country) {
        this.city = city;
        this.postalCode = postalCode;
        this.streetAddress = streetAddress;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address that = (Address) o;

        return new EqualsBuilder().append(city, that.city)
                .append(postalCode, that.postalCode)
                .append(streetAddress, that.streetAddress)
                .append(country, that.country)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(city)
                .append(postalCode)
                .append(streetAddress)
                .append(country)
                .hashCode();
    }
}
