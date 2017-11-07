package com.py.somesuggest.chapter7.no109;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 不需要太多关注反射效率
 * Created by Administrator on 2017/11/7 0007.
 * 注意：反射效率低是个真命题，但因为这一点而不使用它就是个假命题。
 */
public class No109 {
    public static void main(String[] args) {
        System.out.println(Utils.getGenericClassType(UserDao.class));
    }
}

class Utils {
    //获得一个泛型类的实际泛型类型
    public static <T> Class<T> getGenericClassType(Class clz) {
        Type type = clz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type[] types = pt.getActualTypeArguments();
            if (types.length > 0 && types[0] instanceof Class) {
                //若有多个泛型参数，依据索引位置返回
                return (Class) types[0];
            }
        }
        return (Class) Object.class;
    }
}
abstract class BaseDao<T>{
    //获得T的运行期类型
    private Class<T> clz = Utils.getGenericClassType(getClass());
    //根据主键获得一条记录
    public void get(long id){
    }
}
//对于UserDao类，编译器编译时已经明确了其参数类型是String，因此可以通过反射的方法来获取其类型，这也是getGenericClassType方法使用的场景。
class UserDao extends BaseDao<String>{

}