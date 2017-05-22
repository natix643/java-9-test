package cz.natix.java9.app;

import java.util.*;

import static java.lang.System.out;
import static java.util.Collections.nCopies;

class Actions {

    static void runAll(Map<String, Runnable> actions) {
        actions.forEach((name, action) -> {
            out.println("\n" + name);

            List<String> dashes = nCopies(name.length(), "-");
            out.println(String.join("", dashes));

            action.run();
            out.println();
        });
    }
}
