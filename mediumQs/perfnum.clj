;;Returns a boolean based on whether the input number is perfect or not

(fn [x] (= (reduce + (filter #(= (mod x %) 0) (range 1 (/ x 2)))) x))
