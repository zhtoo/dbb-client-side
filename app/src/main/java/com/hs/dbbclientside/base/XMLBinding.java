package com.hs.dbbclientside.base;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/2/23 14:55
 * Description: XML binding数据
 * <p/>
 * xmlns:app="http://schemas.android.com/apk/res-auto"
 */
public class XMLBinding {
    /**
     * 设置方向指示器
     */
    @BindingAdapter({"imageIndicator"})
    public static void imageIndicator(ImageView imageView, boolean isShow) {
        if (isShow) {
            //imageView.setImageResource(R.drawable.ic_arrow_bottom);
        } else {
            //imageView.setImageResource(R.drawable.ic_arrow_right);
        }
    }

    /**
     * 为ImageView设置图片
     */
    @BindingAdapter(value = {"src", "defaultImage"}, requireAll = false)
    public static void setImage(final ImageView imageView, String path, Drawable defaultImage) {
        if (null == defaultImage) {
           // defaultImage = ContextCompat.getDrawable(imageView.getContext(), R.drawable.morentouxiang);
        }
        Glide.with(imageView.getContext()).load(path).error(defaultImage).into(imageView);
    }
    /**
     * 为ImageView设置图片
     */
    @BindingAdapter(value = {"progressingDrawable", "progresSuccDrawable"}, requireAll = false)
    public static void setImage1(final ImageView imageView, String path, Drawable defaultImage) {
        if (null == defaultImage) {
           // defaultImage = ContextCompat.getDrawable(imageView.getContext(), R.drawable.morentouxiang);
        }
        Glide.with(imageView.getContext()).load(path).error(defaultImage).into(imageView);
    }



    /**
     * 设置view是否显示
     *
     * @param visible
     *         true - 显示
     *         false - 不显示
     */
    @BindingAdapter({"visibility"})
    public static void viewVisibility(View view, boolean visible) {
        if (visible) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    /**
     * 设置显示内容值类型转换为string
     */
    @BindingAdapter({"toString"})
    public static void valueToString(TextView view, Object object) {
        view.setText(String.valueOf(object));
    }

    /**
     * 如果text为空，则不显示
     */
    @BindingAdapter({"text"})
    public static void setText(TextView view, String str) {
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
            view.setText(str);
        }
    }

    /**
     * 为RecyclerView添加分割线
     *
     * @param type
     *         水平 - HORIZONTAL = 0;
     *         垂直 - VERTICAL = 1;
     */
    @BindingAdapter({"addItemDecoration"})
    public static void addItemDecoration(RecyclerView view, int type) {
//        DividerLine dividerLine;
//        switch (type) {
//            case DividerLine.HORIZONTAL:
//                dividerLine = new DividerLine(DividerLine.HORIZONTAL);
//                dividerLine.setMarginLeft(20);
//                view.addItemDecoration(dividerLine);
//                break;
//
//            case DividerLine.VERTICAL:
//                dividerLine = new DividerLine(DividerLine.VERTICAL);
//                dividerLine.setMarginLeft(20);
//                view.addItemDecoration(dividerLine);
//                break;
//            case DividerLine.CROSS:
//                dividerLine = new DividerLine(DividerLine.CROSS);
//                view.addItemDecoration(dividerLine);
//                break;
//
//            case DividerLine.DEFAULT:
//            default:
//                break;
//        }
    }

    /**
     * 下拉刷新，上拉加载
     *
     * @param ptrFrame
     *         view
     * @param listener
     *         实现操作
     */
//    @BindingAdapter({"ptrFrame"})
//    public static void ptrFrame(final PtrClassicFrameLayout ptrFrame, final PtrFrameListener listener) {
//        if (null == listener) {
//            ptrFrame.setEnabled(false);
//            return;
//        } else {
//            ptrFrame.setEnabled(true);
//        }
//        ptrFrame.setPtrHandler(new PtrHandler2() {
//            @Override
//            public void onRefreshBegin(PtrFrameLayout frame) {
//                listener.ptrFrameRefresh();
//                listener.ptrFrameRequest(frame);
//            }
//
//            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
//                return PtrDefaultHandler2.checkContentCanBePulledDown(frame, content, header);
//            }
//
//            @Override
//            public void onLoadBegin(PtrFrameLayout frame) {
//                listener.ptrFrameRequest(frame);
//            }
//
//            public boolean checkCanDoLoad(PtrFrameLayout frame, View content, View footer) {
//                return PtrDefaultHandler2.checkContentCanBePulledUp(frame, content, footer);
//            }
//        });
//        ptrFrame.disableWhenHorizontalMove(true);
//        // 初始化view
//        ptrFrame.setLastUpdateTimeRelateObject(ptrFrame);
//        ptrFrame.setMode(PtrFrameLayout.Mode.REFRESH);
//        listener.ptrFrameInit(ptrFrame);
//    }

    /**
     * 设置TextView显示不同颜色的字体（仅限改变数字颜色）
     */
    @BindingAdapter(value = {"middleColor", "middleValue"}, requireAll = false)
    public static void middleColorShow(TextView view, Integer color, String value) {
//        if (color == null) {
//            throw new IllegalArgumentException("TextView color must not be null");
//        }
//        if (value == null) {
//            //设置默认值
//            value = "0";
//            throw new IllegalArgumentException("TextView value must not be null");
//        }
//        view.setText(DisplayFormat.XLIFFNumFormat(value, color));
    }

