package com.zspt.app.modulecouresdetails.adapter;



import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zspt.app.modulecouresdetails.R;
import com.zspt.app.modulecouresdetails.course_watch.model.ChapterLevel0Item;
import com.zspt.app.modulecouresdetails.course_watch.model.ChapterLevel1Item;

import java.util.List;


/**
 * Created by yuequan on 2017/10/17.
 */

public class ChapterAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity,BaseViewHolder> {
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ChapterAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_chapter_level0);
        addItemType(TYPE_LEVEL_1, R.layout.item_chapter_level1);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()){
            case TYPE_LEVEL_0:
                final ChapterLevel0Item lv0= (ChapterLevel0Item) item;
                helper.setText(R.id.item_chapter_level0_chapter,lv0.getChapter());

                break;
            case TYPE_LEVEL_1:
                final ChapterLevel1Item lv1= (ChapterLevel1Item) item;
                helper.setText(R.id.item_chapter_level1_content,lv1.getTitle())
                        .setText(R.id.item_chapter_level1_length,lv1.getLength());
                break;
            default:
                break;

        }
    }
}
