package com.peak.chao.basicsframe.injection;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.lang.reflect.Field;

/**
 * 注解获取Id解析类
 * Created by Chao on 2017-12-23.
 */

public class FindView {


    public static void bind(Object context) {
        Activity at = null;
        //判断传入的context实例
        if (context instanceof Activity) {
            at = (Activity) context;
        } else if (context instanceof Fragment) {
            Fragment fr = (Fragment) context;
            at = fr.getActivity();
        }
        // 获取这个activity中的所有成员变量
        Field[] fields = at.getClass().getDeclaredFields();
        for (Field field : fields) {
            // 获取该变量上面有没有打这个注解
            Id mId = field.getAnnotation(Id.class);
            if (mId != null) {// 有此注解
                int id = mId.value();// 获取注解值
                if (id != 0) {
                    field.setAccessible(true);
                    Object view = null;
                    try {
                        view = at.findViewById(id);// 根据注解ID在Activity布局查找控件
                        // 设置字段的属性
                        field.set(at, view);// 在at中将field变量设置值view
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
