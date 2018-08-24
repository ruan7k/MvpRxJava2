package com.rambo.rxjava2.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rambo.rxjava2.R;
import com.rambo.rxjava2.ui.entity.NovelBean;
/**
 * @author rambo
 * @version 1.0 2018-08-23
 * @since JDK 1.8
 */
public class NovelAdapter extends BaseQuickAdapter<NovelBean, BaseViewHolder> {


    public NovelAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, NovelBean item) {

        helper.setText(R.id.book_name,item.getBookname().trim());
        helper.setText(R.id.book_info,item.getIntroduction().trim());



    }
}
