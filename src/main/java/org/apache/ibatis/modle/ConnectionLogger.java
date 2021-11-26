package org.apache.ibatis.modle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/26 10:12
 * @Description: TODO
 */
public class ConnectionLogger implements InvocationHandler {

  private Connection connection;

  public ConnectionLogger(Connection connection) {
    this.connection = connection;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return method.invoke(connection,args);
  }


  public static void main(String[] args) throws SQLException {
    Connection connection = new ConnectionImpl();
    InvocationHandler invocationHandler = new ConnectionLogger(connection);

    Connection cc = (Connection) Proxy.newProxyInstance(connection.getClass().getClassLoader(),connection.getClass().getInterfaces(),invocationHandler);
    cc.close();
  }
}
