/**
 *    Copyright 2009-2018 the original author or authors.
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
package org.apache.ibatis.reflection.invoker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.ibatis.modle.User;
import org.apache.ibatis.reflection.Reflector;

/**
 *  获取对象属性值
 * @author Clinton Begin
 */
public class GetFieldInvoker implements Invoker {
  private final Field field;

  /**
   * 初始化传入Field对象
   * @param field
   */
  public GetFieldInvoker(Field field) {
    this.field = field;
  }

  /**
   * 调用方法，获取属性值
   * @param target
   * @param args
   * @return
   * @throws IllegalAccessException
   */
  @Override
  public Object invoke(Object target, Object[] args) throws IllegalAccessException {
    try {
      return field.get(target);
    } catch (IllegalAccessException e) {
      if (Reflector.canControlMemberAccessible()) {
        field.setAccessible(true);
        return field.get(target);
      } else {
        throw e;
      }
    }
  }

  /**
   * 获取属性类型
   * @return
   */
  @Override
  public Class<?> getType() {
    return field.getType();
  }

  public static void main(String[] args) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
    User user = new User();
    Invoker invoker = new GetFieldInvoker(User.class.getDeclaredField("userName"));

    Object a = invoker.invoke(user,null);

    System.out.println(invoker.getType());


  }
}
