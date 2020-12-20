package com.netcracker.edu.inventory.model.rack.impl;

import com.netcracker.edu.inventory.model.rack.RackPrimaryKey;
import com.netcracker.edu.location.Location;

import java.util.Objects;

public class RackPK implements RackPrimaryKey {
    private final Location location;

    public RackPK(Location location) {
        this.location = location;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RackPK rackPK = (RackPK) o;
        return Objects.equals(location, rackPK.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
