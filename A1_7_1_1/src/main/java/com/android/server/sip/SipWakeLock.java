package com.android.server.sip;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.telephony.Rlog;
import java.util.HashSet;

class SipWakeLock {
    private static final boolean DBG = true;
    private static final String TAG = "SipWakeLock";
    private HashSet<Object> mHolders = new HashSet();
    private PowerManager mPowerManager;
    private WakeLock mTimerWakeLock;
    private WakeLock mWakeLock;

    SipWakeLock(PowerManager powerManager) {
        this.mPowerManager = powerManager;
    }

    synchronized void reset() {
        log("reset count=" + this.mHolders.size());
        this.mHolders.clear();
        release(null);
    }

    synchronized void acquire(long timeout) {
        if (this.mTimerWakeLock == null) {
            this.mTimerWakeLock = this.mPowerManager.newWakeLock(1, "SipWakeLock.timer");
            this.mTimerWakeLock.setReferenceCounted(DBG);
        }
        this.mTimerWakeLock.acquire(timeout);
    }

    synchronized void acquire(Object holder) {
        this.mHolders.add(holder);
        if (this.mWakeLock == null) {
            this.mWakeLock = this.mPowerManager.newWakeLock(1, TAG);
        }
        if (!this.mWakeLock.isHeld()) {
            this.mWakeLock.acquire();
        }
        log("acquire count=" + this.mHolders.size());
    }

    synchronized void release(Object holder) {
        this.mHolders.remove(holder);
        if (this.mWakeLock != null && this.mHolders.isEmpty() && this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
        log("release count=" + this.mHolders.size());
    }

    private void log(String s) {
        Rlog.d(TAG, s);
    }
}
