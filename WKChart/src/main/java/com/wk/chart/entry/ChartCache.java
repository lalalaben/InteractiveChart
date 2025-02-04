package com.wk.chart.entry;

import androidx.annotation.Nullable;

import com.wk.chart.enumeration.IndexType;
import com.wk.chart.enumeration.ModuleGroupType;
import com.wk.chart.enumeration.ModuleType;
import com.wk.chart.enumeration.TimeType;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.HashMap;

public class ChartCache implements Serializable {
    public @Nullable
    TimeType timeType;
    public float cacheMaxScrollOffset = 0f;
    public float cacheCurrentTransX = 0f;
    public float scale = 1;
    private final HashMap<Integer, TypeEntry> types;

    public ChartCache() {
        this.types = new HashMap<>();
    }

    public @NotNull
    HashMap<Integer, TypeEntry> getTypes() {
        return types;
    }

    public @Nullable
    TypeEntry getTypeEntry(@ModuleGroupType int moduleGroupType) {
        return types.get(moduleGroupType);
    }

    public void updateTypeEntry(@ModuleGroupType int moduleGroupType, @NotNull TypeEntry typeEntry) {
        types.put(moduleGroupType, typeEntry);
    }

    public static class TypeEntry implements Serializable {
        private @ModuleType
        int moduleType;
        private @IndexType
        int indexType;

        public TypeEntry(@ModuleType int moduleType, @IndexType int indexType) {
            this.moduleType = moduleType;
            this.indexType = indexType;
        }

        public @ModuleType
        int getModuleType() {
            return moduleType;
        }

        public void setModuleType(@ModuleType int moduleType) {
            this.moduleType = moduleType;
        }

        public @IndexType
        int getIndexType() {
            return indexType;
        }

        public void setIndexType(@IndexType int indexType) {
            this.indexType = indexType;
        }
    }
}