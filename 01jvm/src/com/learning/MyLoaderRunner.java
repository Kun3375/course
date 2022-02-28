package com.learning;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @author kun
 * @date 2022/2/27
 */
public class MyLoaderRunner extends ClassLoader {

    public static void main(String[] args) throws Exception {
        MyClassLoader loader = new MyClassLoader();
        Class<?> classHello = loader.loadClass("Hello");
        Object instanceHello = classHello.newInstance();
        Method methodHello = classHello.getMethod("hello");
        methodHello.invoke(instanceHello);
    }

    public static class MyClassLoader extends ClassLoader {

        @Override
        public Class<?> findClass(String name) throws ClassNotFoundException {
            // 约定特殊加载的后缀为 xlass；放在 classPath 下；无包名
            String suffix = ".xlass";
            try (
                    InputStream resource = getClass().getResourceAsStream(name + suffix);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream()
            ) {
                if (resource == null) {
                    throw new ClassNotFoundException("cant find class " + name);
                }
                byte[] buffer = new byte[32];
                int len;
                while ((len = resource.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                byte[] content = baos.toByteArray();
                for (int i = 0; i < content.length; i++) {
                    content[i] ^= 255;
                }
                return defineClass(name.substring(name.lastIndexOf("/") + 1), content, 0, content.length);
            } catch (IOException e) {
                throw new ClassNotFoundException("cant process class " + name);
            }

        }

    }
}
