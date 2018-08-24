package com.rambo.rxjava2.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rambo.rxjava2.R;
import java.util.List;
import javax.inject.Inject;

/**
 * file explain
 *
 * @author rambo
 * @version 1.0 2018-08-24
 * @since JDK 1.8
 */
public class MainAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    @Inject
    public MainAdapter(List<String> list) {
        super(R.layout.main_list_item, list);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
       helper.setText(R.id.item_name,item);
    }


}
