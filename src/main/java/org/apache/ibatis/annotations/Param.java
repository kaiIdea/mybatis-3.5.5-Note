/**
 *    Copyright 2009-2020 the original author or authors.
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
package org.apache.ibatis.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation that specify the parameter name.
 *
 * <p>
 * <b>How to use:</b>
 *
 * <pre>
 * public interface UserMapper {
 *   &#064;Select("SELECT id, name FROM users WHERE name = #{name}")
 *   User selectById(&#064;Param("name") String value);
 * }
 * </pre>
 *
 * @author Clinton Begin
 */
@Documented //该注解会保留在Api文档中
@Retention(RetentionPolicy.RUNTIME) //注解会保留到运行阶段
@Target(ElementType.PARAMETER) //可以用在参数上
public @interface Param {
  /**
   *
   * 如果一个注解只有一个名为Value的属性，则在使用过程中为该属性赋值时，可以省略属性名
   * Returns the parameter name.
   *
   * @return the parameter name
   */
  String value();




  //@Target （ANNOTATION_TYPE 注解, CONSTRUCTOR 构造函数, FIELD 字段/属性, LOCAL_VARIABLE 本地变量, METHOD 方法, PACKAGE 包, PARAMETER 参数, TYPE 类/接口/注解/枚举, TYPE_PARAMETER）
  //@Retention SOURCE(保留到源代码阶段，编译的时候会被擦除)，CLASS（保留到类文件阶段，这是默认值的生命周期，JVM运行时会被擦除）RUNTIME （保留到JVM运行阶段）
  //@Inherited 可以被继承
}
