package com.hs.dbbclientside.module.home.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.hs.dbbclientside.R;
import com.zht.expandablerecyclerview.ParentViewHolder;

/**
 * 作者：zhanghaitao on 2017/11/20 17:24
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ParentItemViewHolder extends ParentViewHolder {

    private static final float INITIAL_POSITION = 0.0f;
    private static final float ROTATED_POSITION = 180f;


    @NonNull
    private final ImageView mArrowExpandImageView;
    private final View line;
    private final TextView question;

    public ParentItemViewHolder(@NonNull View itemView) {
        super(itemView);
        question = (TextView) itemView.findViewById(R.id.use_help_question);
        mArrowExpandImageView = (ImageView) itemView.findViewById(R.id.arrow_expand_imageview);
        line = (View) itemView.findViewById(R.id.use_help_line);
    }

    public void bind(ParentItem parentItem, int parentPosition) {
        question.setText(parentItem.getQuestion());
    }

    @SuppressLint("NewApi")
    @Override
    public void setExpanded(boolean expanded) {
        super.setExpanded(expanded);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            if (expanded) {
                mArrowExpandImageView.setRotation(ROTATED_POSITION);
                line.setVisibility(View.GONE);
            } else {
                mArrowExpandImageView.setRotation(INITIAL_POSITION);
                line.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onExpansionToggled(boolean expanded) {
        super.onExpansionToggled(expanded);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            RotateAnimation rotateAnimation;
            if (expanded) { // rotate clockwise
                rotateAnimation = new RotateAnimation(ROTATED_POSITION,
                        INITIAL_POSITION,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            } else { // rotate counterclockwise
                rotateAnimation = new RotateAnimation(-1 * ROTATED_POSITION,
                        INITIAL_POSITION,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            }

            rotateAnimation.setDuration(200);
            rotateAnimation.setFillAfter(true);
            mArrowExpandImageView.startAnimation(rotateAnimation);
        }
    }



}
