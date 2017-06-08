;;Groups numbers based on their remainder of N
(fn [x n] (vals(group-by #(mod % n) x)))
