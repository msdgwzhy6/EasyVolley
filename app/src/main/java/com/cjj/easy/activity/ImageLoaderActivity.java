package com.cjj.easy.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.cjj.easy.constants.Constants;
import com.cjj.easy.me.EasyVolley;
import com.cjj.easy.toolbox.ImageLoader;
import com.cjj.easy.toolbox.ImageLoader.ImageListener;

/**
 * ImageLoader的使用
 *	1. 创建一个RequestQueue对象。
 *	2. 创建一个ImageLoader对象。
 *	3. 获取一个ImageListener对象。
 *	4. 调用ImageLoader的get()方法加载网络上的图片。
 * @author cjj
 *
 */
public class ImageLoaderActivity extends ActionBarActivity implements OnClickListener {
	private ActionBar actionBar;
	private Button btn_imageRequest;
	private ImageView iv_iamge;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(getString(R.string.ImageLoader));
		setContentView(R.layout.activity_image_request);
		findView();
	}

	private void findView() 
	{
		actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		this.btn_imageRequest = (Button) this.findViewById(R.id.btn_image_request);
		this.btn_imageRequest.setOnClickListener(this);
		this.btn_imageRequest.setText(getString(R.string.ImageLoader));
		this.iv_iamge = (ImageView) this.findViewById(R.id.iv_iamge);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
		case android.R.id.home:
			this.finish();
			break;
		}
		return true;
	}

	@Override
	public void onClick(View arg0)
	{
		switch(arg0.getId())
		{
		case R.id.btn_image_request:
			solveImageLoaderRequest();
			break;
		}
	}

	private void solveImageLoaderRequest() 
	{
		ImageLoader imageLoader = EasyVolley.getImageLoader();
		
		ImageListener listener = ImageLoader.getImageListener(iv_iamge,  
		        R.drawable.ic_launcher, R.drawable.ic_launcher);  
		
		imageLoader.get(Constants.PIC_PATH3, listener,600,600);
		
	}
	
	
}
