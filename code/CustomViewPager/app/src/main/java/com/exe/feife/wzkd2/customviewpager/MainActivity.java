package com.exe.feife.wzkd2.customviewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity
{
	private SlideView mSlideView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSlideView = (SlideView) findViewById(R.id.slideView);
		List<Integer> pictureIds = new ArrayList<Integer>();
		pictureIds.add(R.mipmap.plant1);
		pictureIds.add(R.mipmap.plant2);
		pictureIds.add(R.mipmap.plant3);
		pictureIds.add(R.mipmap.plant1);
		pictureIds.add(R.mipmap.plant2);
		pictureIds.add(R.mipmap.plant3);
		pictureIds.add(R.mipmap.plant1);
		pictureIds.add(R.mipmap.plant2);
		pictureIds.add(R.mipmap.plant3);
		mSlideView.addPictureIds(pictureIds, R.mipmap.icon_viewpager_dot_normal,
				R.mipmap.icon_viewpager_dot_focus);
	}

}
