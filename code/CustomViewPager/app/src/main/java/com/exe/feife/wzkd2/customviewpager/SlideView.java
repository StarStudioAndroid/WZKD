package com.exe.feife.wzkd2.customviewpager;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class SlideView extends RelativeLayout
{
	private ViewPager mViewPager;
	private PagerAdapter mPagerAdapter;
	private List<View> mlistPictures;
	private ViewGroup mDotLayout;
	private ImageView[] mDotPictures;
	private int mDotNormal;
	private int mDotFocus;

	public SlideView(Context context)
	{
		this(context, null);
	}

	public SlideView(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public SlideView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		inflate(context, R.layout.layout_slideview, this);
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mDotLayout = (ViewGroup) findViewById(R.id.dotLayout);
		mlistPictures = new ArrayList<View>();

	}

	/**
	 * @param mPictureIds :  the ids represent the pictures that will be showed
	 * @param dotNormal : the unselected dot picture's id
	 * @param dotFocus : the selected dot picture's id
	 */
	public void addPictureIds(List<Integer> mPictureIds, int dotNormal,
			int dotFocus)
	{
		mDotNormal = dotNormal;
		mDotFocus = dotFocus;
		for (int i = 0; i < mPictureIds.size(); i++)
		{
			ImageView _img = new ImageView(getContext());
			_img.setBackgroundResource(mPictureIds.get(i));
			mlistPictures.add(_img);
		}
		mViewPagerAdapter();
		showDots();
		mViewPagerChanged();

	}

	private void mViewPagerAdapter()
	{
		mPagerAdapter = new PagerAdapter()
		{
			@Override
			public boolean isViewFromObject(View arg0, Object arg1)
			{
				return arg0 == arg1;
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object)
			{
				container.removeView(mlistPictures.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position)
			{
				container.addView(mlistPictures.get(position));
				return mlistPictures.get(position);
			}

			@Override
			public int getCount()
			{
				return mlistPictures.size();
			}
		};
		mViewPager.setAdapter(mPagerAdapter);
	}

	private void showDots()
	{
		mDotPictures = new ImageView[mlistPictures.size()];
		for (int i = 0; i < mlistPictures.size(); i++)
		{
			ImageView _img = new ImageView(getContext());
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			params.leftMargin = 6;
			params.rightMargin = 6;
			_img.setLayoutParams(params);
			mDotPictures[i] = _img;
			if (i == 0)
			{
				mDotPictures[i].setBackgroundResource(mDotFocus);
			} else
			{
				mDotPictures[i].setBackgroundResource(mDotNormal);
			}
			mDotLayout.addView(mDotPictures[i]);
		}
	}

	private void mViewPagerChanged()
	{
		mViewPager.setOnPageChangeListener(new OnPageChangeListener()
		{
			@Override
			public void onPageSelected(int arg0)
			{
				for (int i = 0; i < mDotPictures.length; i++)
				{
					mDotPictures[arg0].setBackgroundResource(mDotFocus);
					if (arg0 != i)
					{
						mDotPictures[i].setBackgroundResource(mDotNormal);
					}
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{
			}

			@Override
			public void onPageScrollStateChanged(int arg0)
			{
			}
		});
	}
}
