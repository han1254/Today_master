package com.nequer.android.utils;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class RcyDiffCallback extends DiffUtil.Callback {
    private List<String> newList;
    private List<String> oldList;

    public RcyDiffCallback(List<String> oldList, List<String> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getClass().equals(newList.get(newItemPosition).getClass());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        String oldStr = oldList.get(oldItemPosition);
        String newStr = newList.get(newItemPosition);
        return oldStr.equals(newStr);
    }

}
