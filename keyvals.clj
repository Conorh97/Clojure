;;makes a hash map with keywords and integer values 

(fn [x]
  (loop [vecto x 
         pointer (- (count x) 1) 
         kmap {} 
         vvec []]
    (if (< pointer 0)
      kmap
      (if (= clojure.lang.Keyword (type (nth vecto pointer)))
        (recur vecto
               (- pointer 1)
               (conj kmap {(nth vecto pointer) (into [] (reverse vvec))})
               [])
        (recur vecto
               (- pointer 1)
               kmap
               (conj vvec (nth vecto pointer)))))))
