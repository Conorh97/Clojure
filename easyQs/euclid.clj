;;gets the greatest common divisor of two numbers

(fn [x y]
  (loop [high x low y]
    (if (= low 0)
      high
      (if (< high low)
        (recur low high)
        (recur low (rem high low))))))
