;;replicates elements of a vector an n number of times
(fn [x n]
  (loop [vecto x times n pointer (- (count x) 1) base []]
    (if (< pointer 0)
      (flatten (reverse base))
      (recur vecto times (- pointer 1) (conj base (repeat times (nth vecto pointer)))))))
