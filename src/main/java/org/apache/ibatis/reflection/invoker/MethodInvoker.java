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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.ibatis.modle.User;
import org.apache.ibatis.reflection.Reflector;

/**
 * @author Clinton Begin
 */
public class MethodInvoker implements Invoker {

  private final Class<?> type;
  private final Method method;


  //初始化方法执行器，传入方法对象
  public MethodInvoker(Method method) {
    this.method = method;
    //如果方法参数列表大小== 1时，type=参数类型，否则type=方法返回类型
    if (method.getParameterTypes().length == 1) {
      type = method.getParameterTypes()[0];
    } else {
      type = method.getReturnType();
    }
  }

  /**
   * 方法调用，
   * @param target 目标对象/调用方法的对象
   * @param args 调用参数
   * @return
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   */
  @Override
  public Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException {
    try {
      return method.invoke(target, args);
    } catch (IllegalAccessException e) {
      if (Reflector.canControlMemberAccessible()) {
        method.setAccessible(true);
        return method.invoke(target, args);
      } else {
        throw e;
      }
    }
  }

  /**
   * 获取类型，如果方法参数列表大小== 1时，type=参数类型，否则type=方法返回类型
   * @return
   */
  @Override
  public Class<?> getType() {
    return type;
  }


  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method method = User.class.getMethod("getUser", new Class[]{String.class});
    Invoker invoker = new MethodInvoker(method);

    Object a = invoker.invoke(new User(),new Object[]{"1111"});

    Class clazz = invoker.getType();
    System.out.println(clazz);
  }
}
