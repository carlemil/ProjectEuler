package se.kjellstrand.projecteuleronandroid.problems;

import rx.Observable;

/**
 * Created by carlemil on 2015-12-08.
 */
public class Problem1 implements Solution {

    @Override
    public Observable solve() {
        int ret;
        Observable o= Observable.range(1, 999)
                .filter(i -> (i % 3 == 0 || i % 5 == 0))
                .reduce((a, b) -> a + b);
        return o;
    }
}
