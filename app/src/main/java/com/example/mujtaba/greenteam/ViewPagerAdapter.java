package com.example.mujtaba.greenteam;

/**
 * Created by Mujtaba on 3/17/2018.
 */
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context ;
    private LayoutInflater layoutInflater;
    private Integer [] img = {R.drawable.img11,R.drawable.img22};
    @Override
    public int getCount() {
        return img.length;
    }

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(img[position]);
        ViewPager vp = ( ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View v = (View) object;
        vp.removeView(v);
    }
}
