package com.learning;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.Optional;

/**
 * @author kun
 * @date 2022/2/28
 */
public class ModuleLoaderRunner {

    public static void main(String[] args) throws Exception {
        ModuleLoader loader = new ModuleLoader();
        Class<?> hello = loader.loadClass("Hello");
        Object instanceHello = hello.getDeclaredConstructor().newInstance();
        Method methodHello = hello.getMethod("hello");
        methodHello.invoke(instanceHello);
    }

    public static class ModuleLoader extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            // 或者使用 module-path 寻找？
            ModuleFinder finder = ModuleFinder.of(
                    Path.of(this.getClass().getPackageName().replace(".", "/") + "/" + name + ".jar")
            );
            Optional<ModuleReference> reference = finder.find(name);
            if (reference.isEmpty()) {
                throw new ClassNotFoundException("does't find class " + name);
            }
            try (
                    ModuleReader reader = reference.get().open()
            ) {
                Optional<InputStream> iso = reader.open(name + ".xlass");
                if (iso.isEmpty()) {
                    throw new ClassNotFoundException("class " + name + " not found");
                }
                try (
                        InputStream is = iso.get();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ) {
                    byte[] buffer = new byte[32];
                    int len;
                    while ((len = is.read(buffer)) != -1) {
                        baos.write(buffer, 0, len);
                    }
                    byte[] content = baos.toByteArray();
                    for (int i = 0; i < content.length; i++) {
                        content[i] ^= 255;
                    }
                    return defineClass(name, content, 0, content.length);
                }
            } catch (IOException e) {
                throw new ClassNotFoundException("load class " + name + " failed");
            }
        }
    }
}
