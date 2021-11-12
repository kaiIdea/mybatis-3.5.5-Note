/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection.property;

import java.lang.reflect.Field;

import org.apache.ibatis.reflection.Reflector;

/**
 * Copier:复印. 对象属性值copy,但是要注意，这里的操作是浅拷贝，对于引用类型，copy的是对象引用地址。可能会存在不同对象的相同成员类，
 * 指向同一个对象。
 * @author Clinton Begin
 *
 */
public final class PropertyCopier {

  private PropertyCopier() {
    // Prevent Instantiation of Static Class
  }

  /**
   *
   * @param type  对象模板类
   * @param sourceBean 源对象/被拷贝对象
   * @param destinationBean 目标对象/拷贝对象
   */
  public static void copyBeanProperties(Class<?> type, Object sourceBean, Object destinationBean) {
    Class<?> parent = type;
    //判断对象模板类是否为空，
    while (parent != null) {
      //获取类属性
      final Field[] fields = parent.getDeclaredFields();
      for (Field field : fields) {
        try {
          try {
            //进行属性值copy
            field.set(destinationBean, field.get(sourceBean));
          } catch (IllegalAccessException e) {
            //若私有属性，修改访问权限，再次copy
            if (Reflector.canControlMemberAccessible()) {
              field.setAccessible(true);
              field.set(destinationBean, field.get(sourceBean));
            } else {
              throw e;
            }
          }
        } catch (Exception e) {
          // Nothing useful to do, will only fail on final fields, which will be ignored.
        }
      }
      //父类属性值，也可以copy
      parent = parent.getSuperclass();
    }
  }

}
