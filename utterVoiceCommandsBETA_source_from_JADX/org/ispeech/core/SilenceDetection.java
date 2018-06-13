package org.ispeech.core;

public class SilenceDetection {
    private static final String TAG = "iSpeech SDK";
    private static int counter = 0;
    private static int delta = 0;
    private static int energyMax = 0;
    private static long energyMaxAverage = 0;
    private static int energyMaxCounter = 0;
    private static boolean goingUp = true;
    private static int initialEnergy = 0;
    private static boolean initialized = false;
    private static int relativeSilenceCounter = 0;
    private static long threshold = 0;

    private static long calcEnergy(byte[] bArr, int i, int i2) {
        long j = 0;
        int i3 = 0;
        for (int i4 = i; i4 + 1 < (i + i2) - 1; i4 += 2) {
            int i5 = (bArr[i4] & 255) + ((bArr[i4 + 1] & 255) * 256);
            if (i5 > 32768) {
                i5 = 65536 - i5;
            }
            j += (long) i5;
            i3++;
        }
        return j / ((long) i3);
    }

    public static SilenceResult checkSilence(byte[] bArr, int i, int i2, long j, long j2) {
        long calcEnergy = calcEnergy(bArr, i, i2);
        if (!initialized) {
            delta = (int) (((double) calcEnergy) * 0.25d);
            threshold = ((long) delta) + calcEnergy;
            initialized = true;
        } else if (j2 < threshold && j2 > 0) {
            threshold = (long) Math.max(((double) j2) * 1.25d, ((double) energyMax) * 0.15d);
        }
        return calcEnergy > threshold ? new SilenceResult(false, calcEnergy, getNormalizedEnergy(calcEnergy)) : new SilenceResult(true, calcEnergy, 0);
    }

    public static int getNormalizedEnergy(long j) {
        if (relativeSilenceCounter >= 3) {
            return (int) Math.floor((double) ((((float) (j - ((long) initialEnergy))) / ((float) (energyMax - initialEnergy))) * 128.0f));
        }
        initialEnergy = (int) ((((long) (initialEnergy * relativeSilenceCounter)) + j) / ((long) (relativeSilenceCounter + 1)));
        int i = relativeSilenceCounter + 1;
        relativeSilenceCounter = i;
        if (i == 3) {
            energyMaxAverage = (long) (initialEnergy * 5);
        }
        return 0;
    }
}
