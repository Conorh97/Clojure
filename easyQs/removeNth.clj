;;Removes every Nth element of a sequence

(fn [x n]
  (loop [vecto x splitter n pointer (- (count x) 1) base []]
    (if (< pointer 0)
      (reverse base)
      (if (= (rem(+ pointer 1) n) 0)
        (recur vecto splitter (- pointer 1) base)
        (recur vecto splitter (- pointer 1) (conj base (nth vecto pointer)))))))
