package day01.core4_groupon.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;
import android.widget.VideoView;

import day01.core4_groupon.config.Constant;

/**
 * 对偏好设置文件的操作(3种方式2 )
 *
 * 1) Context的getSharedPreferences(文件名,模式);//参数是:文件名字,储存位置
 * 2) Activity的getPreference(模式);获取以preference_activiy名的偏好设置文件
 * 3) PreferenceManager的getDefaultSharedPreferences(Context);
 *    获取preference_包名 偏好设置文件
 *    模式 Context_MODE_PRIVATE
 * Created by tarena on 2017/6/15.
 */

public class SharedPreFerencesUtil {

    SharedPreferences sp ;

    //通过构造方法重载,以不同的方式来获得偏好设置文件
    public SharedPreFerencesUtil(Context context , String name) {
        sp = context.getSharedPreferences(name,Context.MODE_PRIVATE);
    }

    public SharedPreFerencesUtil(Context context) {
        sp = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean isFirst(){
        return sp.getBoolean(Constant.FIRST,true);
    }

    public void setFirst(boolean first){
        //把偏好设置改为假
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(Constant.FIRST,first);
        editor.commit();//保存
    }

}
