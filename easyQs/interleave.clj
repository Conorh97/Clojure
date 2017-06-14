;;interleaves two sequences together
(fn [x y] (flatten (map vector x y)))
