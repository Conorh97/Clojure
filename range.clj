''Takes two numbers and creates a list in the range of those numbers
(fn [x y]
  (loop [low x high y base ()]
    (if (= low high)
      base
      (recur low (- high 1) (conj base (- high 1))))))
