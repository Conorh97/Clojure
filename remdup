;;Removes all duplicates from a vector
(fn [x]
  (loop [vecto x pointer (- (count x) 1) base []]
    (if(< pointer 0)      
      (reverse base)
      (if (= pointer 0)
        (recur vecto (- pointer 1) (conj base (nth vecto pointer)))
      (if(= (nth vecto pointer) (nth vecto (- pointer 1)))
        (recur vecto (- pointer 1) base)
        (recur vecto (- pointer 1) (conj base (nth vecto pointer)))))))) 
