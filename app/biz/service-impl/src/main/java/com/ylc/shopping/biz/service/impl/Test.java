/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shopping.biz.service.impl;

import java.io.File;
import java.io.IOException;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 *
 * @author ylc
 * @version $Id: Test.java, v 0.1 2018年08月12日 7:23 ylc Exp $
 */
public class Test {

    private final static String MODULE_PATH = "./target/classes/";

    public static void main(String[] args)
            throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {
        //System.setProperty("sun.boot.class.path", "C:\\Users\\ylc\\Desktop\\shopping\\app\\core\\service\\.\\target\\classes");
        //System.setProperty("java.ext.dirs", "C:\\Users\\ylc\\Desktop\\shopping\\app\\core\\service\\.\\target\\classes");
        System.setProperty("java.class.path", "C:\\Users\\ylc\\Desktop\\shopping\\app\\core\\service\\.\\target\\classes");

        Class<Test> cls = Test.class;
        Module mod = cls.getModule();
        mod.getDescriptor().requires();
        ModuleDescriptor.newOpenModule("jdk.foo");

        Path path = Paths.get("C:\\Users\\ylc\\Desktop\\shopping\\app\\");

        List<Path> paths = new ArrayList<>();
        Files.list(path).filter(x -> !x.endsWith("test")).forEach(x -> {
            Path resolve = x.resolve(MODULE_PATH);
            if (Files.notExists(resolve)) {
                try {
                    Files.list(x).forEach(y -> {
                        Path resolve1 = y.resolve(MODULE_PATH);
                        if (!Files.notExists(resolve1)) {
                            paths.add(resolve1);
                        }
                    });
                } catch (IOException e) {
                    System.err.println(e);
                }
            } else {
                paths.add(resolve);
            }
        });
        String join = String.join(";", paths.stream().map(x->x.toString()).collect(Collectors.toList()));
        //System.setProperty("java.class.path", join);
        ModuleFinder of = ModuleFinder.of(paths.stream().toArray(Path[]::new));

        Set<ModuleReference> all = of.findAll();
        of.findAll().forEach(System.err::println);


    }
}