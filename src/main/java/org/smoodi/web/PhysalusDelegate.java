package org.smoodi.web;

import org.smoodi.physalus.engine.Engine;
import org.smoodi.physalus.engine.Physalus;

public interface PhysalusDelegate extends Engine {

    @Override
    default void startEngine() {
        Physalus.instance().startEngine();
    }

    @Override
    default void stopEngine() {
        Physalus.instance().stopEngine();
    }

    @Override
    default State getState() {
        return Physalus.instance().getState();
    }

    default Physalus getPhysalus() {
        return (Physalus) Physalus.instance();
    }
}
