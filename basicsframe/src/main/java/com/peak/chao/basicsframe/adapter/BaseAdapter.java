package com.peak.chao.basicsframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 003 on 2018/3/8.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> implements AdapterInterFace<T> {
    private List<T> mData;
    private int layoutId;
    protected Context mContext;
    private RLItemViewType<T> itemViewType;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    /**
     * 单布局构造
     */
    public BaseAdapter(Context context, List<T> mDatas, int layoutId) {
        this.mContext = context;
        this.mData = mDatas;
        if (this.mData == null) {
            this.mData = new ArrayList<>();
        }
        this.layoutId = layoutId;
        this.itemViewType = null;
    }

    /**
     * 多布局构造
     */
    public BaseAdapter(Context context, List<T> mDatas, RLItemViewType<T> viewType) {
        this.mContext = context;
        this.mData = mDatas;
        if (this.mData == null) {
            this.mData = new ArrayList<>();
        }
        this.itemViewType = viewType == null ? createViewType() : viewType;
        if (itemViewType == null) {
            //使用这个构造函数，你必须实现RLItemViewType接口。
            new NullPointerException("NullPointerException  With this constructor, you must implement the RLItemViewType interface.");
        }
    }

    /**
     * 如果多布局未在构造中指定Type时，需要在内部实现此方法
     */
    protected RLItemViewType<T> createViewType() {
        return null;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        //加载指定item布局
        View inflate = LayoutInflater.from(mContext).inflate(itemViewType == null ?
                layoutId : itemViewType.getLayoutId(viewType), parent, false);
        final ViewHolder holder = new ViewHolder(inflate);
        //用户需要监听时，才设置监听事件
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, viewType, holder.getAdapterPosition());
                }
            });
        }
        if (mOnItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemLongClickListener.onItemLongClick(v, viewType, holder.getAdapterPosition());
                    return true;
                }
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        onBind(holder, position, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData == null || mData.size() <= 0 ? 0 : mData.size();
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setmOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    @Override
    public void addAll(List<T> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public void setData(List<T> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public List<T> getData() {
        return mData;
    }

    /**
     * 绑定数据操作
     */
    public abstract void onBind(ViewHolder holder, int position, T item);
}
