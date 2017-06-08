;;Gives the first N prime numbers

(fn [x] 
  (loop [amount x counter 0 pointer 2 base ()]
    (if(= counter amount)
      (reverse base)
      (if (= ((fn isprime [n]
               (loop [pointer 2 number n]
                (if(= pointer number)
                 true
                 (if(= (mod number pointer) 0)
                  false
                  (recur (+ pointer 1) number))))) pointer) true)
        (recur amount (+ counter 1) (+ pointer 1) (conj base pointer))
        (recur amount counter (+ pointer 1) base)))))
