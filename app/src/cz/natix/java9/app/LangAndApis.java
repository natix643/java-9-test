package cz.natix.java9.app;

import java.io.*;
import java.util.*;

import static cz.natix.java9.app.Actions.runAll;
import static java.lang.System.out;

public class LangAndApis {

    public static void main(String[] args) throws Exception {
        new LangAndApis().run();
    }

    void run() {
        runAll(List.of(this::collections, this::properties, this::diamond));
    }

    void collections() {
        Set<Integer> is = Set.of(1, 2, 3);
        out.println("Set.of " + is);
        out.println("HashSet " + new HashSet<>(is));
    }

    void properties() {
        ResourceBundle bundle = ResourceBundle.getBundle("messages");
        out.println("bundle[name] = " + bundle.getString("name"));

        try (FileInputStream in = new FileInputStream("app/src/messages.properties")) {
            Properties properties = new Properties();
            properties.load(in);

            out.println("properties[name] = " + properties.getProperty("name"));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }


    void diamond() {
        ThreadLocal<String> local = new ThreadLocal<>() {
            @Override
            protected String initialValue() {
                return "42";
            }
        };
        out.println("threadlocal = " + local.get());
    }
}
