package com.hs.dbbclientside.module.home.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hs.dbbclientside.R;
import com.zht.expandablerecyclerview.ExpandableRecyclerAdapter;

import java.util.List;

/**
 * 作者：zhanghaitao on 2017/11/20 17:25
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class UseHelpAdapter extends ExpandableRecyclerAdapter<ParentItem, ChildItem, ParentItemViewHolder, ChildItemViewHolder> {

    private LayoutInflater mInflater;
    private List<ParentItem> mParentList;
    private Context context;

    public UseHelpAdapter(Context context, @NonNull List<ParentItem> parentList) {
        super(parentList);
        this.context = context;
        mParentList = parentList;
        mInflater = LayoutInflater.from(context);
    }

    /**
     * 在这里决定父类的视图
     * @param viewGroup
     * @param viewType
     * @return
     */
    @UiThread
    @NonNull
    @Override
    public ParentItemViewHolder onCreateParentViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = mInflater.inflate(R.layout.item_usehelp_question, viewGroup, false);
        return new ParentItemViewHolder(view);
    }

    /**
     * 在这里决定孩子的视图
     * @param viewGroup
     * @param viewType
     * @return
     */
    @UiThread
    @NonNull
    @Override
    public ChildItemViewHolder onCreateChildViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = mInflater.inflate(R.layout.item_usehelp_answer, viewGroup, false);
        ChildItemViewHolder viewHolder = new ChildItemViewHolder(view);
        return viewHolder;
    }

    @UiThread
    @Override
    public void onBindParentViewHolder(@NonNull ParentItemViewHolder parentItemViewHolder, int parentPosition, @NonNull ParentItem parentItem) {
        parentItemViewHolder.bind(parentItem,parentPosition);
    }

    @UiThread
    @Override
    public void onBindChildViewHolder(@NonNull ChildItemViewHolder childItemViewHolder, int parentPosition, int childPosition, @NonNull ChildItem childItem) {
        childItemViewHolder.bind(childItem,parentPosition,childPosition);
    }

    public void setChildItemClickListener(ChildItemClickListener childItemClickListener) {
        this.listener = childItemClickListener;
    }

    private ChildItemClickListener listener;
    public interface  ChildItemClickListener{
        void onChildItemClick(int parentPosition, int childPosition);
    }


}
