;;Converts a digit to a different base

(fn [n b]
  (loop [number n 
         base b 
         newnum ()]
    (if (= number 1)
      (conj newnum (mod number base))
      (recur (quot number base)
             base
             (conj newnum (mod number base))))))
