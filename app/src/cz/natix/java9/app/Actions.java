package cz.natix.java9.app;

import java.util.List;

import static java.lang.System.out;

class Actions {

    static void runAll(List<Runnable> actions) {
        actions.forEach(a -> {
            a.run();
            out.println();
        });
    }
}
