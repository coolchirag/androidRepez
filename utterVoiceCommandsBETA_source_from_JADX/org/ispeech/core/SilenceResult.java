package org.ispeech.core;

public class SilenceResult {
    public long energy;
    public int normalizedEnergy;
    public boolean status;

    public SilenceResult(boolean z, long j, int i) {
        this.status = z;
        this.energy = j;
        this.normalizedEnergy = i;
    }
}
