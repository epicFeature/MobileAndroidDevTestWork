package com.ntpro.mobileandroiddevtestwork.sorttablefork;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ntpro.mobileandroiddevtestwork.sorttablefork.model.TableColumnModel;
import com.ntpro.mobileandroiddevtestwork.sorttablefork.model.TableColumnWeightModel;

/**
 * The abstract implementation of an adapter used to bring data to a {@link TableHeaderView}.
 *
 * @author ISchwarz
 */
public abstract class TableHeaderAdapter extends ArrayAdapter {

    private final Context context;
    private TableColumnModel columnModel;


    /**
     * Creates a new TableHeaderAdapter.
     *
     * @param context The context that shall be used.
     */
    public TableHeaderAdapter(final Context context) {
        this(context, 0);
    }

    /**
     * Creates a new TableHeaderAdapter. (internally used)
     *
     * @param context     The context that shall be used.
     * @param columnCount The number of columns.
     */
    protected TableHeaderAdapter(final Context context, final int columnCount) {
        this(context, new TableColumnWeightModel(columnCount));
    }

    /**
     * Creates a new TableHeaderAdapter. (internally used)
     *
     * @param context     The context that shall be used.
     * @param columnModel The column model to be used.
     */
    protected TableHeaderAdapter(final Context context, final TableColumnModel columnModel) {
        super(context, 0);
        this.context = context;
        this.columnModel = columnModel;
    }

    /**
     * Gives the {@link Context} of this adapter. (Hint: use this method in the {@code getHeaderView()}-method
     * to programmatically initialize new views.)
     *
     * @return The {@link Context} of this adapter.
     */
    public Context getContext() {
        return context;
    }

    /**
     * Gives the {@link LayoutInflater} of this adapter. (Hint: use this method in the
     * {@code getHeaderView()}-method to inflate xml-layout-files.)
     *
     * @return The {@link LayoutInflater} of this adapter.
     */
    public LayoutInflater getLayoutInflater() {
        return (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Gives the {@link Resources} of this adapter. (Hint: use this method in the
     * {@code getHeaderView()}-method to resolve resources.)
     *
     * @return The {@link Resources} of the context of this adapter.
     */
    public Resources getResources() {
        return getContext().getResources();
    }

    /**
     * Gives the {@link TableColumnWeightModel} that is currently used to render the table headers.
     *
     * @return The {@link TableColumnModel} which is currently used.
     */
    protected TableColumnModel getColumnModel() {
        return columnModel;
    }

    /**
     * Sets the {@link TableColumnModel} that will be used to render the table headers.
     *
     * @param columnModel The {@link TableColumnModel} that should be used.
     */
    protected void setColumnModel(final TableColumnModel columnModel) {
        this.columnModel = columnModel;
    }

    /**
     * Gives the column count that is currently used to render the table headers.
     *
     * @return The number of columns.
     */
    protected int getColumnCount() {
        return columnModel.getColumnCount();
    }

    /**
     * Sets the column count which is used to render the table headers.
     *
     * @param columnCount The column count that should be set.
     */
    protected void setColumnCount(final int columnCount) {
        columnModel.setColumnCount(columnCount);
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public final View getView(final int position, final View convertView, final ViewGroup parent) {

        final LinearLayout rowView = new LinearLayout(getContext());

        final AbsListView.LayoutParams rowLayoutParams = new AbsListView.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rowView.setLayoutParams(rowLayoutParams);
        rowView.setGravity(Gravity.CENTER_VERTICAL);

        final int tableWidth = parent.getWidth();
        for (int columnIndex = 0; columnIndex < getColumnModel().getColumnCount(); columnIndex++) {
            View cellView = getHeaderView(columnIndex, rowView);
            if (cellView == null) {
                cellView = new TextView(getContext());
            }

            final int cellWidth = getColumnModel().getColumnWidth(columnIndex, tableWidth);
            final LinearLayout.LayoutParams cellLayoutParams = new LinearLayout.LayoutParams(cellWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
            cellView.setLayoutParams(cellLayoutParams);
            rowView.addView(cellView);
        }

        return rowView;
    }

    /**
     * Method that gives the header views for the different columns.
     *
     * @param columnIndex The index of the column to return the header view.
     * @param parentView  The view to which the returned view will be added.
     * @return The created header view for the given column.
     */
    public abstract View getHeaderView(int columnIndex, ViewGroup parentView);

}
