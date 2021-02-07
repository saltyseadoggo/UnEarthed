package net.lilycorgitaco.unearthed.world.feature.stonegenerators.data;

import com.google.common.collect.ImmutableList;

import javax.annotation.Nullable;
import java.util.List;

public class BasicReplacer implements CellularOre {
    private Cell cell;
    @Nullable
    private List<Cell> replaceable;
    private float accWeight;

    public BasicReplacer(Cell cell, @Nullable Cell... replaceable) {
        this.cell = cell;
        this.replaceable = ImmutableList.copyOf(replaceable);
    }

    @Override
    public boolean canReplace(State existing) {
        return replaceable.contains(existing.getCell());
    }

    @Override
    public State apply(State existing) {
        return cell.getState(existing.getType());
    }

    @Override
    public float getAccumulatedWeight() {
        return accWeight;
    }

    @Override
    public void setAccumulatedWeight(float weight) {
        this.accWeight = weight;
    }
}
