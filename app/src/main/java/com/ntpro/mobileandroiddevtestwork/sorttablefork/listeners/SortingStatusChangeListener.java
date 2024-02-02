package com.ntpro.mobileandroiddevtestwork.sorttablefork.listeners;


import com.ntpro.mobileandroiddevtestwork.sorttablefork.SortingStatus;

/**
 * Definition of a listener that is notified when the {@link SortingStatus} has changed.
 */
public interface SortingStatusChangeListener {

    /**
     * Callback method that is called when the {@link SortingStatus} has changed.
     *
     * @param newSortingStatus The new {@link SortingStatus}.
     */
    void onSortingStatusChanged(final SortingStatus newSortingStatus);
}
