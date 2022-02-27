package com.learning;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

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
            URL resource = getClass().getResource(name + suffix);
            if (resource == null) {
                throw new ClassNotFoundException("cant find class " + name);
            }
            byte[] content;
            try {
                content = Files.readAllBytes(Paths.get(resource.toURI()));
            } catch (IOException | URISyntaxException | NullPointerException e) {
                throw new ClassNotFoundException("cant find class " + name);
            }
            for (int i = 0; i < content.length; i++) {
                content[i] ^= 255;
            }
            return defineClass(name.substring(name.lastIndexOf("/") + 1), content, 0, content.length);
        }

    }
}
