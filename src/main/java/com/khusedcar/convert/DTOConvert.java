package com.khusedcar.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础对象转换输出输入对象
 */
public class DTOConvert {
    /**
     * 转换单个对象
     *
     * @param source
     * @param target
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T copy(Object source, Class<T> target) throws Exception {
        T targetInstanse = null;
        targetInstanse = target.newInstance();
        BeanUtils.copyProperties(source, targetInstanse);
        return targetInstanse;
    }

    /**
     * 列表转换
     *
     * @param sourceList
     * @param target
     * @param <T>
     * @param <E>
     * @return
     */
    public static <T, E> List<T> copyList(List<E> sourceList, Class<T> target) throws Exception {
        List<T> targetInstance = new ArrayList<>();
        if (CollectionUtils.isEmpty(sourceList)) {
            return targetInstance;
        }
        for (E e : sourceList) {
            targetInstance.add(copy(e, target));
        }
        return targetInstance;
    }

    /**
     * 对象转MAP
     * @param source
     * @return
     */
    public static Map<String,Object> copyMap(Object source) throws Exception {
        if (source == null){
            return null;
        }
        Map<String, Object> result = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(source.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors){
            String key = property.getName();
            //过滤class属性
            if (!key.equals("class")){
                Method method = property.getReadMethod();
                Object value = method.invoke(source);
                if (StringUtils.isEmpty(value.toString())){
                    value = null;
                }
                result.put(key,value);
            }
        }
        return result;
    }
}


