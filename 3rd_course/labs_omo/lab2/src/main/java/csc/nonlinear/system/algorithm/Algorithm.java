package csc.nonlinear.system.algorithm;

import csc.nonlinear.system.dto.Vector;

import java.util.*;

public interface Algorithm<T, R> {
    Vector solve(T t);
}
