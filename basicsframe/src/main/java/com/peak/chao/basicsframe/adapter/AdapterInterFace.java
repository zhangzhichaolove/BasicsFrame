package com.peak.chao.basicsframe.adapter;

import java.util.List;

/**
 * Created by 003 on 2018/3/8.
 */

public interface AdapterInterFace<T> {

    void addAll(List<T> data);

    void setData(List<T> data);

    List<T> getData();
}
