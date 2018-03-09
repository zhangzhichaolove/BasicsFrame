package com.peak.chao.basicsframe.config;

/**
 * Created by Chao  2018/3/9 on 11:22
 * description
 */

public class FrameConfig {

    private boolean deBug;

    private FrameConfig(Builder builder) {
        this.deBug = builder.deBug;
    }

    public static class Builder {
        private static boolean deBug;

        public Builder deBug(boolean deBug) {
            this.deBug = deBug;
            return this;
        }

        public FrameConfig build() {
            return new FrameConfig(this);
        }
    }

    public boolean isDeBug() {
        return deBug;
    }
}
