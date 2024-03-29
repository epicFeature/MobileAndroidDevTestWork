package com.ntpro.mobileandroiddevtestwork.sorttablefork.providers;

import com.ntpro.mobileandroiddevtestwork.sorttablefork.SortState;

/**
 * Provider for images indication the sort status.
 *
 * @author ISchwarz
 */
public interface SortStateViewProvider {

    int NO_IMAGE = 0;

    /**
     * Gives the drawable resource for the given {@link SortState}.
     *
     * @param state The {@link SortState} to return the drawable resource for.
     * @return The drawable resource for the given {@link SortState}.
     */
    int getSortStateViewResource(final SortState state);

}
