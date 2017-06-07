;;splits a sequence by a given character
(fn [n x]
  (loop [vecto x splitter n pointer (- (count x) 1) base []]
    (if(< pointer 0)
      (reverse base)
      (if (= pointer 0)
        (recur vecto splitter (- pointer 1) (conj base (nth vecto pointer)))
        (recur vecto splitter (- pointer 1) (conj base (nth vecto pointer) n))))))
