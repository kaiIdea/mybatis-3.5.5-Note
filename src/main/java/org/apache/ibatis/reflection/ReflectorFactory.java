/**
 *    Copyright 2009-2015 the original author or authors.
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
package org.apache.ibatis.reflection;

public interface ReflectorFactory {

  boolean isClassCacheEnabled();

  void setClassCacheEnabled(boolean classCacheEnabled);

  /**
   * 根据类型获取，反射核心类()
   * @param type
   * @return 此类表示一组缓存的类定义信息
   */
  Reflector findForClass(Class<?> type);
}