    /**
     * 限制EditText只能输入两位小数
     *
     * @param toggle
     *         开关
     */
    @BindingAdapter({"filter"})
    public static void lengthfilter(EditText view, boolean toggle) {
//        if (toggle) {
//            InputFilter[] old      = view.getFilters();
//            InputFilter[] filters  = new InputFilter[old.length + 1];
//            int           position = 0;
//            for (; position < old.length; position++) {
//                filters[position] = old[position];
//            }
//            filters[position] = EditTextFormat.getLengthFilter();
//            view.setFilters(filters);
//        }
    }

    /**
     * 根据不同的状态，设置marginLeft的值
     *
     * @param type
     *         开关
     */
//    @BindingAdapter({"marginLeft"})
//    public static void marginLeft(View view, int type) {
//        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) view.getLayoutParams();
//        if (type == 0) {
//            lp.leftMargin = R.dimen.x0;
//        } else {
//            lp.leftMargin = R.dimen.x20;
//        }
//        view.setLayoutParams(lp);
//    }

    /**
     * 投标按钮文字显示(对staus值进行转换)
     * <p/>
     * tip:标可投条件是 标的status是1并且标的余额不为0
     */
//    @BindingAdapter(value = {"status", "timeToStart", "scales", "financingMo"}, requireAll = false)
//    public static void statusType(TextView view, String status, String timeToStart, String scales, FinancingMo mo) {
//        if (!(status == null || status.equals(""))) {
//            Context context = view.getContext();
//            view.setEnabled(false);
//            if (status.equals("-1")) {
//                view.setText("募集失败");
//            } else if (status.equals("-2")) {
//                view.setText("撤回处理中");
//            } else if (status.equals("0")) {
//                view.setText("等待初审");
//            } else if (status.equals("1")) {
//                if (!mo.isCanTender() && mo.isNewbieOnly()) {
//                    view.setText("仅限新手");
//                    return;
//                }
//
//                if (Double.valueOf(scales) == 100) {
//                    view.setText("满标待审");
//                } else {
//                    view.setText("立即投资");
//                    view.setEnabled(true);
//                }
//            } else if (status.equals("2")) {
//                view.setText("初审未通过");
//            } else if (status.equals("3")) {
//                view.setText("复审通过");
//            } else if (status.equals("4") || status.equals("49")) {
//                view.setText("复审未通过");
//            } else if (status.equals("5") || status.equals("59")) {
//                view.setText("管理员撤回");
//            } else if (status.equals("6")) {
//                view.setText("还款中");
//            } else if (status.equals("7")) {
//                view.setText("部分还款");
//            } else if (status.equals("8")) {
//                view.setText("还款成功");
//            } else {
//                view.setText("已撤回");
//            }
//
//            //保持文字居中,不设此属性显示会有问题
//            view.setGravity(Gravity.CENTER);
//            //定时判断
//            timeToStart = timeToStart == null ? "-1" : timeToStart;
//            Long StartTime = Long.valueOf(timeToStart);
//
//            if (StartTime > 0) {
//                new Countdown(view.getContext(), view, StartTime, "剩余", true);
//            }
//        } else {
//            view.setEnabled(false);
//        }
//    }

    /**
     * 剩余金额不足时,不与输入投资金额
     */
    @BindingAdapter(value = {"minMoney", "remainMoney"}, requireAll = true)
    public static void canEdit(EditText ed, double minMoney, double remainMoney) {
//        if (minMoney > remainMoney) {
//            ed.setEnabled(false);
//            ed.setText(String.valueOf(remainMoney));
//        }
    }

    /**
     * 设置Textview drawable ColorFilter
     *
     * @param tv
     * @param drawableLeft
     * @param drawableTop
     * @param drawableRight
     * @param drawableBottom
     * @param color
     */
    @BindingAdapter(value = {"drawableLeft", "drawableTop", "drawableRight", "drawableBottom", "colorFilter"}, requireAll = false)
    public static void drawableText(TextView tv, Drawable drawableLeft, Drawable drawableTop, Drawable drawableRight, Drawable drawableBottom, int color) {
//        if (0 == color) {
//            color = ContextCompat.getColor(tv.getContext(), R.color.app_color_principal);
//        }
//        if (null != drawableLeft) {
//            drawableLeft.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
//        }
//        if (null != drawableTop) {
//            drawableTop.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
//        }
//        if (null != drawableBottom) {
//            drawableRight.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
//        }
//        if (null != drawableBottom) {
//            drawableRight.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
//        }
//        tv.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);
    }

    /**
     * 设置Textview drawable ColorFilter
     *
     * @param imageView
     * @param color
     */
    @BindingAdapter(value = {"drawable", "colorFilter"}, requireAll = true)
    public static void drawableImageView(ImageView imageView, Drawable drawable, int color) {
//        if (0 == color) {
//            color = ContextCompat.getColor(imageView.getContext(), R.color.app_color_principal);
//        }
//        if (null != drawable) {
//            drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
//        }
//
//        imageView.setImageDrawable(drawable);
    }

    /**
     * list 中 EditText 变化通知
     */
//    @BindingAdapter(value = {"watcher", "list"}, requireAll = false)
//    public static void setEditChangelistener(EditText ed, EditTextFormat.EditTextFormatWatcher watcher, LinkedList<EditText> edlist) {
//        if (null != watcher) {
//            EditTextFormat.editChange(ed, watcher);
//        }
//        if (null != edlist) {
//            edlist.add(ed);
//        }
//    }

    /**
     * 添加背景透明度
     */
    @BindingAdapter({"alpha"})
    public static void setalpha(View view, int alpha) {
        view.getBackground().setAlpha(alpha);
    }
}
